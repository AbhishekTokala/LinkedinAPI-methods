
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class App {
    public static void main(String[] args) throws Exception {
        String accessToken = "AQUk4zQb3cwiej2KX7_Q3cd31fW8IilO114rRIADehegJG2i-g_ciK0D85aXiBPJLnJ_8kxTCrthDqIMY29jda5tBW3WuJLXyJPy_QljhCJzyn47zI15AFhX93p148r_g1ISXoLX70qI9HzSK6A0PSJQuypJB1lWZZO9vm-11jTTWI35akEIHdTayduqKJ6zY9dIYMROWWz0-lyHITZSVQYuzpKT4Tc0qp0BuRSsbC7dPbV9K8_Fplh6V2OqhCt6e-4qyApOApcF9DzwfiHfv7ugBYkzgE2r88LdMW6TGngh9vUHzDEp-LRt0eZNz3uWdRBVpGW4ViwYZcnFMu1lwBcEZPAv-g";
        String url ="https://api.linkedin.com/v2/ugcPosts";
        JSONObject json = new JSONObject();
        json.put("author","urn:li:person:Rd072uJMiO");
        json.put("lifecycleState", "PUBLISHED");
        JSONObject specificContent = new JSONObject();
        JSONObject shareContent = new JSONObject();
        JSONObject shareCommentary = new JSONObject();
        shareCommentary.put("text", "Learning more about LinkedIn by reading the LinkedIn Blog!");
        shareContent.put("shareCommentary", shareCommentary);
        shareContent.put("shareMediaCategory", "ARTICLE");
        JSONArray media = new JSONArray();
        JSONObject mediainner = new JSONObject();
        mediainner.put("status", "READY");
        JSONObject des = new JSONObject();
        des.put("text", "Official LinkedIn Blog - Your source for insights and information about LinkedIn.");
        mediainner.put("description", des);
        
        mediainner.put("originalUrl", "https://blog.linkedin.com/");
        JSONObject title = new JSONObject();
        JSONObject titletext = new JSONObject();
        titletext.put("text", "Official LinkedIn Blog");
        mediainner.put("title", titletext);
        media.add(mediainner);
        shareContent.put("media", media);
        specificContent.put("com.linkedin.ugc.ShareContent", shareContent);
        json.put("specificContent", specificContent);
        JSONObject visibility = new JSONObject();
        visibility.put("com.linkedin.ugc.MemberNetworkVisibility", "PUBLIC");
        json.put("visibility", visibility); 
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(json);
        if (response.statusCode() == 201) {
            System.out.println("Article uploaded successfully!");
        } else {
            System.out.println("Error uploading article: " + response.body());
        }
          
    }
}