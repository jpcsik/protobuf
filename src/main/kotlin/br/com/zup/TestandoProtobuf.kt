package br.com.zup

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    //Criando Objeto
    val request = FuncionarioRequest.newBuilder()
        .setNome("Yasmin")
        .setCpf("111111111-11")
        .setSalario(100000000.0)
        .setAtivo(true)
        .setCargo(Cargo.GERENTE)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua Avenida")
            .setCep("00000-00")
            .setComplemento("Casa")
            .build()
        )
        .build()

    print(request)

    //Escrevendo Objeto
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    //Lendo Objeto
    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.CEO)
    print(request2)

}