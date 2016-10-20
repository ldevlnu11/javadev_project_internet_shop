package ua.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.entity.Product;
import ua.com.serviceImp.ProductServiceImp;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImp productService;
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String product(Model model){
		List<Product> productsFromDB = productService.showAllProducts();
		model.addAttribute("products", productsFromDB);
		model.addAttribute("productModel", new Product());
		return "product";
	}
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product){
		productService.addProduct(product);
		return "redirect:/product";
	}
	
	@RequestMapping(value="/dev/{product_code}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String product_code){
		productService.deleteProduct(product_code);
		return "redirect:/product";
	}
	
}
