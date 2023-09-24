import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class MainTest {

    @Test
    @DisplayName("Correct template input, incorrect hero input")
    public void correctTemplateAndIncorrectHeroInput() {
        String input = "Я взял Tiker. Кого могут взять противники?";
        Scanner scanner = new Scanner(input);

        Assertions.assertThrows(IncorrectHeroException.class, () -> Main.run(scanner));
    }

    @Test
    @DisplayName("Correct hero input, incorrect template input")
    public void correctHeroAndIncorrectTemplateInput() {
        String input = "Я взял Tinker Кого могут взять противники?";
        Scanner scanner = new Scanner(input);

        Assertions.assertThrows(IncorrectTemplateException.class, () -> Main.run(scanner));
    }

    @Test
    @DisplayName("Incorrect template and hero input")
    public void incorrectTemplateAndHeroInput() {
        String input = "Incorrect input";
        Scanner scanner = new Scanner(input);

        Assertions.assertThrows(IncorrectTemplateException.class, () -> Main.run(scanner));
    }

    @Test
    @DisplayName("Hero without enemies, family, lovers")
    public void heroWithoutEnemiesFamilyLovers() throws IncorrectHeroException, IncorrectTemplateException {
        String input = "Я взял Undying. Кого могут взять противники?";
        String output = "Противники могут взять следующих героев: Elder Titan, Enigma, Keeper of the Light, Io, " +
                "Chaos Knight, Lina, Crystal Maiden, Tidehunter, Kunkka, Huskar, Dazzle, Timbersaw, " +
                "Treant Protector, Mars, Zeus, Skywrath Mage, Vengeful Spirit, Anti-mage, Tinker, " +
                "Templar Assasin, Tusk, Bristleback";
        Scanner scanner = new Scanner(input);

        Assertions.assertEquals(Main.run(scanner), output);
    }

    @Test
    @DisplayName("Hero without enemies with family")
    public void heroWithoutEnemiesWithFamily() throws IncorrectHeroException, IncorrectTemplateException {
        String input = "Я взял Elder Titan. Кого могут взять противники?";
        String output = "Противники могут взять следующих героев: Crystal Maiden, Tidehunter, Kunkka, Huskar, " +
                "Dazzle, Timbersaw, Treant Protector, Mars, Zeus, Skywrath Mage, Vengeful Spirit, Anti-mage, " +
                "Undying, Tinker, Templar Assasin, Tusk, Bristleback";
        Scanner scanner = new Scanner(input);

        Assertions.assertEquals(Main.run(scanner), output);
    }

    @Test
    @DisplayName("Hero without enemies with lovers")
    public void heroWithoutEnemiesWithLovers() throws IncorrectHeroException, IncorrectTemplateException {
        String input = "Я взял Vengeful Spirit. Кого могут взять противники?";
        String output = "Противники могут взять следующих героев: Elder Titan, Enigma, Keeper of the Light, Io, " +
                "Chaos Knight, Lina, Crystal Maiden, Tidehunter, Kunkka, Huskar, Dazzle, Timbersaw, Treant Protector, " +
                "Mars, Zeus, Anti-mage, Undying, Tinker, Templar Assasin, Tusk, Bristleback";
        Scanner scanner = new Scanner(input);

        Assertions.assertEquals(Main.run(scanner), output);
    }

    @Test
    @DisplayName("Hero with enemies")
    public void heroWithEnemies() throws IncorrectHeroException, IncorrectTemplateException {
        String input = "Я взял Tinker. Кого могут взять противники?";
        String output = "Противники могут взять следующих героев: Templar Assasin, Tusk, Bristleback";
        Scanner scanner = new Scanner(input);

        Assertions.assertEquals(Main.run(scanner), output);
    }


}
