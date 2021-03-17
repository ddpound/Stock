package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Services.BuySellShowService;
import Services.BuySellShowServiceImpl;
import Services.MainStackSystem;
import Services.MainStockService;
import Services.MainStockServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MainStockController implements Initializable{
	private Parent root;
	private MainStockService mss; 
	private BuySellShowService bss;
	private MainStackSystem Rmss ;

	
	
    public void setRoot(Parent root) {
		this.root = root;
		mss.setRoot(root); // 서비스 임플리에 루트값을 가져와줌
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mss = new MainStockServiceImpl();
		bss = new BuySellShowServiceImpl();
		
		
		// 그래 로그인이 된후에 돌아가는게 맞지
		Rmss = new MainStackSystem();
		Rmss.start(); //  아니 이거 어케끄는지는 나중에 생각
		
	}
	
	//go 매매 매수 창 가는 버튼
	public void btnBuySell() {
		bss.newWindowBuySell();
		
	}
	
	

}
