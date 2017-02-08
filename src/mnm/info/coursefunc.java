package mnm.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class coursefunc {
 
	public String table="course";
	public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
	public List fetch(){
		Statement stmt = null;
				Connection conn = null;
				List result=new ArrayList<room>();
				try {
		            
					// get connection
					conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from "+table);
					course rom;
					
					while (rs.next()) {
						rom=new course(rs.getString(2),rs.getInt(1),rs.getInt(1));
						result.add(rom);
					
						}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					try {
						if(stmt != null)
							stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return result;
				}
	public boolean add(course cou){
		Statement stmt = null;
		Connection conn = null;
		boolean result=false;
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into room () values () ");
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean upadte(room rom,int id){
		Statement stmt = null;
		Connection conn = null;
		boolean result=false;
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			stmt.executeUpdate("update room set () where id="+id);
			result=true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
}
	public boolean del(int id){
		Statement stmt = null;
		Connection conn = null;
		boolean result=false;
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from room where id="+id);
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public static void main(String a[]){
		coursefunc mnm=new coursefunc();
		course te=(course)mnm.fetch().get(0);
		System.out.println(te.getName()+"|"+te.getId());
	}
}