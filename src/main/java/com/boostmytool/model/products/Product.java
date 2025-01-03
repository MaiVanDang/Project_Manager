package com.boostmytool.model.products;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String brand;
	private String category;
	private double price;
	private double baseprice;
    private String supplierID;
    private int quantity;
    private int discount;
    private int totalSold;
    
	@Column (columnDefinition = "TEXT")
	private String description;
	private String imageFileName;
	@Column(name = "created_at", updatable = false)
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date(); // Gán thời gian hiện tại cho createdAt khi tạo mới
        this.updatedAt = new Date(); // Gán thời gian hiện tại cho updatedAt lúc tạo mới
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date(); // Chỉ cập nhật updatedAt khi cập nhật
    }
    
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	public double getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}

	public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", price=" + price +
                ", baseprice=" + baseprice +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", imageFileName='" + imageFileName + '\'' +
                ", brand='" + brand + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}