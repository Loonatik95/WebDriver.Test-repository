package getPropertiesOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemProduct {
    public String name;
    public String regularPrice;
    public String campaignPrice;

    

    public ItemProduct getFirstItemProductCampaigns(WebDriver driver) {
        name = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).getText();
        regularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getText();
        campaignPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getText();
        return this;
    }

    public ItemProduct getItemFromDescriptionPage(WebDriver driver) {
        name = driver.findElement(By.cssSelector("h1.title")).getText();
        regularPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getText();
        campaignPrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getText();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemProduct that = (ItemProduct) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (regularPrice != null ? !regularPrice.equals(that.regularPrice) : that.regularPrice != null) return false;
        return campaignPrice != null ? campaignPrice.equals(that.campaignPrice) : that.campaignPrice == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (regularPrice != null ? regularPrice.hashCode() : 0);
        result = 31 * result + (campaignPrice != null ? campaignPrice.hashCode() : 0);
        return result;
    }
}
