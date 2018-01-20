package com.derekprovance.plutos.repository;

import com.derekprovance.plutos.constants.ExpenseType;
import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.db.tables.Expenditures;
import com.derekprovance.plutos.data.models.Expenditure;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ExpenditureRepository {

    private DefaultDSLContext dsl;

    @Autowired
    public ExpenditureRepository(DefaultDSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Expenditure> getAllExpenditures(Integer userId) {
        final SelectConditionStep<Record> query = dsl.select().from(Expenditures.EXPENDITURES)
                .where(Expenditures.EXPENDITURES.USER_ID.eq(userId));

        return processQuery(query);
    }

    public List<Expenditure> getExpendituresByCategory(Integer userId, ExpenseType expenseType) {
        final SelectConditionStep<Record> query = dsl.select().from(Expenditures.EXPENDITURES)
                .where(Expenditures.EXPENDITURES.USER_ID.eq(userId))
                .and(Expenditures.EXPENDITURES.TYPE.eq(String.valueOf(expenseType)));

        return processQuery(query);
    }

    private List<Expenditure> processQuery(SelectConditionStep<Record> query) {
        List<Expenditure> expenditures = new ArrayList<>();

        for (Record r : query.fetch()) {
            expenditures.add(getIncomeEntity(r));
        }

        return expenditures;
    }

    //TODO - remove the need for this
    private Expenditure getIncomeEntity(Record r) {
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
