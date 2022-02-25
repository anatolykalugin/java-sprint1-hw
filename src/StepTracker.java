import java.util.HashMap;

public class StepTracker {
    HashMap<String, Integer[]> stepTrackerByMonth;
    int stepGoals = 10000;

    StepTracker() {
        stepTrackerByMonth = new HashMap<>();
        Integer[] stepsJan = new Integer[30];
        autoFill(stepsJan);
        stepTrackerByMonth.put("январь", stepsJan);

        Integer[] stepsFeb = new Integer[30];
        autoFill(stepsFeb);
        stepTrackerByMonth.put("февраль", stepsFeb);

        Integer[] stepsMar = new Integer[30];
        autoFill(stepsMar);
        stepTrackerByMonth.put("март", stepsMar);

        Integer[] stepsApr = new Integer[30];
        autoFill(stepsApr);
        stepTrackerByMonth.put("апрель", stepsApr);

        Integer[] stepsMay = new Integer[30];
        autoFill(stepsMay);
        stepTrackerByMonth.put("май", stepsMay);

        Integer[] stepsJun = new Integer[30];
        autoFill(stepsJun);
        stepTrackerByMonth.put("июнь", stepsJun);

        Integer[] stepsJul = new Integer[30];
        autoFill(stepsJul);
        stepTrackerByMonth.put("июль", stepsJul);

        Integer[] stepsAug = new Integer[30];
        autoFill(stepsAug);
        stepTrackerByMonth.put("август", stepsAug);

        Integer[] stepsSep = new Integer[30];
        autoFill(stepsSep);
        stepTrackerByMonth.put("сентябрь", stepsSep);

        Integer[] stepsOct = new Integer[30];
        autoFill(stepsOct);
        stepTrackerByMonth.put("октябрь", stepsOct);

        Integer[] stepsNov = new Integer[30];
        autoFill(stepsNov);
        stepTrackerByMonth.put("ноябрь", stepsNov);

        Integer[] stepsDec = new Integer[30];
        autoFill(stepsDec);
        stepTrackerByMonth.put("декабрь", stepsDec);
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
        if (stepTrackerByMonth.containsKey(month)) {
            Integer[] showingMonth = stepTrackerByMonth.get(month);

            showSteps(showingMonth);
            System.out.println("Всего за данный месяц было пройдено " + findSumSteps(showingMonth) + " шагов.");
            System.out.println("В этом месяце в среднем Вы проходили " + findAverageSteps(findSumSteps(showingMonth),
                                showingMonth.length) + " шагов в день.");
            System.out.println("В данном месяце Вы прошагали дистанцию в "
                                + Converter.convertStepsToDistance(findSumSteps(showingMonth)) + " километров");
            System.out.println("Также, Вы успели сжечь " + Converter.convertStepsToKcal(findSumSteps(showingMonth))
                                + " килокалорий. Хорошая работа!");
            System.out.println("Ваша лучшая серия составляет " + findMaxStreak(showingMonth) + " дней!");
        } else {
            System.out.println("Пожалуйста, проверьте правильность введенных данных и повторите попытку.");
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
        return steps / days;
    }

    int findMaxStreak(Integer[] month) {
        int daysStreak = 0;
        int maxStreak = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i] >= stepGoals) {
                daysStreak += 1;
                if (i == (month.length - 1)) {
                    if (maxStreak < daysStreak) {
                        maxStreak = daysStreak;
                        daysStreak = 0;
                    }
                }
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
