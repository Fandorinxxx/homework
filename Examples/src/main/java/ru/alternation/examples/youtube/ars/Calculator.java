package ru.alternation.examples.youtube.ars;


public class Calculator {
    private int result = 0;

    public void  add(int... args){
        for (int param : args){
            this.result+=param;
        }
    }
    public void  div(int... args) throws UserException {
        if (args.length > 0) {
            result = args[0];
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i + 1] == 0){
                    throw new IllegalArgumentException("div by 0");
                }
                result = result / args[i + 1];
            }
        } else {
            throw new UserException("You should enter args!");
        }
    }

    public int getResult() {
        return this.result;
    }

    public void cleanResult() {
        this.result = 0;
    }
}
