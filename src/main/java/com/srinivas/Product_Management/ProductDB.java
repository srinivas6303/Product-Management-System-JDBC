package com.srinivas.Product_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class ProductDB {
	 Connection con;
	
	public ProductDB() {
		String url="jdbc:mysql://localhost:3306/PMS";
		String username="root";
		String password="Srinu@4848";
		try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//SAVE
	public void save(Product p) {
		String query="Insert into product(name,type,place,warrenty) values (?,?,?,?)";
		
		try(PreparedStatement ps=con.prepareStatement(query)) {
		
		ps.setString(1, p.getName());
		ps.setString(2,p.getType());
		ps.setString(3,p.getPlace());
		ps.setInt(4,p.getWarrenty());
		int rowsAffected = ps.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Data saved!");
		}
		else {
			System.out.println("Data not saved!");
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// GET ALL PRODUCTS
	public void All() {
		String query="select * from product";
		boolean isproductpresent=false;
		
		try{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				isproductpresent=true;
				String name=rs.getString("name");
				String type=rs.getString("Type");
			    String place=rs.getString("place");
			    int warrenty=rs.getInt("warrenty");
			    System.out.println("Product: " + name + ", Type: " + type + 
                        ", Place: " + place + ", Warranty: " + warrenty);
			}
			
			if(!isproductpresent) {
				System.out.println("No products are present!");
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//GET PRODUCTS BY NAME
	public void getProductName(String name) {
		String newname=name.toLowerCase();
		String query="select * from product where name=?";
		boolean isproductpresetbyname=false;
		
		try{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,newname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				isproductpresetbyname=true;
				String namee=rs.getString("name").toLowerCase();
				String type=rs.getString("Type");
			    String place=rs.getString("place");
			    int warrenty=rs.getInt("warrenty");
			    System.out.println("Product: " + namee + ", Type: " + type + 
                        ", Place: " + place + ", Warranty: " + warrenty);
			}
			
			if(!isproductpresetbyname) {
				System.out.println("There is No product present with name: "+ name);
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//GET PRODUCTS BY PLACE
		public void getProductPlace(String text) {
			String newtext=text.toLowerCase();
			String query="select * from product where place=?";
			boolean isproductpresentplace=false;
			try{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,text);
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					isproductpresentplace=true;
					String name=rs.getString("name");
					String type=rs.getString("Type");
				    String place=rs.getString("place").toLowerCase();
				    int warrenty=rs.getInt("warrenty");
				    System.out.println("Product: " + name + ", Type: " + type + 
	                        ", Place: " + place + ", Warranty: " + warrenty);
				}
				
				if(!isproductpresentplace) {
					System.out.println("There is No product present at this palce: "+ text);
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//DELETE PRODUCT BY NAME
		public void deleteProductName(String text) {
			String query="delete from product where name =?";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, text);
				int rowaffected=ps.executeUpdate();
				if(rowaffected>0) {
					System.out.println(text+ " Product is deleted!");
				}
				else {
					System.out.println("There is no product with this name: "+ text);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		//OUR OF WARRENTY
		public void outOf(int year) {
			String query="select * from product  where warrenty < ?";
			boolean isfound=false;
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, year);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					isfound=true;
					String name=rs.getString("name");
				    String type=rs.getString("type");
				    String place=rs.getString("place");
				    int warrenty=rs.getInt("warrenty");
				    System.out.println("Product: " + name + ", Type: " + type + 
	                        ", Place: " + place + ", Warranty: " + warrenty);
				}
				if(!isfound) {
					System.out.println("There is no product out of warrenty");
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//FIND PRODUCT BY USING SUBSTRING
		public void findSubString(String text) {
		   String newtext=text.toLowerCase();
		   String query="select * from product where lower(name) like ? OR  lower(type) like ? OR  lower(place) like ? OR  warrenty like ? ";
		   
		   try {
			   PreparedStatement ps=con.prepareStatement(query);
			   String searchtext= "%"+newtext+"%";
			   ps.setString(1, searchtext);
			   ps.setString(2, searchtext);
			   ps.setString(3, searchtext);
			   
			   try {
				   int year = Integer.parseInt(newtext);
				   ps.setInt(4, year);
			   }
			   catch(NumberFormatException e) {
				   ps.setInt(4, -1);
			   }
			   
			   ResultSet rs=ps.executeQuery();
			   boolean isFound=false;
			   while(rs.next()) {
				   isFound=true;
				   String name=rs.getString("name");
				   String type=rs.getString("type");
				   String place=rs.getString("place");
				   int warrenty=rs.getInt("warrenty");
				   
				   System.out.println("Product: " + name + ", Type: " + type + 
	                        ", Place: " + place + ", Warranty: " + warrenty);
			   }
			   
			   if(!isFound) {
				   System.out.print("Product not found with this Substring: "+ text);
			   }
			   
			   
		   }
		   catch(SQLException e) {
			   e.printStackTrace();
		   }
		}

		
		//DELETE ALL PRODUCTS
		public void deleteAll() {
			String query="delete from product";
			
			try {
				PreparedStatement ps=con.prepareStatement(query);
				int rowaffected=ps.executeUpdate();
				if(rowaffected>0) {
					System.out.println("All Products is deleted!");
				}
				else {
					System.out.println("There is No products");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	
}
