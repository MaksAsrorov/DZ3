package DZ_8_11_2018;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 04.11.2018.
 */
public class Min10Rubles extends BaseTest {


  @Test
  public void testDeposit() {
    HashMap<String, String> testData = new HashMap<>();
    testData.put("Карта отправителя", "5406 5715 1819 4617");
    testData.put("Карта получателя", "5367433138590699");
    testData.put("Срок действия ММ", "03");
    testData.put("Срок действия ГГ", "21");
    testData.put("СВС", "512");
    testData.put("Сумма", "5");


    WebDriver driver = BaseTest.getDriver();
    driver.get("https://www.raiffeisen.ru/");
    acceptRegion();

    click(driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")));
    click(driver.findElement(By.xpath("//div[@id='menu6'] //a[contains(text(),'Переводы ')]")));

    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    Assert.assertTrue("Перевод с карты на карту/по номеру телефона",
            driver.findElement(By.xpath("//div[@id='menu6'] //a[contains(text(),'Переводы ')]")).isEnabled());

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Номер карты отправителя\"]")),
            testData.get("Карта отправителя"));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Номер карты получателя\"]")),
            testData.get("Карта получателя"));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"ММ\"]")),
            testData.get("Срок действия ММ"));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"ГГ\"]")),
            testData.get("Срок действия ГГ"));


    fillField(driver.findElement(By.xpath("//INPUT[@autocomplete='cc-csc']")),
            testData.get("СВС"));

    fillField(driver.findElement(By.xpath("//input[@placeholder='Сумма перевода, \u20BD']")),
            testData.get("Сумма"));

    Assert.assertTrue("Минимальная сумма перевода – 10 р",
            isElementPresent(By.xpath("//div[contains(text(), 'Минимальная сумма перевода')]")));


  }
}

