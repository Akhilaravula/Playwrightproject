package playwrightsessions;


import com.microsoft.playwright.*;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=Ab5oB3rsuC-N5UnspIygZmj6iK76usm4bmSDI4ySc33g3gTnCvxwEiA1CseC-QM1UjHZ5800tJGF_g&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-315273815%3A1725297920968416&ddm=0");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        }
    }
}

