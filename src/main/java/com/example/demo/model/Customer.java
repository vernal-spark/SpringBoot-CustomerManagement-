package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
//import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
//@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 7156526077883281623L;
	@Id
	private int cid;
	private String cname;
	private String cemail;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + "]";
	}
	

}
