import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5001);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        out.println(sc.nextLine());

        // receive thread
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (Exception e) {
            }
        }).start();

        // send messages
        while (true) {
            String msg = sc.nextLine();
            out.println(msg);
            if (msg.equalsIgnoreCase("exit"))
                break;
        }

        s.close();
    }
}