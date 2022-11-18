package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
//import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
//@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 7156526077883281623L;
	@Id
	private int cid;
	private String cname;
	private String cemail;
}
