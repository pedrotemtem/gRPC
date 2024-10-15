package com.example.grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreeterImpl())
                .build();

        System.out.println("Server started, listening on 8080");
        server.start();
        server.awaitTermination();
    }
}