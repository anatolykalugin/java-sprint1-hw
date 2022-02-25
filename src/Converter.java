public class Converter {

    public static double convertStepsToDistance (int steps) {
        return steps * 0.00075;
    }

    public static double convertStepsToKcal (int steps) {
        return (steps * 50) / 1000;
    }
}
