package main;

public class Main {
  public static void main(String[] args) {
    MyArrayList employees = new MyArrayList();
    employees.add("Кирилл");
    employees.add("Дима");
    employees.add("Максим");
    employees.add("Артем");
    employees.add("Никита");
    employees.add("Матвей");
    for (int i = 0; i < employees.getSize(); i++) {
      System.out.println(employees.get(i));
    }
    employees.remove(4);
    System.out.println();
    for (int i = 0; i < employees.getSize(); i++) {
      System.out.println(employees.get(i));
    }
  }
}