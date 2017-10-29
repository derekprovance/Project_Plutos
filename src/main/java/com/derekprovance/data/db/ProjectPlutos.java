/**
 * This class is generated by jOOQ
 */
package com.derekprovance.data.db;


import com.derekprovance.data.db.tables.Expenditures;
import com.derekprovance.data.db.tables.Incomes;
import com.derekprovance.data.db.tables.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class ProjectPlutos extends SchemaImpl {

	private static final long serialVersionUID = -835692;

	/**
	 * The reference instance of <code>project_plutos</code>
	 */
	public static final ProjectPlutos PROJECT_PLUTOS = new ProjectPlutos();

	/**
	 * No further instances allowed
	 */
	private ProjectPlutos() {
		super("project_plutos");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Expenditures.EXPENDITURES,
			Incomes.INCOMES,
			Users.USERS);
	}
}
