package l11_hibernate_mapping.one2many;

import java.util.Set;

public class Cart {
	private int id;
	private String name;
	private int total;
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
