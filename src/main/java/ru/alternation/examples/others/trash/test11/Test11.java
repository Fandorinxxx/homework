package ru.alternation.examples.others.trash.test11;

public class Test11 {

    public static void main(String[] args) {
        Long value = new Long(0);
        System.out.println(value.equals(0)); // false

        /*
        public boolean equals(Object obj) {
            if (obj instanceof Long) {
                return value == ((Long)obj).longValue();
            }
            return false;
        }
        */

        System.out.println(value.equals(0L)); // true
    }
}