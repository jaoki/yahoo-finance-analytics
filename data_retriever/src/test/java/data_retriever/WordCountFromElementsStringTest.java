package data_retriever;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.util.Collector;
import org.codehaus.jackson.JsonNode;
import org.testng.annotations.Test;

public class WordCountFromElementsStringTest {

	public class QuoteSplitter implements FlatMapFunction<JsonNode, JsonNode> {

		private static final long serialVersionUID = 1L;

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
		JsonNode quotes = Yahoo.retrieveQuoteByDate("TWTR", "2015-01-01", "2016-01-01");

		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		DataSet<JsonNode> a = env.fromElements(quotes);
		FlatMapOperator<JsonNode, JsonNode> b = a.flatMap(new QuoteSplitter()).returns(JsonNode.class);
		MapFunction<JsonNode, ExtractCloseQuoteMapper.CloseQuote> mapper = new ExtractCloseQuoteMapper();
		MapOperator<JsonNode, ExtractCloseQuoteMapper.CloseQuote> result = b.map(mapper);
//		for(int i = 0; i < quotes.size(); i++){
//			JsonNode quote = quotes.get(i);
//			System.out.println(quote.get("Date").getTextValue());
//			
//		}
		result.print();





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


}
