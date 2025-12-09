import java.time.LocalDate;
import java.util.Objects;

public class Person {
  private final int id;
  private final String name;
  private final String gender;
  private final Division division; // Ссылка на сущность Division
  private final double salary;
  private final LocalDate birthDate;

  public Person(int id, String name, String gender, LocalDate birthDate, Division division, double salary) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.division = division;
    this.salary = salary;
    this.birthDate = birthDate;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public Division getDivision() {
    return division;
  }

  public double getSalary() {
    return salary;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", birthDate=" + birthDate +
            ", salary=" + salary +
            ", division=" + division +
            '}';
  }
}