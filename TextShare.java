import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
class TextShare{
    public static void main(String[] args) throws Exception{
        String accessToken = "AQUk4zQb3cwiej2KX7_Q3cd31fW8IilO114rRIADehegJG2i-g_ciK0D85aXiBPJLnJ_8kxTCrthDqIMY29jda5tBW3WuJLXyJPy_QljhCJzyn47zI15AFhX93p148r_g1ISXoLX70qI9HzSK6A0PSJQuypJB1lWZZO9vm-11jTTWI35akEIHdTayduqKJ6zY9dIYMROWWz0-lyHITZSVQYuzpKT4Tc0qp0BuRSsbC7dPbV9K8_Fplh6V2OqhCt6e-4qyApOApcF9DzwfiHfv7ugBYkzgE2r88LdMW6TGngh9vUHzDEp-LRt0eZNz3uWdRBVpGW4ViwYZcnFMu1lwBcEZPAv-g";
        String message = "Hello, world!";
        URL url = new URL("https://api.linkedin.com/v2/ugcPosts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);
        connection.setRequestProperty("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("author", "urn:li:person:Rd072uJMiO");
        json.put("lifecycleState", "PUBLISHED");
        JSONObject specificContent = new JSONObject();
        JSONObject shareContent = new JSONObject();
        JSONObject shareCommentary = new JSONObject();
        shareCommentary.put("text", "Testing Linkedin API");
        shareContent.put("shareCommentary", shareCommentary);
        specificContent.put("com.linkedin.ugc.ShareContent", shareContent);
        shareContent.put("shareMediaCategory", "NONE");
        json.put("specificContent", specificContent);
        JSONObject visibility = new JSONObject();
        visibility.put("com.linkedin.ugc.MemberNetworkVisibility", "PUBLIC");
        json.put("visibility", visibility);
        System.out.println(json);
        OutputStream os = connection.getOutputStream();
        os.write(json.toString().getBytes());
        os.flush();
        int responseCode = connection.getResponseCode();
        if (responseCode == 201) {
            System.out.println("Post created successfully");
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}