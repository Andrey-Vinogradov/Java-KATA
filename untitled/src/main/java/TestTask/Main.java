package TestTask;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Укажите путь к вашей папке
        File folder = new File("c:/tmp/");

        // Проверяем, существует ли папка
        if (!folder.exists()) {
            System.out.println("Папка не существует: " + folder.getAbsolutePath());
            return;
        }

        // Проверяем, является ли путь директорией
        if (!folder.isDirectory()) {
            System.out.println("Указанный путь не является папкой: " + folder.getAbsolutePath());
            return;
        }

        // Получаем список файлов
        File[] files = folder.listFiles();

        // Проверяем, есть ли файлы в папке
        if (files == null || files.length == 0) {
            System.out.println("Папка пуста: " + folder.getAbsolutePath());
            return;
        }

        // Выводим информацию о каждом файле
        for (File file : files) {
            // Пропускаем подпапки (если нужно только файлы)
            if (file.isFile()) {
                System.out.println("Имя: " + file.getName() +
                        ", Размер: " + file.length() + " байт" +
                        ", Путь: " + file.getAbsolutePath());
            }
        }
    }
}