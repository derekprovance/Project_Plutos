/**
 * This class is generated by jOOQ
 */
package com.derekprovance.plutos.data.db.tables.records;


import com.derekprovance.plutos.data.db.tables.Users;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record9<Integer, String, String, String, Long, Long, Long, Timestamp, Timestamp> {

	private static final long serialVersionUID = 243967019;

	/**
	 * Setter for <code>project_plutos.users.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>project_plutos.users.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>project_plutos.users.first_name</code>.
	 */
	public void setFirstName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>project_plutos.users.first_name</code>.
	 */
	public String getFirstName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>project_plutos.users.last_name</code>.
	 */
	public void setLastName(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>project_plutos.users.last_name</code>.
	 */
	public String getLastName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>project_plutos.users.email</code>.
	 */
	public void setEmail(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>project_plutos.users.email</code>.
	 */
	public String getEmail() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>project_plutos.users.pocket_change</code>.
	 */
	public void setPocketChange(Long value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>project_plutos.users.pocket_change</code>.
	 */
	public Long getPocketChange() {
		return (Long) getValue(4);
	}

	/**
	 * Setter for <code>project_plutos.users.witholdings</code>.
	 */
	public void setWitholdings(Long value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>project_plutos.users.witholdings</code>.
	 */
	public Long getWitholdings() {
		return (Long) getValue(5);
	}

	/**
	 * Setter for <code>project_plutos.users.deductions</code>.
	 */
	public void setDeductions(Long value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>project_plutos.users.deductions</code>.
	 */
	public Long getDeductions() {
		return (Long) getValue(6);
	}

	/**
	 * Setter for <code>project_plutos.users.created_at</code>.
	 */
	public void setCreatedAt(Timestamp value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>project_plutos.users.created_at</code>.
	 */
	public Timestamp getCreatedAt() {
		return (Timestamp) getValue(7);
	}

	/**
	 * Setter for <code>project_plutos.users.updated_at</code>.
	 */
	public void setUpdatedAt(Timestamp value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>project_plutos.users.updated_at</code>.
	 */
	public Timestamp getUpdatedAt() {
		return (Timestamp) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, Long, Long, Long, Timestamp, Timestamp> fieldsRow() {
		return (Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, Long, Long, Long, Timestamp, Timestamp> valuesRow() {
		return (Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Users.USERS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Users.USERS.FIRST_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Users.USERS.LAST_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Users.USERS.EMAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field5() {
		return Users.USERS.POCKET_CHANGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field6() {
		return Users.USERS.WITHOLDINGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field7() {
		return Users.USERS.DEDUCTIONS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field8() {
		return Users.USERS.CREATED_AT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field9() {
		return Users.USERS.UPDATED_AT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getFirstName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getLastName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getEmail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value5() {
		return getPocketChange();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value6() {
		return getWitholdings();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value7() {
		return getDeductions();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value8() {
		return getCreatedAt();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value9() {
		return getUpdatedAt();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value2(String value) {
		setFirstName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value3(String value) {
		setLastName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value4(String value) {
		setEmail(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value5(Long value) {
		setPocketChange(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value6(Long value) {
		setWitholdings(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value7(Long value) {
		setDeductions(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value8(Timestamp value) {
		setCreatedAt(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value9(Timestamp value) {
		setUpdatedAt(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord values(Integer value1, String value2, String value3, String value4, Long value5, Long value6, Long value7, Timestamp value8, Timestamp value9) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UsersRecord
	 */
	public UsersRecord() {
		super(Users.USERS);
	}

	/**
	 * Create a detached, initialised UsersRecord
	 */
	public UsersRecord(Integer id, String firstName, String lastName, String email, Long pocketChange, Long witholdings, Long deductions, Timestamp createdAt, Timestamp updatedAt) {
		super(Users.USERS);

		setValue(0, id);
		setValue(1, firstName);
		setValue(2, lastName);
		setValue(3, email);
		setValue(4, pocketChange);
		setValue(5, witholdings);
		setValue(6, deductions);
		setValue(7, createdAt);
		setValue(8, updatedAt);
	}
}