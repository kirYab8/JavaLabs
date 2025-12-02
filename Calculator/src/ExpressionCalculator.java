import java.util.*;

public class ExpressionCalculator {
  private Map<String, Double> variables = new HashMap<>();

  public double evaluate(String expression) throws Exception {
    expression = expression.replaceAll("\\s+", "");

    if (!checkBrackets(expression)) {
      throw new Exception("Неверное количество или порядок скобок");
    }

    return parseExpression(expression);
  }

  private boolean checkBrackets(String expression) {
    int balance = 0;
    for (char c : expression.toCharArray()) {
      if (c == '(') balance++;
      if (c == ')') balance--;
      if (balance < 0) return false;
    }
    return balance == 0;
  }

  private double parseExpression(String expr) throws Exception {
    // Сложение и вычитание
    int index = findOperator(expr, "+-");
    if (index != -1) {
      double left = parseExpression(expr.substring(0, index));
      double right = parseExpression(expr.substring(index + 1));
      char op = expr.charAt(index);

      if (op == '+') return left + right;
      if (op == '-') return left - right;
    }

    // Умножение и деление
    index = findOperator(expr, "*/");
    if (index != -1) {
      double left = parseExpression(expr.substring(0, index));
      double right = parseExpression(expr.substring(index + 1));
      char op = expr.charAt(index);

      if (op == '*') return left * right;
      if (op == '/') {
        if (right == 0) throw new Exception("Деление на ноль");
        return left / right;
      }
    }

    // Обработка скобок
    if (expr.startsWith("(") && expr.endsWith(")")) {
      return parseExpression(expr.substring(1, expr.length() - 1));
    }

    // Число
    try {
      return Double.parseDouble(expr);
    } catch (NumberFormatException e) {
      throw new Exception("Неизвестный символ: " + expr);
    }
  }

  private int findOperator(String expr, String operators) {
    int bracketLevel = 0;

    for (int i = expr.length() - 1; i >= 0; i--) {
      char c = expr.charAt(i);

      if (c == ')') bracketLevel++;
      else if (c == '(') bracketLevel--;
      else if (bracketLevel == 0 && operators.indexOf(c) != -1) {
        return i;
      }
    }
    return -1;
  }
}