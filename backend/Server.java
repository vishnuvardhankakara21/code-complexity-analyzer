import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;

public class Server {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        server.createContext("/analyze", new AnalyzeHandler());

        server.start();

        System.out.println("Server running on port 8080");
    }

    static class AnalyzeHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {

            InputStream input = exchange.getRequestBody();
            String code = new String(input.readAllBytes());

            String result = ComplexityAnalyzer.analyze(code);

            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

            exchange.sendResponseHeaders(200, result.length());

            OutputStream os = exchange.getResponseBody();
            os.write(result.getBytes());
            os.close();
        }
    }
}