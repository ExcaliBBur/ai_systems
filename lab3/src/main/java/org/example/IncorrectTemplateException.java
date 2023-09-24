package org.example;

/**
 * Incorrect Template input
 */
public class IncorrectTemplateException extends Exception {

    public IncorrectTemplateException() {
        super("Ввод не соответствует шаблону.");
    }
}
