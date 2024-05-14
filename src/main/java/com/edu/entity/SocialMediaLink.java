package com.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="socialmedialink")
public class SocialMediaLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String link;
	
	@ManyToOne
	private Institute institute;

	@Override
	public String toString() {
		return "SocialMediaLink [id=" + id + ", link=" + link + ", institute=" + institute + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public SocialMediaLink(Integer id, String link, Institute institute) {
		super();
		this.id = id;
		this.link = link;
		this.institute = institute;
	}

	public SocialMediaLink() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
