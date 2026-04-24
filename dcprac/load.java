import java.util.*;

public class load{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of processes: ");
        int p = sc.nextInt();

        int load[] = new int[n];

        for (int i = 0; i < p; i++) {

            int minNode = 0;

            for (int j = 1; j < n; j++) {
                if (load[j] < load[minNode]) {
                    minNode = j;
                }
            }

            load[minNode]++;

            System.out.println("Process " + (i + 1) + " assigned to Node " + minNode);
        }

        System.out.println("\nFinal Load Distribution:");

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " has " + load[i] + " processes");
        }

        sc.close();
    }
}