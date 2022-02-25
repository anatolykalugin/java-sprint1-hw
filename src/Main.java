import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Как Вас зовут?");
        String name = scanner.next();
        System.out.println("Добрый день, " + name + "!");

        StepTracker stepTracker = new StepTracker();

        while (true) {
            getMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Пожалуйста, введите название нужного месяца:");
                String month = scanner.next();
                System.out.println("Пожалуйста, введите нужный день (от 1 до 30):");
                int day = scanner.nextInt();
                System.out.println("Пожалуйста, введите количество шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveSteps(month.toLowerCase(), day, steps);
            } else if (command == 2) {
                System.out.println("Пожалуйста, введите название нужного месяца:");
                String month = scanner.next();
                stepTracker.showStats(month.toLowerCase());
            } else if (command == 3) {
                System.out.println("Текущая цель: " + stepTracker.stepGoals + " шагов в день.");
                System.out.println("Пожалуста, введите новую цель:");
                int newGoals = scanner.nextInt();
                stepTracker.setNewGoals(newGoals);
            } else if (command == 0) {
                System.out.println("Всего доброго, " + name + "!");
                break;
            } else {
                System.out.println("Простите, такой команды нет. Попробуйте снова.");
            }
        }
    }

    static void getMenu() {
        System.out.println("Что Вы хотели бы сделать? Выберите пункт от 0 до 3:");
        System.out.println("Нажмите 1, чтобы ввести количество шагов за любой день");
        System.out.println("Нажмите 2, чтобы узнать статистику по шагам за любой месяц");
        System.out.println("Нажмите 3, чтобы изменить цель по шагам в день");
        System.out.println("Нажмите 0, чтобы выйти из программы");
    }
}

