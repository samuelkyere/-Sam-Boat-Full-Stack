package com.samboat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samboat.model.Product;
import com.samboat.repositary.ProductRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.samboat.exception.ProductNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/")



public class ProductController {
	
	@Autowired
	       private ProductRepository productRepo;
	
		   @GetMapping("/allproducts")
		   public List<Product> getAllProducts() 
		   {
			 
			   return productRepo.findAll();
		   }
		   
		   @PostMapping("/addproduct")
public Product newProducts(@RequestBody Product pd) {
			   return productRepo.save(pd);
		   }
		   
		   @GetMapping("/product/{id}") 
		   public ResponseEntity<Product> getProductById(@PathVariable int id)
		   {
			   Product p= productRepo.findById(id).orElseThrow (() -> new ProductNotFoundException("Product not found"));
			   return ResponseEntity.ok(p);
		   }
		   
		   @GetMapping("/product/name/{name}")
		   public ResponseEntity<List> getProductByName (@PathVariable String name)
		   
		   {
		   List <Product> products=productRepo.findByProductName(name);
		   System.out.println(name);
		   if(products.isEmpty())
		   {
			   System.out.println(new ProductNotFoundException("Student(p) with the name "+ name +" not found" ));
		   }
		   
		   return ResponseEntity.ok(products);
		   }
		   
		   @PutMapping("/product/{id}")
		   public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product)
		   {
			   Product p= productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
			   p.setProductName(product.getProductName());
			   p.setQuantity(product.getQuantity());
			   p.setUnitPrice(product.getUnitPrice());
			   p.setImage(product.getImage());
			   p.setOriginOfProduct(product.getOriginOfProduct());
			   Product updatedProduct=productRepo.save(p);
			   
			   return ResponseEntity.ok(updatedProduct);
			   
		   }
		   @DeleteMapping("/product/{id}")
		   public String deleteProduct(@PathVariable int id)
		   {
			  productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
			          productRepo.deleteById(id);
					  return "The product with id: "+ id +" is removed fromthe database." ;
		   }
		   

}
