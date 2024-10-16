package com.example.grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.grpc.GreeterGrpc;
import com.example.grpc.GreeterGrpc.*;
import com.example.grpc.HelloReply;
import com.example.grpc.HelloRequest;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloReply response = stub.sayHello(HelloRequest.newBuilder()
                .setName("World")
                .build());

        System.out.println(response.getMessage());

        channel.shutdown();
    }
}
