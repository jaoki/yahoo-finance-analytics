package data_retriever;

import org.apache.flink.api.common.functions.MapFunction;
import org.codehaus.jackson.JsonNode;

public class ExtractCloseQuoteMapper implements MapFunction<JsonNode, ExtractCloseQuoteMapper.CloseQuote> {

	private static final long serialVersionUID = 1L;

	@Override
	public ExtractCloseQuoteMapper.CloseQuote map(JsonNode value) throws Exception {
		float closePrice = Float.parseFloat(value.get("Close").getTextValue());
		String date = value.get("Date").getTextValue();
		return new CloseQuote(closePrice, date);
	}
	
	public static class CloseQuote{
		public CloseQuote(float closePrice, String date) {
			this.closePrice = closePrice;
			this.date = date;
		}
		private float closePrice;
		private String date;

		public float getClosePrice() { return closePrice; }
		public void setClosePrice(float closePrice) { this.closePrice = closePrice; }
		public String getDate() { return date; }
		public void setDate(String date) { this.date = date; }
		
		@Override
		public String toString() {
			return date + ":" + closePrice;
			
		}
		
	}

}
