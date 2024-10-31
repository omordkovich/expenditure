import dao.Expense;
import dao.ExpenseImpl;
import model.Category;
import model.Expenditure;
import model.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExpenditureListAppl implements Serializable {
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
                    scanner.nextLine();
                    String cInput = scanner.nextLine();
                    double money = 0;
                    String category = "";
                    switch (cInput) {
                        case "1" -> category = "Products";
                        case "2" -> category = "Transport";
                        case "3" -> category = "Fun";
                        default -> {
                            System.out.println("Wrong input");
                            continue;
                        }
                    }
                    System.out.println("Enter how much money(€) did you spend on " + category + ": ");
                    try {
                        money = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong format! Enter 0,00");
                        continue;
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
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data/save.dat"))) {
                        list = (ExpenseImpl) ois.readObject();
                        Expenditure.setIdCounter(list.findMaxID());
                        System.out.println("List ist loaded!");
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "6" -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/data/save.dat"))) {
                        try {
                            oos.writeObject(list);
                            System.out.println("Saved!");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "7" -> {
                    list = new ExpenseImpl();
                    System.out.println("List is clean!");
                }

                case "8" -> {
                    System.out.println("Enter category you want to filter:");
                    categories.forEach(category -> System.out.print(category.getName()));
                    scanner.nextLine();
                    String cInput = scanner.nextLine();
                    String c = "";
                    switch (cInput) {
                        case "1" -> c = "Products";
                        case "2" -> c = "Transport";
                        case "3" -> c = "Fun";
                        default -> {
                            System.out.println("Wrong input");
                            continue;
                        }
                    }
                    List<Expenditure> filteredList = list.expenseByCategory(c);
                    System.out.println("List by " + c + ": ");
                    filteredList.forEach(System.out::println);
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
