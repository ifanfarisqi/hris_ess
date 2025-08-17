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
WebUI.setText(inputEmail, 'saiqul@gmail.com')
TestObject inputPassword = new TestObject().addProperty("id", ConditionType.EQUALS, "password")
WebUI.setText(inputPassword, 'password123')
TestObject btnLogin = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div[2]/div[2]/form/div[4]/button")
WebUI.click(btnLogin)
TestObject txtDashboard = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/a/p")
WebUI.verifyElementPresent(txtDashboard, 3)


//Working Day Change
TestObject btnService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
WebUI.click(btnService)
WebUI.delay(0.5)
TestObject btnAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
WebUI.click(btnAttendance)
WebUI.delay(0.5)
TestObject btnSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
WebUI.click(btnSubmission)
WebUI.delay(0.5)
TestObject btnWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[5]/li')
WebUI.click(btnWorkExitPermit)
WebUI.delay(0.5)
TestObject txtWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[1]/div/h1')
WebUI.verifyElementPresent(txtWorkExitPermit, 5)


//Button Request
TestObject btnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div[2]/a')
WebUI.click(btnRequest)
WebUI.delay(3)


//Field Category
TestObject clickCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div/select')
WebUI.click(clickCategory)
TestObject clickValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div/div/div[5]')
WebUI.click(clickValueCategory)

//Field Select Date
String dateValue = "2025-08-10"
String js = """
  let el = document.querySelector('input[placeholder="Input Date"]');
  let lastValue = el.value;
  el.value = '${dateValue}';
  let tracker = el._valueTracker;
  if (tracker) {
    tracker.setValue(lastValue);
  }
  el.dispatchEvent(new Event('input', { bubbles: true }));
  el.dispatchEvent(new Event('change', { bubbles: true }));
"""
WebUI.executeJavaScript(js, null)

TestObject clickFirstDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[2]/div/div[1]/span/input')
WebUI.click(clickFirstDuration)
TestObject clickValueHoursFirstDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[19]')
WebUI.click(clickValueHoursFirstDuration)
TestObject clickValueMinutesFirstDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[8]')
WebUI.click(clickValueMinutesFirstDuration)

TestObject clickSecondDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[2]/div/div[2]/span/input')
WebUI.click(clickSecondDuration)
TestObject clickValueHoursSecondDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[1]/ul/li[22]')
WebUI.click(clickValueHoursSecondDuration)
TestObject clickValueMinutesSecondDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[2]/ul/li[6]')
WebUI.click(clickValueMinutesSecondDuration)

TestObject clickTitle= new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div/div/h1')
WebUI.click(clickTitle)


//Upload File
TestObject uploadFile = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')
WebUI.uploadFile(uploadFile, '/Users/ifanmuhammad/Downloads/TEST-FILE-DOWNLOAD.pdf')


//Field Member To be Notified
TestObject clickSelectMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div/select')
WebUI.click(clickSelectMember)
TestObject clickValueSelectMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div/div/div[6]')
WebUI.click(clickValueSelectMember)


//Button Submit
TestObject btnSubmit = new TestObject()
btnSubmit.addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-primary') and normalize-space()='Submit']")
WebUI.click(btnSubmit)
WebUI.delay(0.5)


//Massage Error Verify
TestObject errorMassageNote = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[2]/div[1]/span')
WebUI.verifyElementPresent(errorMassageNote, 3)


WebUI.closeBrowser()