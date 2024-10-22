package com.example.grpc;

import io.grpc.stub.StreamObserver;
import com.example.grpc.GreeterGrpc.GreeterImplBase;
import com.example.grpc.HelloReply;
import com.example.grpc.HelloRequest;

public class GreeterImpl extends GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("Received request: " + request);

        // Accessing all attributes from the request
        String name = request.getName();
        float price = request.getPrice();  // Directly access the float field
        String description = request.getDescription();
        String image = request.getImage();

        // Creating a greeting message with all fields
        String greeting = "Hello, " + name + "! Price: " + price
                + ", Description: " + description
                + ", Image: " + image;

        // Build the response message with the greeting
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(greeting)
                .build();

        // Send the response back to the client
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
