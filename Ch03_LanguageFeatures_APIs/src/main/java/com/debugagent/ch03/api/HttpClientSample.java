package com.debugagent.ch03.api;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientSample {
    public static void main(String[] argv) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://debugagent.com/"))
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        System.out.println(new String(response.body()));
    }
}
