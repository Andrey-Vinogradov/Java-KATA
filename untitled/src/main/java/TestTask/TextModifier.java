package TestTask;

import java.util.Scanner;

public class TextModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение строки из консоли
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        scanner.close();
//a. Если в тексте между словами присутствует несколько пробелов подряд,
// надо оставить только один из них.

        // Преобразование строки в массив символов
        char[] charsA = input.toCharArray();
        int lengthA = charsA.length;
        String variantA = "";//пустая строка для хранения результата
        boolean wasSpace = false;

        for (int i = 0; i < lengthA; i++) {
            char currentChar = charsA[i];

            // Если текущий символ - пробел
            if (currentChar == ' ') {
                if (!wasSpace) { // Если предыдущий символ не был пробелом, добавляем пробел
                    variantA += currentChar;
                }
                wasSpace = true;
            } else {
                // Если текущий символ не пробел, добавляем его и сбрасываем флаг
                variantA += currentChar;
                wasSpace = false;
            }
        }
        System.out.println("после удаления двойных пробелов: "+variantA);
        // b. Если в тексте присутствует знак минус (-), это значит,
        // что символ слева от этого знака надо поменять местами с символом,
        // который стоит справа от этого знака.
        // Обратите внимание, что символом может быть не только буква,
        // но и цифра или любой другой знак/символ, в том числе символ пробела.
        // После смены символов местами, знак минус (-) надо удалить из строки результата.

        char[] charsB = variantA.toCharArray();
        String variantB = "";//пустая строка для хранения результата

        for (int i = 0; i < charsB.length; i++) {
            if (charsB[i] == '-' && i > 0 && i < charsB.length - 1) {
                variantB = variantB.substring(0, variantB.length() - 1) + charsB[i + 1] + charsB[i - 1];
                i++; //пропускаем символ справа от '-'
            } else {
                variantB += charsB[i];
            }
        }

        // Вывод результата
        System.out.println("Откорректированная строка:");
        System.out.println(variantB);
    }
}
