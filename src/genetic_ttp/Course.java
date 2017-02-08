/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

/**
 *
 * @author mnm
 */
public class Course {
    public int _id;
    public String _name;

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }
    public Course(int id, String name) {
        _id=id;
        _name=name;
    }
}
