public class Converter {

    public Converter() {
    }

    public static double convertStepsToDistance (int steps) {
        double totalDistance = steps * 0.00075;
        return totalDistance;
    }

    public static double convertStepsToKcal (int steps) {
        double totalKcal = (steps * 50) / 1000;
        return totalKcal;
    }
}
