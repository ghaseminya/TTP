package mnm.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class roomfunc {

	public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
	public List fetch(){
		Statement stmt = null;
				Connection conn = null;
				List result=new ArrayList<room>();
				try {
		            
					// get connection
					conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select seat,name,building,section,flor,lab,lab2, lab3 ,id from room ");
					room rom;
					
					while (rs.next()) {
						rom=new room((Integer.parseInt(rs.getString(9))+1),Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
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
	public boolean add(room rom){
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
		roomfunc mnm=new roomfunc();
		room te=(room)mnm.fetch().get(0);
		System.out.println(te.getName()+"|"+te.getBuilding()+"|"+te.getFlor()+"|"+te.getLab());
	}
}