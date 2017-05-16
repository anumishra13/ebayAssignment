

package automationEbay;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class OnlineStore {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

System.setProperty("webdriver.ie.driver","D:\\Selenium\\3.4\\IEDriverServer_Win32_3.4.0\\IEDriver.exe");
WebDriver driver=  new InternetExplorerDriver();
driver.get("http://www.ebay.com");

driver.manage().window().maximize();
System.out.println("Successfully opened.");

WebElement search=driver.findElement(By.id("gh-ac"));
search.sendKeys("tv sony");
System.out.println("Entered tv sony in search.");

WebElement searchBtn=driver.findElement(By.id("gh-btn"));
searchBtn.click();
System.out.println("'Search' Button clicked");

WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='AnswersModule']/div/nav/ul/li[1]/a/div")));
WebElement size=driver.findElement(By.xpath("//*[@id='AnswersModule']/div/nav/ul/li[1]/a/div"));
size.click();
System.out.println("Screen size 50-60 inches is selected!"+"\n");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item1c826b2314']/h3/a")));

WebElement firstLink=driver.findElement(By.xpath("//*[@id='item1c826b2314']/h3/a"));
String productName=firstLink.getText();
firstLink.click();
System.out.println("Selected Product Name: "+ productName + "\n");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vi-itm-cond")));

System.out.println("PRODUCT DETAILS");
String prodTitle=driver.findElement(By.id("itemTitle")).getText();
System.out.println("Product Name:"+ prodTitle +"\n");

Assert.assertEquals(productName,prodTitle);
System.out.print("Verified product name selected and on product details screen are SAME."+ "\n");

String itemLabel=driver.findElement(By.xpath("//*[@id='mainContent']/form/div[1]/div[1]/div[1]")).getText();
WebElement item=driver.findElement(By.id("vi-itm-cond"));
String itemCondition= item.getText();
System.out.println(itemLabel + itemCondition);

String timeLabel=driver.findElement(By.xpath("//*[@id='mainContent']/form/div[1]/div[3]/div[1]")).getText();
WebElement time=driver.findElement(By.id("vi-cdown_timeLeft"));
String timeLeft=time.getText();
System.out.println(timeLabel + timeLeft);

String priceLabel=driver.findElement(By.id("prcIsum-lbl")).getText();
WebElement price=driver.findElement(By.id("prcIsum"));
String dollarPrice=price.getText();
System.out.println(priceLabel + dollarPrice);

WebElement seller=driver.findElement(By.id("mbgLink"));
String sellerName=seller.getText();
System.out.println("Seller name :" + sellerName + "\n");

WebElement addCart=driver.findElement(By.id("isCartBtn_btn"));
addCart.click();
System.out.println("Clicked on 'Add To Cart'!"+"\n");

WebElement noPlan=driver.findElement(By.id("addNoThx"));
noPlan.click();
System.out.println("Clicked on 'No Thanks' on pop-up!"+"\n");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("122447143700_title")));

WebElement titlePreview=driver.findElement(By.id("122447143700_title"));
String productNamePreview=titlePreview.getText();
System.out.println("REVIEW ITEM SCREEN:");
System.out.println("Product name:" + productNamePreview);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fw-b']")));

WebElement pricePreview=driver.findElement(By.xpath("//div[@class='fw-b']"));
String dollarPricePreview=pricePreview.getText();
System.out.println("Price:" + dollarPricePreview);

WebElement sellerPreview=driver.findElement(By.xpath("//*[@id='albertsinc']/div[1]/div[2]/div/span[1]/a[1]"));
String sellerNamePreview=sellerPreview.getText();
System.out.println("Seller Name:" +sellerNamePreview + "\n");

Assert.assertEquals(prodTitle,productNamePreview);
System.out.print("Verified product name selected and product name on Review Item screen are SAME." +"\n\n");

Assert.assertEquals(sellerName,sellerNamePreview);
System.out.print("Verified sellername on Product Details and Review Item screen are SAME." +"\n\n");

WebElement checkoutBtn=driver.findElement(By.id("ptcBtnBottom"));
checkoutBtn.click();
System.out.println("'Proceed to Checkout' clicked!" + "\n");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gtChk")));
WebElement guestBtn=driver.findElement(By.id("gtChk"));
guestBtn.click();
System.out.println("'Continue as Guest' clicked!" + "\n");


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='s_0']/div/div[3]/div/div/div[2]/div[1]/div[1]")));
WebElement lastTitle=driver.findElement(By.xpath("//*[@id='s_0']/div/div[3]/div/div/div[2]/div[1]/div[1]"));
String guestTitle=lastTitle.getText();
System.out.println("GUEST CHECKOUT SCREEN");
System.out.println("Product Name:" + guestTitle);

WebElement lastPrice=driver.findElement(By.xpath("//*[@id='s_0']/div/div[3]/div/div/div[2]/div[1]/div[2]/span"));
String guestPrice=lastPrice.getText();
System.out.println("Price: " + guestPrice);

String lastQty=driver.findElement(By.xpath("//*[@id='s_0']/div/div[3]/div/div/div[2]/div[2]/div/span[2]")).getText();
System.out.println("Quantity:" + lastQty + "\n");

Assert.assertEquals(productNamePreview,guestTitle );
System.out.print("Verified product name on product details screen and guest checkout screen are SAME." +"\n\n");

Assert.assertEquals(dollarPricePreview,guestPrice );
System.out.print("Verified price of the product on Review Item and Guest checkout screen are SAME.");


//driver.quit();

    }

}


