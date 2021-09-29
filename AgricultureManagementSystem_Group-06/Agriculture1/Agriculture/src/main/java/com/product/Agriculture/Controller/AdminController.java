package com.product.Agriculture.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.product.Agriculture.dto.ProductDto;
import com.product.Agriculture.model.Category;
import com.product.Agriculture.model.Product;
import com.product.Agriculture.repository.UserRepository;
import com.product.Agriculture.service.CategoryService;
import com.product.Agriculture.service.CustomUserDetailService;
import com.product.Agriculture.service.ProductService;

@Controller
public class AdminController {

	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserRepository userRepository; 
	
	
	@GetMapping("/admin")
	public String adminHome()
	{
		System.out.println("Admin Page");
		return "adminHome.html";
	}
	
	@GetMapping("/admin/categories")
	public String getCategory(Model model) {
		System.out.println("Category Page");
		model.addAttribute("categories", categoryService.getAllCategories());
		return "Categories.html";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCategoryAdd(Model model) {
		System.out.println("Category Add Page");
		model.addAttribute("category", new Category());
		return "categoriesAdd.html";
	}
	
	
	  @PostMapping("/admin/categories/add1") 
	  public String postCategoryAdd(@ModelAttribute("category") Category category) 
	  {
	  System.out.println("Category Page Retrieve");
	  categoryService.addCategory(category); 
	  return "redirect:/admin/categories"; 
	  }
	 
	
	  @GetMapping("/admin/categories/delete/{id}")
	  public String deleteCat(@PathVariable int id)
	  {
		  categoryService.removeCategoryById(id);
		  return "redirect:/admin/categories"; 
	  }
	  
	  @GetMapping("/admin/categories/update/{id}")
	  public String updateCat(@PathVariable int id,Model model)
	  {
		  Optional<Category> category= categoryService.getCategoryById(id);
		  if(category.isPresent())
		  {
			  model.addAttribute("category", category.get());
			  return "categoriesAdd.html"; 
		  }
		  else
			  return "404";
		  
	  }
	  
	  
	  //User Section
	  
	  @GetMapping("/admin/users")
	   public String displayUser(Model model)
	   {
		   model.addAttribute("users",userRepository.findAll());
		   return "admin_UserList.html";
	   }
	  
	  
	  @GetMapping("/admin/users/delete/{id}")
	   public String deleteUser(@PathVariable int id)
	   {
		   userRepository.deleteById(id);
		   return "redirect:/admin/users";
	   }
	  
	  //Product Section
	   @GetMapping("/admin/products")
	   public String displayProduct(Model model)
	   {
		   model.addAttribute("products", productService.getAllProducts());
		   return "admin_product.html";
	   }
	   
	   @GetMapping("/admin/products/add")
	   public String productAddGet(Model model)
	   {
		   model.addAttribute("productDTO", new ProductDto());
		   System.out.println(new ProductDto());
		  model.addAttribute("categories", categoryService.getAllCategories());
		  System.out.println("After adding product");
		   return "admin_AddProduct.html";
	   }
	  
	   @PostMapping("/admin/products/add")
	   public String productAddPost(@ModelAttribute("productDTO") ProductDto productDTO, 
			   @RequestParam("productImage")MultipartFile file, 
			   @RequestParam("imgName")String imgName) throws IOException
	   {
		   Product product=new Product();
		   product.setId(productDTO.getId());
		   product.setName(productDTO.getName());
		   product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		   product.setPrice(productDTO.getPrice());
		   product.setDescription(productDTO.getDescription());
		   String imageUUID;
		   if(!file.isEmpty())
		   {
			   imageUUID=file.getOriginalFilename();
			   Path fileNameAndPath =Paths.get(uploadDir, imageUUID);
			   Files.write(fileNameAndPath, file.getBytes());
		   }else {
			   imageUUID = imgName;
		   }
		   product.setImageName(imageUUID);
		   
		   productService.addProduct(product);
		   return "redirect:/admin/products";
	   }
	   
	   @GetMapping("/admin/product/delete/{id}")
	   public String deleteProduct(@PathVariable long id)
	   {
		   productService.removeProductById(id);
		   return "redirect:/admin/products";
	   }
	   
	   @GetMapping("/admin/product/update/{id}")
	   public String updateProductGet(@PathVariable long id, Model model) {
		   Product product = productService.getProductById(id).get();
		   ProductDto productDTO = new ProductDto();
		   productDTO.setId(product.getId());
		   productDTO.setName(product.getName());
		   productDTO.setCategoryId((product.getCategory().getId()));
		   productDTO.setPrice(product.getPrice());
		   productDTO.setDescription(product.getDescription());
		   productDTO.setImageName(product.getImageName());
		   
		   model.addAttribute("categories", categoryService.getAllCategories());
		   model.addAttribute("productDTO",productDTO);
		  
		   return "admin_AddProduct.html";
	   }
	   
}

