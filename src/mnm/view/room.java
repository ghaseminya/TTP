package mnm.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class room {
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
					ResultSet rs = stmt.executeQuery("select count(*) from room ");
					int num=0;
					while (rs.next()) {
						num=rs.getInt(1);
						}
					result=new String[num][9];
					
					rs = stmt.executeQuery("select seat,name,building,section,flor,lab,lab2, lab3 from room ");
					num=0;
					while (rs.next()) {
						result[num][0]=(num+1)+"";
						result[num][1]=rs.getString(2);
						result[num][2]=rs.getString(3);
						result[num][3]=rs.getString(4);
						result[num][4]=rs.getString(5);
						result[num][5]=rs.getString(1);
						result[num][6]=rs.getString(6);
						result[num][7]=rs.getString(7);
						result[num][8]=rs.getString(8);
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
