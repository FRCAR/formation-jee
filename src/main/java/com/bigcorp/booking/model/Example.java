package com.bigcorp.booking.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.johnzon.mapper.JohnzonIgnore;

@Entity
@Table(name = "EXAMPLE")
public class Example {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {	
		this.id = id;
	}

}
