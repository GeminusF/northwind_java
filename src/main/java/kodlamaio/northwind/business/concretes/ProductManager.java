package kodlamaio.northwind.business.concretes;

import java.util.List;

// Javada beans proje classidi
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service // bu class projede service misyasini yerine yeterecek
public class ProductManager implements ProductService {

	// DataAccess terefindeki Dao-nu elcatan eleyirik
	private ProductDao productDao;

	// ProductDao terefde yaradilan instance buraya vermek ucun autowired
	// anatosyonundan istifade eleyirik
	@Autowired // tek bir instance yaradilir bundan gedir
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi");

		// jpa repositoryin hazirlagidi CRUD operasyonlari
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product); // elave eleme ve update eleme
		return new SuccessResult("Urun eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductAndCategory(productName, categoryId), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize); // sayma 0dan baslayir
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName"); // siralam asc + , desc - , 2ci param hansi field gore getirilsin
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort)) ;
	}

}
