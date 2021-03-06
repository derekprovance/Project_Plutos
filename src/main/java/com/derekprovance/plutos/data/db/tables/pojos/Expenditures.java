/**
 * This class is generated by jOOQ
 */
package com.derekprovance.plutos.data.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Expenditures implements Serializable {

	private static final long serialVersionUID = -2084562927;

	private Integer   id;
	private Integer   userId;
	private String    name;
	private Long      value;
	private String    type;
	private String    cycleUnit;
	private Integer   cycleAmt;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Integer   expiredOn;

	public Expenditures() {}

	public Expenditures(Expenditures value) {
		this.id = value.id;
		this.userId = value.userId;
		this.name = value.name;
		this.value = value.value;
		this.type = value.type;
		this.cycleUnit = value.cycleUnit;
		this.cycleAmt = value.cycleAmt;
		this.createdAt = value.createdAt;
		this.updatedAt = value.updatedAt;
		this.expiredOn = value.expiredOn;
	}

	public Expenditures(
		Integer   id,
		Integer   userId,
		String    name,
		Long      value,
		String    type,
		String    cycleUnit,
		Integer   cycleAmt,
		Timestamp createdAt,
		Timestamp updatedAt,
		Integer   expiredOn
	) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.value = value;
		this.type = type;
		this.cycleUnit = cycleUnit;
		this.cycleAmt = cycleAmt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.expiredOn = expiredOn;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return this.value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCycleUnit() {
		return this.cycleUnit;
	}

	public void setCycleUnit(String cycleUnit) {
		this.cycleUnit = cycleUnit;
	}

	public Integer getCycleAmt() {
		return this.cycleAmt;
	}

	public void setCycleAmt(Integer cycleAmt) {
		this.cycleAmt = cycleAmt;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getExpiredOn() {
		return this.expiredOn;
	}

	public void setExpiredOn(Integer expiredOn) {
		this.expiredOn = expiredOn;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Expenditures (");

		sb.append(id);
		sb.append(", ").append(userId);
		sb.append(", ").append(name);
		sb.append(", ").append(value);
		sb.append(", ").append(type);
		sb.append(", ").append(cycleUnit);
		sb.append(", ").append(cycleAmt);
		sb.append(", ").append(createdAt);
		sb.append(", ").append(updatedAt);
		sb.append(", ").append(expiredOn);

		sb.append(")");
		return sb.toString();
	}
}
