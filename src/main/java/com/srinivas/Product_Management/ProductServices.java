package com.srinivas.Product_Management;

public class ProductServices {
	
	ProductDB db=new ProductDB();

    //ADD PRODUCT
    public void addProduct(Product product){
    	System.out.println("ADDING PRODUCT");
    	db.save(product);
    }


    //ALL PRODUCTS
    public void getAllProducts() {
    	System.out.println("GET ALL PRODUCTS:");
    	db.All();
    }

    //GET PRODUCT BY NAME
    public void getProductByName(String name) {
    	System.out.println("GET PRODUCTS BY NAME");
    	db.getProductName(name);
    }
    

   // GET PRODUCT BY PLACE
    public void getProductByPlace(String place) {
    	System.out.println("GET PRODUCTS BY PLACE");
    	db.getProductPlace(place);
    }
    
    
 // DELETE PRODUCT BY NAME
    public void deleteProductByName(String name){
    	System.out.println("DELETE PRODUCT BY NAME");
    	db.deleteProductName(name);
    }

    // DELETE ALL PRODUCTS
    public void deleteAllProducts(){
    	System.out.println("DELETE All PRODUCTS");
    	db.deleteAll();
    }

    //OUT OF WARRENTY
    public void outOfWarrenty(int year) {
        System.out.println("OUT OF WARRENTY");
        db.outOf(year);
    }

    //FIND BY SUBSTRING
    public void findBySubString(String text) {
    	System.out.println("FIND BY SUBSTRING");
    	db.findSubString(text);
    }


}
