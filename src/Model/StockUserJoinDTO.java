package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class StockUserJoinDTO {
	ArrayList<StockUserJoin> arrSTUJ;
	HashMap<String, StockUserJoin> hashSTUJ;
	
	public StockUserJoinDTO() {
		arrSTUJ = new ArrayList<StockUserJoin>();
		hashSTUJ = new HashMap<String, StockUserJoin>();
	}
	
	public void setarrSTUJ(StockUserJoin stockuserJoin){
		arrSTUJ.add(stockuserJoin);
	}
	
	// 유저이름,주식 으로 값을 구함
	// 아 이렇게 하면 되겠다
	public void sethashSTUJ(StockUserJoin stockUserJoin) {
		hashSTUJ.put(stockUserJoin.getID_PK(), stockUserJoin);
	}
	
	public ArrayList<StockUserJoin> getarrSTUJ() {
		return arrSTUJ;
	}
	
	public HashMap<String, StockUserJoin> gethashSTUJ(){
		return hashSTUJ;
	}
	
	
}
