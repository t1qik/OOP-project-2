import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class Search {

    private final Scanner scanner = new Scanner(System.in);
    private String search;

    String getSearch(){
        return search;
    }

    void AddSearch(){
        System.out.println("Здравствуйте, введите свой поисковой запрос:");
        while (true) {
            search = scanner.nextLine();
            if(search == null || search.isEmpty() || search.isBlank()){
                System.out.println("Неверный ввод, попробуйте еще раз:");
            }
            else break;
        }
        try {
            String encodedSearch = URLEncoder.encode(search, "UTF-8");
            search = encodedSearch;
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
