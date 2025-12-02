import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ExpressionCalculator calculator = new ExpressionCalculator();

    while (true) {
      System.out.print("Введите выражение: ");
      String input = scanner.nextLine().trim();

      if (input.isEmpty()) {
        continue;
      }

      try {
        double result = calculator.evaluate(input);
        System.out.println("Результат: " + result + "\n");
      } catch (Exception e) {
        System.out.println("Ошибка: " + e.getMessage() + "\n");
      }
    }

  }
}