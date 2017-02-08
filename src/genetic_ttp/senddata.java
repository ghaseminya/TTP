/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

/**
 *
 * @author mnm
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mnm
 */
public class senddata {
    public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";

    public senddata() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
    public static void main(String a[]){
    senddata mnm=new senddata();
    mnm.getfromdatabase();
    }


    public String[][][] getfromdatabase(){
        Statement stmt = null;
        Connection conn= null;
        String data[][][]=new String[0][0][0];
        try {
			conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct id from room_week_busy ");
            int row=0;
            while(rs.next())
            {
                row++;
            }
            data=new String[row][3][8];
            rs = stmt.executeQuery("select room_week_busy.id , prof,course,seatnum,day,hour,seat, name from room_week_busy inner join room on room.id=room_week_busy.id");
            int i=0;int room=0;int j=0;
            while(rs.next())
            {
                if(room<rs.getInt(1))
                i++;
                data[i][j%3][0]=rs.getInt(1)+"";
                data[i][j%3][1]=rs.getString(2);
                data[i][j%3][2]=rs.getString(3);
                data[i][j%3][3]=rs.getInt(4)+"";
                data[i][j%3][4]=rs.getInt(5)+"";
                data[i][j%3][5]=rs.getInt(6)+"";
                data[i][j%3][6]=rs.getInt(7)+"";
                data[i][j%3][7]=rs.getString(8);
                j++;
                room=rs.getInt(1);

            }

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


        for(int is=0;is<data.length;is++){
            for(int jj=0;jj<3;jj++){
                for(int k=0;k<8;k++){

            System.out.print(data[is][jj][k]);
        }System.out.println();
            }System.out.println();}
int i=0;
 for(int j=0;j<3;j++){System.out.println("hour: "+j);
       for(int k=0;k<7;k++)
{
System.out.println(data[i][k%3][1]+"|"+data[i][k%3][2]+"|"+data[i][k%3][3]);
}
}
        return data;
    }

    /* fill datat from schudle
     *
     */


}
