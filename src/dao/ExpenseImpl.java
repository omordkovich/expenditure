package dao;

import model.Expenditure;

import java.util.List;

public class ExpenseImpl implements Expense {
    @Override
    public boolean addExpense(Expenditure expenditure) {
        return false;
    }

    @Override
    public Expenditure removeExpense(int id) {
        return null;
    }

    @Override
    public Expenditure updateExpense(Expenditure expenditure) {
        return null;
    }

    @Override
    public List<Expenditure> expenseByCategory() {
        return List.of();
    }

    @Override
    public void printExpenditure() {

    }
}
