package com.derekprovance.plutos.repository;


import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.db.tables.Incomes;
import com.derekprovance.plutos.data.models.Income;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class IncomeRepository extends AbstactRepository {
    public static List<Income> getIncomesForUser(Integer userId) {
        List<Income> incomes = new ArrayList<>();
        Result<Record> results = dsl.select().from(Incomes.INCOMES).where(Incomes.INCOMES.USER_ID.eq(userId)).fetch();
        for (Record r : results) {
            incomes.add(getIncomeEntity(r));
        }
        return incomes;
    }

    //TODO - remove the need for this
    private static Income getIncomeEntity(Record r) {
        Income income = new Income();
        income.setId(r.getValue(Incomes.INCOMES.ID, Integer.class));
        income.setExpires(r.getValue(Incomes.INCOMES.EXPIRED_ON, Long.class));
        income.setSource(r.getValue(Incomes.INCOMES.SOURCE, String.class));
        income.setValue(r.getValue(Incomes.INCOMES.VALUE, Long.class));
        income.setCycleUnit(r.getValue(Incomes.INCOMES.CYCLE_UNIT, FinanceTimePeriod.class));
        income.setUserId(r.getValue(Incomes.INCOMES.USER_ID, Integer.class));
        return income;
    }
}
