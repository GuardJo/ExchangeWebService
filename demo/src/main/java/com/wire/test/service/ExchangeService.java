package com.wire.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Map;

@Service
public class ExchangeService {
    public double getExchangeValue(String countryName) {
        double exchangeValue = 0.0;
        switch (countryName) {
            case "한국(KRW)":
                exchangeValue = toKRW();
                break;
            case "일본(JPY)":
                exchangeValue = toJPY();
                break;
            case "필리핀(PHP)":
                exchangeValue = toPHP();
                break;
        }

        return exchangeValue;
    }

    private double reponseExchangeAPI(String country) {
        try {
            URL url = new URL("http://api.currencylayer.com/live?access_key=e2276d344968441f56c1d0d6cdf38d8e&currencies=" + country);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                Map<String, Object> map = parsing(line);
                String reponse = map.get("quotes").toString().split("=")[1].replaceAll("}", "");
                return Double.parseDouble(reponse);
            }

            connection.disconnect();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    private double toKRW() {
        return reponseExchangeAPI("KRW");
    }

    private double toJPY() {
        return reponseExchangeAPI("JPY");
    }

    private double toPHP() {
        return reponseExchangeAPI("PHP");
    }

    private Map<String, Object> parsing(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
    }

    public String calculateResult(double exchangeValue, double remittanceAmount, String country) {
        double result = exchangeValue * remittanceAmount;

        System.out.println(result);
        return result + "";
    }

    public String transformMoneyType(String country) {
        return country.substring(country.indexOf("(") + 1, country.indexOf(")"));
    }
}
