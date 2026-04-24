import java.util.*;

class Bankers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Processes: ");
        int p = sc.nextInt();

        System.out.print("Resources: ");
        int r = sc.nextInt();

        int allocation[][] = new int[p][r];
        int max[][] = new int[p][r];
        int available[] = new int[r];
        int need[][] = new int[p][r];

        System.out.println("Enter Allocation:");
        for (int i = 0; i < p; i++)
            for (int j = 0; j < r; j++)
                allocation[i][j] = sc.nextInt();

        System.out.println("Enter Max:");
        for (int i = 0; i < p; i++)
            for (int j = 0; j < r; j++)
                max[i][j] = sc.nextInt();

        System.out.println("Enter Available:");
        for (int i = 0; i < r; i++)
            available[i] = sc.nextInt();

        // Need = Max - Allocation
        for (int i = 0; i < p; i++)
            for (int j = 0; j < r; j++)
                need[i][j] = max[i][j] - allocation[i][j];

        boolean finished[] = new boolean[p];
        int safeSeq[] = new int[p];
        int work[] = available.clone();

        int count = 0;

        while (count < p) {
            boolean found = false;

            for (int i = 0; i < p; i++) {
                if (!finished[i]) {

                    int j;
                    for (j = 0; j < r; j++)
                        if (need[i][j] > work[j])
                            break;

                    if (j == r) {
                        for (int k = 0; k < r; k++)
                            work[k] += allocation[i][k];

                        safeSeq[count++] = i;
                        finished[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("Not Safe");
                return;
            }
        }

        System.out.print("Safe Sequence: ");
        for (int i = 0; i < p; i++)
            System.out.print("P" + safeSeq[i] + " ");
    }
}