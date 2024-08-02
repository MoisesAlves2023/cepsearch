package br.com.cepsearch.modules;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ConvertJson {

    public ConvertJson(String json) {
        Gson gson = new Gson();

        try {
            Address address = gson.fromJson(json, Address.class);

            if (address.getLogradouro() != null && !address.getLogradouro().isEmpty() &&
                    address.getBairro() != null && !address.getBairro().isEmpty()) {

                address.setContainAddress(true);
                System.out.println("Endereço encontrado: " + address);
            } else {
                System.out.println("O CEP informado não contém informações completas.");
            }


            WriteAddress writeAddress = new WriteAddress(address);
        } catch (JsonSyntaxException e) {
            System.out.println("Erro ao converter o JSON: " + e.getMessage());
        }
    }
}
