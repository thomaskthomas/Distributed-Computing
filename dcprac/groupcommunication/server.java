import java.net.*;
import java.io.*;
import java.util.*;

public class server {

    static Vector<Socket> clients = new Vector<>();

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5001);
        System.out.println("Server running...");

        while (true) {
            Socket s = ss.accept();
            clients.add(s);

            new Thread(() -> handle(s)).start();
        }
    }

    static void handle(Socket s) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String name = in.readLine();
            broadcast(name + " joined");

            String msg;
            while ((msg = in.readLine()) != null) {
                if (msg.equalsIgnoreCase("exit"))
                    break;
                broadcast(name + ": " + msg);
            }

            broadcast(name + " left");
            clients.remove(s);
            s.close();

        } catch (Exception e) {
        }
    }

    static void broadcast(String msg) {
        for (Socket c : clients) {
            try {
                PrintWriter out = new PrintWriter(c.getOutputStream(), true);
                out.println(msg);
            } catch (Exception e) {
            }
        }
    }
}