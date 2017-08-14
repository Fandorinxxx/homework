package ru.alternation.examples.Youtube.Ars;


import java.util.Scanner;

public class InteractRunner {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {

            Calculator calc = new Calculator();
            String exit = "no";
            while (!exit.equals("yes")){
                System.out.println("Enter first arg: ");
                String first = scanner.next();
                System.out.println("Enter second arg: ");
                String second = scanner.next();

                try {
                    calc.div(Integer.parseInt(first), Integer.parseInt(second));
                } catch (UserException e) {
                    e.printStackTrace();
                    System.out.println("Please enter two arguments");
                }
                System.out.println("Result: " + calc.getResult());

                System.out.println("Exit : yes/no");
                exit = scanner.next();
            }

        }
    }
}
