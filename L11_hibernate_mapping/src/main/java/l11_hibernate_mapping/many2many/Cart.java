package l11_hibernate_mapping.many2many;

import java.util.Set;

public class Cart {
	private int id;
	private int total;
	private String name;
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
	public Cart(int id, int total, String name, Set<l11_hibernate_mapping.many2many.Items> items) {
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
