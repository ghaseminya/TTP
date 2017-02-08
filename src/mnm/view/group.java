package mnm.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class group {
	public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
	public String[][] fetch(){
		Statement stmt = null;
				Connection conn = null;
				String[][] result=new String[0][0];
				List<Integer> allObjects = new ArrayList<Integer>();
				try {
		            
					// get connection
					conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select count(*) from coursename ");
					int num=0;
					while (rs.next()) {
						num=rs.getInt(1);
						}
					result=new String[num][2];
					
					rs = stmt.executeQuery("select name ,id_group from coursename ");
					num=0;
					while (rs.next()) {
						result[num][0]=rs.getString(1);
						result[num][1]=rs.getString(2);
						num++;
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
	public static void main(String a[]){
		group mnm=new group();
		String[][] data=new mnm.view.group().fetch();
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i][0]+"\t"+data[i][1]);
		}
	}
}
