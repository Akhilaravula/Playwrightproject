package playwrightsessions;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
import java.nio.file.Paths;

public class FirstTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
            Page page = context.newPage();
            page.navigate("https://www.globalsqa.com/demo-site/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tabs")).click();
            page.frameLocator(".demo-frame >> nth=0").getByText("Mauris mauris ante, blandit").click();
            page.frameLocator(".demo-frame >> nth=0").getByRole(AriaRole.TAB, new FrameLocator.GetByRoleOptions().setName("Section 2")).click();
            page.frameLocator(".demo-frame >> nth=0").getByRole(AriaRole.TAB, new FrameLocator.GetByRoleOptions().setName("Section 3")).click();
            page.frameLocator(".demo-frame >> nth=0").getByRole(AriaRole.TAB, new FrameLocator.GetByRoleOptions().setName("Section 4")).click();
            page.locator(".close_img").first().click();
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        }
    }
}