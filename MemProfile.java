import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class MemProfile {
    public static void main (String[] args)  throws IOException 
    {
        URL url = new URL("https://api.linkedin.com/v2/me");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestProperty("Authorization", "Bearer AQUk4zQb3cwiej2KX7_Q3cd31fW8IilO114rRIADehegJG2i-g_ciK0D85aXiBPJLnJ_8kxTCrthDqIMY29jda5tBW3WuJLXyJPy_QljhCJzyn47zI15AFhX93p148r_g1ISXoLX70qI9HzSK6A0PSJQuypJB1lWZZO9vm-11jTTWI35akEIHdTayduqKJ6zY9dIYMROWWz0-lyHITZSVQYuzpKT4Tc0qp0BuRSsbC7dPbV9K8_Fplh6V2OqhCt6e-4qyApOApcF9DzwfiHfv7ugBYkzgE2r88LdMW6TGngh9vUHzDEp-LRt0eZNz3uWdRBVpGW4ViwYZcnFMu1lwBcEZPAv-g");

        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("Response code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());                        
    }       
}
