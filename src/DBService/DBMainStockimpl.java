package DBService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import Model.DataModel;
import Model.DataModelDTO;
import Model.Stock;
import Model.TableRowDataModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DBMainStockimpl implements DBMainStock{
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 에러날시 개인컴에서 사용하던 url을 이용해주세요
	private String id = "java"; // 개인이 사용하시던 데베 아이디 이용해주세요
	private String pwd = "1234"; // 비밀번호도 마찬가지!

	private DataModelDTO dto = new DataModelDTO();
	private DataModel dm ;
	
	public DataModelDTO getgetDTO() {
		return dto;
	}
	
	public void DBMainStockimpl() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DBload();
	}

	
	
	@Override
	public int DBload() {
		String sql = "select * from Stock ";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
           
			while (rs.next()) {
				dm = new DataModel();
				dm.setStockName(rs.getString("StockName"));
				dm.setStockPrice(rs.getInt("StockPrice"));
				dm.setChangePrice(rs.getInt("PrestockPrice"));
				dto.setadd_H(dm);
		     	dto.setadd(dm); // ?
		     	
					//System.out.println(dto.getArrDataList().get(1).getStockName());
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 1;
	}
		
		
	}


