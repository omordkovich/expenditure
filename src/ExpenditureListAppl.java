import dao.Expense;
import dao.ExpenseImpl;
import model.Category;
import model.Expenditure;
import model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenditureListAppl {
    public static void main(String[] args) {
        System.out.println("Welcome to expenditure list!");
        Scanner scanner = new Scanner(System.in);
        List<Menu> menus = new ArrayList<>(List.of(Menu.values()));
        List<Category> categories = new ArrayList<>(List.of(Category.values()));
        List<Expenditure> notes = new ArrayList<>();
        Expense list = new ExpenseImpl(notes);
        boolean flag = true;
        do {
            menus.forEach(menu -> System.out.print(menu.getName()));
            String input = scanner.next();
            switch (input) {
                case "1" -> {
                    System.out.println("Select Category");
                    categories.forEach(category -> System.out.print(category.getName()));
                    String cInput = scanner.next();
                    double money = 0;
                    String category = "";
                    switch (cInput) {
                        case "1" -> category = "Products";
                        case "2" -> category = "Transport";
                        case "3" -> category = "Fun";
                        default -> {
                            System.out.println("Wrong input");
                            break;
                        }
                    }
                    System.out.println("Enter how much money(€) did you spend on " + category + ": ");
                    try {
                        money = scanner.nextDouble();
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format! Enter 0,00");
                    }
                    Expenditure newExp = new Expenditure(category, money);
                    list.addExpense(newExp);
                }
                case "2" -> {

                }
                case "3" -> {

                }
                case "4" -> {
                    System.out.println("Your List:");
                    list.printExpenditure();
                }
                case "5" -> {

                }
                case "6" -> {

                }
                case "7" -> {
                    list = new ExpenseImpl();
                    System.out.println("List is clean!");
                }

                case "8" -> {

                }
                case "9" -> {
                    System.out.println("Quit TODO List!");
                    flag = false;
                }
                default -> System.out.println("Wrong input!");
            }
        } while (flag);
    }
}
