package ru.alternation.examples.Others.Trash.InitOrder;

/**
 * Порядок инициализации таков:

 1. Статические элементы родителя
 2. Статические элементы наследника
 3. Глобальные переменные родителя
 4. Конструктор родителя
 5. Глобальные переменные наследника
 6. Конструктор наследника

 http://ru.stackoverflow.com/a/464067

 При создании нового экземпляра класса, выделяется память для всех переменных экземпляра, объявленных в классе,
 и для всех переменных экземпляра, объявленных в каждом суперклассе, включая все скрытые переменные (§8.3).

 Если выделить память невозможно из-за нехватки свободного места, создание экземпляра прерывается с OutOfMemoryError.
 Иначе все переменные экземпляра нового объекта, включая объявленные в суперклассе, инициализируются значениями по-умолчанию.


 В отличие от C++, Java не устанавливает отдельные правила для диспетчеризации методов во время создания нового
 экземпляра класса. Если вызываются методы, переопределенные в наследниках в инициализируемом объекте, эти
 переопределенные методы используются до полной инициализации нового объекта.



 https://youtu.be/_LJggWWO7W4
 *
 */
public class Test {
    Test(){
        System.out.println("Test()" + i1 + " " + o1);
    }

    int o1;
    static int i1;
    static int i2 = setterInt(2, "static int i2 = 2");

    static {
        System.out.println("Static block 1 of Test");
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
    }
// Только перед использованием. Тут нельзя. Иначе illegal forward reference
//    static int i1;
//    static int i2 = 2;

    static int i3 = setterInt(3, "static int i3 = 3");
    static {
        System.out.println("Static block 2 of Test");
    }

    static int setterInt(int i, String s){
        System.out.println(s);
        return i;
    }

    public static void main(String[] args) {
        System.out.println("psvm of Test");


        A a = new B();
        System.out.println(a.m);  // 0
        // ибо "Глобальные переменные наследника" не были инициализированы еще, а метод вызвался "полиморфный".

        A a2 = new A();
        System.out.println(a2.m); // 5
    }
}

class A{

    int m = print();

    int print(){
       return 5;
    }
}

class B extends A{
    int k = 20;

    @Override
    int print() {
        return k;
    }
}


