/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.xml;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mnm
 * the setdayandhoure in data base from hello page
 */
public class fetch {
public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
    public fetch() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
    public void setdayandh(String day,String hour){
    Statement stmt = null;
		Connection conn = null;
        List result=new ArrayList();
//        String temp="";
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            List temp=getstr(day);
            List hours=getstr(hour);
            for(int i=0;i<temp.size();i++)
            {
//                stmt.executeUpdate("insert into result (schollid,darsid,darstime) values ("+schollid+","+ni.getId()+",'"+getstr(ni.getDay(),ni.getHour())+"')");
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
    }
    public List getstr(String s){
        List result=new ArrayList();
        int g;
        while(s.indexOf("|")!=-1){
                g=s.indexOf("|");
                result.add(s.substring(0,g));
                s=s.substring(g+1);
        }
        result.add(s);
        return result;
    }
}
