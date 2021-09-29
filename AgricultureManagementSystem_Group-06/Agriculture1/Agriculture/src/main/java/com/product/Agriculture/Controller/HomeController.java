package com.product.Agriculture.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.Agriculture.global.GlobalData;
import com.product.Agriculture.service.CategoryService;
import com.product.Agriculture.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "new_Index.html";
	}
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop.html";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id)
	{
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop.html";
	}
	
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id)
	{
		model.addAttribute("product", productService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "admin_ViewProduct.html";
	}
	
	
}
