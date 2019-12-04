package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	int result;
	
	public UserDAO() {
		/*
		 * Class.forName("oracle.jdbc.driver.OracleDriver"); Connection conn =
		 * DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl",
		 * "caroline", "1234"); PreparedStatement pstmt = conn.prepareStatement("sql");
		 */
		
//		JNDI를 이용하기 위해서 객체를 생성한다.
		try {
			Context init = new InitialContext();
			
//			java:comp/env로 가서 jdbc/OracleDB라는 이름의 Resource를 찾아서 연결한다.
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			
		} catch (NamingException e) {
			System.out.println("DB 연결 실패");
			return; /**QQQQ*/		
			
		}
		
	}

	public int lookUpId(String id, String pwd) {
		
		String sql = "select * from users where id = ?";	
				
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (pwd.equals(rs.getString("password"))) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
			System.out.println("결과 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;	
		
	}

	public int insertUser(User user) {
		
		String sql = "insert into users values(?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAge());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
		
	}
	
	public void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
