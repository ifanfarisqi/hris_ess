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
import pages.LoginPage as LoginPage
import pages.WorkExitPermitPageApproval as WorkExitPermitPageApproval


WebUI.openBrowser('')
WebUI.navigateToUrl('https://ics-hris.skwn.dev/login')

LoginPage loginPage = new LoginPage()
loginPage.login("eri@email.com", "8SQVv/p9jVTHLrggi8kCzw==")

WorkExitPermitPageApproval workExitPermitPageApproval = new WorkExitPermitPageApproval()
workExitPermitPageApproval.workExitPermit()
workExitPermitPageApproval.workExitPermitApprove('Test Approval Work Exit Permit')
workExitPermitPageApproval.confirmModalVerify()
workExitPermitPageApproval.confirmModalSuccess()

WebUI.delay(2)

WebUI.closeBrowser()