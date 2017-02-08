/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

import java.util.ListIterator;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author mnm
 */
public class Main {
public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
    
    
    public boolean fetchconfig(String filename)
    {
Configuration test=new Configuration();
        if(true){
         
        test.getfromdatabase();
//        System.out.println(test.getCourseClasses().size());
        ListIterator keys = test.getCourseClasses().listIterator();
//        System.out.println("befor loop"+keys.);
//        for(int i=0;i<10;i++  )
//        {
//            CourseClass temp=(CourseClass)keys.next();
//            System.out.printf( "%-10s\n", temp._groups.get(0)._name );
//        }
//        Configuration conf=new Configuration();
        Schedule prototype = new Schedule( 2, 2, 80, 3,test);
        Algorithm target=new Algorithm(100, 8, 5, prototype);
//        System.out.println(target._prototype.DAYS_NUM+"<<<<<<<<<<<<<<this is day num");
        Schedule sample=target.Start();//



        System.out.println(target._chromosomes.get(target._bestChromosomes.get(0))._fitness+"<<<<<<<<<<<<<<this is fitness");
//        settodatabase(sample);
//        System.out.println(sample._fitness+"<<<<<<<<<<<<<<this is day num");
        }else{
        test.settodatabase();
//        test.settodatabase();
//            test.getfromdatabase();
        }
return true;
	// Parsed student groups

    }
    public void settodatabase(Schedule sch){

        Set<CourseClass> cs=sch._classes.keySet();
         Statement stmt = null;
        Connection conn= null;
        try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();

                        stmt.executeUpdate("delete from room_week_busy ");
                        Configuration con1=new Configuration();
                        con1.getfromdatabase();
                        int ro=con1.GetNumberOfRooms();
                        int day=sch.DAYS_NUM;
                        int hou=sch.DAY_HOURS;
                        int dayt=0;int roomt=0;int hout=0;int i=0;int r=0;int roomprim=0;
                        String data[][]=new String[ro][5];
                        for(CourseClass cst:cs)
                        {
                            data[r][0]=cst._course._name;
                            data[r][1]=cst._professor._name;
                            data[r][2]=cst._numberOfSeats+"";
                            dayt=i/(hou*ro);
                           roomt=(int)Math.ceil((i-(dayt*(hou*ro)))/hou);
                            
                            hout=(i-(dayt*(hou*ro)))-(hou*(roomt-1));
                            dayt++;
                            data[r][3]=dayt+"";
                            data[r][4]=hout+"";
//                            System.out.println(r+"day: \t"+(dayt)+"room#\t"+(roomt)+"hou#\t"+hout+"\t"+cst._course._name);
                            if(roomt>roomprim)r++;
                                roomprim=roomt;

                            stmt.executeUpdate("insert into room_week_busy (id,prof,course,seatnum,day,hour) values ("+roomt+",'"+cst._professor._name+"','"+cst._course._name+"',"+cst._numberOfSeats+","+dayt+","+(hout-3)+")");
                            i++;
                        }

//                         stmt.executeUpdate("insert into ");

		} catch (SQLException e) {
			e.printStackTrace();
            //System.out.println("1");
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
    public static void main(String[] args) {
        // TODO code application logic here
        Main mnm=new Main();
//        mnmrandom as=new mnmrandom();
//       System.out.println(as.randomstring(1, 2));
        mnm.fetchconfig("");
         /*int ro=3;
         int day=3;
         int hou=3;
         int dayt=0;
         int roomt=0;
         int hout=0;
         int i=24;
         dayt=i/(hou*ro);
         roomt=(int)Math.ceil((i-(dayt*(hou*ro)))/hou);
         hout=(i-(dayt*(hou*ro)))-(hou*(roomt-1));
         System.out.println("day: \t"+(dayt+1)+"room#\t"+(roomt)+"hou#\t"+hout);*/

    }

    public Main() {
        //try {
		//	Class.forName("com.mysql.jdbc.Driver");
		//} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		//}

    }

}