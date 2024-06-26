package de.telekom.simple.ta.pages.offer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import de.telekom.simple.ta.base.SimpleBasicPage;
import de.telekom.simple.ta.pages.onka.LeistungenTabPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OfferDashboardPage extends SimpleBasicPage {

    Page page;
    private final Locator angebotTab;
    private final Locator workflowTab;
    private final Locator einstellungenButton;
    private final Locator leistungenTab;

    public OfferDashboardPage(Page page) {
        super(page);
        this.page = page;
        this.angebotTab = page.locator("//li/a/span[.='Angebot']");
        this.workflowTab = page.locator("//li/a/span[.='Workflow']");
        this.einstellungenButton = page.locator("//div[@id='workflowButtonDropdown']");
        this.leistungenTab = page.locator("//li/a/span[.='Leistungen']");

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Offer Dashboard"))).isVisible();
    }

    public OfferDashboardAngebotPage openAngebotTab() {
        angebotTab.click();
        return new OfferDashboardAngebotPage(page);
    }

    public OfferDashboardWorkflowPage openWorkflowTab() {
        workflowTab.click();
        return new OfferDashboardWorkflowPage(page);
    }

    public LeistungenTabPage openLeistungenTab() {
        leistungenTab.click();
        return new LeistungenTabPage(page);
    }

}
