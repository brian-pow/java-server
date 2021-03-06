package com.bp.httpServer;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class Main {
    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                // Set up the listener - you can change the port/host here
                // 0.0.0.0 means "listen on ALL available addresses"
                .addHttpListener(8080, "localhost")

                .setHandler(exchange -> {
                    // Sets the return Content-Type to text/html
                    exchange.getResponseHeaders()
                            .put(Headers.CONTENT_TYPE, "text/html");

                    // Returns a hard-coded HTML document
                    exchange.getResponseSender()
                            .send("<html>" +
                                    "<body>" +
                                    "<h1>its time for some pizza</h1>" +
                                    "<h3>More pizza</h3>" +
                                    "</body>" +
                                    "</html>");
                }).build();

        // Boot the web server
        server.start();
    }
}