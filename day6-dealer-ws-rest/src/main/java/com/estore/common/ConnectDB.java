package com.estore.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
	private Connection connection =null;
	public Connection getConnection(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/estoreone","root","root");
			
		}catch(Exception e){
			
			System.out.println("unable to connect to database check DB");
			
		}
		return connection;
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String name="mobile";
		String pid="m3";
		ResultSet rs=null;
		ConnectDB db = new ConnectDB();
		Connection con = db.getConnection();
		PreparedStatement st=null;
		st=con.prepareStatement("select * from products where pname=?");
		st.setString(1, name);
		rs=st.executeQuery();
		while(rs.next()){
			List<Product> ls = new ArrayList<Product>();
			Product p = new Product();
			p.setModel(rs.getString("pmodel"));
			p.setName(rs.getString("pname"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			ls.add(p);
			for(Product p1 : ls)
			System.out.println(p1.getName()+ " ," + p.getModel()+ ", " + p.getPrice()+ ", "+ p.getStock());
		}
		st=con.prepareStatement("select price from products where pid=?");
		st.setString(1, pid);
		rs=st.executeQuery();
		while(rs.next())
		System.out.println("Price of the mobile selected is :" +rs.getInt("price"));

	}

}
