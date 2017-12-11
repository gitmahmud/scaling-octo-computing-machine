package util;

public class TimerX {
    static long startTimer;

    public static void start() {
        startTimer = System.currentTimeMillis();
    }

    public static void end(boolean debug) {
        if (debug) {
            System.out.println("\nExecution time " + timeToString(System.currentTimeMillis() - startTimer));
        }
    }

    public static String timeToString(long diff) {
        long sec = (diff / 1000) % 60;
        long min = (diff / 1000) / 60;

        return min + " minutes and " + sec + " seconds";


    }

}
