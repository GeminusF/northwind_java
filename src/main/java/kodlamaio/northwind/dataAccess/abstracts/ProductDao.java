package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.northwind.entities.concretes.Product;

//ProductDao yerine ProductRepository olaraq gore bilerem, JpaRepositorya gore bele adlanir

// .Netdeki EntityFramework base sinifini adamlar JpaRepository olaraq yazib
// PK	
// Fsyo urunle elaqeli CRUD operasyonlar hazirdi

//Burda bir JpaRepository extensionu vasitesi ile aslinda hansi entity-e(tabloya) , hansi id veri tipi ile sorgulanir hazirlamasi gerekdiyini repositorye demis oluruq

// Generic olaraq isleyir arxaplanda menim verdiyim deyerlere gore, arxaplanda spring bir repository classi yaradir(qisacasi bir instance yaradir)

// Repository database birbasa elcatan bir DAO(Data Access Object)du. Repository database el
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
