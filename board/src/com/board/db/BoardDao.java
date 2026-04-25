package board;

import java.sql.*;

public class BoardDao {
	private Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/jspdb", "jsp", "1234");
		
		return conn;
	}
	
	// 지정된 글 번호의 레코드를 DB에서 삭제
	public void deleteOne(int num) {
		
		try(
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
		) {
			stmt.executeUpdate("delete from board where num=" + num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
