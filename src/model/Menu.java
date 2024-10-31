package model;

import java.io.Serializable;

public enum Menu implements Serializable {
    ADD("(1) Add Note | "),
    DEL("(2) Remove Note | "),
    EDIT("(3) Edit Note | "),
    PRINT("(4) Print list | "),
    LOAD("(5) Load list | "),
    SAVE("(6) Save list | "),
    CLEAN("(7) Clear list | "),
    LIST("(8) List by Category | "),
    EXIT("(9) Quit Application\n");

    private String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
