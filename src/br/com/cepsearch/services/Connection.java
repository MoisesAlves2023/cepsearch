package br.com.cepsearch.services;

import br.com.cepsearch.modules.ConvertJson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    public Connection(long cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response;

            // Enviar a requisição e obter a resposta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Exibir a resposta
            String address = response.body();
            System.out.println("Enviando dados");

            // Enviar a resposta pra ser tratada
            try {
                ConvertJson convertJson = new ConvertJson(address);
            } catch (Exception e){
                System.out.println("Deu errado ao escrever");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
