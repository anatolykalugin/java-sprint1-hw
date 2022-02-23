import java.util.HashMap;

public class StepTracker {

    HashMap<String, Integer[]> stepTrackerByMonth;
    int stepGoals = 10000;

    StepTracker() {
        stepTrackerByMonth = new HashMap<>();
        Integer[] stepsJan = new Integer[30];
        autoFill(stepsJan);
        stepTrackerByMonth.put("Январь", stepsJan);

        Integer[] stepsFeb = new Integer[30];
        autoFill(stepsFeb);
        stepTrackerByMonth.put("Февраль", stepsFeb);

        Integer[] stepsMar = new Integer[30];
        autoFill(stepsMar);
        stepTrackerByMonth.put("Март", stepsMar);

        Integer[] stepsApr = new Integer[30];
        autoFill(stepsApr);
        stepTrackerByMonth.put("Апрель", stepsApr);

        Integer[] stepsMay = new Integer[30];
        autoFill(stepsMay);
        stepTrackerByMonth.put("Май", stepsMay);

        Integer[] stepsJun = new Integer[30];
        autoFill(stepsJun);
        stepTrackerByMonth.put("Июнь", stepsJun);

        Integer[] stepsJul = new Integer[30];
        autoFill(stepsJul);
        stepTrackerByMonth.put("Июль", stepsJul);

        Integer[] stepsAug = new Integer[30];
        autoFill(stepsAug);
        stepTrackerByMonth.put("Август", stepsAug);

        Integer[] stepsSep = new Integer[30];
        autoFill(stepsSep);
        stepTrackerByMonth.put("Сентябрь", stepsSep);

        Integer[] stepsOct = new Integer[30];
        autoFill(stepsOct);
        stepTrackerByMonth.put("Октябрь", stepsOct);

        Integer[] stepsNov = new Integer[30];
        autoFill(stepsNov);
        stepTrackerByMonth.put("Ноябрь", stepsNov);

        Integer[] stepsDec = new Integer[30];
        autoFill(stepsDec);
        stepTrackerByMonth.put("Декабрь", stepsDec);
    }

    void saveSteps(String month, int day, int steps) {
        if ((stepTrackerByMonth.containsKey(month)) && (day > 0) && (day <= 30) && (steps >= 0)) {
            Integer[] addingMonth = stepTrackerByMonth.get(month);
            addingMonth[day - 1] = steps;
            System.out.println("Шаги сохранены!");
        } else {
            System.out.println("Пожалуйста, проверьте правильность введенных данных и повторите попытку.");
        }
    }

    void showStats(String month) {
        Converter converter = new Converter();
        if (stepTrackerByMonth.containsKey(month)) {
            Integer[] showingMonth = stepTrackerByMonth.get(month);

            showSteps(showingMonth);
            System.out.println("Всего за данный месяц было пройдено " + findSumSteps(showingMonth) + " шагов.");
            System.out.println("В этом месяце в среднем Вы проходили " + findAverageSteps(findSumSteps(showingMonth), showingMonth.length) + " шагов в день.");
            System.out.println("В данном месяце Вы прошагали дистанцию в " + converter.convertStepsToDistance(findSumSteps(showingMonth)) + " километров");
            System.out.println("Также, Вы успели сжечь " + converter.convertStepsToKcal(findSumSteps(showingMonth)) + " килокалорий. Хорошая работа!");
            System.out.println("Ваша лучшая серия составляет " + findMaxStreak(showingMonth) + " дней!");
        }
    }

    void setNewGoals(int newGoals) {
        if (newGoals >= 0) {
            stepGoals = newGoals;
            System.out.println("Новая цель - " + stepGoals);
        } else {
            System.out.println("Введено отрицательное значение. Цель не изменилась.");
        }
    }

    void showSteps(Integer[] month) {
        for (int i = 0; i < (month.length - 1); i++) {
            System.out.print((i + 1) + " день: " + month[i] + ", ");
        }
        System.out.println(month.length + " день: " + month[month.length - 1]);
    }

    int findSumSteps(Integer[] month) {
        int sumSteps = 0;
        for (int i = 0; i < month.length; i++) {
            sumSteps += month[i];
        }
        return sumSteps;
    }

    double findAverageSteps(double steps, double days) {
        double averageSteps = steps / days;
        return averageSteps;
    }

    int findMaxStreak(Integer[] month) {
        int daysStreak = 0;
        int maxStreak = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i] > stepGoals) {
                daysStreak += 1;
            } else {
                if (maxStreak < daysStreak) {
                    maxStreak = daysStreak;
                    daysStreak = 0;
                }
            }
        }
        return maxStreak;
    }

    void autoFill(Integer[] month) {
        for (int i = 0; i < month.length; i++) {
            month[i] = 0;
        }
    }

}
