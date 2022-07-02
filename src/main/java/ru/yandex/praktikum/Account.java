package ru.yandex.praktikum;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name == null) { return false; }

        if (name.length() < 3 || name.length() > 19) { return false; }

        int spaceNum = 0;
        for (char ch: name.toCharArray()) {
            if (ch == ' ') { spaceNum++; }
        }
        if (spaceNum != 1) { return false; }

        if (name.startsWith(" ") || name.endsWith(" ")) { return false; }

        return true;
    }

}