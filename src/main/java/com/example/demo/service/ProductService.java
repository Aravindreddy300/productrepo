package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository departmentRepo;
	
	
	public List<Product> listAll() {
	
	return departmentRepo.findAll();
	
	}
	
	public Optional<Product> getProduct(int id){
		Optional<Product> p=departmentRepo.findById(id);
		return p;
	}
	
	public Product createProduct(Product department) {
		return departmentRepo.save(department);
	}
	
	public Map<String,Boolean> deleteProduct(Integer departmentId){
		departmentRepo.deleteById(departmentId);
		Map<String,Boolean> response=new HashMap();
		response.put("department has been deleted", Boolean.TRUE);
		return response;
	}
	
	public String updateProduct(Integer departmentId, Product newProduct) {
		Optional<Product> existingProduct = departmentRepo.findById(departmentId);
		if(existingProduct.isPresent()) {
			Product foundProduct = existingProduct.get();
			foundProduct.setName(newProduct.getName());
			foundProduct.setPrice(newProduct.getPrice());
			departmentRepo.save(foundProduct);
 
			return "department Updated";
		}
		return "department Not Updated";

	}
	
	
	
	
	
	


}
