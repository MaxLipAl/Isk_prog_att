import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println("Введите данные (Фамилия, Имя, Отчество, дата рождения (00.00.0000), номер_телефона (123456), пол (м или ж):");
                String inputData = scanner.nextLine();

                String[] dataParts = inputData.split(" ");
                if (dataParts.length != 6) {
                    System.err.println("Ошибка: Неверное количество данных. Пожалуйста, введите данные в правильном формате.");
                    continue;
                }

                Person person = Person.fromString(inputData);

                String fileName = person.getLastName() + ".txt";
                FileManager.writeToFile(fileName, person.toString());
                System.out.println("Данные успешно записаны в файл: " + fileName);
                break;
            } catch (InvalidDataFormatException e) {
                System.err.println("Ошибка: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);

        scanner.close();
    }
}