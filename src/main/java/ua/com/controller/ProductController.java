package ua.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.entity.Product;
import ua.com.service.ProductService;
import ua.com.serviceImp.ProductServiceImp;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		List<Product> productsFromDB = productService.showAllProducts();
		model.addAttribute("products", productsFromDB);
		return "product";
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String addProduct(@RequestParam String product_name, String product_number, String product_price) {
		Product product = new Product();
		product.setProduct_name(product_name);
		product.setProduct_number(product_number);
		product.setProduct_price(product_price);
		productService.addProduct(product);
		return "redirect:/product";
	}

	@RequestMapping(value = "/dev/{product_code}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String product_code) {
		productService.deleteProduct(product_code);
		return "redirect:/product";
	}

}
