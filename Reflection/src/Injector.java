import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
  private Properties properties;

  public Injector() {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("config.properties"));
    } catch (IOException e) {
      System.err.println("Файл config.properties не найден!");
    }
  }

  public <T> T inject(T object) {
    Class<?> clazz = object.getClass();
    Field[] fields = clazz.getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(AutoInjectable.class)) {

        // Получаем тип поля (интерфейс)
        String interfaceName = field.getType().getName();

        // Ищем в properties, какой класс должен его реализовать
        String implClassName = properties.getProperty(interfaceName);

        if (implClassName != null) {
          try {
            // Создаем экземпляр класса реализации через рефлексию
            Object implementation = Class.forName(implClassName)
                    .getDeclaredConstructor()
                    .newInstance();

            // Делаем поле доступным (если оно private)
            field.setAccessible(true);
            // Записываем созданный объект в поле
            field.set(object, implementation);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }
    return object;
  }
}