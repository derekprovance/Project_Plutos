/**
 * This class is generated by jOOQ
 */
package com.derekprovance.data.db.tables;


import com.derekprovance.data.db.Keys;
import com.derekprovance.data.db.ProjectPlutos;
import com.derekprovance.data.db.tables.records.IncomesRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Incomes extends TableImpl<IncomesRecord> {

	private static final long serialVersionUID = -346672531;

	/**
	 * The reference instance of <code>project_plutos.incomes</code>
	 */
	public static final Incomes INCOMES = new Incomes();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<IncomesRecord> getRecordType() {
		return IncomesRecord.class;
	}

	/**
	 * The column <code>project_plutos.incomes.id</code>.
	 */
	public final TableField<IncomesRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>project_plutos.incomes.user_id</code>.
	 */
	public final TableField<IncomesRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>project_plutos.incomes.source</code>.
	 */
	public final TableField<IncomesRecord, String> SOURCE = createField("source", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>project_plutos.incomes.value</code>.
	 */
	public final TableField<IncomesRecord, Long> VALUE = createField("value", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.incomes.cycle_unit</code>.
	 */
	public final TableField<IncomesRecord, String> CYCLE_UNIT = createField("cycle_unit", org.jooq.impl.SQLDataType.VARCHAR.length(255).defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.incomes.created_at</code>.
	 */
	public final TableField<IncomesRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.incomes.updated_at</code>.
	 */
	public final TableField<IncomesRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.incomes.expired_on</code>.
	 */
	public final TableField<IncomesRecord, Date> EXPIRED_ON = createField("expired_on", org.jooq.impl.SQLDataType.DATE, this, "");

	/**
	 * Create a <code>project_plutos.incomes</code> table reference
	 */
	public Incomes() {
		this("incomes", null);
	}

	/**
	 * Create an aliased <code>project_plutos.incomes</code> table reference
	 */
	public Incomes(String alias) {
		this(alias, INCOMES);
	}

	private Incomes(String alias, Table<IncomesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Incomes(String alias, Table<IncomesRecord> aliased, Field<?>[] parameters) {
		super(alias, ProjectPlutos.PROJECT_PLUTOS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<IncomesRecord, Integer> getIdentity() {
		return Keys.IDENTITY_INCOMES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<IncomesRecord> getPrimaryKey() {
		return Keys.KEY_INCOMES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<IncomesRecord>> getKeys() {
		return Arrays.<UniqueKey<IncomesRecord>>asList(Keys.KEY_INCOMES_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<IncomesRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<IncomesRecord, ?>>asList(Keys.INCOMES_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Incomes as(String alias) {
		return new Incomes(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Incomes rename(String name) {
		return new Incomes(name, null);
	}
}
