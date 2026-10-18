import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class OpenInBrowser {

    private final Scanner scanner = new Scanner(System.in);

    ParseResponse.WikiSearchResponse parsed;

    OpenInBrowser(ParseResponse.WikiSearchResponse parsed){
        this.parsed = parsed;
    }

    void GoInBrowser(){
        System.out.println("Выберите страницу, которую хотите открыть:");
        int numb;
        while (true){
            numb = scanner.nextInt();
            if(numb <=0 || numb >5){
                System.out.println("Неверный ввод, попробуйте еще раз.");
            }
            else break;
        }
        int id = parsed.getQuery().getSearch().get(numb - 1).getPageid();
        String url = "https://ru.wikipedia.org/?curid=" + id;

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            // Проверяем, поддерживается ли именно открытие ссылок
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(url));
                } catch (Exception e) {
                    System.out.println("Не удалось открыть браузер: " + e.getMessage());
                }
            } else {
                System.out.println("Открытие браузера не поддерживается на этой системе.");
            }
        } else {
            System.out.println("Класс Desktop не поддерживается.");
        }
    }
}
