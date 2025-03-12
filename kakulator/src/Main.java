import java.util.Scanner;

class Main {

    // Метод для выполнения арифметических операций
    static String calc(String input) throws Exception {
        // Разделяем строку на части (число, оператор, число)
        String[] parts = input.split(" ");

        // Проверяем, что ввод состоит ровно из 3 элементов
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода");
        }

        // Преобразуем строки в числа
        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);

        // Проверяем, что числа в пределах 1-10
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        // Выполнение операции
        int result = 0;
        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("-")) {
            result = a - b;
        } else if (operator.equals("*")) {
            result = a * b;
        } else if (operator.equals("/")) {
            if (b == 0) {
                throw new Exception("Деление на ноль невозможно");
            }
            result = a / b;  // Отбрасываем остаток
        } else {
            throw new Exception("Неизвестная операция");
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        // Сканер для ввода с консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 3 + 4):");

        // Чтение строки
        String input = scanner.nextLine();

        try {
            // Вызов метода calc и вывод результата
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            // В случае ошибки выводим исключение
            System.out.println("throws Exception //" + e.getMessage());
        }

        scanner.close();
    }
}
