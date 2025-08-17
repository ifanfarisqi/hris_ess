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

//Detail Data Shift Change
TestObject detailData = new TestObject()
detailData.addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div/div[1]/div')
WebUI.click(detailData)


//Reject
def clickButtonByText(String buttonText) {
	TestObject button = new TestObject()
	button.addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//button[normalize-space()='" + buttonText + "']"
	)

	WebUI.waitForElementVisible(button, 5)
	WebUI.click(button)
}
clickButtonByText("Reject")


//Field Note
TestObject inputNote = new TestObject()
inputNote.addProperty("id", ConditionType.EQUALS, "note")
WebUI.setText(inputNote, "test ditolak work exit permit")


//Button Send
TestObject btnSend = new TestObject()
btnSend.addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-primary')]")
WebUI.click(btnSend)
WebUI.delay(1)


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
WebUI.delay(1)

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
WebUI.delay(1)

def verifyPageTitle1(String expectedTitle) {
    TestObject pageTitle = new TestObject()
    pageTitle.addProperty(
        "xpath",
        ConditionType.EQUALS,
        "//h1[normalize-space()='" + expectedTitle + "']"
    )

    WebUI.waitForElementVisible(pageTitle, 10)
    WebUI.verifyElementText(pageTitle, expectedTitle)
}
verifyPageTitle1("Work Exit Permit Approval")
WebUI.delay(3)


WebUI.closeBrowser()