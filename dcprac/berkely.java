import java.util.*;

class Berkeley {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Master time (h m s):");
        int mh = sc.nextInt(), mm = sc.nextInt(), ms = sc.nextInt();

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        int h[] = new int[n], m[] = new int[n], s[] = new int[n];
        double diff[] = new double[n];

        // Convert master time to seconds
        int masterTime = mh * 3600 + mm * 60 + ms;

        double sum = 0;

        System.out.println("Enter node times:");
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            m[i] = sc.nextInt();
            s[i] = sc.nextInt();

            int nodeTime = h[i] * 3600 + m[i] * 60 + s[i];

            diff[i] = nodeTime - masterTime; // difference
            sum += diff[i];
        }

        // Include master (diff = 0)
        double avg = sum / (n + 1);

        // Adjust master
        int newMaster = masterTime + (int) Math.round(avg);

        System.out.println("\nSynchronized Times:");
        System.out.println("Master: " + format(newMaster));

        // Adjust nodes
        for (int i = 0; i < n; i++) {
            int nodeTime = h[i] * 3600 + m[i] * 60 + s[i];

            int newTime = nodeTime - (int) Math.round(diff[i] - avg);

            System.out.println("Node " + (i + 1) + ": " + format(newTime));
        }

        sc.close();
    }

    // Convert seconds → HH:MM:SS
    static String format(int t) {
        t = (t + 86400) % 86400;
        int h = t / 3600;
        int m = (t % 3600) / 60;
        int s = t % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}