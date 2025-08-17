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
TestObject inputEmail = new TestObject().addProperty('id', ConditionType.EQUALS, 'email')
WebUI.setText(inputEmail, 'saiqul@gmail.com')
TestObject inputPassword = new TestObject().addProperty('id', ConditionType.EQUALS, 'password')
WebUI.setText(inputPassword, 'password123')
TestObject btnLogin = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div[2]/div[2]/form/div[4]/button')
WebUI.click(btnLogin)
TestObject txtDashboard = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/header/nav/div/div[1]/a/p')
WebUI.verifyElementPresent(txtDashboard, 8)


//Shift Change
TestObject btnService = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/header/nav/div/div[1]/div/div/button/div')
WebUI.click(btnService)
WebUI.delay(0.5)
TestObject btnAttendance = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div')
WebUI.click(btnAttendance)
WebUI.delay(0.5)
TestObject btnSubmission = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div')
WebUI.click(btnSubmission)
WebUI.delay(0.5)
TestObject btnShiftChange = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[4]/li')
WebUI.click(btnShiftChange)
WebUI.delay(0.5)
TestObject txtShiftChange = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[1]/div/h1')
WebUI.verifyElementPresent(txtShiftChange, 5)


//Filter
TestObject btnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
WebUI.click(btnFilter)
 

//Select Status
TestObject dropdownContainer = new TestObject()
dropdownContainer.addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
WebUI.click(dropdownContainer)
WebUI.delay(0.5)
TestObject approvedOption = new TestObject()
approvedOption.addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")
WebUI.click(approvedOption)


//Select Date
String rangeTanggal = "2024-04-19 - 2024-04-19"
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
WebUI.delay(1)


//Button Apply
TestObject btnApply = new TestObject()
btnApply.addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class, 'btn-primary') and text()='Apply']")
WebUI.click(btnApply)
WebUI.delay(3)


//Filter
TestObject btnFilter1 = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
WebUI.click(btnFilter1)
WebUI.delay(1)


//Button Reset
String js = """
  const btn = document.querySelector("button.btn-disabled");
  btn.click();
"""
WebUI.executeJavaScript(js, null)


//Button Apply
TestObject btnApply1 = new TestObject()
btnApply1.addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class, 'btn-primary') and text()='Apply']")
WebUI.click(btnApply1)

WebUI.delay(3)

WebUI.closeBrowser()