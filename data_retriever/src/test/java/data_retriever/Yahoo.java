package data_retriever;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Yahoo {
	public static JsonNode retrieveQuoteByDate(String ticker, String startDate, String endDate) throws IOException, ClientProtocolException, JsonProcessingException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20"
				+ "where%20"
				+ "symbol%20%3D%20%22" + ticker + "%22"
				+ "%20and%20startDate%20%3D%20%22" + startDate + "%22"
				+ "%20and%20endDate%20%3D%20%22" + endDate + "%22&"
				+ "format=json&"
				+ "diagnostics=false&"
				+ "env=http%3A%2F%2Fdatatables.org%2Falltables.env&callback=";
		
		System.out.println("Yahoo API URL: " + URL);
		HttpGet httpGet = new HttpGet(URL);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		HttpEntity entity1 = response1.getEntity();
		String contentPayload = EntityUtils.toString(response1.getEntity()) ;
		EntityUtils.consume(entity1);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(contentPayload);
		JsonNode quotes = root.path("query").path("results").path("quote");
		return quotes;
	}


}
