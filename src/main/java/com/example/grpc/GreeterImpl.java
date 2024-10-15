package com.example.grpc;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String greeting = "Hello, " + name;

        HelloReply reply = HelloReply.newBuilder()
            .setMessage(greeting)
            .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
