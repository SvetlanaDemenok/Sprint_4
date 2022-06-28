package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    String name;
    boolean isValid;

    public AccountTest(String name, boolean isValid) {
        this.name = name;
        this.isValid = isValid;
    }

    @Parameterized.Parameters(name = "name=\"{0}\" isValid={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // < нижней граниы
                {"", false},
                {"SD", false},
                // > верхней границы
                {"Svetlana Demenoooook", false},
                // в границах
                {"S D", true},
                {"Svetlana Demenoook", true},
                {"Sv D", true},
                {"Svetlana Demenook", true},
                {"Svetlana Demenok", true},
                // нет пробелов
                {"SvetlanaDemnok", false},
                // больше 1го пробела
                {"Svetlana  Demenok", false},
                // пробел в начале строки
                {" Svetlana", false},
                // пробел в конце строки
                {"Svetlana ", false},
        });
    }

    @Test
    public void checkNameToEmboss() {
        var account = new Account(name);

        assertEquals(isValid, account.checkNameToEmboss());
    }
}