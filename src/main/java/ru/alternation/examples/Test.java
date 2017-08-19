package ru.alternation.examples;



public  class Test {
    public static void main(String[] args) {

        System.out.println(Type.INTEGER.isPrimitive());
        Type.INTEGER.setPrimitive(true);
        System.out.println(Type.INTEGER.isPrimitive());


    }


    enum Type {
        INT(true) {
            public Object parse(String string) { return Integer.valueOf(string); }
        },
        INTEGER(false) {
            public Object parse(String string) { return Integer.valueOf(string); }
        },
        STRING(false) {
            public Object parse(String string) { return string; }
        };

        boolean primitive;
        Type(boolean primitive) { this.primitive = primitive; }

        public void setPrimitive(boolean primitive) {
            this.primitive = primitive;
        }

        public boolean isPrimitive() { return primitive; }
        public abstract Object parse(String string);
    }

}
