package com.testingAPI.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testingAPI.blog.payload.ApiResponse;
import com.testingAPI.blog.payload.CategoryDto;
import com.testingAPI.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createdCat = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCat, HttpStatus.CREATED);		
	}
	
	
	//update
	@PutMapping("/{catID}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catID){
		CategoryDto updatedCat = this.categoryService.updateCategory(categoryDto, catID);
		return new ResponseEntity<CategoryDto>(updatedCat, HttpStatus.OK);		
	} 
	
	//delete
	@DeleteMapping("/{catID}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catID){
		this.categoryService.deleteCategory(catID);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category Deleted successfully", true),HttpStatus.OK);		
	}
	
	//get
	@GetMapping("/{catID}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catID){
		return ResponseEntity.ok(this.categoryService.getCategory(catID));
				
	}
	
	//get all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
				
	}
	

}
