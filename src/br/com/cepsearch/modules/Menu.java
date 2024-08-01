package br.com.cepsearch.modules;

import br.com.cepsearch.services.Connection;

import java.util.Scanner;

public class Menu {
    private String message =
            """
            *******************************
            
             Bem vindo ao buscador de cep
            
            *******************************
            """;

    public String getMessage() {
        return message;
    }

    public Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getMessage());
        long responseUser;

        while (true) {
            System.out.println("Insira o cep para receber informações (ou digite 'sair' para encerrar): ");

            if (scanner.hasNextLong()) {
                responseUser = scanner.nextLong();
                Connection connection = new Connection(responseUser);
                break;
            } else if (scanner.hasNext("sair")) {
                System.out.println("Encerrando o programa.");
                break;
            } else {
                System.out.println("Por favor, insira um número válido para o CEP.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        scanner.close(); // Fecha o Scanner quando terminar
    }
}
