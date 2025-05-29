import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PruebaAPI {
    public static void main(String[] args) {
        try {
            // URL de la API a la que deseas conectarte
            String url = "https://jsonplaceholder.typicode.com/posts/1";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Método de la petición (GET, POST, etc.)
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprime la respuesta de la API
            System.out.println("Respuesta de la API: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}