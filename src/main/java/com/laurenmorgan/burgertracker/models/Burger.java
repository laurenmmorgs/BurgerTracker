package com.laurenmorgan.burgertracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	//USE AUTO INSTEAD BECAUSE IT WORKS BETTER 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @NotNull(message="Name must be at least 3 characters.")
    @Size(min = 3, max = 40, message="Name must be at least 3 characters.")
    private String burgerName;
    
    
    @NotNull(message="Name must be at least 3 characters.")
    @Size(min = 3, max = 40, message="Name must be at least 3 characters.")
    private String restName;
    
    
    
    @NotNull(message="Must be at least 0-5.")
    @Min(value=0, message="Must be at least 0-5.")
    private Integer rating;
    
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    public Burger() {
    
    }
    
    

	public Burger(
			String burgerName, String restName,
			int rating) {
		this.burgerName = burgerName;
		this.restName = restName;
		this.rating = rating;

	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getBurgerName() {
		return burgerName;
	}


	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}


	public String getRestName() {
		return restName;
	}


	public void setRestName(String restName) {
		this.restName = restName;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}


