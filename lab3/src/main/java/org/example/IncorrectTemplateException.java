package org.example;

public class IncorrectTemplateException extends Exception {

    public IncorrectTemplateException() {
        super("Ввод не соответствует шаблону.");
    }
}
