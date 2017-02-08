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
public class StudentsGroup {
    int _id;
    // Name of student group
    String _name;
    // Number of students in group
    int _numberOfStudents;
    // List of classes that group attends
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

    public int getNumberOfStudents() {
        return _numberOfStudents;
    }

    public StudentsGroup(int id, String name, int numberOfStudents) {
        _id=id;
        _name=name;
        _numberOfStudents= numberOfStudents;
    }
 public  void AddClass(CourseClass courseClass)
{
     _courseClasses =new ArrayList<CourseClass>();
	_courseClasses.add( courseClass );
}


}
