import java.io.*;
import java.net.*;

public class WebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8081);
        System.out.println("Server started on port 8081...");

        while (true) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("");
            out.println("<h1>Hello from Jenkins Deployed Server!</h1>");
            client.close();
        }
    }
}
