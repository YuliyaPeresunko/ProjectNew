package HomeWork.WaitersHW;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitersHW {
    private final WebDriver driver;

    public WaitersHW(WebDriver driver) {
        this.driver = driver;
    }

    private static final long EXPLICITY_WAIT = 20L;

    private FluentWait<WebDriver> fluentWait(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeout) {
        FluentWait<WebDriver> wait = fluentWait(timeout);
        wait.until(function);
    }

    //////////////////////

    public void waitForPresenceOfElementLocated(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }
    public WebElement waitForPresenceOfElementLocatedReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /////////////////////

    public void waitForTextToBePresentInElementValue(By by, String text){
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(driver.findElement(by),text),EXPLICITY_WAIT);
    }

    /////////////////////

    public void waitForInvisibilityOf(WebElement element){
        waitForFunction(ExpectedConditions.invisibilityOf(element),EXPLICITY_WAIT);
    }
    public void waitForInvisibilityOf(By by){
        waitForFunction(ExpectedConditions.invisibilityOf(driver.findElement(by)),EXPLICITY_WAIT);
    }

    /////////////////////

    public void waitForTitleContains(String text){
        waitForFunction(ExpectedConditions.titleContains(text),EXPLICITY_WAIT);
    }

    //////////////////////
    public void waitForTitleIs(String text){
         waitForFunction(ExpectedConditions.titleIs(text),EXPLICITY_WAIT);
     }


    /////////////////////

    public void waitForElementToBeClickable(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeClickable(element),EXPLICITY_WAIT);
    }
    public void waitForElementToBeClickable(By by){
        waitForFunction(ExpectedConditions.elementToBeClickable(driver.findElement(by)),EXPLICITY_WAIT);
    }
    public WebElement waitForElementToBeClickableReturn(WebElement element){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementToBeClickableReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }
    ////////////////////

    public void waitForElementToBeSelected(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeSelected(element),EXPLICITY_WAIT);
    }
    public void waitForElementToBeSelected(By by){
        waitForFunction(ExpectedConditions.elementToBeSelected(driver.findElement(by)),EXPLICITY_WAIT);
    }

    ////////////////////

    public void waitForElementSelectionStateToBe(WebElement element, boolean bool){
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, bool),EXPLICITY_WAIT);
    }
    public void waitForElementSelectionStateToBe(By by, boolean bool){
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(driver.findElement(by), bool),EXPLICITY_WAIT);
    }

    /////////////////////

    public void waitForVisibilityOfElementLocated(By by){
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by),EXPLICITY_WAIT);
    }

    public WebElement waitForVisibilityOfElementLocatedReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    /////////////////////

    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element),EXPLICITY_WAIT);
    }
    public void waitForFrameToBeAvailableAndSwitchToIt(By by){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(by)),EXPLICITY_WAIT);
    }

    ////////////////////

    public void waitForAlertIsPresent(){
        waitForFunction(ExpectedConditions.alertIsPresent(),EXPLICITY_WAIT);
    }


    ////////////////////
}
