/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.asatid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mnm
 */
public class asatidlist {
public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
	public asatidlist() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
public static void mains(String sa[]){
    asatidlist a=new asatidlist();
    String mnm="ali is good!";
    System.out.println(mnm.substring(0,mnm.length()-2));
    List m=a.selectAll(1);
    for(int i=0;i<m.size();i++)
    {
        asatid ni =(asatid) m.get(i);
        System.out.println(a.gettechid(ni.getSecuence()));
    }

//    List assd=a.selectAll(1);
//    for(int i=0;i<assd.size();i++)
//        {
//        asatid  ni=(asatid) assd.get(i);
//        System.out.println(ni.getLimitation()[0]+"\t"+ni.getLimitation()[1]+"\t"+ni.getLimitation().length);
//        System.out.println(ni.getName());
//        System.out.println(ni.getSecuence()[0]+"\t"+ni.getSecuence()[1]+"\t"+ni.getSecuence().length);
//        }
//List arrau=new ArrayList();
//    asatid mnm=new  asatid();
//    mnm.setName("محمد مهدی قاسمی نیا");
//    mnm.setLimitation(new boolean[]{true,true,true,true,true,true,false,true,true,true,true,true,true,false,true,true,true,true,true,true,false});
//    mnm.setPersenel("253685");
//    mnm.setSchollid("1");
//
////    mnm.setSecuence(new String[]{"JAVA","C++","PHP","JSP"});
//    arrau.add(mnm);
//    boolean m=true;
//    m=m?false:false;
}
        public List selectAll(int id) {
		Statement stmt = null;
		Connection conn = null;
		List allObjects = new ArrayList();
		try {
            
			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from masters where schollid="+id+"  ORDER BY id DESC");
			asatid ni;
			while (rs.next()) {
				ni = new asatid();
                ni.setId(rs.getInt(1));
                ni.setName(rs.getString(2));
                ni.setLimitation(getbol(rs.getString(3)));
                ni.setSum(rs.getInt(9));
                ni.setAct(rs.getInt(10));
                ni.setSecuence(rs.getString(4));
                ni.setSchollid(rs.getString(5));
                ni.setPersenel(rs.getString(6));
                ni.setComent(rs.getString(7));

				allObjects.add(ni);
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
		return allObjects;
	}




        public void insert(asatid mnm) {
		Statement stmt = null;
		Connection conn = null;
		try {

			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
                String limit="";
                int sum=0;
                for(int j=0;j<mnm.getLimitation().length;j++)
                {if(mnm.getLimitation()[j]){limit=limit+"1";sum++;}
                    else limit+="0";}
                String techid=gettechid(mnm.getSecuence());
                stmt.executeUpdate("insert into masters (name,limitation,teach,schollid,persenelid,comment,act,sum,teachid)" +
                        "values ('"+mnm.getName()+"','"+limit+"','"+mnm.getSecuence()+"','"+mnm.getSchollid()+"','"+mnm.getPersenel()+"','"+mnm.getComent()+"',0,"+sum+",'"+techid+"') ");

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
        public void delete(int masid) {
		Statement stmt = null;
		Connection conn = null;
		try {

			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
                stmt.executeUpdate("delete from masters where id="+masid);

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
           public void update(asatid mnm,int id) {
		Statement stmt = null;
		Connection conn = null;
		try {

			// get connection
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            String limit="";
            int sum=0;
            for(int j=0;j<mnm.getLimitation().length;j++)
            {if(mnm.getLimitation()[j]){limit=limit+"1";sum++;}
                else limit+="0";}
            stmt.executeUpdate("update  masters set name='"+mnm.getName()+"',limitation='"+limit+"',teach='"+mnm.getSecuence()+"',schollid='"+mnm.getSchollid()+"',persenelid='"+mnm.getPersenel()+"',comment='"+mnm.getComent()+"',sum="+sum+" where id="+id+" ");

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
    public boolean[] getbol(String s){
        boolean result[]=new boolean[s.length()];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                result[i]=true;
            else
                result[i]=false;

        }
        return result;
    }
    public int getint(String s){
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                result++;

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
    public String gettechid(String s){
    String result="";
    List temp=getstr(s);
//    Collections.sort(temp);
    Statement stmt = null;
	Connection conn = null;
	try {
        conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
		stmt = conn.createStatement();
        String query="";
        for(int i=0;i<temp.size();i++){
            String temps=temp.get(i).toString().replace(" ","");
            query+=" name='"+temps+"' or";
        }
        
        if(temp.size()>0){
        query=query.substring(0,query.length()-2);
        ResultSet rs=stmt.executeQuery("select code from dars where "+query+" ORDER BY name");//name='asdaasdasda' or name='arabi' or name='asda'
        while (rs.next()) {
            result+=rs.getString(1);
            result+="|";

            }
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
public static void main(String as[]){
asatidlist mnm=new asatidlist();
System.out.println(mnm.selectAll(1).size());

}
}
