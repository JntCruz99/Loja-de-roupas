package com.example.Loja.de.roupas.Service.Impl;

import com.example.Loja.de.roupas.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private RestTemplate restTemplate;

    public String fazerSolicitacaoPost() {
        String apiUrl = "https://sandbox.api.pagseguro.com/checkouts";
        String token = "EF72DA2481434AB3A1B8E66A4EE63C85";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        String requestBody = "{\n" +
                "\t\"reference_id\": \"REFERÊNCIA DO PRODUTO\",\n" +
                "\t\"customer\": {\n" +
                "\t\t\"name\": \"João teste\",\n" +
                "\t\t\"email\": \"joao@teste.com\",\n" +
                "\t\t\"phone\": {\n" +
                "\t\t\t\"country\": \"+55\",\n" +
                "\t\t\t\"area\": \"27\",\n" +
                "\t\t\t\"number\": \"999999999\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"customer_modifiable\": true,\n" +
                "\t\"items\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"reference_id\": \"ITEM01\",\n" +
                "\t\t\t\"name\": \"Nome do Produto\",\n" +
                "\t\t\t\"quantity\": 1,\n" +
                "\t\t\t\"unit_amount\": 500\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"additional_amount\": 0,\n" +
                "\t\"discount_amount\": 0,\n" +
                "\t\"shipping\": {\n" +
                "\t\t\"type\": \"FREE\",\n" +
                "\t\t\"amount\": 0,\n" +
                "\t\t\"service_type\": \"PAC\",\n" +
                "\t\t\"address\": {\n" +
                "\t\t\t\"country\": \"BRA\",\n" +
                "\t\t\t\"region_code\": \"SP\",\n" +
                "\t\t\t\"city\": \"São Paulo\",\n" +
                "\t\t\t\"postal_code\": \"01452002\",\n" +
                "\t\t\t\"street\": \"Faria Lima\",\n" +
                "\t\t\t\"number\": \"1384\",\n" +
                "\t\t\t\"locality\": \"Pinheiros\",\n" +
                "\t\t\t\"complement\": \"5 andar\"\n" +
                "\t\t},\n" +
                "\t\t\"address_modifiable\": true,\n" +
                "\t\t\"box\": {\n" +
                "\t\t\t\"dimensions\": {\n" +
                "\t\t\t\t\"length\": 15,\n" +
                "\t\t\t\t\"width\": 10,\n" +
                "\t\t\t\t\"height\": 14\n" +
                "\t\t\t},\n" +
                "\t\t\t\"weight\": 300\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"payment_methods\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"credit_card\",\n" +
                "\t\t\t\"brands\": [\"mastercard\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"credit_card\",\n" +
                "\t\t\t\"brands\": [\"visa\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"debit_card\",\n" +
                "\t\t\t\"brands\": [\"visa\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"PIX\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"BOLETO\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"payment_methods_configs\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"credit_card\",\n" +
                "\t\t\t\"brands\": [\"mastercard\"],\n" +
                "\t\t\t\"config_options\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"option\": \"installments_limit\",\n" +
                "\t\t\t\t\t\"value\": \"1\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t],\n" +
                "  \"redirect_url\": \"https://pagseguro.uol.com.br\",\n" +
                "\t\"return_url\": \"https://pagseguro.uol.com.br\",\n" +
                "\t\"notification_urls\": [\n" +
                "\t\t\"https://pagseguro.uol.com.br\"\n" +
                "\t]\n" +
                "}";


                    HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
            String responseBody = response.getBody();

            return responseBody;
        }
}
