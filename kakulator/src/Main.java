import java.util.Scanner;

class Main {


    static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода");
        }

        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

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
            result = a / b;
        } else {
            throw new Exception("Неизвестная операция");
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 3 + 4):");


        String input = scanner.nextLine();

        try {

            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {

            System.out.println("throws Exception //" + e.getMessage());
        }

        scanner.close();
    }
}
