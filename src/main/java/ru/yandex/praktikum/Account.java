package ru.yandex.praktikum;

import java.util.regex.Pattern;

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

        return Pattern.compile("^\\w+ \\w+$").matcher(name).matches();
    }

}