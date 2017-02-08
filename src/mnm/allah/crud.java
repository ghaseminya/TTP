package mnm.allah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.api.Listbox;

public class crud {
	String table="allah";
	 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DATABASE_URL = "jdbc:mysql://localhost/webshop?characterEncoding=UTF-8";
	 public ResultSet resultSet;	
	public List read(){

		Connection connection = null; // manages connection
	    Statement statement = null; // query statement
	    List<allah> result=new ArrayList<allah>();
	    allah re=new allah();
	    try {
	        Class.forName(JDBC_DRIVER); // load database driver class
	        connection =
	        DriverManager.getConnection(DATABASE_URL, "tmnmbonusr", "mtaksir@25");
	        statement = connection.createStatement();
	        
	        resultSet=statement.executeQuery("select * from "+table);
	        while (resultSet.next()){
               re=new  allah();
               
               re.setName(resultSet.getString(1));
               re.setE_Name(resultSet.getString(2));
               re.setAyeh(resultSet.getInt(5));
               re.setTranslat(resultSet.getString(3));
               re.setSoureh(resultSet.getInt(4));
               
	            result.add(re);
	        }
	        }catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	        } // end catch
	        catch (ClassNotFoundException classNotFound) {
	            classNotFound.printStackTrace();
	        } // end catch
	        finally // ensure statement and connection are closed properly
	        {
	            try {
	                statement.close();
	                connection.close();
	            } // end try
	            catch (Exception exception) {
	                exception.printStackTrace();
	            } // end catch
	        } // end finally
	        return result;
	}
	public boolean create(List al){
        boolean result=false;
        Connection connection = null; // manages connection
	    Statement statement = null; // query statement
	    try {
	        Class.forName(JDBC_DRIVER); // load database driver class
	        connection =
	        DriverManager.getConnection(DATABASE_URL, "tmnmbonusr", "mtaksir@25");
	        statement = connection.createStatement();
	        for (int j = 0; j < al.size(); j++) {
	        	allah in=(allah)al.get(j);
		        
		        statement.executeUpdate("insert into "+table+" ( Name , name_e ,translate,soreh, ayeh) values ('"+in.Name+"','"+in.E_Name+"','"+in.translat+"','"+in.soureh+"','"+in.ayeh+"')");
		        	
			}
	        }catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	        } // end catch
	        catch (ClassNotFoundException classNotFound) {
	            classNotFound.printStackTrace();
	        } // end catch
	        finally // ensure statement and connection are closed properly
	        {
	            try {
	                statement.close();
	                connection.close();
	            } // end try
	            catch (Exception exception) {
	                exception.printStackTrace();
	            } // end catch
	        } // end finally
        return result;

	}
public static void main(String ap[]){
	crud mnm=new crud();
	List as=mnm.read();
	for (int i = 0; i < as.size(); i++) {
		allah asss=(allah)as.get(i);
		System.out.println(asss.Name);
	}
	allah temp=new allah();
	temp.ayeh=1;
	temp.E_Name="Al Rahim";
	temp.translat="The Most Merciful in Action";
	temp.Name="Alrahman";
	temp.soureh=3;
	List result=new ArrayList();
	result.add(temp);
	mnm.create(result);
	org.zkoss.zul.Listbox mnmv=new org.zkoss.zul.Listbox();
	
}
}
