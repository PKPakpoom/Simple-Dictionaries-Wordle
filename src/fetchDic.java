import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;

import javax.net.ssl.HttpsURLConnection;

public class fetchDic {
	//static String URLBase = "https://od-api.oxforddictionaries.com:443/api/v2/entries/en/";
	static String URLBase = "https://api.dictionaryapi.dev/api/v2/entries/en/";
	
	public static String getDescription(String word) {
		String fullURL = URLBase + word;
        try {
            URL url = new URL(fullURL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            // Oxford Dictionaries API
            /*
            File jsonFile = new File("resources/keys.json");
            FileReader reader = new FileReader(jsonFile);
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject headers = jsonReader.readObject();
            
            // set the headers from the JSONObject
            for (String key : headers.keySet()) {
                String value = headers.getString(key);
                conn.setRequestProperty(key, value);
            }
            */
            
            if (conn.getResponseCode() != 200) {
            	return "HTTP error code : " + conn.getResponseCode();
                //throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
           }
            
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responsetxt = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responsetxt.append(inputLine);
            }
            in.close();
            
            // get Oxford's response
            //JsonObject response = Json.createReader(new StringReader(responsetxt.toString())).readObject();
            
            JsonArray response = Json.createReader(new StringReader(responsetxt.toString())).readArray();
            
            // get Oxford's Dictionaries API description 
            /*
            String description = response.getJsonArray("results")
            		.getJsonObject(0)
            		.getJsonArray("lexicalEntries")
            		.getJsonObject(0)
            		.getJsonArray("entries")
            		.getJsonObject(0)
            		.getJsonArray("senses")
            		.getJsonObject(0)
            		.getJsonArray("definitions")
            		.getJsonString(0)
            		.toString();
            String description = response.toString();
            */
            
            String description = response
        		   .getJsonObject(0)
        		   .getJsonArray("meanings")
        		   .getJsonObject(0)
        		   .getJsonArray("definitions")
        		   .getJsonObject(0)
        		   .getJsonString("definition")
        		   .toString();
            
           return description;
        }
        catch (Exception e) {
            return e.getMessage();
        }
	}
	
	public static boolean isword(String word) {
		String fullURL = URLBase + word;
        try {
            URL url = new URL(fullURL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            
            if (conn.getResponseCode() != 200) {
            	return false;
           }
            
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responsetxt = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responsetxt.append(inputLine);
            }
            in.close();
            
            JsonArray response = Json.createReader(new StringReader(responsetxt.toString())).readArray();

            response
            .getJsonObject(0)
        	.getJsonArray("meanings")
        	.getJsonObject(0)
        	.getJsonArray("definitions")
        	.getJsonObject(0)
        	.getJsonString("definition")
        	.toString();
            
           return true;
        }
        catch (Exception e) {
            return false;
        }
	}
	
}
