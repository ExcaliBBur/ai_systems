package org.example;

import org.jpl7.Term;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    private final String regex;
    private final Pattern pattern;

    private final Scanner scanner;

    private String line;

    public Utility(Scanner scanner) {
        this.regex = "Я взял [A-Z][a-z]*( [A-Z][a-z]*| [a-z]*)*\\. Кого могут взять противники\\?";
        this.pattern = Pattern.compile(this.regex);
        this.scanner = scanner;
    }

    public String readLineAndValidate() throws IncorrectTemplateException {
        String line = scanner.nextLine().trim();
        if (!checkLine(line)) {
            throw new IncorrectTemplateException();
        }

        this.line = line;
        return line;
    }

    public String getHeroName() {
        return line.substring(7, line.indexOf("."));
    }

    public boolean checkLine(String line) {
        return pattern.matcher(line).find();
    }

    public void printGuide() {
        System.out.println("Ввод необходимо осуществлять по следующему шаблону: ");
        System.out.println("Я взял %Hero%. Кого могут взять противники?\n");
    }

    public String createAnswer(Map<String, Term>[] results) {
        StringBuilder stringBuilder = new StringBuilder("Противники могут взять следующих героев: ");
        for (int i = 0; i < results.length; i++) {
            for (Map.Entry<String, Term> entry : results[i].entrySet()) {
                stringBuilder.append(entry.getValue().toString().replace("'", "")).append(", ");
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
