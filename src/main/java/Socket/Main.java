package Socket;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Start Player1 in a new JVM process
            Process player1 = new ProcessBuilder("java", "-cp", "C:\\Users\\RaghuRam\\.m2\\repository\\junit\\junit\\3.8.1\\junit-3.8.1.jar", "C:\\Users\\RaghuRam\\eclipse-workspace\\coding-test\\src\\main\\java\\Socket\\Player1.java").start();
            // Start Player2 in a new JVM process
            Process player2 = new ProcessBuilder("java", "-cp", "C:\\Users\\RaghuRam\\.m2\\repository\\junit\\junit\\3.8.1\\junit-3.8.1.jar", "C:\\Users\\RaghuRam\\eclipse-workspace\\coding-test\\src\\main\\java\\Socket\\Player2.java").start();

            player1.waitFor();
            player2.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}