/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.result;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 *
 * @author mnm
 * this class fetch result from xml file that craete from fet and with function "setdb" copy all value
 * to database
 */
public class fetchxml {

    public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
    public fetchxml(int id) {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

this.schollid=id;
    }

    public int schollid;
    public List fetch(){
List mnm=new ArrayList();
  try {
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("/home/mnm/fet-results/timetables/mnm-single/mnm_activities.xml"));
            content ni=new content();


            // normalize text representation
            doc.getDocumentElement ().normalize ();
            NodeList listOftype = doc.getElementsByTagName("Activities_Timetable");
            int totaltype = listOftype.getLength();
            Node ftNode = listOftype.item(0);
            if(ftNode.getNodeType() == Node.ELEMENT_NODE){
                Element ftElement = (Element)ftNode;
                NodeList nList = ftElement.getElementsByTagName("Activity");

                for(int i=0;i<nList.getLength();i++)
                {
                    ni=new content();
                    Node ftNodes = nList.item(i);
                    Element ftElements = (Element)ftNodes;
                    NodeList nListid = ftElements.getElementsByTagName("Id");
                    NodeList nListday = ftElements.getElementsByTagName("Day");
                    NodeList nListhour = ftElements.getElementsByTagName("Hour");
                    Element nElement = (Element)nListid.item(0);
                    NodeList tnList = nElement.getChildNodes();
                    String name=((Node)tnList.item(0)).getNodeValue().trim();
//                    System.out.println(name);
                    ni.setId(name);
                    nElement = (Element)nListday.item(0);
                    tnList = nElement.getChildNodes();
                    name=((Node)tnList.item(0)).getNodeValue().trim();
//                    System.out.println(name);
                    ni.setDay(name);
                    nElement = (Element)nListhour.item(0);
                    tnList = nElement.getChildNodes();
                    name=((Node)tnList.item(0)).getNodeValue().trim();
//                    System.out.println(name);
                    ni.setHour(name);
                    mnm.add(ni);
                }

            }

        }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line "
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }
  return mnm;
}
    class content{
        String id;
        String day;
        String hour;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
    }
    public void setdb(List temp){
        Statement stmt = null;
		Connection conn = null;
        List result=new ArrayList();
//        String temp="";
        content ni=new content();
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            for(int i=0;i<temp.size();i++)
            {
                ni=(content) temp.get(i);
//                System.out.println("insert into result (schollid,darsid,darstime) select "+schollid+","+ni.getId()+",schollday.count*schollhour.count from schollday,schollhour where schollday.day='"+ni.getDay()+"' AND schollhour.name='"+ni.getHour()+"'");
                stmt.executeUpdate("insert into result (schollid,darsid,darstime) select "+schollid+","+ni.getId()+",schollday.count*schollhour.count from schollday,schollhour where schollday.day='"+ni.getDay()+"' AND schollhour.name='"+ni.getHour()+"'");
                // ;

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
    public int getstr(String day,String hour){
        int result=0;
        classresult ne=new classresult();
        List days=ne.gettitle(schollid);
        List hours=ne.gethour(schollid);
        for(int j=days.size()-1;j>-1;j--)
        {System.out.println(days.get(j));
                result++;
             if(days.get(j).equals(day))
                {for(int i=0;i<hours.size();i++)
            {

                                    if(hours.get(i).equals(hour))
                    {
                        break;
                    }
                }
            }
        }
        return result;

    }
    public void setpaygah(){
        Statement stmt = null;
		Connection conn = null;
        content ni=new content();
		try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
        classresult ne=new classresult();
        List days=new ArrayList();
        List hours=new ArrayList();
        days.add("شنبه");
        days.add("یک‌شنبه");
        days.add("دو‌شنبه");
        days.add("سه‌شنبه");
        days.add("چهار‌شنبه");
        days.add("پنج‌شنبه");
        days.add("جمعه");
        hours.add("08:00");
        hours.add("09:45");
        hours.add("11:00");
        for(int j=days.size()-1;j>-1;j--)
         for(int i=0;i<hours.size();i++)
            stmt.executeUpdate("insert into dandh (scholid,name) values ("+schollid+",'"+hours.get(i)+days.get(j)+"')");
                for(int j=days.size()-1;j>-1;j--)
        stmt.executeUpdate("insert into schollday (scholid,day,count) values ("+schollid+",'"+days.get(j)+"',"+(j+1)+")");
                     for(int i=0;i<hours.size();i++)
        stmt.executeUpdate("insert into schollhour (scholid,name,count) values ("+schollid+",'"+hours.get(i)+"',"+(i+1)+")");

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

    public static void main(String m[]){
        fetchxml mm=new fetchxml(1);
        List temp=mm.fetch();
        for(int i=0;i<temp.size();i++)
        {
            content nis=(content) temp.get(i);
            System.out.println(nis.getDay()+"\t"+nis.getHour()+"\t"+nis.getId());
        }
        mm.setdb(temp);
//        mm.setpaygah();

    }

}
