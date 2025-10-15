package InputFunctions;

import java.util.Scanner;

public class InputFunctions {
    static int GetIntInput(int Min, int Max, String InputText) {
        while (true) {
            Scanner InputScanner = new Scanner(System.in);
            int IntInput = 0;
            try {
                System.out.print(InputText);
                IntInput = InputScanner.nextInt();
            }
            catch (Exception Ex) {
                System.out.println("Ошибка: Вы должны ввести целое число!");
                continue;
            }
            if (IntInput < Min) {
                System.out.println("Ошибка: Число слишком маленькое!");
                continue;
            }
            else if (IntInput > Max) {
                System.out.println("Ошибка: Число слишком большое!");
                continue;
            }
            else {
                return IntInput;
            }
        }
    }

    static int GetIntInputOnlyMin(int Min, String InputText) {
        return GetIntInput(Min, Integer.MAX_VALUE, InputText);
    }

    static int GetIntInputOnlyMax(int Max, String InputText) {
        return GetIntInput(Integer.MIN_VALUE, Max, InputText);
    }

    static double GetDoubleInput(double Min, double Max, String InputText) {
        while (true) {
            Scanner InputScanner = new Scanner(System.in);
            double DoubleInput = 0;
            try {
                System.out.print(InputText);
                DoubleInput = InputScanner.nextDouble();
            }
            catch (Exception Ex) {
                System.out.println("Ошибка: Вы должны ввести число!");
                continue;
            }
            if (DoubleInput < Min) {
                System.out.println("Ошибка: Число слишком маленькое!");
                continue;
            }
            else if (DoubleInput > Max) {
                System.out.println("Ошибка: Число слишком большое!");
                continue;
            }
            else {
                return DoubleInput;
            }
        }
    }

    static double GetDoubleInputOnlyMin(double Min, String InputText) {
        return GetDoubleInput(Min, Integer.MAX_VALUE, InputText);
    }

    static double GetDoubleInputOnlyMax(double Max, String InputText) {
        return GetDoubleInput(Integer.MIN_VALUE, Max, InputText);
    }
}
