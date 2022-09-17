package com.bigcorp.persister.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BigCorpUser {
    @Id
    @GeneratedValue(generator = "SEQ_BIGCORP_USER_ID",
         strategy = GenerationType.SEQUENCE) 
	@SequenceGenerator(name = "SEQ_BIGCORP_USER_ID", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


}
