/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.dars;
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
public class darslist {
public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
	public darslist() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
     public void insert(String names,boolean[] limis,String pids,String schols,String secus,String comments){
    mnm.asatid.asatid mnm=new  mnm.asatid.asatid();
    mnm.setName(names);
    mnm.setLimitation(limis);
    mnm.setPersenel(pids);
    mnm.setSchollid(schols);
    mnm.setSecuence(secus);
    mnm.setComent(comments);
    new mnm.asatid.asatidlist().insert(mnm);
    }
    public static void main(String a[]){
        String[][] listkoli=new darslist().selectdars(1,"02");
        for(int i=0;i<listkoli.length;i++)
        {
//detail sat=new detail();
//            List s=(ArrayList)listkoli.get(i);
            System.out.println(listkoli[i][1]+"\t"+listkoli[i][2]);
           
        }
//            detail s=new detail();
            
//sat=(ArrayList)listkoli.get(listkoli.indexOf("02"));


    }
  public List selectAll(int scholid) {
		Statement stmt = null;
		Connection conn = null;
		List allObjects = new ArrayList();
        List temp = new ArrayList();
        List temp2 = new ArrayList();
        dars ni;
        try {

			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("" +
                    "select reshte.id,reshte.name from kind inner join scholl on kind.scholid=scholl.id join reshte where kind.id=reshte.maghta" +
                    "  AND kind.scholid="+scholid+" ORDER BY id DESC");
			while (rs.next()) {
                name na=new  name();
                na.id=rs.getInt(1);
                na.name=rs.getString(2);
                temp.add(na);

			}
            for(int i=0;i<temp.size();i++){
            ni=new dars();
            name na=(name)temp.get(i);

            ni.setName(na.name);
                rs = stmt.executeQuery("select name from dars where id='"+na.id+"' ORDER BY id DESC");
                temp2=new ArrayList();
                while (rs.next()) {
                    temp2.add(rs.getString(1));

			}ni.setSub(temp2);

allObjects.add(ni);
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
		return allObjects;
	}
 public List selectAllstat(int scholid) {
		Statement stmt = null;
		Connection conn = null;
		List allObjects = new ArrayList();
        List temp = new ArrayList();
        List temp2 = new ArrayList();
        dars ni;
        try {

			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("" +
                    "select reshte.id,reshte.name from kind inner join scholl on kind.scholid=scholl.id join reshte where kind.id=reshte.maghta" +
                    "  AND kind.scholid="+scholid+" ORDER BY id DESC");
			while (rs.next()) {
                name na=new  name();
                na.id=rs.getInt(1);
                na.name=rs.getString(2);
                temp.add(na);

			}
            for(int i=0;i<temp.size();i++){
            ni=new dars();
            name na=(name)temp.get(i);
detail s=new detail();
            ni.setName(na.name);
                rs = stmt.executeQuery("select code,vahed,name from dars where id='"+na.id+"' ORDER BY id DESC");
                temp2=new ArrayList();
                while (rs.next()) {
                    s=new detail();
                    s.code=rs.getString(1);
                    s.vahed=rs.getDouble(2);
                    s.name=rs.getString(3);
                    temp2.add(s);

			}ni.setSub(temp2);

allObjects.add(ni);
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
		return allObjects;
	}


 public String[][] selectdars(int scholid,String darscode) {
		Statement stmt = null;
		Connection conn = null;
        String[][] temps=new String[0][0];


        try {

			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            int i=0;
            ResultSet rs = stmt.executeQuery("select class.reshte from class inner join classdars on class.id=classdars.id where class.schoolid="+scholid+" AND classdars.code='"+darscode+"' ORDER BY class.reshte ASC ");

            while (rs.next()) {
                i++;
            }
			temps=new String[i][5];i=0;
            rs = stmt.executeQuery("select class.reshte,class.name,classdars.name,classdars.master,classdars.vahed from class inner join classdars on class.id=classdars.id where class.schoolid="+scholid+" AND classdars.code='"+darscode+"' ORDER BY class.reshte ASC ");

            while (rs.next()) {
                //temps=new ArrayList();
                temps[i][0]=rs.getString(1);
                temps[i][1]=(rs.getString(2));
                temps[i][2]=(rs.getString(3));
                temps[i][3]=(rs.getString(4));
                temps[i][4]=(rs.getString(5));
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
		return temps;
	}
class name{
    public int id;
    public String name;

}

class detail{
public double vahed;
public String code;
public String name;
}

}

