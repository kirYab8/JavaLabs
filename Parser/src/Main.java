import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    CsvReaderLab lab = new CsvReaderLab();
    try {
      List<Person> peopleList = lab.loadPeopleFromCsv();

      System.out.println("\nПервые 5 объектов Person из списка");
      peopleList.stream().limit(5).forEach(System.out::println);

    } catch (IOException e) {
      System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
      e.printStackTrace();
    }
  }
}