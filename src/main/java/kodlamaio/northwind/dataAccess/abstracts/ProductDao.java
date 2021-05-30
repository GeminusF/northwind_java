package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//ProductDao yerine ProductRepository olaraq gore bilerem, JpaRepositorya gore bele adlanir

// .Netdeki EntityFramework base sinifini adamlar JpaRepository olaraq yazib
// PK	
// Fsyo urunle elaqeli CRUD operasyonlar hazirdi

//Burda bir JpaRepository extensionu vasitesi ile aslinda hansi entity-e(tabloya) , hansi id veri tipi ile sorgulanir hazirlamasi gerekdiyini repositorye demis oluruq

// Generic olaraq isleyir arxaplanda menim verdiyim deyerlere gore, arxaplanda spring bir repository classi yaradir(qisacasi bir instance yaradir)

// Repository database birbasa elcatan bir DAO(Data Access Object)du. Repository database el
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	Product getByProductName(String productName); // xusisi bir sey elemek lazim deyil adlandirma duz olmalidi, getBy gorenkimi tablolari baxir , elaqeli column gore bir where kosulu yapisdiri
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); //  and operatoru olan where kosulu yazilir

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); // or operatoru gelir
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName );
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") //database tablosunu unut , =: atiyir paramslari
	List<Product> getByProductAndCategory(String productName, int categoryId);
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	// select p.productId, p.productName, c.categoryName from Category c inner join Product p
	// on c.categoryId = p.categoryId
	
	// JPQL de hemise base tablodan getmek lazimdi, SQLde sixinti olmaz, JPQL biraz ugrasdirar
	
	// From tum alanlari getirir select secdiklerimi getirir
	
	// join columnlari var deye
}
