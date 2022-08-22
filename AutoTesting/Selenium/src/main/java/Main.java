import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;

/**
 * Постановка задачи: требуется через поисковый запрос найти в документации Selenium информацию про sendKeys.
 *
 */

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Для Java\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // установка неявного ожидания 15 сек.
        WebElement object = driver.findElement(By.xpath("//input[@aria-label=\"Найти\"]")); // создание ссылки на веб-элемент
        object.click(); // установка курсора в строку поиска
        object.sendKeys("Selenium documentation"); // ввод поискового запроса
        object.submit(); // отправка поискового запроса
        object = driver.findElement(By.xpath("//*[contains(@href, \"selenium.dev\")]")); // указание на ссылку, которая ведет на официальный сайт Selenium(достоверный источник информации)
        object.click(); // переход по ссылке
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles()); // получение числа окон и вкладок
        driver.switchTo().window(tabs.get(1)); // переход во вторую вкладку(которая открылась при переходе по ссылке)
        object= driver.findElement(By.xpath("//*[@class=\"navbar-toggler-icon\"]")); // смена ссылки на следующий объект - навигационная панель
        object.click();
        object = driver.findElement(By.xpath("//button[@aria-label=\"Search\"]")); // смена ссылки на кнопку поиска
        object.click();
        object = driver.findElement(By.xpath("//*[@class=\"DocSearch-Input\"]")); // смена ссылки на поле для ввода запроса
        object.sendKeys("send keys");
        object = driver.findElement(By.xpath("//*[@class=\"DocSearch-Hit-Select-Icon\"]")); // пришлось добавить для подтверждения выбора (Keys.ENTER почему-то не срабатывало)
        object.click();
    }
}
