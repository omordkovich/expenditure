package model;

import java.io.Serializable;

public enum Category implements Serializable {
    PRO("(1) Products | "),
    TRA("(2) Transport | "),
    FUN("(3) Fun\n");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

