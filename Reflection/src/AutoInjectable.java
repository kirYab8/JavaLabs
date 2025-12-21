import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME) // Аннотация будет доступна во время работы программы
@Target(ElementType.FIELD)          // Аннотацию можно ставить только на поля класса
public @interface AutoInjectable {
}