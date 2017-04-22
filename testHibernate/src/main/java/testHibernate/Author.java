package testHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
	@Id
	@GeneratedValue
	@Column(name = "book_id")
	private long id;
	private String name;
	
//	@ManyToMany(cascade = CascadeType.ALL, mappedBy="authors") // only add this for bidirectional relation
//	private Set<Book> books = new HashSet<Book>();
	
}
