import java.util.*;

public class distributedglobalaverage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        double[] values = new double[n];

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextDouble();
        }

        System.out.print("Enter number of rounds: ");
        int rounds = sc.nextInt();

        for (int round = 1; round <= rounds; round++) {

            double[] newValues = new double[n];

            for (int i = 0; i < n; i++) {
                double left = values[(i - 1 + n) % n];
                double right = values[(i + 1) % n];

                newValues[i] = (values[i] + left + right) / 3;
            }

            values = newValues;

            System.out.print("Round " + round + ": ");
            for (double v : values) {
                System.out.printf("%.2f ", v);
            }
            System.out.println();
        }

        sc.close();
    }
}