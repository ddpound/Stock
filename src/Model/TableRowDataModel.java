package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TableRowDataModel {
	
	
	private StringProperty stockName;
	private IntegerProperty stockPrice;
    private IntegerProperty changePrice;
    
    public StringProperty getStockName() {
		return stockName;
	}



	public void setStockName(StringProperty stockName) {
		this.stockName = stockName;
	}



	public IntegerProperty getStockPrice() {
		return stockPrice;
	}



	public void setStockPrice(IntegerProperty stockPrice) {
		this.stockPrice = stockPrice;
	}



	public IntegerProperty getChangePrice() {
		return changePrice;
	}



	public void setChangePrice(IntegerProperty changePrice) {
		this.changePrice = changePrice;
	}


    
    public TableRowDataModel(StringProperty stockName, IntegerProperty stockPrice, IntegerProperty changePrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.changePrice = changePrice;
           }


    
    
    
	
	



}
