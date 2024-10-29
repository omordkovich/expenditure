package dao;

import model.Expenditure;

import java.util.ArrayList;
import java.util.List;

public class ExpenseImpl implements Expense {
    List<Expenditure> expenditures;

    public ExpenseImpl() {
        this.expenditures = new ArrayList<>();
    }

    public ExpenseImpl(List<Expenditure> expenditures) {
        this();
        expenditures.forEach(this::addExpense);
    }

    @Override
    public boolean addExpense(Expenditure expenditure) {
        if (expenditure == null || expenditures.contains(expenditure))
            return false;
        expenditures.add(expenditure);
        return true;
    }

    @Override
    public Expenditure removeExpense(int id) {
        Expenditure victim = findById(id);
        if(expenditures.contains(victim)&&victim!=null){
            expenditures.remove(victim);
            return victim;
        }else {
            return null;
        }
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

    @Override
    public Expenditure findById(int id) {
        return expenditures.stream()
                .filter(e -> e.getId() == (id))
                .findFirst()
                .orElse(null);
    }


}
