package com.example.shop.services;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class CurentyService {

    public double getUsdPrice(int bynPrice) {
        try {
            URL url = new URL("https://api.nbrb.by/exrates/rates/431");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String courseUsd = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(courseUsd);
            double usd = Double.parseDouble(jsonObject.getString("Cur_OfficialRate"));
            return Math.round(bynPrice / usd);
        } catch (Exception e) {
            System.out.println("Mistake 1");
            return 0;
        }
    }

    public double getEurPrice(int bynPrice) {
        try {
            URL url = new URL("https://api.nbrb.by/exrates/rates/451");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String courseUsd = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(courseUsd);
            double eur = Double.parseDouble(jsonObject.getString("Cur_OfficialRate"));
            return Math.round(bynPrice / eur);
        } catch (Exception e) {
            System.out.println("Mistake 1");
        }
        return 0;
    }
}
