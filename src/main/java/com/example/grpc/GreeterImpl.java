package com.example.grpc;
import io.grpc.stub.StreamObserver;
import com.example.grpc.GreeterGrpc.GreeterImplBase;
import com.example.grpc.HelloReply;


public class GreeterImpl extends GreeterImplBase {
    @Override
    public void sayHello(com.example.grpc.HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String greeting = "Hello, " + name;

        HelloReply reply = HelloReply.newBuilder()
            .setMessage(greeting)
            .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
