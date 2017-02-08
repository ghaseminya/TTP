/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mnm
 */
public class Configuration {
    public int NumberOfRoom;
    public int NumberOfCourseclass;
    public List<CourseClass> listcourseclass;
    public int duration;
    public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";

    public int mnm_NUMprof=13;
    public int mnm_NUMroom=2;
    public int mnm_NUMcourse=8;
    public int mnm_NUMstu=4;
    public int mnm_NUMcoucla=20;

    public List<CourseClass> getCourseClasses() {
        return _courseClasses;
    }

    public Map<Course, Integer> getCourses() {
        return _courses;
    }

    public boolean isIsEmpty() {
        return _isEmpty;
    }

    public Map<Professor, Integer> getProfessors() {
        return _professors;
    }

    public Map<Room, Integer> getRooms() {
        return _rooms;
    }

    public Map<StudentsGroup, Integer> getStudentGroups() {
        return _studentGroups;
    }
    public Room roomid;
    Map<Professor,Integer> _professors=new HashMap<Professor, Integer>();
    Map< StudentsGroup,Integer> _studentGroups=new HashMap<StudentsGroup, Integer>();
    // Parsed courses
    Map< Course,Integer> _courses=new HashMap<Course, Integer>();
    // Parsed rooms
    Map< Room,Integer> _rooms=new  HashMap<Room, Integer>();
    // Parsed classes
    List<CourseClass> _courseClasses;
    // Inidicate that configuration is not prsed yet
    boolean _isEmpty;
    public mnmrandom rand=new mnmrandom();

