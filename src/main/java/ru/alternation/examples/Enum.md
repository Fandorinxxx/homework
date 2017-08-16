```
public abstract class Enum<E extends Enum<E>>
    implements Comparable<E>, Serializable {...}
```

### Как я это понял (не факт, что верно):

Enum реализует интерфейс `Comparable<E>`, где `E` является наследником `Enum`, притом такого, который реализует
`Comparable` именно того же `E`.

Примером такого (наследника Enum) класса может быть Day:
```
enum Day {
    THURSDAY, FRIDAY, SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY
}
```
    
И еще один пример перечисления:
```
   enum Season { WINTER, SPRING, SUMMER, AUTUMN }
```

И если теперь подставить в определение вместо `E` конкретный класс:

Enum реализует интерфейс `Comparable<Day>`, где `Day` является наследником `Enum`, притом такого, который реализует именно
`Comparable<Day>`, а не, например, `Comparable<Season>`.


И если можно было наследоваться явно, без использования "магического синтаксиса", то выглядело бы это вот так:

```
public class Test {
   public static class Day extends Enum<Day>{ // Error: Classes cannot directly extend 'java.lang.Enum'
       public Day(String name, int ordinal) {
           super(name, ordinal);
       }
   }
   public static void main(String[] args) {
      Day SUNDAY = new Day("MONDAY", 0);
      Day MONDAY = new Day("MONDAY", 1);
   }
}
```