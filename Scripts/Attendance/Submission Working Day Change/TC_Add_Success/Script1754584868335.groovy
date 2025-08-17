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
TestObject btnWorkingDayChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[3]/li')
WebUI.click(btnWorkingDayChange)
WebUI.delay(0.5)
TestObject txtWorkingDayChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[1]/div/h1')
WebUI.verifyElementPresent(txtWorkingDayChange, 5)


//Button Request
TestObject btnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div[2]/a')
WebUI.click(btnRequest)
WebUI.delay(3)


// Field Work Schedule
TestObject inputTanggalWork = new TestObject()
inputTanggalWork.addProperty("xpath", ConditionType.EQUALS, "(//input[@placeholder='DD/MM/YYYY'])[1]")
WebUI.click(inputTanggalWork)

TestObject selectTanggalWork = new TestObject()
selectTanggalWork.addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and text()='14']")
WebUI.waitForElementVisible(selectTanggalWork, 10)
WebUI.click(selectTanggalWork)


// Field Replacement Schedule
TestObject inputTanggalReplacement = new TestObject()
inputTanggalReplacement.addProperty("xpath", ConditionType.EQUALS, "(//input[@placeholder='DD/MM/YYYY'])[2]")
WebUI.click(inputTanggalReplacement)

TestObject pickDate = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/div/main/div[2]/form/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[19]')
WebUI.click(pickDate)


//Field Note
TestObject inputNote = new TestObject()
inputNote.addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")
WebUI.waitForElementVisible(inputNote, 3)
WebUI.setText(inputNote, "Test")


//Field Upload
TestObject uploadFile = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")
WebUI.uploadFile(uploadFile, '/Users/ifanmuhammad/Downloads/TEST-FILE-DOWNLOAD.pdf')


//Field Member to be Notified
TestObject inputSearch = new TestObject()
inputSearch.addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='Add Member to be notified them']")
WebUI.waitForElementVisible(inputSearch, 5)
WebUI.setText(inputSearch, 'V')
TestObject resultNama = new TestObject()
resultNama.addProperty('xpath', ConditionType.EQUALS, "//li[@data-test='result']//span[text()='Otavia Ulandari']")
WebUI.waitForElementClickable(resultNama, 5)
WebUI.click(resultNama)


//Button Submit
TestObject btnSubmit = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/div/main/div[2]/form/div[2]/button')
WebUI.click(btnSubmit)
WebUI.delay(0.5)
def verifysMessage(String expectedText) {
	TestObject successMessage = new TestObject()
	successMessage.addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//div[normalize-space()='" + expectedText + "']"
	)

	WebUI.waitForElementVisible(successMessage, 10)
	WebUI.verifyElementText(successMessage, expectedText)
}
verifysMessage("Are you sure to send the request?")

def clickAlertOk() {
	TestObject okButton = new TestObject()
	okButton.addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//button[@type='button' and contains(@class,'swal2-confirm')]"
	)

	WebUI.waitForElementVisible(okButton, 10)
	WebUI.click(okButton)
}
clickAlertOk()

def verifysMessageAgain(String expectedText) {
	TestObject successMessage = new TestObject()
	successMessage.addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//div[normalize-space()='" + expectedText + "']"
	)

	WebUI.waitForElementVisible(successMessage, 10)
	WebUI.verifyElementText(successMessage, expectedText)
}
verifysMessageAgain("Request was successfully sent")

def clickAlertOkAgain() {
	TestObject okButton = new TestObject()
	okButton.addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//button[@type='button' and contains(@class,'swal2-confirm')]"
	)

	WebUI.waitForElementVisible(okButton, 10)
	WebUI.click(okButton)
}
clickAlertOkAgain()

TestObject heading = new TestObject()
heading.addProperty("xpath", ConditionType.EQUALS, "//h1[text()='Working Day Change']")
WebUI.waitForElementPresent(heading, 5)
WebUI.delay(1)


WebUI.closeBrowser()