package employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpDao {

	public static Connection getConnection()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sahil", "root", "");
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return con;
	}
	
	public static int save(Emp e)
	{
		Connection con = EmpDao.getConnection();
		String query = "insert into empp(name, password, email, country)"
				+ "values(?,?,?,?)";
		int status = 0;
		try 
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status=ps.executeUpdate();
			
		} 
		catch (SQLException e1) {
			System.out.println(e1);
		}
		
		return status;
	}
	
	public static List<Emp> getAllemployee()
	{
		List<Emp> list = new ArrayList<Emp>();
		String query = "select * from empp";
		
		try 
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				
				list.add(e);
			}
			con.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Emp getEmployee(int id) throws SQLException
	{
		String query = "select * from empp where id="+id;
				
		Connection con = EmpDao.getConnection();
		Emp e = new Emp();
		try
		{
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		con.close();
		return e;
		
	}
	
	public static int update(Emp e)
	{
		String query = "update empp set id=?,name=?,password=?,email=?,country=? where id="+e.getId();
		int status = 0;
		
		try 
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCountry());
			
			status=ps.executeUpdate();
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id)
	{
		int status = 0;
		String query = "delete from empp where id="+id;
		try 
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			status=ps.executeUpdate();
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return status;
	}
	
//	public static void main(String args[]) throws SQLException
//	{
//		Emp e = EmpDao.getEmployee(3);
//		System.out.println(e.getName());
//	}
	
}
