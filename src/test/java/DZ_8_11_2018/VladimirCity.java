package DZ_8_11_2018;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 04.11.2018.
 */
public class VladimirCity extends BaseTest {


  @Test
  public void testDeposit() throws InterruptedException {


    WebDriver driver = BaseTest.getDriver();
    driver.get("https://www.raiffeisen.ru/");
    click(driver.findElement(By.xpath("//a[@class='sec-menu__link sm-i region-active']")));
    click(driver.findElement(By.xpath("//a[contains(text(),'Владимир')]")));
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    Assert.assertTrue("Владимир",
            driver.findElement(By.xpath("//a[@class='sec-menu__link sm-i region-active']")).isEnabled());
    scroll(BaseTest.getDriver().findElement((By.xpath("//li//a[contains(text(),'Качество обслуживания')]"))));

    Assert.assertTrue("Качество обслуживания",
            driver.findElement(By.xpath("//li//a[contains(text(),'Качество обслуживания')]")).isEnabled());

    Assert.assertTrue("Карьера в банке",
            driver.findElement(By.xpath("//li//a[contains(text(),'Карьера в банке')]")).isEnabled());

    Assert.assertTrue("Реквизиты",
            driver.findElement(By.xpath("//li//a[contains(text(),'Реквизиты')]")).isEnabled());

    Assert.assertTrue("Противодействие коррупции",
            driver.findElement(By.xpath("//li//a[contains(text(),'Противодействие коррупции')]")).isEnabled());



  }





}

//	Перейти по ссылке - https://www.raiffeisen.ru/
//				2. Нажать кнопку – Выбор региона
//				3. Выбрать – Владимир
//				4. Проверить, что на главной странице регион Москва сменилась на Владимир
//				5. Поскроллить к концу страницы
//				6. Проверить, что в конце страницы есть ссылки – Качество обслуживания, Карьера в банке, Реквизиты, Противодействие коррупции