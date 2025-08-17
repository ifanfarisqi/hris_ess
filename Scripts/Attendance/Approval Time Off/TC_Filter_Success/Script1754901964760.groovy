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


// Time Off
TestObject btnService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
WebUI.click(btnService)
WebUI.delay(0.5)
TestObject btnAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
WebUI.click(btnAttendance)
WebUI.delay(0.5)
TestObject btnApproval = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/div/div')
WebUI.click(btnApproval)
WebUI.delay(0.5)
TestObject btnTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/ul/a[1]/li')
WebUI.click(btnTimeOff)
WebUI.delay(0.5)
TestObject txtTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Time Off Approval']")
WebUI.waitForElementVisible(txtTimeOff, 15)
WebUI.verifyElementPresent(txtTimeOff, 5)


//Filter
TestObject btnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
WebUI.click(btnFilter)


//Select Option Status
TestObject dropdownContainer = new TestObject()
dropdownContainer.addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
WebUI.click(dropdownContainer)
WebUI.delay(0.5)  
TestObject approvedOption = new TestObject()
approvedOption.addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")
WebUI.click(approvedOption)


//Select Option Category
TestObject dropdownCategory = new TestObject()
dropdownCategory.addProperty("xpath", ConditionType.EQUALS, "((//select)[2])/parent::div[contains(@class, 'cursor-pointer')]")
WebUI.click(dropdownCategory)
TestObject opsiValue = new TestObject()
opsiValue.addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Cuti Mendadak') and contains(@class, 'cursor-pointer')]")
WebUI.click(opsiValue)


//Select Date
TestObject inputDateRange = new TestObject('inputDateRange')
inputDateRange.addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYYY - DD-MM-YYYY']")
WebUI.click(inputDateRange)
TestObject tglAwal = new TestObject('tglAwal')
tglAwal.addProperty('xpath', ConditionType.EQUALS, "//button[@type='button' and normalize-space()='5']")
WebUI.click(tglAwal)
TestObject tglAkhir = new TestObject('tglAkhir')
tglAkhir.addProperty('xpath', ConditionType.EQUALS, "//button[@type='button' and normalize-space()='6']")
WebUI.click(tglAkhir)


//Button Submit
TestObject btnSubmit = new TestObject()
btnSubmit.addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'btn-primary') and text()='Submit']")
WebUI.click(btnSubmit)
WebUI.delay(3)


WebUI.closeBrowser()