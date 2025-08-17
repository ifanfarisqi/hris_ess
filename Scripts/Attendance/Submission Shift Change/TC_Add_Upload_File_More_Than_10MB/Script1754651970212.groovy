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


//Button Request
TestObject btnRequest = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/div[2]/a')
WebUI.click(btnRequest)
WebUI.delay(3)


//Field Work Schedule
TestObject inputTanggal = new TestObject()
inputTanggal.addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYYY']")

WebUI.waitForElementVisible(inputTanggal, 5)
WebUI.setText(inputTanggal, "12-08-2025")


//Field Replacement Schedule
TestObject clickSchedule = new TestObject()
clickSchedule.addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div')
WebUI.click(clickSchedule)
WebUI.delay(0.5)
TestObject selectValueSchedule = new TestObject()
selectValueSchedule.addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div/div/div[4]')
WebUI.click(selectValueSchedule)


//Field Replacement Employee
TestObject clickEmployee = new TestObject()
clickSchedule.addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[3]/div/div')
WebUI.click(clickSchedule)
WebUI.delay(0.5)
TestObject selectValueEmployee = new TestObject()
selectValueEmployee.addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[3]/div/div/div/div[4]')
WebUI.click(selectValueEmployee)


//Field Note
TestObject inputNote = new TestObject()
inputNote.addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")
WebUI.waitForElementVisible(inputNote, 3)
WebUI.setText(inputNote, "Test")


//Field Upload
TestObject uploadFile = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")
WebUI.uploadFile(uploadFile, '/Users/ifanmuhammad/Downloads/10mb.jpg')


//Error Massage Verify
TestObject errorMassage = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="swal2-html-container"]/div/div')
WebUI.verifyElementPresent(errorMassage, 3)
TestObject btnOk = new TestObject()
btnOk.addProperty('xpath', ConditionType.EQUALS, "//button[contains(@class, 'swal2-confirm') and text()='OK']")
WebUI.waitForElementClickable(btnOk, 3)
WebUI.click(btnOk)
WebUI.delay(0.5)


WebUI.closeBrowser()