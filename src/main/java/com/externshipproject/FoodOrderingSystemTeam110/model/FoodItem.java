package com.externshipproject.FoodOrderingSystemTeam110.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "food_items")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_item_id")
    private Long id;
    private String name;
    private double price;
    @Column(name="description")
    private String desc;
	@ManyToMany(mappedBy = "foodItems")
	private List<Restaurant> restaurants;
    public FoodItem() {
    }
    public FoodItem(String name, double price, String desc, List<Restaurant> restaurants) {
        this.name = name;
        this.price = price;
        this.setDesc(desc);
        this.restaurants = restaurants;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
}