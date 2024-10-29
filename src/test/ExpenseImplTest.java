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
        // Проверяем добавления null
        assertFalse(expense.addExpense(null));
        // Проверяем добавление уже существующего объекта
        Expenditure duplicateExpense = expenseList.get(3);
        assertFalse(expense.addExpense(duplicateExpense));
        // Проверяем добавление нового объекта
        Expenditure newExpense = new Expenditure("fun", 75);
        assertTrue(expense.addExpense(newExpense));
    }
    @Test
    void removeExpense() {
        // Удаление существующего объекта
        Expenditure existingExpense = expenseList.get(0);
        assertTrue(expense.removeExpense(existingExpense));
        assertFalse(expe);


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
        List<Expenditure> allExpenses = expense.expenseByCategory();

        List<Expenditure> productsExpenses = allExpenses.stream()
                .filter(e -> "products".equalsIgnoreCase(e.getCategory()))
                .toList();

        assertEquals(0, productsExpenses.size());



    }
}