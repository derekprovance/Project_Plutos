package com.derekprovance.repository;

import com.derekprovance.constants.ExpenseType;
import com.derekprovance.constants.FinanceTimePeriod;
import com.derekprovance.data.models.Expenditure;
import com.derekprovance.data.db.tables.Expenditures;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ExpenditureRepository extends AbstactRepository {
    public static List<Expenditure> getAllExpenditures(Integer userId) {
        final SelectConditionStep<Record> query = dsl.select().from(Expenditures.EXPENDITURES)
                .where(Expenditures.EXPENDITURES.USER_ID.eq(userId));

        return processQuery(query);
    }

    public static List<Expenditure> getExpendituresByCategory(Integer userId, ExpenseType expenseType) {
        final SelectConditionStep<Record> query = dsl.select().from(Expenditures.EXPENDITURES)
                .where(Expenditures.EXPENDITURES.USER_ID.eq(userId))
                .and(Expenditures.EXPENDITURES.TYPE.eq(String.valueOf(expenseType)));

        return processQuery(query);
    }

    private static List<Expenditure> processQuery(SelectConditionStep<Record> query) {
        List<Expenditure> expenditures = new ArrayList<>();

        for (Record r : query.fetch()) {
            expenditures.add(getIncomeEntity(r));
        }

        return expenditures;
    }

    //TODO - remove the need for this
    private static Expenditure getIncomeEntity(Record r) {
        Expenditure expenditure = new Expenditure();
        expenditure.setId(r.getValue(Expenditures.EXPENDITURES.ID, Integer.class));
        expenditure.setCycleAmt(r.getValue(Expenditures.EXPENDITURES.CYCLE_AMT, Integer.class));
        expenditure.setCycleUnit(r.getValue(Expenditures.EXPENDITURES.CYCLE_UNIT, FinanceTimePeriod.class));
        expenditure.setName(r.getValue(Expenditures.EXPENDITURES.NAME, String.class));
        expenditure.setUserId(r.getValue(Expenditures.EXPENDITURES.USER_ID, Integer.class));
        expenditure.setType(r.getValue(Expenditures.EXPENDITURES.TYPE, ExpenseType.class));
        expenditure.setValue(r.getValue(Expenditures.EXPENDITURES.VALUE, Long.class));

        return expenditure;
    }
}
