package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {
    @FXML
    private TextField city;
    @FXML
    private Button getData;
    @FXML
    private Text pressure;
    @FXML
    private Text temp_feels;
    @FXML
    private Text temp_info;
    @FXML
    private Text temp_max;
    @FXML
    private Text temp_min;
    @FXML
    void initialize() {
        getData.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if (!getUserCity.isEmpty()) {
                String apiKey = "017ba7f119b3e9c12c5cb2735d160a2d";
                String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=" + apiKey;

                String output = getUrlContent(apiUrl);
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output).getJSONObject("main");
                    temp_info.setText("Температура: " + (obj.getInt("temp")-273)+" °С");
                    temp_feels.setText("Ощущается: " + (obj.getInt("feels_like")-273)+" °С");
                    temp_max.setText("Максимум: " + (obj.getInt("temp_max")-273)+" °С");
                    temp_min.setText("Минимум: " + (obj.getInt("temp_min")-273)+" °С");
                    pressure.setText("Давление: " + obj.getInt("pressure")+" hpa");
                }
            }
        });
    }

    private static String getUrlContent(String urlAddress) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                reader.close();
            } else {
                System.out.println("Такой город не найден");
            }

            connection.disconnect();
        } catch (IOException e) {
            System.err.println("Произошла ошибка при получении данных с URL-адреса: " + e.getMessage());
        }

        return content.toString();
    }
}