import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        List<String> basket = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            List<String> menu = new ArrayList<>();
            menu.add("1. Добавить");
            menu.add("2. Показать");
            menu.add("3. Удалить");

            System.out.println("Пожалуйста выберите операцию: " + "\n" + menu);
            String input = scanner.nextLine();
            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String in = scanner.nextLine();
                    basket.add(in);
                    count++;
                    System.out.println("Итого в списке покупок: " + count);
                    break;
                case 2:
                    printBasket(basket);
                    break;
                case 3:
                    printBasket(basket);
                    System.out.println("Какую хотите удалить? Введите номер или название: ");
                    String delete = scanner.nextLine();
//if (scanner.hasNextInt()) { //хотел сделать сначала через него но тогда приходится вводить данные два раза не придумал как иначе убрать двойной ввод
                    if (delete.matches("\\d")) {
                        int operationDelete = Integer.parseInt(delete);
                        System.out.printf("Покупка %s удалена ", basket.get(operationDelete - 1));
                        System.out.println();
                        basket.remove(operationDelete - 1);
                    } else {
                        System.out.println("Покупка " + delete + " удалена");
                        basket.remove(delete);
                    }
                    printBasket(basket);
                    break;

                default:
                    System.out.println("Такой команды нет" + "\n");

                    break;
            }
        }

    }
    private static void printBasket(List<String> basket) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < basket.size(); i++) {
            System.out.println((i + 1) + ". " + basket.get(i));
        }
    }
}