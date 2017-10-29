package com.derekprovance.repository;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class AbstactRepository {
    public static DSLContext dsl = DSL.using(
            "jdbc:mysql://127.0.0.1/project_plutos?serverTimezone=UTC",
            "root",
            "ykyusdeu"
    );
}
