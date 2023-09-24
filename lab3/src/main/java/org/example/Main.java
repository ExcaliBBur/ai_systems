package org.example;

import org.jpl7.Atom;
import org.jpl7.Compound;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String run(Scanner scanner) throws IncorrectHeroException, IncorrectTemplateException {

        Utility utilily = new Utility(scanner);
        QueryController queryController = new QueryController();
        queryController.init();

        utilily.printGuide();

        utilily.readLineAndValidate();

        String heroName = utilily.getHeroName();

        queryController.setQuery(new Query(new Compound("hero", new Term[]{new Atom(heroName)})));

        if (!queryController.getQuery().hasSolution()) {
            throw new IncorrectHeroException(heroName);
        }

        queryController.setQuery(new Query("opponents('" + heroName + "', Y)"));

        Map<String, Term>[] results = queryController.getResults();

        if (results.length == 0) {
            queryController.setQuery(new Query(String.format("hero(X), '%s' \\== X, not_family('%s', X), " +
                    "not_lovers('%s', X)", heroName, heroName, heroName)));
            results = queryController.getResults();
        }

        return utilily.createAnswer(results);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(Main.run(scanner));
        } catch (IncorrectTemplateException | IncorrectHeroException e) {
            System.out.println(e.getMessage());
        }
    }
}