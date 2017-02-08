/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mnm
 */
public class CourseClass {

    String _name;

    public String getName() {
        return _name;
    }
    Professor _professor;
    // Course to which class belongs
    Course _course;
    // Student groups who attend class
    List<StudentsGroup> _groups;
    // Number of seats (students) required in room
    int _numberOfSeats;
    // Duration of class in hours
    int _duration;

    public Course getCourse() {
        return _course;
    }

    public int getDuration() {
        return _duration;
    }

    public List<StudentsGroup> getGroups() {
        return _groups;
    }

    public int getNumberOfSeats() {
        return _numberOfSeats;
    }

    public Professor getProfessor() {
        return _professor;
    }
    public CourseClass(String name,Professor professor, Course course,List<StudentsGroup> groups, int duration) {
        _name=name;
        _professor=professor;
        _course=course;
        _numberOfSeats=0;
        _duration=duration;
//        System.out.println(this._duration);
        _professor.AddCourseClass( this );
        // bind student groups to class
        for( int it=0;it<groups.size();it++ )
        {
            groups.get(it).AddClass(this);
            _groups=new ArrayList<StudentsGroup>();
            _groups.add(groups.get(it));
            _numberOfSeats += groups.get(it).getNumberOfStudents();
        }
    }
// Returns TRUE if another class has one or overlapping student groups.
public boolean GroupsOverlap(CourseClass c )
{
    for(int i=0;i<_groups.size();i++)
        for(int j=0;j<c._groups.size();j++)
        {
            if(_groups.get(i).equals(c._groups.get(j))){
//                System.out.println(c._groups.get(j)._name+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+_groups.get(i)._name);
                return true;}
        }
	return false;
}
public boolean ProfessorOverlaps(CourseClass c )
{
//    JOptionPane.showMessageDialog(null,c._professor._name+"|"+_professor._name,"sad", 0);
    return _professor == c._professor;
}
}

