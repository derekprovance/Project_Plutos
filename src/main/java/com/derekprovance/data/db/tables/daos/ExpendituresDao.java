/**
 * This class is generated by jOOQ
 */
package com.derekprovance.data.db.tables.daos;


import com.derekprovance.data.db.tables.Expenditures;
import com.derekprovance.data.db.tables.records.ExpendituresRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class ExpendituresDao extends DAOImpl<ExpendituresRecord, com.derekprovance.data.db.tables.pojos.Expenditures, Integer> {

	/**
	 * Create a new ExpendituresDao without any configuration
	 */
	public ExpendituresDao() {
		super(Expenditures.EXPENDITURES, com.derekprovance.data.db.tables.pojos.Expenditures.class);
	}

	/**
	 * Create a new ExpendituresDao with an attached configuration
	 */
	public ExpendituresDao(Configuration configuration) {
		super(Expenditures.EXPENDITURES, com.derekprovance.data.db.tables.pojos.Expenditures.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.derekprovance.data.db.tables.pojos.Expenditures object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchById(Integer... values) {
		return fetch(Expenditures.EXPENDITURES.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.derekprovance.data.db.tables.pojos.Expenditures fetchOneById(Integer value) {
		return fetchOne(Expenditures.EXPENDITURES.ID, value);
	}

	/**
	 * Fetch records that have <code>user_id IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByUserId(Integer... values) {
		return fetch(Expenditures.EXPENDITURES.USER_ID, values);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByName(String... values) {
		return fetch(Expenditures.EXPENDITURES.NAME, values);
	}

	/**
	 * Fetch records that have <code>value IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByValue(Long... values) {
		return fetch(Expenditures.EXPENDITURES.VALUE, values);
	}

	/**
	 * Fetch records that have <code>type IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByType(String... values) {
		return fetch(Expenditures.EXPENDITURES.TYPE, values);
	}

	/**
	 * Fetch records that have <code>cycle_unit IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByCycleUnit(String... values) {
		return fetch(Expenditures.EXPENDITURES.CYCLE_UNIT, values);
	}

	/**
	 * Fetch records that have <code>cycle_amt IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByCycleAmt(Integer... values) {
		return fetch(Expenditures.EXPENDITURES.CYCLE_AMT, values);
	}

	/**
	 * Fetch records that have <code>created_at IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByCreatedAt(Timestamp... values) {
		return fetch(Expenditures.EXPENDITURES.CREATED_AT, values);
	}

	/**
	 * Fetch records that have <code>updated_at IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByUpdatedAt(Timestamp... values) {
		return fetch(Expenditures.EXPENDITURES.UPDATED_AT, values);
	}

	/**
	 * Fetch records that have <code>expired_on IN (values)</code>
	 */
	public List<com.derekprovance.data.db.tables.pojos.Expenditures> fetchByExpiredOn(Integer... values) {
		return fetch(Expenditures.EXPENDITURES.EXPIRED_ON, values);
	}
}
