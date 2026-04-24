import java.util.*;

class Ricart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] ts = new int[n];

        System.out.println("Enter timestamps:");
        for (int i = 0; i < n; i++) {
            ts[i] = sc.nextInt();
        }

        System.out.print("Enter requesting process (0 to " + (n - 1) + "): ");
        int p = sc.nextInt();

        int replies = 0;

        System.out.println("\nP" + p + " requests CS");

        for (int i = 0; i < n; i++) {
            if (i == p)
                continue;

            System.out.println("P" + p + " -> REQUEST -> P" + i);

            if (ts[p] < ts[i] || (ts[p] == ts[i] && p < i)) {
                System.out.println("P" + i + " -> OK -> P" + p);
                replies++;
            } else {
                System.out.println("P" + i + " defers reply");
            }
        }

        if (replies == n - 1)
            System.out.println("\nP" + p + " enters CS");
        else
            System.out.println("\nP" + p + " waits for replies");

        sc.close();
    }
}