/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnm
 */
public class Professor {
    int _id;
    String _name;
    List<CourseClass> _courseClasses;


    public List<CourseClass> getCourseClasses() {
        return _courseClasses;
    }

    
    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }
    public Professor(int id, String name){
         _id=id;
         _name=name;
    }
    public void AddCourseClass(CourseClass courseClass)
    {
        if(!courseClass.equals(null))
//        System.out.println("prof "+courseClass._duration);
        _courseClasses=new ArrayList<CourseClass>();
      	_courseClasses.add( courseClass );
    }

}
