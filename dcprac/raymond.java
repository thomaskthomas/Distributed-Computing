class Raymond {

    static int holder[] = { 1, 1, 2, 2 };
    static boolean hasToken[] = { true, false, false, false };

    static void requestCS(int p) {

        int original = p;
        System.out.println("Process " + p + " requests Critical Section");

        // Walk up the tree to find the token holder
        while (!hasToken[p - 1]) {
            int parent = holder[p - 1];
            System.out.println("Request sent from P" + p + " to P" + parent);
            p = parent;
        }

        // p now holds the token; transfer it to original
        hasToken[p - 1] = false;
        hasToken[original - 1] = true;

        // Update holder pointers: the old token holder now points toward original
        if (p != original) {
            holder[p - 1] = original;
        }

        System.out.println("Token transferred to Process " + original);
        System.out.println("Process " + original + " enters Critical Section\n");
    }

    public static void main(String[] args) {

        System.out.println("Initial Token Holder: Process 1\n");

        requestCS(3);
        requestCS(4);
    }
}

/*
 * import java.util.*;
 * 
 * class Raymond {
 * 
 * static int holder[];
 * static boolean hasToken[];
 * 
 * static void requestCS(int p) {
 * 
 * int original = p;
 * System.out.println("\nProcess " + p + " requests Critical Section");
 * 
 * // move up tree to find token
 * while (!hasToken[p - 1]) {
 * int parent = holder[p - 1];
 * System.out.println("Request sent from P" + p + " to P" + parent);
 * p = parent;
 * }
 * 
 * // transfer token
 * hasToken[p - 1] = false;
 * hasToken[original - 1] = true;
 * 
 * if (p != original)
 * holder[p - 1] = original;
 * 
 * System.out.println("Token transferred to Process " + original);
 * System.out.println("Process " + original + " enters Critical Section");
 * }
 * 
 * public static void main(String[] args) {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.print("Enter number of processes: ");
 * int n = sc.nextInt();
 * 
 * holder = new int[n];
 * hasToken = new boolean[n];
 * 
 * System.out.println("Enter holder (parent) of each process:");
 * for (int i = 0; i < n; i++)
 * holder[i] = sc.nextInt();
 * 
 * System.out.print("Enter initial token holder: ");
 * int t = sc.nextInt();
 * hasToken[t - 1] = true;
 * 
 * System.out.print("Enter number of requests: ");
 * int r = sc.nextInt();
 * 
 * for (int i = 0; i < r; i++) {
 * System.out.print("Enter process requesting CS: ");
 * int p = sc.nextInt();
 * requestCS(p);
 * }
 * 
 * sc.close();
 * }
 * }
 */