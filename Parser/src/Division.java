import java.time.LocalDate;
import java.util.Objects;

public class Division {
  private final String id; // ID генерируется в программе
  private final String name;

  public Division(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Division division = (Division) o;
    // Для подразделения достаточно сравнивать по имени,
    // так как ID генерируется при считывании
    return Objects.equals(name, division.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Division{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}