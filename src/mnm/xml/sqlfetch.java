/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.xml;
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

//list of hor name
//getdayname();//list of day name√
//String[] teacher = db.getteacher();//list of name of all teacher√
//String[] Subject = db.getSubject();//list of name of all dars√
//String[] stu =db.getstu();//list of name of all class√
//String[][] activi =db.getactivi();//list of all activity with data in it
// List arrayob=db.getarrayob();//list of all conflictred list dars
public class sqlfetch implements sqlfetchint {
    public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
    public int scholid;
    public sqlfetch(int scholid) {
        this.scholid=scholid;
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    public String[] gethourename(){
        String[] result= new String[0];
        result=new String[]{"1","2","3"};
        return result;
    }
    public String[] getdayname(){
        String[] result= new String[0];
        result=new String[]{"shanbe","yek","do","se","char","pang","jome"};
        return result;
    }

    public String[] getteacher(){
        String[] result= new String[0];
         Statement stmt = null;
		Connection conn = null;
        try {
            int i=0;
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from masters where schollid="+scholid);
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select name from masters where schollid="+scholid);
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


    public String[] getSubject(){
    String[] result= new String[0];
    Statement stmt = null;
		Connection conn = null;
        try {
            int i=0;
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select dars.name from kind inner join scholl on kind.scholid=scholl.id join reshte join dars where kind.id=reshte.maghta AND dars.id=reshte.id AND  kind.scholid="+scholid);
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select dars.name from kind inner join scholl on kind.scholid=scholl.id join reshte join dars where kind.id=reshte.maghta AND dars.id=reshte.id AND  kind.scholid="+scholid);
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
    public String[] getstu(){
        String[] result= new String[0];
        Statement stmt = null;
		Connection conn = null;
        try {
            int i=0;
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from class where schoolid="+scholid);
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select name from class where schoolid="+scholid);
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




    public String[][] getactivi(){
        String[][] result= new String[0][0];

        Statement stmt = null;
		Connection conn = null;
        try {
            int i=0;
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select classdars.vahed from class inner join classdars on class.id=classdars.id where class.schoolid="+scholid+" ORDER BY class.reshte ASC");
			while (rs.next()) {
                i++;
            }
            rs = stmt.executeQuery("select class.name,classdars.code,classdars.master,classdars.vahed from class inner join classdars on class.id=classdars.id where class.schoolid="+scholid+" ORDER BY class.reshte ASC");
			result=new String[i][5];i=0;
            while (rs.next()) {
                result[i][0]=rs.getString(3);
                result[i][1]=rs.getString(2);
                result[i][2]=rs.getString(4);
                result[i][3]=rs.getString(1);
                result[i][4]=i+"";
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
    public List getarrayob(){
    List result=new ArrayList();
    List temp=new ArrayList();
        teacherdb asass=new teacherdb();
        String day[]=new String[]{"shanbe","yek","do","se","char","pang","jome"};
        String houre[]=new String[]{"1","2","3"};

        Statement stmt = null;
		Connection conn = null;
        try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name,limitation,sum,act from masters where  schollid="+scholid );
            while (rs.next()) {
                String temps=rs.getString(2);
                temp=new ArrayList();
                asass=new teacherdb();
                int not=0;
                for(int k=0;k<day.length;k++)
                    for(int j=0;j<houre.length;j++)
                    {
                        String adad=temps.substring(0, 1);
                        temps=temps.substring(1);
                        if(adad.equals("1"))
                        {
                            temp.add(day[k]);
                            temp.add(houre[j]);
                        }else{not++;}

                    }
                asass.setArr(temp);
                asass.setName(rs.getString(1));
                asass.setNumber(not);
                result.add(asass);
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
    class teacherdb{
        String name;
        int number;
        List arr;

        public List getArr() {
            return arr;
        }

        public void setArr(List arr) {
            this.arr = arr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
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

public static void main(String a[]){
    sqlfetch mnm =new sqlfetch(1);

    List temp=mnm.getarrayob();
    for(int u=0;u<temp.size();u++)
    {
    sqlfetch.teacherdb asd=(sqlfetch.teacherdb) temp.get(u);
    List as=asd.getArr();
    System.out.println(asd.getName()+"\t"+asd.getNumber());
    for(int i=0;i<as.size();i++)
    {
        System.out.print(as.get(i)+"\t");
    }
    System.out.println();
    System.out.println("///////////////////////////////////////////////////////////");
    }
}
}
