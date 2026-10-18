import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ParseResponse {

    private WikiSearchResponse parsed;

    ParseResponse(String response){
        Gson gson = new Gson();
        this.parsed = gson.fromJson(response, WikiSearchResponse.class);
    }

    WikiSearchResponse getParsed(){
        return parsed;
    }

    public class WikiSearchResponse {
        private boolean batchcomplete;
        private Query query;

        public Query getQuery() { return query; }

        public static class Query {
            private SearchInfo searchinfo;
            private List<SearchResult> search;

            public SearchInfo getSearchinfo() { return searchinfo; }
            public List<SearchResult> getSearch() { return search; }
        }

        public static class SearchInfo {
            private int totalhits;
            public int getTotalhits() { return totalhits; }
        }

        public static class SearchResult {
            private int ns;
            private String title;
            private int pageid;
            private String snippet;

            public String getTitle() { return title; }
            public int getPageid() { return pageid; }
            public String getSnippet() { return snippet; }
        }
    }

    void OutParsed() {
        System.out.println("Всего найдено: " + parsed.getQuery().getSearchinfo().getTotalhits());
        int i = 1;
        for (WikiSearchResponse.SearchResult r : parsed.getQuery().getSearch()) {
            System.out.println(i + ")" + r.getTitle() + " (pageid=" + r.getPageid() + ")");
            i++;
        }
    }
}
