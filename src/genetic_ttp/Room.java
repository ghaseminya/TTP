/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

/**
 *
 * @author mnm
 */
public class Room {
    static int _nextRoomId;
    int _id;

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public static int getNextRoomId() {
        return _nextRoomId;
    }

    public int getNumberOfSeats() {
        return _numberOfSeats;
    }
    // Room name
    String _name;
    // Number of seats in room
    int _numberOfSeats;
    public Room(String name, int numberOfSeats) {
        _nextRoomId = 0;
        _id=_nextRoomId++;
        _name=name;
        _numberOfSeats=numberOfSeats;
    }
}
