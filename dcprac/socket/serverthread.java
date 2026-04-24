import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Waiting...");

        Socket socket = ss.accept();
        System.out.println("Connected!");

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        while (true) {
            String msg = in.nextLine();
            System.out.println("Client: " + msg);

            if (msg.isBlank())
                break;

            System.out.print("Server: ");
            msg = sc.nextLine();
            out.println(msg);

            if (msg.isBlank())
                break;
        }

        socket.close();
        ss.close();
    }
}