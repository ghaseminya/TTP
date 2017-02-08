package mnm.xml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class create {

     public static void main(String[] args) {
      create mnm=new create();
      mnm.create();
  }

    public void create(){
        String name="";
        int stunum=0;
        sqlfetch db=new sqlfetch(1);
        String[] hourename = db.gethourename();//list of hor name
        String[] dayname = db.getdayname();//list of day name
        String[] teacher = db.getteacher();//list of name of all teacher
        String[] Subject = db.getSubject();//list of name of all dars

        String[] stu =db.getstu();//list of name of all class
        String[][] activi =db.getactivi();//list of all activity with data in it
        List arrayob=db.getarrayob();//list of all conflictred list dars
        try{
            PrintStream out = new PrintStream(new FileOutputStream("/home/mnm/Desktop/fet.xml"));
            out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            out.println("<!DOCTYPE FET><FET version=\"5.10.1\">");
            out.println("<Institution_Name>سادات</Institution_Name>");
            out.println("<Comments>this is the first test of my program</Comments>");
            
            out.println("<Hours_List>");
            out.println("<Number>"+hourename.length+"</Number>");
            for (int i=0;i<hourename.length;i++)
            {
                out.println("<Name>"+hourename[i]+"</Name>");
            }
            out.println("</Hours_List>");

//////////////////////////////////////////////////////////////////////////////////////////////////

            out.println("<Days_List>");
            out.println("<Number>"+dayname.length+"</Number>");
            for (int i=0;i<dayname.length;i++)
            {
                out.println("<Name>"+dayname[i]+"</Name>");
            }
            out.println("</Days_List>");

//////////////////////////////////////////////////////////////////////////////////////////////////

            out.println("<Students_List>");
            out.println("<Year>");
            for (int i=0;i<stu.length;i++)
            {
                out.println("<Group>");
                out.println("<Name>"+stu[i]+"</Name>");
                out.println("<Number_of_Students>0</Number_of_Students>");
                out.println("</Group>");
            }
            out.println("</Year>");
            out.println("</Students_List>");

//////////////////////////////////////////////////////////////////////////////////////////////////

            out.println("<Teachers_List>");
            for (int i=0;i<teacher.length;i++)
            {
                out.println("<Teacher>");
                out.println("<Name>"+teacher[i]+"</Name>");
                out.println("</Teacher>");
            }
            out.println("</Teachers_List>");

//////////////////////////////////////////////////////////////////////////////////////////////////

            out.println("<Subjects_List>");
            for (int i=0;i<Subject.length;i++)
            {
                out.println("<Subject>");
                out.println("<Name>"+Subject[i]+"</Name>");
                out.println("</Subject>");
            }
            out.println("</Subjects_List>");

//////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("<Activities_List>");
            for (int i=0;i<activi.length;i++)
            {
                out.println("<Activity>");
                out.println("<Teacher>"+activi[i][0]+"</Teacher>");
                out.println("<Subject>"+activi[i][3]+"</Subject>");
                out.println("<Duration>"+1+"</Duration>");//activi[i][2]
                out.println("<Total_Duration>"+1+"</Total_Duration>");//activi[i][2]
                out.println("<Id>"+activi[i][4]+"</Id>");
                out.println("<Activity_Group_Id>"+activi[i][4]+"</Activity_Group_Id>");
                out.println("<Active>true</Active>");
                out.println("<Students>"+activi[i][2]+"</Students>");
                out.println("</Activity>");
            }
            out.println("</Activities_List>");
            out.println("<Buildings_List>");
            out.println("</Buildings_List>");
            out.println("<Rooms_List>");
            out.println("</Rooms_List>");


//////////////////////////////////////////////////////////////////////////////////////////////////

            out.println("<Time_Constraints_List>");
            out.println("<ConstraintBasicCompulsoryTime>100</ConstraintBasicCompulsoryTime>");
            for (int i=0;i<arrayob.size();i++)
            {
                out.println("<ConstraintTeacherNotAvailableTimes>");
                out.println("<Weight_Percentage>100</Weight_Percentage>");
                sqlfetch.teacherdb ni=(sqlfetch.teacherdb) arrayob.get(i);
                out.println("<Teacher>"+ni.getName()+"</Teacher>");
                out.println("<Number_of_Not_Available_Times>"+ni.getNumber()+"</Number_of_Not_Available_Times>");
                List te=ni.getArr();
                for(int j=0;j<te.size();j=j+2)
                {
                    out.println("<Not_Available_Time>");
                    out.println("<Day>"+te.get(j)+"</Day>");
                    out.println("<Hour>"+te.get(j+1)+"</Hour>");
                    out.println("</Not_Available_Time>");
                }


                out.println("</ConstraintTeacherNotAvailableTimes>");
            }
            out.println("</Time_Constraints_List>");
            out.println("</FET>");
        }
        catch (IOException e)
        {
            System.err.println ("Unable to write to file");
			System.exit(-1);
		}
        System.out.println("mnm i ok compltet!");


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
}
