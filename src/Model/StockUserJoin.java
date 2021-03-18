package Model;

public class StockUserJoin {
	private String ID_PK ; //이게 그 , 가 들어간 유저이름, 스톡이름 이렇게 만드는 것
	private String userId;
	private String StockName;
	private int StockPrice;
	private int SaveStockNumber;
	
	
	public String getID_PK() {
		return ID_PK;
	}
	public void setID_PK(String userId, String stockName) {
		ID_PK = userId+","+stockName;
	}
	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public int getStockPrice() {
		return StockPrice;
	}
	public void setStockPrice(int stockPrice) {
		StockPrice = stockPrice;
	}
	public int getSaveStockNumber() {
		return SaveStockNumber;
	}
	public void setSaveStockNumber(int saveStockNumber) {
		SaveStockNumber = saveStockNumber;
	}
	
	
}
