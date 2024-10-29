package dao;

import model.Expenditure;

import java.util.List;

public interface Expense {
    //adds expense note
    boolean addExpense(Expenditure expenditure);

    //removes expense note
    Expenditure removeExpense(int id);

    //edit expense note
    Expenditure updateExpense(Expenditure expenditure);

    //returns list of total expenses by category
    List<Expenditure> expenseByCategory();

    //prints
    void printExpenditure();
}
