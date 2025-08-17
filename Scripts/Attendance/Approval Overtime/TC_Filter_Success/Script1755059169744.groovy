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


//OverTime
TestObject btnService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
WebUI.click(btnService)
WebUI.delay(0.5)
TestObject btnAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
WebUI.click(btnAttendance)
WebUI.delay(0.5)
TestObject btnApproval = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/div/div')
WebUI.click(btnApproval)
WebUI.delay(0.5)
TestObject btnOverTime = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/ul/a[2]/li')
WebUI.click(btnOverTime)
WebUI.delay(0.5)
TestObject txtOverTime = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Overtime Approval']")
WebUI.waitForElementVisible(txtOverTime, 15)
WebUI.verifyElementPresent(txtOverTime, 5)


//Filter
TestObject btnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
WebUI.click(btnFilter)


//Select Value Status
TestObject dropdown = new TestObject()
dropdown.addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'cursor-pointer') and .//select]")
WebUI.waitForElementClickable(dropdown, 5)
WebUI.click(dropdown)
WebUI.delay(1)
TestObject opsiWaiting = new TestObject()
opsiWaiting.addProperty('xpath', ConditionType.EQUALS, "//div[text()='Waiting For Approval']")
WebUI.waitForElementClickable(opsiWaiting, 5)
WebUI.click(opsiWaiting)


//Select Date
String rangeTanggal = "2025-08-07 - 2025-08-10"
String jsScript = """
const input = document.querySelector("input[placeholder='YYYY-MM-DD - YYYY-MM-DD']");
if (input) {
  const nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;
  nativeInputValueSetter.call(input, '$rangeTanggal');
  
  input.dispatchEvent(new Event('input', { bubbles: true }));
  input.dispatchEvent(new Event('change', { bubbles: true }));
}
"""
WebUI.executeJavaScript(jsScript, null)


//Button Submit
TestObject btnApply = new TestObject()
btnApply.addProperty('xpath', ConditionType.EQUALS, "//button[text()='Apply']")
WebUI.waitForElementClickable(btnApply, 3)
WebUI.click(btnApply)

WebUI.delay(5)

WebUI.closeBrowser()