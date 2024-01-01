package l11_hibernate_mapping.many2manyAnnotation;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart-m2m-annoation")
public class Cart {
	@Id
	@Column(name = "card_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(targetEntity = Items.class,cascade = {CascadeType.ALL})
	@JoinTable(name = "CART_ITEMS_ANNOTATION",joinColumns = {@JoinColumn(name="card_id")},inverseJoinColumns = {@JoinColumn(name = "item_id")})
	private Set<Items> Items;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Items> getItems() {
		return Items;
	}
	public void setItems(Set<Items> items) {
		Items = items;
	}
	public Cart(int id, int total, String name, Set<Items> items) {
		super();
		this.id = id;
		this.total = total;
		this.name = name;
		Items = items;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + ", name=" + name + ", Items=" + Items + "]";
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
