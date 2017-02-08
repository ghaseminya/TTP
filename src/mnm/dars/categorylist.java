/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.dars;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import org.zkoss.zul.Listgroup;
/**
 *
 * @author mnm
 */
public class categorylist {
public String math;
public String[][] mathlist;
public String tajrobi;
public String[][]  tajrobilist;
public String ensani;
public List ensanilist;
public String maref;
public List mareflist;

    public categorylist() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    public String[][] getdars(String scholl,int classid){

         String[][] result=new String[0][0];
        Statement stmt = null;
		Connection conn = null;
        try {
int i=0;
            // get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select classdars.id from class inner join classdars on class.id=classdars.id where classdars.id='"+classid+"' AND class.schoolid="+scholl);
            while (rs.next()) {
i++;
            }
             rs =stmt.executeQuery("select classdars.name,classdars.master,classdars.code from class inner join classdars on class.id=classdars.id where classdars.id='"+classid+"' AND class.schoolid="+scholl);
			result=new String[i][4];i=0;
            int temp;
            while (rs.next()) {
                temp=i+1;
                result[i][3]=temp+"";
                result[i][2]=rs.getString(1);
                result[i][1]=rs.getString(2);
                result[i][0]=rs.getString(3);
                i++;
            }


		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("1");
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
    public String[][] getostad(String a){
        String[][] result=new String[0][0];
        Statement stmt = null;
		Connection conn = null;
        try {
int i=0;
            // get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id from masters where teachid LIKE '%"+a+"%' ");
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select name from masters where teachid LIKE '%"+a+"%' ORDER BY id DESC");
			result=new String[i][2];i=0;
            while (rs.next()) {
                result[i][0]=i+"";
                result[i][1]=rs.getString(1);
                i++;
            }

		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("1");
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
    public String[][] getlist(String reshte){
        if(reshte.equals("ریاضی"))return mathlist;
        if(reshte.equals("تجربی"))return tajrobilist;
        return mathlist;
    }
    public String[][] getallclass(String scholl){
        String[][] result=new String[0][0];
        Statement stmt = null;
		Connection conn = null;
        try {
int i=0;
            // get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id from class where schoolid='"+scholl+"' ");
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select id,name,reshte,kind    from class where schoolid='"+scholl+"' ");
			result=new String[i][5];i=0;
            while (rs.next()) {
                result[i][0]=i+"";
                result[i][1]=rs.getString(2);
                result[i][2]=rs.getString(3);
                result[i][4]=rs.getString(1);
                result[i][3]=rs.getString(4);
                i++;
            }

		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("1");
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
    public int createclass(String scholl,String name,String reshte){
        Statement stmt = null;
		Connection conn = null;
        int id=0;
        try {
            // get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            String kind="";
            ResultSet rs = stmt.executeQuery("select kind.name from kind inner join scholl on kind.scholid=scholl.id join reshte " +
                    "where kind.id=reshte.maghta AND  kind.scholid="+scholl+" AND reshte.name='"+reshte+"';") ;

            while (rs.next()) {
                kind=rs.getString(1);
            }
			stmt.executeUpdate("insert into class (name,reshte,schoolid,kind) values ('"+name+"','"+reshte+"',"+scholl+",'"+kind+"')") ;
             rs = stmt.executeQuery("select id from class where name='"+name+"' AND reshte='"+reshte+"' AND schoolid="+scholl+"");

            while (rs.next()) {
                id=rs.getInt(1);
            }
            stmt.executeUpdate("insert into classdars (id,name,code)  (select "+id+",dars.name,dars.code from dars inner join reshte on reshte.id=dars.id where reshte.name='"+reshte+"')") ;


		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("1");
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
        return id;
    }
    public void saveclassdars(String[][] res,int classid){
        Statement stmt = null;
		Connection conn = null;
        try {
            // get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from classdars where id="+classid+" ");
for(int i=0;i<res.length;i++)
stmt.executeUpdate("insert into classdars (id,name,master,code) values ("+classid+",'"+res[i][2]+"','"+res[i][1]+"','"+res[i][0]+"')");

		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("1");
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
public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
public static void main(String ass[]){
categorylist a=new categorylist();
//System.out.println(a.createclass("1", "riazi A1","math"));
//a.createclass("1","hasansas", "math");
System.out.println(a.getallclass("1").length);
String[][] sd= a.getallclass("1");
for(int i=0;i<sd.length;i++)
{
    System.out.println(sd[i][0]+"\t"+sd[i][1]+"\t"+sd[i][2]+"\t"+sd[i][3]);
}

}

public String[] getkindnumber(int scholid){
     String[] result=new String[0];
        Statement stmt = null;
		Connection conn = null;
        try {
int i=0;
            // get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from kind where scholid="+scholid);
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select name from kind where scholid="+scholid);
			result=new String[i];i=0;
            while (rs.next()) {
                result[i]=rs.getString(1);
                i++;
            }

		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("1");
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

}
