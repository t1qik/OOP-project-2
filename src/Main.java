

void main() {

    Search search = new Search();
    search.AddSearch();

    SendSearch response = new SendSearch(search.getSearch());

    ParseResponse parsed = new ParseResponse(response.getResponse());
    parsed.OutParsed();

    OpenInBrowser desktop = new OpenInBrowser(parsed.getParsed());
    desktop.GoInBrowser();

    return;
}
