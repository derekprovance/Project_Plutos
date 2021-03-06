/**
 * This class is generated by jOOQ
 */
package com.derekprovance.plutos.data.db.tables;


import com.derekprovance.plutos.data.db.Keys;
import com.derekprovance.plutos.data.db.ProjectPlutos;
import com.derekprovance.plutos.data.db.tables.records.UsersRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Users extends TableImpl<UsersRecord> {

	private static final long serialVersionUID = -1891079265;

	/**
	 * The reference instance of <code>project_plutos.users</code>
	 */
	public static final Users USERS = new Users();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UsersRecord> getRecordType() {
		return UsersRecord.class;
	}

	/**
	 * The column <code>project_plutos.users.id</code>.
	 */
	public final TableField<UsersRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>project_plutos.users.first_name</code>.
	 */
	public final TableField<UsersRecord, String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>project_plutos.users.last_name</code>.
	 */
	public final TableField<UsersRecord, String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>project_plutos.users.email</code>.
	 */
	public final TableField<UsersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.users.pocket_change</code>.
	 */
	public final TableField<UsersRecord, Long> POCKET_CHANGE = createField("pocket_change", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.users.witholdings</code>.
	 */
	public final TableField<UsersRecord, Long> WITHOLDINGS = createField("witholdings", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.users.deductions</code>.
	 */
	public final TableField<UsersRecord, Long> DEDUCTIONS = createField("deductions", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.users.created_at</code>.
	 */
	public final TableField<UsersRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * The column <code>project_plutos.users.updated_at</code>.
	 */
	public final TableField<UsersRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>project_plutos.users</code> table reference
	 */
	public Users() {
		this("users", null);
	}

	/**
	 * Create an aliased <code>project_plutos.users</code> table reference
	 */
	public Users(String alias) {
		this(alias, USERS);
	}

	private Users(String alias, Table<UsersRecord> aliased) {
		this(alias, aliased, null);
	}

	private Users(String alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
		super(alias, ProjectPlutos.PROJECT_PLUTOS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UsersRecord, Integer> getIdentity() {
		return Keys.IDENTITY_USERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UsersRecord> getPrimaryKey() {
		return Keys.KEY_USERS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UsersRecord>> getKeys() {
		return Arrays.<UniqueKey<UsersRecord>>asList(Keys.KEY_USERS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users as(String alias) {
		return new Users(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Users rename(String name) {
		return new Users(name, null);
	}
}
