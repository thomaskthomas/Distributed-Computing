import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Client: ");
            String msg = sc.nextLine();
            out.println(msg);

            if (msg.isBlank())
                break;

            msg = in.nextLine();
            System.out.println("Server: " + msg);

            if (msg.isBlank())
                break;
        }

        socket.close();
    }
}