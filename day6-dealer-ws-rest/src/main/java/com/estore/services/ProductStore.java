package com.estore.services;

import com.estore.common.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductStore {
	
	public List<Product> getAllProducts(String name) throws SQLException{
		List<Product> ls = new ArrayList<Product>();
		ResultSet rs=null;
		ConnectDB db = new ConnectDB();
		Connection con = db.getConnection();
		PreparedStatement st=null;
		st=con.prepareStatement("select * from products where pname=?");
		st.setString(1, name);
		rs=st.executeQuery();
		while(rs.next()){
			Product p = new Product();
			p.setModel(rs.getString("pmodel"));
			p.setName(rs.getString("pname"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			ls.add(p);
		}
		return ls;
		}
		
	public double getprice(String pmodel) throws SQLException {
		ConnectDB db = new ConnectDB();
		Connection con = db.getConnection();
		PreparedStatement st=null;
		ResultSet rs=null;
		double price=0.0;
		st=con.prepareStatement("select price from products where pmodel=?");
		st.setString(1, pmodel);
		rs=st.executeQuery();
		while(rs.next())
			price=rs.getInt("price");
		return price;
	}
	}
	


