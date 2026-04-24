import java.util.Scanner;

public class bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];

        // Initialize all processes as active
        for (int i = 0; i < n; i++) {
            process[i] = 1;
        }

        // Take crashed process input
        System.out.print("Enter process ID that crashed: ");
        int crashed = sc.nextInt();
        process[crashed] = 0;

        System.out.println("Process " + crashed + " has crashed");

        // Take initiator input
        System.out.print("Enter process ID that starts election: ");
        int initiator = sc.nextInt();

        System.out.println("\nElection started by process " + initiator);

        int coordinator = initiator;

        // Election process
        for (int i = initiator + 1; i < n; i++) {
            if (process[i] == 1) {
                System.out.println("Election message sent from " + initiator + " to " + i);
                System.out.println("OK message from " + i);

                System.out.println("New election started by process " + i);
                coordinator = i;
            }
        }

        // Final coordinator
        System.out.println("\nFinal Coordinator is Process " + coordinator);

        // Coordinator informs all
        for (int i = 0; i < n; i++) {
            if (process[i] == 1 && i != coordinator) {
                System.out.println("Message to " + i + ": Coordinator is " + coordinator);
            }
        }

        sc.close();
    }
}