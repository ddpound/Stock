package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DBService.DBMainStock;
import DBService.DBMainStockimpl;
import Model.Stock;
import Model.TableRowDataModel;
import Services.BuySellShowService;
import Services.BuySellShowServiceImpl;
import Services.MainStockService;
import Services.MainStockServiceImpl;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swt.FXCanvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainStockController implements Initializable {
	private Parent root;
	private MainStockService mss;
	private BuySellShowService bss;
	private TableRowDataModel tr;
	private DBMainStock db;
	private ArrayList a;
	 
	private ObservableList<TableRowDataModel> myList;
	@FXML
	private TableView<TableRowDataModel> tableView;
	@FXML
	private TableColumn<TableRowDataModel, String> stockName;
	@FXML
	private TableColumn<TableRowDataModel, Integer> stockPrice;
	@FXML
	private TableColumn<TableRowDataModel, Integer> changePrice;
	
	private ArrayList<TableRowDataModel> testLsit = new ArrayList<TableRowDataModel>();
	
	public void List() {
		int j = 0;
		try {

			j = db.getgetDTO().getHashDataList().size();
			System.out.println("aaa");
			System.out.println(db.getgetDTO().getHashDataList().get("샘성").getStockName() + "aaaaaa");
			System.out.println(db.getgetDTO().getArrDataList().get(2).getStockName() + "bbbbbbbbbbbbbbbbbbb");
		} catch (Exception e) {
			System.out.println(root);
		}
		FXCollections ar ;
		
		for (int i = 0; i < j; i++) {
			testLsit.add( 
                    new TableRowDataModel(
					
					new SimpleStringProperty(db.getgetDTO().getHashDataList().get(db.getgetDTO().getArrDataList().get(i).getStockName()).getStockName()),
					new SimpleIntegerProperty(db.getgetDTO().getHashDataList().get(db.getgetDTO().getArrDataList().get(i).getStockName()).getStockPrice()), 
					new SimpleIntegerProperty(db.getgetDTO().getHashDataList().get(db.getgetDTO().getArrDataList().get(i).getStockName()).getChangePrice())));
					
			 
		}
		
		myList = FXCollections.observableArrayList(testLsit);
	}
	
	
	
	

	public void setRoot(Parent root) {
		this.root = root;
		mss.setRoot(root); // 서비스 임플리에 루트값을 가져와줌

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mss = new MainStockServiceImpl();
		bss = new BuySellShowServiceImpl();
		db = new DBMainStockimpl();

		stockName.setCellValueFactory(cellData -> cellData.getValue().getStockName());
		stockPrice.setCellValueFactory(cellData -> cellData.getValue().getStockPrice().asObject());
		changePrice.setCellValueFactory(cellData -> cellData.getValue().getChangePrice().asObject());
		db.DBload();
		List();
		tableView.setItems(myList);

		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	// go 매매 매수 창 가는 버튼
	public void btnBuySell() {
		bss.newWindowBuySell();

	}

}