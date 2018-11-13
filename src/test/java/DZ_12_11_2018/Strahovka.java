package DZ_12_11_2018;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * Created by Maria on 04.11.2018.
 */
public class Strahovka extends BaseTest {


  @Test
  public void testDeposit() {
    HashMap<String, String> testData = new HashMap<>();
    testData.put("Ф", "Смешариков");
    testData.put("И", "Медвед");
    testData.put("О", "Копатыч");
    testData.put("ДР", "21.12.1992");
    testData.put("Тел", "9199621876");
    testData.put("Почта", "hahariky-smeshariky@yandex.ru");
    testData.put("Код", "52k6w");


    WebDriver driver = BaseTest.getDriver();
    driver.get("https://www.raiffeisen.ru/");
    acceptRegion();


    click(driver.findElement(By.xpath("//a[@href='/retail/insurance/']")));
    click(driver.findElement(By.xpath("//a[@href='/retail/insurance/everyday/travel/vbc/']")));
    click(driver.findElement(By.xpath("//div[@class='b-intro__block-buttons']//a[@class='button']")));


    Assert.assertTrue("Форма заявки на страховую программу",
            isElementPresent(By.xpath("//h1[@class=\"e-title e-title--h2\"]")));


    Assert.assertTrue("Вояж (Комфорт/Бизнес класс/Первый класс)",
            isElementPresent(By.xpath("//span[@class='ui-selectmenu-text']")));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Фамилия\"]")),
            testData.get("Ф"));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Имя\"]")),
            testData.get("И"));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Имя\"]")),
            testData.get("О"));

    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Дата Рождения\"]")),
            testData.get("ДР"));


    fillField(driver.findElement(By.xpath(" //input[@placeholder=\"+7 964 385-54-43\"]")),
            testData.get("Тел"));


    fillField(driver.findElement(By.xpath("//input[@placeholder=\"Электронная почта\"]")),
            testData.get("Почта"));

    fillField(driver.findElement(By.xpath("//input[@placeholder='Проверочный код']")),
            testData.get("Код"));



    click(driver.findElement(By.xpath("//span[@class=\"checkbox-block__span\"]"))); //чекбокс

    Assert.assertTrue("Кнопка - Отправить  не активна",
            driver.findElement(By.xpath("//button[@id=\"btn_submit\"]")).isDisplayed());




  }
}

//1. Перейти по ссылке - https://www.raiffeisen.ru/
//2. Выбрать пункт меню – Страхование
//3. Выбрать – В путешествие
//4. Нажать на кнопку – Оставить заявку
//5. Проверить, что есть текст - Форма заявки на страховую программу
//6. Проверить, что поле продукт заполнено значением - Вояж (Комфорт/Бизнес класс/Первый класс)
//7. Заполнить поля: ФИО, Дата рождения, Номер телефона, Эл. почта
//8. Отметить чекбокс – Я согласен с условиями
//9. Заполнить проверочный код – любое значении
//10. Проверить, что кнопка Отправить активна