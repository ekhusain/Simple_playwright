package de.telekom.simple.ta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import de.telekom.simple.ta.pages.offer.OfferDashboardPage;
import de.telekom.simple.ta.pages.sales.SalesDashboardStammdatenPage;

public class SimpleAlertPage {
    Page page;
    Locator confirmButton;

    public SimpleAlertPage(Page page) {
        this.page = page;
        confirmButton = page.locator("//button[@class='btn btn-primary' and .='Bestätigen']");
    }

    public OfferDashboardPage doConfirmAction() {
        confirmButton.click();
        return new OfferDashboardPage(page);
    }

    public SalesDashboardStammdatenPage doBestaetigen() {
        page.locator("//button[contains(., 'Bestätigen')]").click();
        return new SalesDashboardStammdatenPage(page);
    }

}
