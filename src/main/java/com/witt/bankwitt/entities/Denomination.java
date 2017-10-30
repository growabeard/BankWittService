package com.witt.bankwitt.entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity (name = "denominations")
public class Denomination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "denom_seq_gen")
	@SequenceGenerator(name = "denom_seq_gen", sequenceName = "DENOMINATIONS_seq", allocationSize = 1)
	private Integer id;

	@Column (name = "count")
	private Integer count;
	
	@Column (name = "value")
	private Integer value;
	
	@Column (name = "userid")
	private Integer userid;

	@Column (name = "label")
	private String label;
	
	@Column (name = "updated")
	private String updated;
	
	@Column (name = "name")
	private String name;
	
	@Transient
	private String total;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
