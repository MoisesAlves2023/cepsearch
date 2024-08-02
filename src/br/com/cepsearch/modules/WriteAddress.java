package br.com.cepsearch.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAddress {

    public WriteAddress(Address address) {
        try (FileWriter fileWriter = new FileWriter("endereco.txt")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(address);
            fileWriter.write(json);
            System.out.println("Escrita em endereco.txt finalizada.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}
