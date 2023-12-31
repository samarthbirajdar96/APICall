package org.example;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
        public class Main {
            public static void main(String[] args) throws IOException {
                URL url = null;
                HttpURLConnection connection = null;
                int responseCode = 0;
                String urlstring = "https://api.nationalize.io/?name=nathaniel";
                try {
                    url = new URL(urlstring);

                } catch (MalformedURLException e) {
                    System.out.println("problem in url");
                    return;
                }

                //connection
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    responseCode = connection.getResponseCode();
                } catch (IOException e) {
                    System.out.println("connection problem");
                    return;
                }

                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder apiData = new StringBuilder();
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        apiData.append(line);
                    }

                    try {
                        in.close();
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }

                    JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
                        }
                    else{
                            System.out.println("API not made");
                                    
            }
        }
