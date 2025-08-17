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
WebUI.verifyElementPresent(txtDashboard, 8)


// Time Off
TestObject btnService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
WebUI.click(btnService)
WebUI.delay(0.5)
TestObject btnAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
WebUI.click(btnAttendance)
WebUI.delay(0.5)
TestObject btnSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
WebUI.click(btnSubmission)
WebUI.delay(0.5)
TestObject btnTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[1]/li")
WebUI.click(btnTimeOff)
WebUI.delay(0.5)
TestObject txtTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[1]/div/h1")
WebUI.verifyElementPresent(txtTimeOff, 5)


//Button Request
TestObject btnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[2]/a")
WebUI.click(btnRequest)
WebUI.delay(3)


//Field Category
TestObject selectCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div")
WebUI.click(selectCategory)
WebUI.delay(1)
TestObject selectValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div/div/div[7]")
WebUI.click(selectValueCategory)


//Field Replacement Employee
TestObject selectReplacementEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[2]/div")
WebUI.click(selectReplacementEmployee)
WebUI.delay(1)
TestObject selectValueReplacementEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[2]/div/div/div[6]")
WebUI.click(selectValueReplacementEmployee)


//Field Tanggal Single Date
TestObject clickFieldDate = new TestObject()
clickFieldDate.addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYY']")
WebUI.click(clickFieldDate)
TestObject selectSingleDate = new TestObject()
selectSingleDate.addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[30]")
WebUI.click(selectSingleDate)

//Field Tanggal Multiple Date
//TestObject clickRadioButtonMultipleDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[1]/div/button[2]/div[1]")
//WebUI.click(clickRadioButtonMultipleDate)
//TestObject clickFieldTanggal = new TestObject()
//clickFieldTanggal.addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/input")
//WebUI.click(clickFieldTanggal)
//TestObject selectStartMultipleDate = new TestObject()
//selectStartMultipleDate.addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[30]")
//WebUI.click(selectStartMultipleDate)
//TestObject selectFinishMultipleDate = new TestObject()
//selectFinishMultipleDate.addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/button[31]")
//WebUI.click(selectFinishMultipleDate)


//Field Note
TestObject inputNote = new TestObject()
inputNote.addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")
WebUI.waitForElementVisible(inputNote, 3)
WebUI.setText(inputNote, "Contoh catatan cuti")


//Field Upload
TestObject uploadFile = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")
WebUI.uploadFile(uploadFile, '/Users/ifanmuhammad/Downloads/10mb.jpg')


//Modal Notification Error
TestObject txtFileSizeRequired = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='swal2-html-container']/div/div")
WebUI.verifyElementPresent(txtFileSizeRequired, 5)
TestObject btnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "/html/body/div[2]/div/div[6]/button[3]")
WebUI.click(btnOk)


WebUI.closeBrowser()