package SelenideUI;

import Owner.ApiTestPreconditions;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class OwnerTests {
    @Test(description = "Checking Owners page")
    @Story("Checking the URL")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("owners.com")
    public void pageCheck(){
       OwnersPage ownersPage = new OwnersPage();
       ownersPage.openPage()
               .assertUrl(url());
    }

    @Test(description = "Creating a new owner")
    @Story("Creating a new owner")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("owners.com")
    public void addNewOwnerTestWithApi() {
        OwnersPage ownersPage = new OwnersPage();
        ownersPage.openPage();
        ElementsCollection before = ownersPage.ownersList();
        ownersPage.assertUrl(url());
        ApiTestPreconditions apiPrec = new ApiTestPreconditions();
        apiPrec.setUp();
        apiPrec.addOwner();
        ownersPage.openPage();
        refresh();
        ElementsCollection after = ownersPage.ownersList();
        assertThat(before.size()+1).isEqualTo(after.size());
    }
//    @Test(description = "Back button test")
//    @Story("Clicking the back button test")
//    @Severity(SeverityLevel.TRIVIAL)
//    @TmsLink("owners.com")
//    public void backButtonTest() {
//        goToOwnersPage();
//        OwnersPage ownersPage = new OwnersPage(driver);
//        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        assertUrl(driver.getCurrentUrl());
//        newOwnerPage.clickBackButton();
//        assertThat(owners).isEqualTo(driver.getCurrentUrl());
//    }
//    @Test(description = "FirstName field validation")
//    @Story("FirstName field validation")
//    @Severity(SeverityLevel.TRIVIAL)
//    @TmsLink("owners.com")
//    public void firstNameValidationTests() {
//        String firstNameLongValidation = "First name must be at least 2 characters long";
//        String requiredFirst = "First name is required";
//        goToOwnersPage();
//        OwnersPage ownersPage = new OwnersPage(driver);
//        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.setFirstName("w");
//        assertThat(firstNameLongValidation).isEqualTo(newOwnerPage.helpBlock());
//
//        newOwnerPage.clearFName();
//        assertThat(requiredFirst).isEqualTo(newOwnerPage.helpBlock());
//    }
//    @Test(description = "LastName field validation")
//    @Story("LastName field validation")
//    @Severity(SeverityLevel.TRIVIAL)
//    @TmsLink("owners.com")
//    public void lastNameValidationTests() {
//        String lastNamelongValidation = "Last name must be at least 2 characters long";
//        String requiredLast = "Last name is required";
//        goToOwnersPage();
//        OwnersPage ownersPage = new OwnersPage(driver);
//        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.setLastName("p");
//        assertThat(lastNamelongValidation).isEqualTo(newOwnerPage.helpBlock());
//
//        newOwnerPage.clearLastName();
//        assertThat(requiredLast).isEqualTo(newOwnerPage.helpBlock());
//    }
//    @Test(description = "Address field validation")
//    @Story("Address field validation")
//    @Severity(SeverityLevel.TRIVIAL)
//    @TmsLink("owners.com")
//    public void addressValidationTest() {
//        String address = "Address is required";
//        goToOwnersPage();
//        OwnersPage ownersPage = new OwnersPage(driver);
//        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.setAddress("*");
//        newOwnerPage.clearAddress();
//        assertThat(address).isEqualTo(newOwnerPage.helpBlock());
//    }
//    @Test(description = "City field validation")
//    @Story("City field validation")
//    @Severity(SeverityLevel.TRIVIAL)
//    @TmsLink("owners.com")
//    public void cityValidationTest() {
//        String city = "City is required";
//        goToOwnersPage();
//        OwnersPage ownersPage = new OwnersPage(driver);
//        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.setCity("-");
//        newOwnerPage.clearCity();
//        assertThat(city).isEqualTo(newOwnerPage.helpBlock());
//    }
//    @Test(description = "Telephone field validation")
//    @Story("Telephone field validation")
//    @Severity(SeverityLevel.TRIVIAL)
//    @TmsLink("owners.com")
//    public void telephoneTest() {
//        String telephone ="Phone number only accept digits";
//        String telephoneRequired = "Phone number is required";
//        goToOwnersPage();
//        OwnersPage ownersPage = new OwnersPage(driver);
//        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.setTelephone(" ");
//        assertThat(telephone).isEqualTo(newOwnerPage.helpBlock());
//
//        newOwnerPage.clearTelephone();
//        assertThat(telephoneRequired).isEqualTo(newOwnerPage.helpBlock());
//    }
}
