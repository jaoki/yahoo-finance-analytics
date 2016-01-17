package flink_playground;

import java.io.IOException;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class WordCountFromElementsStringTest {

	public class QuoteSplitter implements FlatMapFunction<JsonNode, JsonNode> {

		@Override
		public void flatMap(JsonNode values, Collector<JsonNode> out) throws Exception {
			for(int i = 0; i < values.size(); i++){
				JsonNode value = values.get(i);
				out.collect(value);
			}
		}

	}

	@Test
	public void test1() throws Exception {
		String contentPayload = retrieveData();
//		System.out.println(contentPayload);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(contentPayload);
//		JsonNode count = root.path("query").path("count");
//		System.out.println(mapper.writeValueAsString(count));
//		System.out.println(root.getTextValue());
		JsonNode quotes = root.path("query").path("results").path("quote");

		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		DataSet<JsonNode> a = env.fromElements(quotes);
		FlatMapOperator<JsonNode, JsonNode> result = a.flatMap(new QuoteSplitter());
//		for(int i = 0; i < quotes.size(); i++){
//			JsonNode quote = quotes.get(i);
//			System.out.println(quote.get("Date").getTextValue());
//			
//		}
		result.print();





//		// set up the execution environment
//		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//
//		// get input data
//		DataSet<String> text = env.fromElements(
//				"To be, or not to be,--that is the question:--",
//				"Whether 'tis nobler in the mind to suffer",
//				"The slings and arrows of outrageous fortune",
//				"Or to take arms against a sea of troubles,"
//				);
//
//		DataSet<Tuple2<String, Integer>> counts =
//				// split up the lines in pairs (2-tuples) containing: (word,1)
//				text.flatMap(new LineSplitter())
//				// group by the tuple field "0" and sum up tuple field "1"
//				.groupBy(0)
//				.sum(1);
//
//		// execute and print result
//		counts.print();

	}

	private String retrieveData() throws IOException, ClientProtocolException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20where%20symbol%20%3D%20%22YHOO%22%20and%20startDate%20%3D%20%222009-09-11%22%20and%20endDate%20%3D%20%222010-03-10%22&format=json&diagnostics=true&env=http%3A%2F%2Fdatatables.org%2Falltables.env&callback=";
		HttpGet httpGet = new HttpGet(URL);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		HttpEntity entity1 = response1.getEntity();
		String contentPayload = EntityUtils.toString(response1.getEntity()) ;
		EntityUtils.consume(entity1);
		return contentPayload;
	}

	//
	// 	User Functions
	//

	/**
	 * Implements the string tokenizer that splits sentences into words as a user-defined
	 * FlatMapFunction. The function takes a line (String) and splits it into
	 * multiple pairs in the form of "(word,1)" (Tuple2<String, Integer>).
	 */
	public static final class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {

		@Override
		public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
			// normalize and split the line
			String[] tokens = value.toLowerCase().split("\\W+");

			// emit the pairs
			for (String token : tokens) {
				if (token.length() > 0) {
					out.collect(new Tuple2<String, Integer>(token, 1));
				}
			}
		}
	}
}
