package ru.alternation.stepik.basic.section2.stage3.step10;

/**
 Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка,
 которая читается одинаково слева направо и справа налево (в том числе пустая).
 При определении "палиндромности" строки должны учитываться только буквы и цифры. А пробелы, знаки препинания,
 а также регистр символов должны игнорироваться. Гарантируется, что в метод попадают только строки,
 состоящие из символов ASCII (цифры, латинские буквы, знаки препинания).
 Т.е. русских, китайских и прочих экзотических символов в строке не будет.

 Воспользуйтесь предоставленным шаблоном.
 Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

 Подсказки (не читайте, если хотите решить сами):

 для удаления из строки всех символов, не являющихся буквами и цифрами,
 можно воспользоваться регулярным выражением "[^a-zA-Z0-9]"; найдите в классе String метод,
 выполняющий замену по регулярному выражению;
 для перестановки символов строки в обратном порядке можно воспользоваться методом reverse(),
 который находится в классе StringBuilder;
 в классе String есть методы для преобразования всей строки в верхний и нижний регистр.

 Sample Input:
 Madam, I'm Adam!
 Sample Output:
 true
 */


    // http://proglang.su/java/123
    // https://www.tutorialspoint.com/java/java_string_replaceall

    // !!!
    // http://www.quizful.net/post/Java-RegExp

public class Main {

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {

        text = text.replaceAll("\\W", "");
        return  text.equalsIgnoreCase(new StringBuilder(text).reverse().toString());
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

}

