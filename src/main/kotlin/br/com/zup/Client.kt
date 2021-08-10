package br.com.zup

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yasmin")
        .setCpf("111111111-11")
        .setSalario(100000000.0)
        .setIdade(25)
        .setAtivo(true)
        .setCargo(Cargo.GERENTE)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua Avenida")
            .setCep("00000-00")
            .setComplemento("Casa")
            .build()
        )
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)

    println(response)

}