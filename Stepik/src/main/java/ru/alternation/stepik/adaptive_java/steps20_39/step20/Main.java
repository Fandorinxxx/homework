package ru.alternation.stepik.adaptive_java.steps20_39.step20;

import java.util.Scanner;

/**
 # 1.20 Healthy sleep

 Ann watched a TV program about health and learned that it is recommended to sleep at least A hours per day,
 but oversleeping is also not healthy and you should not sleep more than B hours. Now Ann sleeps H hours per day.
 If Ann's sleep schedule complies with the requirements of that TV program – print "Normal".
 If Ann sleeps less than A hours, output “Deficiency”, if she sleeps more than B hours, output “Excess”.

 Input to this program are the three strings with variables in the following order: A, B, H. A is always less than
 or equal to B.

 Please note latters case: the output should exactly correspond to what required in the problem, i.e. if the program
 has to output "Excess", such output as "excess", "EXCESS", "ExCeSs" and others will not be graded as correct.

 You should carefully think about all conditions, which you need to use. A special attention should be paid to
 the strictness of the used conditional operators: distinguish between < and ≤; > and ≥. In order to understand
 which ones to use, please carefully read the problem statement.

 ____________________________________________________________________________________________________
 Sample Input 1:
 6
 10
 8

 Sample Output 1:
 Normal

 ____________________________________________________________________________________________________
 Sample Input 2:
 7
 9
 10

 Sample Output 2:
 Excess

 ____________________________________________________________________________________________________
 Sample Input 3:
 7
 9
 2

 Sample Output 3:
 Deficiency

 */



public class Main {
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int H = scanner.nextInt();

        System.out.println(H < A ? "Deficiency" : H > B ? "Excess" : "Normal");

//        if (H < A) {
//            System.out.println("Deficiency");
//        } else if (H > B) {
//            System.out.println("Excess");
//        } else {
//            System.out.println("Normal");
//        }

    }
}

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int A = Integer.parseInt(reader.readLine()); // throws IOException
//        int B = Integer.parseInt(reader.readLine());
//        int H = Integer.parseInt(reader.readLine());