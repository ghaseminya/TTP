package mnm.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mnm.hibernate.Room;
import mnm.hibernate.RoomHome;
public class tests {
	public  String connectionString = "jdbc:mysql://localhost/TTP?characterEncoding=UTF-8";
	public String[] recumenuv_as_arr(int id){
		String[] result=new String[0];
		
		
		
		Statement stmt = null;
				Connection conn = null;
				
				List<Integer> allObjects = new ArrayList<Integer>();
				try {
		            
					// get connection
					conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
					stmt = conn.createStatement();
					if(id==1)
					{
						ResultSet rs = stmt.executeQuery("select name from coursegroup where id=1");
						String temp="";
						while(rs.next()){
							 temp=rs.getString(1);
						}
						result[0]=temp;
						return result;
					}
					ResultSet rs = stmt.executeQuery("select one.id,two.id,two.id_subgroup from coursegroup as one inner join coursegroup as two on one.id_subgroup=two.id order by one.id DESC");
					boolean key=false;
					while (rs.next()) {
						if(id==rs.getInt(1)||key)
						if(allObjects.size()!=0){
							key=true;
							if(allObjects.get(allObjects.size()-1)==rs.getInt(1))
							{
								allObjects.add(rs.getInt(2));
								allObjects.add(rs.getInt(3));
						    }
						}else{
							key=true;
					allObjects.add(rs.getInt(1));
					allObjects.add(rs.getInt(2));
					allObjects.add(rs.getInt(3));
					
						}
						}
					if(allObjects.get(allObjects.size()-1)==0)
					allObjects.remove(allObjects.size()-1);
					String sql="";
					for(int j=allObjects.size()-1;j>=0;j--)
						sql+="id="+allObjects.get(j)+" or ";
					sql=sql.substring(0,sql.length()-3);
					
					result=new String[allObjects.size()];
					int i=0;
					rs = stmt.executeQuery("select name from coursegroup where "+sql+"order by id DESC");
					while(rs.next()){
						result[i]=rs.getString(1);
						i++;
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
	public String recumenuv_as_str(int id){
		Statement stmt = null;
				Connection conn = null;
				String result="";
				List<Integer> allObjects = new ArrayList<Integer>();
				try {
		            
					// get connection
					conn = DriverManager.getConnection(connectionString,"root","mtaksir@qom.");
					stmt = conn.createStatement();
					if(id==1)
					{
						ResultSet rs = stmt.executeQuery("select name from coursegroup where id=1");
						String temp="";
						while(rs.next()){
							 temp=rs.getString(1);
						}
						result=temp;
						return result;
					}
					ResultSet rs = stmt.executeQuery("select one.id,two.id,two.id_subgroup from coursegroup as one inner join coursegroup as two on one.id_subgroup=two.id order by one.id DESC");
					boolean key=false;
					while (rs.next()) {
						if(id==rs.getInt(1)||key)
						if(allObjects.size()!=0){
							key=true;
							if(allObjects.get(allObjects.size()-1)==rs.getInt(1))
							{
								allObjects.add(rs.getInt(2));
								allObjects.add(rs.getInt(3));
						    }
						}else{
							key=true;
					allObjects.add(rs.getInt(1));
					allObjects.add(rs.getInt(2));
					allObjects.add(rs.getInt(3));
					
						}
						}
					if(allObjects.get(allObjects.size()-1)==0)
					allObjects.remove(allObjects.size()-1);
					String sql="";
					for(int j=allObjects.size()-1;j>=0;j--)
						sql+="id="+allObjects.get(j)+" or ";
					sql=sql.substring(0,sql.length()-3);
					
					rs = stmt.executeQuery("select name from coursegroup where "+sql+"order by id DESC");
					while(rs.next()){
						result+=rs.getString(1)+"/";
					}
					result=result.substring(0,result.length()-1);
					
					
					
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
	public static void main(String a[]){
//		tests mnm=new tests();
//		String as=mnm.recumenuv_as_str(11);
//		mnm.hibernate.RoomHome rooms=new RoomHome();
		mnm.hibernate.Room rm=new Room();
		 Room room=new Room();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpatest");
		EntityManager em=emf.createEntityManager();
		try{
		EntityTransaction entr=em.getTransaction();
		entr.begin();
		//first query
		Query query=em.createNamedQuery("Room.findAll");
		query.setParameter(1, 1);
		List stList=query.getResultList();
		Iterator stIterator=stList.iterator();
		while(stIterator.hasNext()){
		Room st=(Room)stIterator.next();
		System.out.print("sname:"+st.getBuilding());
		System.out.print(" sroll:"+st.getFlor());
		System.out.print(" scourse:"+st.getName());
		System.out.println();
		}
		//second query

		Query update_query=em.createNamedQuery("updateroom");
		update_query.setParameter(1, "yxpf");
		update_query.setParameter(2, "mnm is ok");
		int updateData=update_query.executeUpdate();
		System.out.println(updateData +" record updated");

		entr.commit();
		}
		finally{
		em.close();
		}


		System.out.println("----------Data of Home-----------");
		System.out.println(rm.getId());
		System.out.println(rm.getFlor());
		System.out.println(rm.getBuilding());
		System.out.println(rm.getLab());
		System.out.println(rm.getName());
	}
}
