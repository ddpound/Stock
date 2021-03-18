package Services;
//여기서 난수 실행 계속 실행시키는 중요한 요소임
// 스레드 하나더 발생시키도록 하자 여기 스레드로 계속 랜덤 변수로 데베값을 넣었다 뺏다 하는거임

import java.util.ArrayList;
import java.util.Random;



import Controllers.MainStockController;
import DBService.ChangeStock;
import DBService.ChangeStockImpl;
import DBService.DBMainStock;
import DBService.DBPalMoney;
import DBService.StockDBService;
import DBService.StockDBServiceImpl;
import Model.TableRowDataModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MainStackSystem extends Thread{
	private int i=0;
	private Label PalMoney;
	private Random random;
	private double randomPrice;
	private double randomStackName;
	private StockDBService SDBS; // 여기 디비저장후 바로 여기에 값들을 다 저장하니깐 이걸 가져와야함
	private ChangeStock chst;
	private DBPalMoney dbpalM;
	
	private Label LabChStock;
	private Label LabChMoney;

	

	
	
	public MainStackSystem() {
		SDBS = new StockDBServiceImpl();
		random = new Random();
		chst = new ChangeStockImpl();
		dbpalM = new DBPalMoney();
		
		
		
	}
	
	public void run() {
		this.i =0;
		  try
	        {
			  // 이름만 저장한 리스트를 만든다.
			  // 순서를 랜덤으로 해서 값을 출력한다 즉 인덱스 1 -> "샘성" 이런식으로 
			  
			
			 
			  
	            while(true)
	            {
	            	sleep(1000);
	            	System.out.println("주식 변동프로그램  작동중 : " + i);
	                randomPrice = Math.random();
	                randomStackName = Math.random();
	                int intPrice = (int )(randomPrice * 70000)+ 7000;
	                // 0부터 리스트 사이즈까지 랜덤으로
	                int indexStackName = (int )(randomPrice * SDBS.getStockList().getArrStoList().size())+ 0; // 이거수정
	                // 여기에 전달해서 그값을 변동시키면 될듯 
	                // 근데 미리 받아놓은 STACKDTO가 있으니깐 거기 리스트 밸류값도 같이 받아야할듯
	                
	                
	                System.out.println( SDBS.getStockList().getArrStoList().get(indexStackName).getStockName());
	                System.out.println(intPrice);
	            	
	            	
	            	
	            	// fx 전문 쓰레드
	            	Platform.runLater(new Runnable() { 
	            		@Override 
	            		public void run() {	
	            		try{
	            			//로그인 직후에 돌아가는 자동프로그램이니깐
	            			LabChStock = (Label)Run.Run.getMainStockroot().lookup("#LabChStock");
		            		LabChMoney = (Label)Run.Run.getMainStockroot().lookup("#LabChMoney");

		            		
		            		LabChStock.setText(SDBS.getStockList().getArrStoList().get(indexStackName).getStockName());
		            		LabChMoney.setText(Integer.toString(intPrice));
		            		
		            		
		            	}catch(Exception e) {
		            		System.out.println("아 에러임1");
		            	}
	            		
	            		try {
		            		if(Run.Run.getBuySellroot().equals(null)) {
		            			
			            	}else {
			            		//반면 이녀석은 두번째 창때 받는 거니깐
			            		PalMoney = (Label)Run.Run.getBuySellroot().lookup("#PalMoney");
			            		System.out.println(dbpalM.PlusMoney(Run.Run.getNOWUSER()));
			            		int setTextPalMoney = Run.Run.getNOWUSERMONEY() + dbpalM.PlusMoney(Run.Run.getNOWUSER());
			            		if(setTextPalMoney < 3000000) {
			            			PalMoney.setTextFill(Color.RED);
			            		}else {
			            			PalMoney.setTextFill(Color.BLUE);
			            		}
			            		
				    			PalMoney.setText(Integer.toString(setTextPalMoney )); //요기에 값을 잘 받아오면 될듯
			            	}
	            			
	            			
	            			
	            			
	            			
	            			
	            		}catch(Exception e) {
		            		System.out.println("아 에러임2");
		            	}
	            		
	            		
	            		
	            		
	            		
	            		
	            		} 
	            		
	            		
	            		
	            		
	            	});

	            	
	            	
	            	
	               
	                
	                
	                
	                // 업데이트가 완료되면 pre와 pre pre를 또 같이 업데이트 해주는 메소드가 필요할듯 
	    			// 밑의 executeQuery 하기 직전에 값을 받아서 옮겨넣어줘야할듯
	                
	                chst.prepreChange(SDBS.getStockList().getArrStoList().get(indexStackName).getStockName());
	             
	                chst.preChange(SDBS.getStockList().getArrStoList().get(indexStackName).getStockName());
	                
	                chst.change(SDBS.getStockList().getArrStoList().get(indexStackName).getStockName(), intPrice);
	                
	                
	                // 여기다가 총 손익 돈 넣어야 하는부분(2021.03.17 추가)

//	                if(PalMoney.equals(null)) {
//	                	
//	                }else {
//	                	  PalMoney.setText("30");
//	                }
	              
	                
	                
	                
	                Thread.sleep(3000);
	                
	                
	                
	                i++;
	            }
	        }catch(InterruptedException e)
	        {
	            System.out.println(e);
	        }
	}
	
	
	
}
