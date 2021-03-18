package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataModelDTO {
   private ArrayList<DataModel> ArrDataList;
   private HashMap<String,DataModel> hashMap;
   public DataModelDTO() {
	   ArrDataList = new ArrayList<DataModel>();
     	hashMap = new HashMap<>();    
   }
   
   public void setadd(DataModel dm) {
	   
	   ArrDataList.add(dm);
   }
   
   public ArrayList<DataModel> getArrDataList(){
	   return ArrDataList;
   }
   
   public void setadd_H(DataModel dm) {
	   hashMap.put(dm.getStockName() ,dm);
   }
   public HashMap<String, DataModel> getHashDataList(){
	   return hashMap;
   }
}
