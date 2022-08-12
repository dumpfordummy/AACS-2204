package com.example.javafx_login;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginApi {
    static String apiUrl = "https://ooptwebapi.azurewebsites.net/loginapis";
    static ArrayList<String> username;
    static ArrayList<String> password;

    static {
        username = new ArrayList<>();
        password = new ArrayList<>();
    }

    public static boolean IsLoginExist(String username, String password) {
        getRequest();
        return LoginApi.username.contains(username) && LoginApi.password.contains(password);
    }

    public static void getRequest() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(LoginApi::parse)
                .join();
    }

    public static void parse(String responseBody) {
        JSONArray logins = new JSONArray(responseBody);
        for(int i = 0; i < logins.length(); i++) {
            JSONObject login = logins.getJSONObject(i);
            username.add(login.getString("username"));
            password.add(login.getString("password"));
        }
    }

    public static HttpResponse<Void> postSignupRequest(String username, String password) throws IOException, InterruptedException {
        String data = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();
       return client.send(request, HttpResponse.BodyHandlers.discarding());
    }
}
