package DBService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.StockUserJoin;
import Model.StockUserJoinDTO;
import Run.Run;

public class DBPalMoney {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 에러날시 개인컴에서 사용하던 url을 이용해주세요
	private String id = "java"; // 개인이 사용하시던 데베 아이디 이용해주세요
	private String pwd = "1234"; // 비밀번호도 마찬가지!
	private StockUserJoinDTO stuJDTO = new StockUserJoinDTO();
	private StockUserJoin stuj;
	
	public DBPalMoney() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public int PlusMoney(String nowUsername) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "select StockUser.USERID,StockUser.STOCKNAME,Stock.STOCKPRICE,StockUser.SAVESTOCKNUMBER "
				+ "from Stock, StockUser "
				+ "where StockUser.STOCKNAME=Stock.STOCKNAME and StockUser.USERID="+"'"+nowUsername+"'";
		// 위 sql문은 해당유저가 산 주식 값을 전부다 확인해볼수있음
		
		
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			
			
			while (rs.next()) {
				stuj = new StockUserJoin();
				
				stuj.setUserId(rs.getString("USERID"));
				stuj.setStockName(rs.getString("STOCKNAME"));
				stuj.setStockPrice(rs.getInt("STOCKPRICE"));
				stuj.setSaveStockNumber(rs.getInt("SAVESTOCKNUMBER"));
				stuj.setID_PK(Run.getNOWUSER() , stuj.getStockName());
				
				stuJDTO.setarrSTUJ(stuj);
				stuJDTO.sethashSTUJ(stuj);
				
				// System.out.println(stuj.getID_PK()+ stuj.getStockPrice() +",  "+stuj.getSaveStockNumber());
				result += (stuj.getStockPrice() *stuj.getSaveStockNumber());
				
				// System.out.println(result);
				
			}
			
			
		}catch(Exception e) {
			
		}finally {
			if(ps!= null && con != null  ) {
				try {
					ps.close();
					con.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		return result;
	}
	
	
}
