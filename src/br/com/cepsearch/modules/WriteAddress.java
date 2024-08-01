package br.com.cepsearch.modules;
import java.io.FileWriter;

public class WriteAddress {

    public WriteAddress(String address) {
        try {
        FileWriter fileWriter = new FileWriter("endereco.txt");
        fileWriter.write(address);
        fileWriter.close();
            System.out.println("Escrita txt finalizadas.. Encerrando o programa");
        } catch ( java.io.IOException e){
            System.out.println("Deu erro");
            System.out.println(e.getMessage());
        }

    }
}
