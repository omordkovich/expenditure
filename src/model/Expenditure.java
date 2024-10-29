package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Expenditure {
    private static int idCounter = 0;
    private int id;
    private String category;
    private double money;
    private LocalDateTime date;

    public Expenditure(String category, double money) {
        this.id = ++idCounter;
        this.category = category;
        this.money = money;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedTime = date.format(timeFormatter);
        return String.format("Expenditure ID: %d, category: %s, spent money: %.2f created: %s", id, category, money, formattedTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expenditure that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static void setIdCounter(int idCounter) {
        Expenditure.idCounter = idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getMoney() {
        return money;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
