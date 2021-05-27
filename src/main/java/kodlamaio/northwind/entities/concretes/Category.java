package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"}) // recursive struktrun qarsisini alir, lazy deyirik biz istediyimiz yere qeder islesin, productun adini tapib butuun categoryde gezmesin deye istifade ederik
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
	
	@Id
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category") // field adi  // aralarindaki elaqe, 1ci param mappedBy 2ci parametr her yerde data deyis
	private List<Product> products; // products tablomuz , products da olanda ManyToOne yazacagiq tersine olur
}
