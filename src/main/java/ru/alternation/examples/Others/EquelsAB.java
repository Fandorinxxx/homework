package ru.alternation.examples.Others;

/**
 * Также видно, что допустим доступ к приватным члена сложенных классов (и они друг к другу).
 */
public class EquelsAB {
    public static void main(String[] args) {
        B.prints();
        System.out.println(A.strs);
        new B().print();
    }

    static class A {
        private String str1;
        private String str2;
        private static String strs = "0s";
        private String str = "0_";

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (str1 != null ? !str1.equals(a.str1) : a.str1 != null) return false;
            return str2 != null ? str2.equals(a.str2) : a.str2 == null;
        }

        @Override
        public int hashCode() {
            int result = str1 != null ? str1.hashCode() : 0;
            result = 31 * result + (str2 != null ? str2.hashCode() : 0);
            return result;
        }
    }

    static class B extends A {
        private String str3;
        private String str4;
        private static String strs = "1s";
        private String str = "1_";


        public static void prints(){
            System.out.println(A.strs);    // private
        }
        public void print(){
            System.out.println(super.str); // private
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            if (str3 != null ? !str3.equals(b.str3) : b.str3 != null) return false;
            return str4 != null ? str4.equals(b.str4) : b.str4 == null;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (str3 != null ? str3.hashCode() : 0);
            result = 31 * result + (str4 != null ? str4.hashCode() : 0);
            return result;
        }
    }
}