    public Configuration() {
try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//    randomcomplete();
//getfromdatabase();
    }
    public void randomcomplete(){
        Professor prof[]=new Professor[mnm_NUMprof];
        Course cou[]=new  Course[mnm_NUMcourse];
        StudentsGroup stu[]=new StudentsGroup[mnm_NUMstu];

        String room[]=new String[mnm_NUMroom];
        int roomseat[]=new int[mnm_NUMroom];
        for(int i=0;i<10;i++)
        {
            String temp=rand.randomstring(1, 6);
            prof[i]=new Professor(i,temp );
            _professors.put(prof[i],i);
        }

        for(int i=0;i<10;i++)
        {
            String temp=rand.randomstring(1, 6);
            int tempi=rand.rand(15, 30);
//            ////System.out.println(" id "+temp+"name"+tempi);
            stu[i]=new StudentsGroup(i,temp ,tempi );
//            ////System.out.println(stu[i]._id+" id "+stu[i].getName()+"name "+stu[i].getNumberOfStudents()+" ;");
            _studentGroups.put(stu[i] ,i);
        }

        for(int i=0;i<10;i++)
        {
            String temp=rand.randomstring(1, 6);
            cou[i]=new Course(i, temp);
            _courses.put(cou[i], i);
        }

        for(int i=0;i<10;i++)
        {
            String temp=rand.randomstring(1, 6);
            int tempi=rand.rand(20, 40);
            room[i]=temp;
            roomseat[i]= tempi;
            _rooms.put(new Room(room[i],roomseat[i]), i);
        }

        

        _courseClasses=new ArrayList<CourseClass>();
        for(int i=0;i<10;i++)
        {
            List<StudentsGroup> tmep=new ArrayList<StudentsGroup>(1);
//            ////System.out.println(i+"this is :"+stu[i].getName());
            tmep.add( stu[i]);
            int tempi=rand.rand(1,2);
//            _courseClasses.add(i, new CourseClass(prof[i], cou[i],tmep, tempi));
        }


    }
    public void settodatabase(){
//    List temp=new ArrayList();
//        String day[]=new String[]{"shanbe","yek","do","se","char","pang","jome"};
//        String houre[]=new String[]{"1","2","3"};
        Professor prof[]=new Professor[mnm_NUMprof];
        Course cou[]=new  Course[mnm_NUMcourse];
        StudentsGroup stu[]=new StudentsGroup[mnm_NUMstu];

        String room[]=new String[mnm_NUMroom];
        int roomseat[]=new int[mnm_NUMroom];

        Statement stmt = null;
	Connection conn = null;
        try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
                        stmt.executeUpdate("delete from room");
                        stmt.executeUpdate("delete from course");
                        stmt.executeUpdate("delete from prof");
                        stmt.executeUpdate("delete from stu");
                        stmt.executeUpdate("delete from soustu");
                        stmt.executeUpdate("delete from list_id");
                        for(int i=0;i<mnm_NUMprof;i++)
        {
            String temp=rand.randomstring(1, 6);
            prof[i]=new Professor(i,temp );
                     stmt.executeUpdate("insert into prof (name,id) values ('"+temp+"',"+i+")");
            _professors.put(prof[i],i);
        }

        for(int i=0;i<mnm_NUMstu;i++)
        {
            String temp=rand.randomstring(1, 6);
            int tempi=rand.rand(15, 30);
//            ////System.out.println(" id "+temp+"name"+tempi);
            stu[i]=new StudentsGroup(i,temp ,tempi );
//            ////System.out.println(stu[i]._id+" id "+stu[i].getName()+"name "+stu[i].getNumberOfStudents()+" ;");
            stmt.executeUpdate("insert into stu (name,id,seat) values ('"+temp+"',"+i+","+tempi+")");
            _studentGroups.put(stu[i] ,i);
        }

        for(int i=0;i<mnm_NUMcourse;i++)
        {
            String temp=rand.randomstring(1, 6);
            cou[i]=new Course(i, temp);
            stmt.executeUpdate("insert into course (name,id) values ('"+temp+"',"+i+")");
            _courses.put(cou[i], i);
        }

        for(int i=0;i<mnm_NUMroom;i++)
        {
            String temp=rand.randomstring(1, 6);
            int tempi=rand.rand(20, 40);
            room[i]=temp;
            roomseat[i]= tempi;
            stmt.executeUpdate("insert into room (name,id,seat) values ('"+temp+"',"+i+","+tempi+")");
            _rooms.put(new Room(room[i],roomseat[i]), i);
        }



        _courseClasses=new ArrayList<CourseClass>();
        for(int i=0;i<mnm_NUMcoucla;i++)
        {
            List<StudentsGroup> tmep=new ArrayList<StudentsGroup>(1);
//            ////System.out.println(i+"this is :"+stu[i].getName());
            int studentgrouprandomnumber=rand.rand(1, mnm_NUMstu);
            int id[]=new int[mnm_NUMstu];
            int tempi=1;//rand.rand(1,2);
            String name=rand.randomstring(7,7);
            for(int u=0;u<1;u++)//studentgrouprandomnumber
            {
                id[u]=rand.rand(0, mnm_NUMstu-1);
                tmep.add( stu[id[u]]);
                stmt.executeUpdate("insert into list_id (id,list_id) values ("+i+","+id[u]+")");
            }
            stmt.executeUpdate("insert into soustu (name,prof_name,id,course_name,dur,listnum) values ('"+name+"','"+prof[i%mnm_NUMprof].getName()+"',"+i+",'"+cou[i%mnm_NUMcourse].getName()+"',"+tempi+","+1+")");
            _courseClasses.add(i, new CourseClass(name,prof[i%mnm_NUMprof], cou[i%mnm_NUMcourse],tmep, tempi));
        }
		} catch (SQLException e) {
			e.printStackTrace();
            ////System.out.println("1");
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
    public void getfromdatabase(){
//    List temp=new ArrayList();
//        String day    []=new String[]{"shanbe","yek","do","se","char","pang","jome"};
//        String houre[]=new String[]{"1","2","3"};
        Professor prof;
        Course cou;
        StudentsGroup stu;
         StudentsGroup stuarr[]=new StudentsGroup[10];

        Room room;

        Statement stmt = null;
        Statement stmt2 = null;
	Connection conn = null;
        Connection conn2= null;
        try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id,name from prof ");
        _professors=new HashMap<Professor, Integer>();
        while (rs.next()){
            prof=new Professor(rs.getInt(1),rs.getString(2) );
            _professors.put(prof,rs.getInt(1));
        }

        rs = stmt.executeQuery("select id,name,seat from stu ");
        _studentGroups=new HashMap<StudentsGroup, Integer>();
        while(rs.next())
        {
            stu=new StudentsGroup(rs.getInt(1),rs.getString(2) ,rs.getInt(3) );
            stuarr[rs.getInt(1)]=new StudentsGroup(rs.getInt(1),rs.getString(2) ,rs.getInt(3) );
            _studentGroups.put(stu ,rs.getInt(1));
        }
        rs = stmt.executeQuery("select id,name from course ");
        _courses=new HashMap<Course, Integer>();
        while(rs.next())
        {
            cou=new Course(rs.getInt(1), rs.getString(2));
            _courses.put(cou, rs.getInt(1));
        }
        rs = stmt.executeQuery("select id,name,seat from room ");
        _rooms=new  HashMap<Room, Integer>();
        while(rs.next())
        {
            room=new Room(rs.getString(2), rs.getInt(3));
            _rooms.put(room, rs.getInt(1));
        }



        rs = stmt.executeQuery("select id,prof_name,course_name,dur,listnum,name from soustu ");
        conn2 = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
	stmt2 = conn.createStatement();
        _courseClasses=new ArrayList<CourseClass>();
        while(rs.next())
        {
//            ////System.out.println( "rs.getString(1) ="+rs.getInt(1)+"rs.getString(2) ="+rs.getString(2)+"rs.getString(3) ="+rs.getString(3)+"rs.getString(4) ="+rs.getString(4));
            Professor as=new Professor( rs.getInt(1),rs.getString(2));
            Course as2=new Course(rs.getInt(1),rs.getString(3));
            List<StudentsGroup> tmep=new ArrayList<StudentsGroup>(rs.getInt(5));
            ResultSet rs2 = stmt2.executeQuery("select id,list_id from list_id where id="+rs.getInt(1));
            while(rs2.next())
            {
                tmep.add(stuarr[rs2.getInt(2)]);
//                ////System.out.println("rs2.getInt(2):"+rs2.getInt(2));
            }
            
            

            _courseClasses.add(rs.getInt(1), new CourseClass(rs.getString(6),as, as2, tmep, rs.getInt(4)));
        }
//                for(int j=0;j<mnm.getLimitation().length;j++)
//                {if(mnm.getLimitation()[j]){limit=limit+"1";sum++;}
//                    else limit+="0";}
//                String techid=gettechid(mnm.getSecuence());
//                stmt.executeUpdate("insert into masters (name,limitation,teach,schollid,persenelid,comment,act,sum,teachid)" +
//                        "values ('"+mnm.getName()+"','"+limit+"','"+mnm.getSecuence()+"','"+mnm.getSchollid()+"','"+mnm.getPersenel()+"','"+mnm.getComent()+"',0,"+sum+",'"+techid+"') ");
//

		} catch (SQLException e) {
			e.printStackTrace();
            ////System.out.println("1");
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


 

    public int getDuration() {
        return duration;
    }

    public List<CourseClass> getListcourseclass() {
        return listcourseclass;
    }

    

    public int getNumberOfCourseclass() {
        return _courseClasses.size();
    }

    public int getNumberOfRoom() {
        return _rooms.size();
    }





	public  Professor GetProfessorById(int id)
	{
            Iterator iter2 = _professors.entrySet().iterator();// parent2._classes.begin();
            while(iter2.hasNext()){
                ////System.out.println("GetProfessorById : "+_professors.size());
                Map.Entry entry1 = (Map.Entry) iter2.next();
                int ro=( Integer)entry1.getValue();
                if(ro==id){
                    return ( Professor)entry1.getKey();
                }

            }
        return null;
	}

	// Returns number of parsed professors
	public int GetNumberOfProfessors()
        { return (int)_professors.size(); }

	// Returns pointer to student group with specified ID
	// If there is no student group with such ID method returns NULL
	public  StudentsGroup GetStudentsGroupById(int id)
	{
                        Iterator iter2 = _studentGroups.entrySet().iterator();// parent2._classes.begin();
            while(iter2.hasNext()){
                ////System.out.println("GetStudentsGroupById : "+_studentGroups.size());
                Map.Entry entry1 = (Map.Entry) iter2.next();
                int ro=( Integer)entry1.getValue();
                if(ro==id){
                    return ( StudentsGroup)entry1.getKey();
                }

            }
        return null;


	}

	// Returns number of parsed student groups
	public int GetNumberOfStudentGroups()
        { return (int)_studentGroups.size(); }

	// Returns pointer to course with specified ID
	// If there is no course with such ID method returns NULL
	public  Course GetCourseById(int id)
	{
		  Iterator iter2 = _courses.entrySet().iterator();// parent2._classes.begin();
            while(iter2.hasNext()){
                ////System.out.println("GetCourseById : "+_courses.size());
                Map.Entry entry1 = (Map.Entry) iter2.next();
                int ro=( Integer)entry1.getValue();
                if(ro==id){
                    return ( Course)entry1.getKey();
                }

            }
        return null;
	}

	public int GetNumberOfCourses()
        { return (int)_courses.size(); }

	// Returns pointer to room with specified ID
	// If there is no room with such ID method returns NULL
	public Room GetRoomById(int id)
	{
		Iterator iter2 = _rooms.entrySet().iterator();// parent2._classes.begin();
            while(iter2.hasNext()){
                ////System.out.println("GetCourseById : "+_rooms.size());
                Map.Entry entry1 = (Map.Entry) iter2.next();
                int ro=( Integer)entry1.getValue();
                if(ro==id){
                    return ( Room)entry1.getKey();
                }

            }
                return  null;
	}

	// Returns number of parsed rooms
	public int GetNumberOfRooms()
        { return (int)_rooms.size(); }

	// Returns reference to list of parsed classes
	 public List<CourseClass>  GetCourseClasses()
         { return _courseClasses; }

	// Returns number of parsed classes
	public int GetNumberOfCourseClasses()
        { return (int)_courseClasses.size(); }

	// Returns TRUE if configuration is not parsed yet
	public boolean IsEmpty()
        { return _isEmpty; }



}
