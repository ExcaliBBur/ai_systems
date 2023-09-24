package org.example;

/**
 * Incorrect Hero input
 */
public class IncorrectHeroException extends Exception {
    public IncorrectHeroException(String hero) {
        super(String.format("Героя %s не существует в базе знаний. Попробуйте ещё раз.%n", hero));
    }
}
