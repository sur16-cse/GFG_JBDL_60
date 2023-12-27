package l11_hibernate_mapping.one2many.Annotation;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart-o2m-annotation")
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "total")
	private int total;

	@OneToMany(mappedBy = "cart")
	private Set<Items> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

	public Cart(int id, String name, int total) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
