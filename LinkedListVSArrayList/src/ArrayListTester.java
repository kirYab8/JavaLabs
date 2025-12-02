import java.util.ArrayList;

public class ArrayListTester {
  private ArrayList<Integer> list;

  public ArrayListTester() {
    this.list = new ArrayList<>();
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

    for (int i = operationsCount - 1; i >= 0; i--) {
      list.remove(i);
    }

    return System.nanoTime() - startTime;
  }
}