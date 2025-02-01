package com.srinivas.Product_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        
        ProductServices ps=new ProductServices();
        
//        ps.addProduct(new Product("Realme XT", "Phone", "Home", 2026));
//        ps.addProduct(new Product("Samsung Galaxy S21", "Phone", "Office", 2025));
//        ps.addProduct(new Product("HP Pavilion", "Laptop", "Home", 2028));
//        ps.addProduct(new Product("Sony Bravia", "Television", "Living Room", 2030));
//        ps.addProduct(new Product("Apple iPad", "Tablet", "Office", 2027));
//        ps.addProduct(new Product("Dell XPS 15", "Laptop", "Work", 2029));
//        ps.addProduct(new Product("Bose SoundLink", "Speaker", "Bedroom", 2025));
//        ps.addProduct(new Product("Logitech MX Master 3", "Mouse", "Office", 2027));
//        ps.addProduct(new Product("Canon EOS 90D", "Camera", "Studio", 2028));
//        ps.addProduct(new Product("Philips Air Fryer", "Appliance", "Kitchen", 2026));

        
        ps.getAllProducts();
        System.out.println("------------------------------------------------");
        
        ps.getProductByName("dell XPS 15");
        System.out.println("------------------------------------------------");
        
       ps.getProductByPlace("office");
       System.out.println("------------------------------------------------");
        
       ps.deleteProductByName("Bose soundLink");
       ps.getProductByName("Bose soundLink");
       System.out.println("------------------------------------------------");
        
       
       ps.outOfWarrenty(2026);
       System.out.println("------------------------------------------------");
        
        ps.findBySubString("2026");
        System.out.println("------------------------------------------------");
        
        ps.deleteAllProducts();
        ps.getAllProducts();
        
        
    }
}
