package kodlamaio.northwind.business.concretes;

import java.util.List;

// Javada beans proje classidi
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service // bu class projede service misyasini yerine yeterecek
public class ProductManager implements ProductService {
	
	// DataAccess terefindeki Dao-nu elcatan eleyirik
	private ProductDao productDao;
	
	// ProductDao terefde yaradilan instance buraya vermek ucun autowired anatosyonundan istifade eleyirik
	@Autowired // tek bir instance yaradilir bundan gedir
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		
		return this.productDao.findAll(); // jpa repositoryin hazirlagidi CRUD operasyonlari
	}

}
