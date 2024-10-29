package test;


import dao.Expense;
import dao.ExpenseImpl;
import model.Expenditure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseImplTest {
    Expense expense;
    List<Expenditure> expenseList;

    @BeforeEach
    void setUp() {
        expense = new ExpenseImpl();
        expenseList = new ArrayList<>(List.of(
                new Expenditure("products", 3.99),
                new Expenditure("products", 4.99),
                new Expenditure("fun", 300),
                new Expenditure("transport", 2.70),
                new Expenditure("products", 25),
                new Expenditure("fun", 50)));
        expenseList.forEach(expense::addExpense);
    }

    @Test
    void addExpense() {

    }
    @Test
    void removeExpense() {

    }
    @Test
    void updateExpense() {
        int idToUpdate = expenseList.get(0).getId();
        Expenditure updatedExpense = new Expenditure("products", 10.0);
        updatedExpense.setId(idToUpdate);
        expense.updateExpense(updatedExpense);
        Expenditure result = expenseList.stream().filter(exp -> exp.getId() == idToUpdate).findFirst().orElse(null);


    }
    @Test
    void expenseByCategory() {

    }
}