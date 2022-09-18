package com.example.javafx_login.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

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

    public static String getIsQRScanned() {
        AtomicReference<String> result = new AtomicReference<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ooptwebapi.azurewebsites.net/loginapis/getQrScanned")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(result::set);
        return result.get();
    }

    public static void setIsQRScanned(boolean isQRScanned) {
        String url;
        if(isQRScanned){
            url = "https://ooptwebapi.azurewebsites.net/loginapis/setQrScanned/true";
        }else {
            url = "https://ooptwebapi.azurewebsites.net/loginapis/setQrScanned/false";
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
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
