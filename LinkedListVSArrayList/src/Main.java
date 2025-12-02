public class Main {
  public static void main(String[] args) {
    int operationsCount = 1337;

    System.out.println("Количество операций для каждого теста: " + operationsCount);

    ArrayListTester arrayListTester = new ArrayListTester();
    LinkedListTester linkedListTester = new LinkedListTester();

    // Тестируем операции
    System.out.println("\nРезультаты тестирования:");
    System.out.println("Тип списка    | Метод   | Время\n");

    long alAdd = arrayListTester.testAdd(operationsCount);
    long llAdd = linkedListTester.testAdd(operationsCount);
    System.out.printf("ArrayList     | add     | %d\n", alAdd);
    System.out.printf("LinkedList    | add     | %d\n", llAdd);
    System.out.println();

    long alGet = arrayListTester.testGet(operationsCount);
    long llGet = linkedListTester.testGet(operationsCount);
    System.out.printf("ArrayList     | get     | %d\n", alGet);
    System.out.printf("LinkedList    | get     | %d\n", llGet);
    System.out.println();

    long alDelete = arrayListTester.testDelete(operationsCount);
    long llDelete = linkedListTester.testDelete(operationsCount);
    System.out.printf("ArrayList     | delete  | %d\n", alDelete);
    System.out.printf("LinkedList    | delete  | %d\n", llDelete);

    System.out.println();
    System.out.println("Более быстрый вариант для каждой операции:");
    System.out.println("add:    " + (alAdd < llAdd ? "ArrayList" : "LinkedList"));
    System.out.println("get:    " + (alGet < llGet ? "ArrayList" : "LinkedList"));
    System.out.println("delete: " + (alDelete < llDelete ? "ArrayList" : "LinkedList"));
  }
}