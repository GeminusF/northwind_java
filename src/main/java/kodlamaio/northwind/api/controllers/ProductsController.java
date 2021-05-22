package kodlamaio.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

import java.util.List;

@RestController // sen controllersun demekdir
@RequestMapping("/api/products") // coxlu controller temzinleme
public class ProductsController {

	private ProductService productService;
	
	
	// unit testde mocking saxtadan oturu , microservicelerden oturu
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	@GetMapping("/getall") // http get request
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}
	
	// @RequestBody arka planda bir product yaradib onu elave eleyir
	

}
