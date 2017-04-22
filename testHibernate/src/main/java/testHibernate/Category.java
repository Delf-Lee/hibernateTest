
package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int id;
	private String name;
	
	// specify cascade opt in parent table
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL) // joined field name in Product class 
	private Set<Product> products = new HashSet<Product>();
}
