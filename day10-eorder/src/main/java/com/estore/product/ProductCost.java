package com.estore.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.estore.common.ConnectDB;

public class ProductCost {
    public double getprice(String model) throws Exception{
        double price=0;
        Connection con=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        ConnectDB db = new ConnectDB();
        con=db.getConnection();
        st=con.prepareStatement("select price from products where pmodel=?");
        st.setString(1, model);
        rs=st.executeQuery();
        while(rs.next())
            price=rs.getInt("price");
        if(price >=5000 && price <=10000)
            price = price + price * .1;
        else if ( price > 10000 && price <=20000)
            price = price + price * .2;
        else 
            price = price + price * .3;
        return price;
        
        
    }
public static void main(String[]args) throws Exception{
    
    ProductCost p = new ProductCost();
    System.out.println("The final price is:" + p.getprice("mbm5"));
    
}
}