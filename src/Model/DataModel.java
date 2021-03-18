package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
	private String stockName;
	private int stockPrice;
    private int changePrice;
    
    
    
    
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	public int getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(int changePrice) {
		this.changePrice = changePrice;
	}
	
}
