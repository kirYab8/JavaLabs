import java.util.LinkedList;

public class LinkedListTester {
  private LinkedList<Integer> list;

  public LinkedListTester() {
    this.list = new LinkedList<>();
  }

  // Тест добавления элементов
  public long testAdd(int operationsCount) {
    list.clear();
    long startTime = System.nanoTime();

    for (int i = 0; i < operationsCount; i++) {
      list.add(i);
    }

    return System.nanoTime() - startTime;
  }

  // Тест получения элементов
  public long testGet(int operationsCount) {
    list.clear();
    for (int i = 0; i < operationsCount; i++) {
      list.add(i);
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < operationsCount; i++) {
      list.get(i);
    }

    return System.nanoTime() - startTime;
  }

  // Тест удаления элементов
  public long testDelete(int operationsCount) {
    list.clear();
    for (int i = 0; i < operationsCount; i++) {
      list.add(i);
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < operationsCount; i++) {
      list.removeFirst();
    }

    return System.nanoTime() - startTime;
  }
}