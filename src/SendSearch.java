import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SendSearch {
    private String search;
    private String response;
    SendSearch(String search){
        this.search = "https://ru.wikipedia.org/w/api.php?action=query&list=search&srsearch=" + search
                + "&format=json"
                + "&formatversion=2"
                + "&srlimit=5";
        try {
            // 2. Создаем HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // 3. Строим запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.search))
                    // Устанавливаем User-Agent (обязательно для Википедии)
                    .header("User-Agent", "MyWikiBot/1.0 (dmitrijfrolkin470@gmail.com)")
                    .GET() // Указываем метод GET
                    .build();

            // 4. Отправляем синхронный запрос и получаем ответ как String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.response = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getSearch(){
        return search;
    }
    String getResponse(){
        return response;
    }

}
