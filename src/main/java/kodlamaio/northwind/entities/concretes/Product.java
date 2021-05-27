package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // sen bir entity nesnesisen
@Table(name = "products") //databasede hansi tabloya qarsiliq gelir
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	// Class her bir setri izah eleyir	
	
	@Id // tabloda id alani demeyimiz lazimdi cunki emellerini ona gore elecek
	@GeneratedValue(strategy = GenerationType.IDENTITY) // idnin 1-1 artdigini gosterir , (strategy = GenerationType.IDENTITY) avto artirma
	@Column(name = "product_id") // tablonun hansi kolumuna qarsiliq gelir
	private int id;

	//@Column(name = "category_id")
	//private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name = "category_id") // join olan columdu
	private Category category; // Jpa categoryin icinde categoryId ozu tapir pk yapilandirir
	
}
