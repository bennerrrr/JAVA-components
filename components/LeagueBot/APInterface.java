package components.LeagueBot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

//import org.json.JSONObject;

//key:
//RGAPI-81450b37-a59d-4bb2-b37b-ef0e0e915272

//link for uuid:
//https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/banjoe/42069
public class APInterface {
    
    private static final String API_URL_PUUID = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";

    String username;
    String tag;
    String puuid;
    String region = "Americas";
    String apiKey;


    public APInterface(String username, String tag, String region, String apiKey) {
        this.username = username;
        this.tag = tag;
        this.region = region;
        this.apiKey = apiKey;
    }

    public String getPuuid() {

        String url = this.API_URL_PUUID + this.username + "/" + this.tag + "?api_key=" + this.apiKey;

        try {
            URL obj = URI.create(url).toURL();
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                //JSONObject myResponse = new JSONObject(response.toString());
                //puuid = myResponse.getString("puuid");
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
        return puuid;
    }

    

}
