package kodlamaio.northwind.business.concretes;

import java.util.List;

// Javada beans proje classidi
import org.springframework.beans.factory.annotation.Autowired;
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

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");

		// jpa repositoryin hazirlagidi CRUD operasyonlari
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product); //elave eleme ve update eleme
		return new SuccessResult("Urun eklendi");
	}

}
