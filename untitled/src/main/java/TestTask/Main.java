package TestTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(textModifier());
    }

    public static String textModifier() {
        Scanner scanner = new Scanner(System.in);

        // Чтение строки из консоли
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        scanner.close();

        // a. Удаление лишних пробелов
        char[] charsA = input.toCharArray();
        String variantA = ""; // Пустая строка для хранения результата
        boolean wasSpace = false;

        for (char currentChar : charsA) {
            if (currentChar == ' ') {
                if (!wasSpace) {
                    variantA += currentChar;
                }
                wasSpace = true;
            } else {
                variantA += currentChar;
                wasSpace = false;
            }
        }
//        System.out.println("После удаления двойных пробелов: " + variantA);

        // b. Обработка символа '-'
        char[] charsB = variantA.toCharArray();
        String variantB = ""; // Пустая строка для хранения результата

        for (int i = 0; i < charsB.length; i++) {
            if (charsB[i] == '-' && i > 0 && i < charsB.length - 1) {
                // Меняем местами символы слева и справа от '-'
                variantB = variantB.substring(0, variantB.length() - 1) + charsB[i + 1] + charsB[i - 1];
                i++; // Пропускаем символ справа от '-'
            } else {
                variantB += charsB[i];
            }
        }
//        System.out.println("После обработки символа '-' : " + variantB);

        // c. Замена символа '+' на '!'
        char[] charsC = variantB.toCharArray();
        String variantC = ""; // Пустая строка для хранения результата

        for (char c : charsC) {
            if (c == '+') {
                variantC += '!';
            } else {
                variantC += c;
            }
        }
//        System.out.println("После замены символа '+' на '!' : " + variantC);

        // d. Удаление цифр и подсчёт их суммы
        char[] charsD = variantC.toCharArray();
        String variantD = ""; // Пустая строка для хранения результата
        int sum = 0;

        for (char c : charsD) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            } else {
                variantD += c;
            }
        }
        if (sum > 0) {
            variantD += " " + sum;
        }
//        System.out.println("После подсчёта суммы цифр и их удаления: " + variantD);

        // Возвращаем окончательный результат
        return variantD;
    }
}