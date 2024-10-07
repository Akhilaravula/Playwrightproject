package playwrightsessions;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
public class firstprogram {
    public static void main(String[] args)
    {
        Playwright pw= Playwright.create();
        Browser browser=  pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         Page page   = browser.newPage();
         page.navigate("https://www.amazon.com");
         String title = page.title();
         System.out.println(title);
         browser.close();
         pw.close();

    }
}
