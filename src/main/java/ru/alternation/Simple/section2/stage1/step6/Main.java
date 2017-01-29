package ru.alternation.Simple.section2.stage1.step6;

/**
 Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).
 Во всех остальных случаях метод должен возвращать false.

 Воспользуйтесь шаблоном кода, который предлагает система. Ввод-вывод будет сделан за вас.
 Вам надо только проанализировать переданные в метод booleanExpression значения (a, b, c, d) и вернуть результат.
 Попробуйте составить формулу с использованием булевых операторов.
 Если не получается, вернитесь к этому заданию после просмотра степов про условные операторы и циклы.

 При записи сложных выражений рекомендуется использовать скобки, чтобы не запутаться в порядке применения операторов.

 В качестве примера уже указано заведомо некорректное решение задачи. Исправьте его.

 Совет тем, у кого не проходит какой-то из тестов. В данной задаче возможно всего 16 комбинаций значений входных параметров.
 Их можно выписать на бумажку, посчитать для них правильные ответы и сравнить с тем, что выдает ваше решение.
 Попробуйте самостоятельно проделать это, найти ошибку и исправить решение.

 Sample Input 1:
 false false false false
 Sample Output 1:
 false

 Sample Input 2:
 true true true true
 Sample Output 2:
 false

 Sample Input 3:
 false false true true
 Sample Output 3:
 true

 */
public class Main {
    public static void main(String[] args) {

        System.out.println(booleanExpression(false, false, false, false));  // false
        System.out.println(booleanExpression(true,  true,  true,  true) );  // false
        System.out.println(booleanExpression(false, false, true,  true));   // true
    }

    // Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).
    // Во всех остальных случаях метод должен возвращать false.
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {



        // a b c d   1
        // 1 1 0 0    a&b & !(c|d)
        // 1 0 1 0    a&c & !(b|d)
        // 1 0 0 1    a&d & !(b|c)
        // 0 1 1 0    b&c & !(a|d)
        // 0 1 0 1    b&d & !(a|c)
        // 0 0 1 1    c&d & !(a|b)

        //


        return  (a&b && !(c|d)) ||
                (a&c && !(b|d)) ||
                (a&d && !(b|c)) ||
                (b&c && !(a|d)) ||
                (b&d && !(a|c)) ||
                (c&d && !(a|b));


    }
}
