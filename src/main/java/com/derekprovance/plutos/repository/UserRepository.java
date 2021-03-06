package com.derekprovance.plutos.repository;

import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.data.db.tables.Users;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    private DefaultDSLContext dsl;

    @Autowired
    public UserRepository(DefaultDSLContext dsl) {
        this.dsl = dsl;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Result<Record> result = dsl.select().from(Users.USERS).fetch();
        for (Record r : result) {
            users.add(getUserEntity(r));
        }
        return users;
    }

    public User getUserByEmail(String email) {
        Record result = dsl.select().from(Users.USERS).where(Users.USERS.EMAIL.eq(email)).fetchOne();
        return getUserEntity(result);
    }

    //TODO - look into JOOQ auto casting
    private User getUserEntity(Record r){
        User user = new User();
        user.setId(r.getValue(Users.USERS.ID));
        user.setFirstName(r.getValue(Users.USERS.FIRST_NAME));
        user.setLastName(r.getValue(Users.USERS.LAST_NAME));
        user.setDeductions(r.getValue(Users.USERS.DEDUCTIONS));
        user.setWitholdings(r.getValue(Users.USERS.WITHOLDINGS));
        user.setEmail(r.getValue(Users.USERS.EMAIL));
        user.setPocketChange(r.getValue(Users.USERS.POCKET_CHANGE));
        return user;
    }
}
