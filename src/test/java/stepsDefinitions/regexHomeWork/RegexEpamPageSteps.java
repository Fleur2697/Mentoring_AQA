package stepsDefinitions.regexHomeWork;

import desktop.fragment.epamContactUs.EpamContactUsAddressFragment;
import desktop.pages.EpamContactUsPage;
import driver.Util;
import dto.AddressEpam;
import dto.PricesRows;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegexEpamPageSteps {
    EpamContactUsPage epamContactUsPage = new EpamContactUsPage();
    EpamContactUsAddressFragment epamContactUsAddressFragment = new EpamContactUsAddressFragment();

    @DataTableType
    public AddressEpam defineAddressEpam(Map<String, String> entry) {
        return new AddressEpam(entry.get("country"), entry.get("city"), entry.get("postcode"), entry.get("streetName"), entry.get("streetNumber"));
    }

    @Then("I see address")
    public void iSeeAddress(List<AddressEpam> expectedAddressEpam) {
        AddressEpam expectedAddress = expectedAddressEpam.get(0);
        epamContactUsAddressFragment.getAddress();
        System.out.println(epamContactUsAddressFragment.getAddress());
        String country = epamContactUsAddressFragment.getAddress().split("\\u2022")[2].trim();
        String city = epamContactUsAddressFragment.getAddress().split(",")[1].trim();
        String postcode = Util.getValueByRegEx(epamContactUsAddressFragment.getAddress(), "(\\w+)\\s(\\d+)\\s").trim();
        String streetName = Util.getValueByRegEx(epamContactUsAddressFragment.getAddress(), "(\\d+)([\\w\\s]+)", 2).trim();
        String streetNumber = Util.getValueByRegEx(epamContactUsAddressFragment.getAddress(), "\\d{1,3}").trim();

        assertAll("Address is wrong",
                () -> assertEquals(expectedAddress.city, city, "City is wrong"),
                () -> assertEquals(expectedAddress.country, country, "Country is wrong"),
                () -> assertEquals(expectedAddress.postcode, postcode, "postcode is wrong"),
                () -> assertEquals(expectedAddress.streetName, streetName, "streetName is wrong"),
                () -> assertEquals(expectedAddress.streetNumber, streetNumber, "streetNumber is wrong"));
    }
}
