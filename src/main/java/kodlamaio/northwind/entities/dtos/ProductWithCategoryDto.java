package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO - data transform object

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {
	
	private int id;
	
	private String productName;
	
	private String categoryName;
}
