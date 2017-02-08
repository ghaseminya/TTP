/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mnm
 */
public class classresult {
    public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
    public classresult() {

	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
     public List gettitle(int scholid) {
		Statement stmt = null;
		Connection conn = null;
        List result=new ArrayList();
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select day from schollday where scholid="+scholid);
			while (rs.next()) {
                result.add(rs.getString(1));
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
     public List gethour(int scholid) {
		Statement stmt = null;
		Connection conn = null;
        List result=new ArrayList();
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select name from schollhour  where scholid="+scholid);
			while (rs.next()) {
                result.add(rs.getString(1));
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
    public static void main(String manm[]){
        classresult mnm=new classresult();
//        List as=mnm.gettitle(1);
        String as[][]=mnm.getjadval(60,1);
        for(int i=0;i<as.length;i++)
        {
            System.out.println(as[i][0]+"\t"+as[i][1]+"\t"+as[i][2]+"\t"+as[i][3]);
        }
        System.out.println(4/7+"\t"+4%7);
//        String[][][] datass=new StringCC[1][1][1];
//        datass[2]=mnm.getjadval(Integer.CparseInt(""),1);

    }
    public String[][] getjadval(int classid,int scholid){
        String[][] result=new String[0][0];


        Statement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();//
            ResultSet rs=stmt.executeQuery("select count(*) from schollday where scholid="+scholid);
            int day=0;
            int hour=0;
            while (rs.next()) {
                day=rs.getInt(1);
            }
             rs=stmt.executeQuery("select count(*) from schollhour where scholid="+scholid);
            while (rs.next()) {
                hour=rs.getInt(1);
            }
            result=new String[hour][day];
            rs=stmt.executeQuery("select name,master,code,mascode,vahed,darstime from classdars inner join result  where classdars.generid=result.darsid AND classdars.id="+classid);
			while (rs.next()) {
                System.out.println(day+"\t"+hour+"\t"+rs.getInt(6)/day+"\t"+rs.getInt(6)%day);
                result[rs.getInt(6)%day][rs.getInt(6)/day]=rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3);
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
    public int getnum(String s){
        int result=0;
        int g;
        while(s.indexOf("|")!=-1){
                g=s.indexOf("|");
                result++;
                s=s.substring(g+1);
        }
        result++;
        return result;
    }

}
