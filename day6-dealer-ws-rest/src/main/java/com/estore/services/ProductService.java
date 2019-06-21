package com.estore.services;


import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.estore.common.Product;

@Path("/Products")
public class ProductService {
	
   ProductStore ps = new ProductStore();
   /*private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";*/


   @GET
   @Path("/list")
   @Produces(MediaType.APPLICATION_XML)
   public List<Product> getAllProducts(@QueryParam("name")String name) throws SQLException{
   return ps.getAllProducts(name);
   }
   
      
   @GET
   @Path("/price")
   @Produces(MediaType.TEXT_PLAIN)
   public double getPrice(@QueryParam("model")String model) throws SQLException{
	   System.out.println("The price of product is" + ps.getprice(model));
	   return ps.getprice(model);
   }
   
   }
