package com.boostmytool.model.suppliers;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date createdAt;
	private Date updatedAt;
	private String name;
	private float totalRevenue;
	@Column (columnDefinition = "TEXT")
	private String address;
	private String description;
	private String imageLogo;
    private String phone;
    private String email;	
//    public Supplier(Long id, String name, String address, String description, Date createdAt, Date updatedAt, String imageLogo) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.description = description;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.imageLogo = imageLogo;
//    }
	
    
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public float getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getImageLogo() {
		return imageLogo;
	}
	public void setImageLogo(String imageLogo) {
		this.imageLogo = imageLogo;
	}
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }	
}