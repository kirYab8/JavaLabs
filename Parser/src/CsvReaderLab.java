import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CsvReaderLab {

  // Путь к файлу. Предполагается, что файл находится в папке resources.
  private static final String CSV_FILE_PATH = "foreign_names.csv";
  private static final String SEPARATOR = ";";
  // Формат даты, используемый в файле: DD.MM.YYYY
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  /**
   * Считывает данные из CSV-файла и возвращает список объектов Person.
   * @return Список объектов Person.
   * @throws IOException Если произошла ошибка ввода-вывода.
   */
  public List<Person> loadPeopleFromCsv() throws IOException {
    List<Person> people = new ArrayList<>();
    // Используем Map для хранения уже созданных Division (по названию),
    // чтобы не создавать дубликаты и присваивать один и тот же объект.
    Map<String, Division> divisionCache = new HashMap<>();

    // Получаем InputStream для файла, используя ClassLoader.
    // Это более надежно, чем прямой путь, если файл находится в ресурсах JAR.
    try (InputStream is = getClass().getClassLoader().getResourceAsStream(CSV_FILE_PATH);
         BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

      if (is == null) {
        // Если файл не найден в ресурсах, попробуем загрузить как обычный файл.
        // В данном случае, я предполагаю, что файл доступен через ClassLoader.
        // Для теста с вашим загруженным файлом, он доступен как 'foreign_names.csv'.
        System.err.println("Ошибка: Файл " + CSV_FILE_PATH + " не найден в ресурсах.");
        return people;
      }

      // Считываем заголовок, чтобы пропустить его
      String headerLine = reader.readLine();
      System.out.println("Пропускаем заголовок: " + headerLine);

      String line;
      // Итерируемся по оставшимся строкам
      while ((line = reader.readLine()) != null) {
        String[] fields = line.split(SEPARATOR);

        // Проверка на корректное количество столбцов (должно быть 6: id, name, gender, BirtDate, Division, Salary)
        if (fields.length != 6) {
          System.err.println("Пропускаем строку из-за неверного формата: " + line);
          continue;
        }

        try {
          // 1. Парсинг полей
          int id = Integer.parseInt(fields[0]);
          String name = fields[1];
          String gender = fields[2];
          String birthDateStr = fields[3]; // Дата рождения в формате DD.MM.YYYY
          String divisionName = fields[4]; // Название подразделения
          double salary = Double.parseDouble(fields[5]);

          // 2. Создание или получение Division
          Division division;
          if (divisionCache.containsKey(divisionName)) {
            division = divisionCache.get(divisionName);
          } else {
            // Генерируем ID для нового подразделения (используем UUID для простоты)
            String divisionId = UUID.randomUUID().toString();
            division = new Division(divisionId, divisionName);
            divisionCache.put(divisionName, division);
          }

          // 3. Преобразование даты
          LocalDate birthDate = LocalDate.parse(birthDateStr, DATE_FORMATTER);

          // 4. Создание объекта Person
          Person person = new Person(id, name, gender, birthDate, division, salary);
          people.add(person);

        } catch (NumberFormatException e) {
          System.err.println("Ошибка парсинга числа в строке: " + line + ". " + e.getMessage());
        } catch (java.time.format.DateTimeParseException e) {
          System.err.println("Ошибка парсинга даты в строке: " + line + ". " + e.getMessage());
        }
      }

    } // try-with-resources автоматически закрывает ресурсы

    System.out.println("\nРезультат чтения");
    System.out.println("Всего прочитано людей: " + people.size());
    System.out.println("Всего уникальных подразделений: " + divisionCache.size());

    return people;
  }


}