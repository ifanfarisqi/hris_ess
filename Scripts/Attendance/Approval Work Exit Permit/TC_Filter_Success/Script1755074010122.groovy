import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys

WebUI.openBrowser('')
WebUI.navigateToUrl('https://ics-hris.skwn.dev/login')

WebUI.delay(2)


//Login
TestObject inputEmail = new TestObject().addProperty("id", ConditionType.EQUALS, "email")
WebUI.setText(inputEmail, 'eri@email.com')
TestObject inputPassword = new TestObject().addProperty("id", ConditionType.EQUALS, "password")
WebUI.setText(inputPassword, 'password123')
TestObject btnLogin = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div[2]/div[2]/form/div[4]/button")
WebUI.click(btnLogin)
TestObject txtDashboard = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/a/p")
WebUI.waitForElementVisible(txtDashboard, 15)
WebUI.verifyElementPresent(txtDashboard, 5)


//Work Exit Permit
TestObject btnService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
WebUI.click(btnService)
WebUI.delay(0.5)
TestObject btnAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
WebUI.click(btnAttendance)
WebUI.delay(0.5)
TestObject btnApproval = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/div/div')
WebUI.click(btnApproval)
WebUI.delay(0.5)
TestObject btnWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/ul/a[5]/li')
WebUI.click(btnWorkExitPermit)
WebUI.delay(0.5)
def verifyPageTitle(String expectedTitle) {
    TestObject pageTitle = new TestObject()
    pageTitle.addProperty(
        "xpath",
        ConditionType.EQUALS,
        "//h1[normalize-space()='" + expectedTitle + "']"
    )

    WebUI.waitForElementVisible(pageTitle, 10)
    WebUI.verifyElementText(pageTitle, expectedTitle)
}
verifyPageTitle("Work Exit Permit Approval")


//Filter
TestObject btnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
WebUI.click(btnFilter)


//Select Option Status
TestObject dropdown = new TestObject()
dropdown.addProperty("xpath", ConditionType.EQUALS, "((//select)[1])/parent::div[contains(@class, 'cursor-pointer')]")
WebUI.waitForElementClickable(dropdown, 5)
WebUI.click(dropdown)
TestObject optionWaiting = new TestObject()
optionWaiting.addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Waiting for Approval') and contains(@class, 'cursor-pointer')]")
WebUI.click(optionWaiting)


//Select Option Category
TestObject dropdownCategory = new TestObject()
dropdownCategory.addProperty("xpath", ConditionType.EQUALS, "((//select)[2])/parent::div[contains(@class, 'cursor-pointer')]")
WebUI.waitForElementClickable(dropdownCategory, 5)
WebUI.click(dropdownCategory)
TestObject selectValueCategory = new TestObject()
selectValueCategory.addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Keperluan Keluarga') and contains(@class, 'cursor-pointer')]")
WebUI.click(selectValueCategory)


//Select Date
String rangeTanggal = "06-08-2025 - 10-08-2025"
String jsScript = """
const input = document.querySelector("input[placeholder='DD-MM-YYYY - DD-MM-YYYY']");
if (input) {
  const nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;
  nativeInputValueSetter.call(input, '$rangeTanggal');
  
  input.dispatchEvent(new Event('input', { bubbles: true }));
  input.dispatchEvent(new Event('change', { bubbles: true }));
}
"""

WebUI.executeJavaScript(jsScript, null)


//Button Submit
TestObject btnSubmit = new TestObject()
btnSubmit.addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'btn-primary') and text()='Submit']")
WebUI.click(btnSubmit)
WebUI.delay(3)


WebUI.closeBrowser()