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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import pages.LoginPage as LoginPage
import pages.WorkingDayChangePageSubmission as WorkingDayChangePage

WebUI.openBrowser('')
WebUI.navigateToUrl('https://ics-hris.skwn.dev/login')

LoginPage loginPage = new LoginPage()
loginPage.login('saiqul@gmail.com', 'VvH/06ph0eWVSEmkJj4cqw==')
loginPage.verifyLblDashboard()

WorkingDayChangePage workingDayChangePage = new WorkingDayChangePage()
workingDayChangePage.workingDayChange()
workingDayChangePage.BtnRequset()
workingDayChangePage.WorkScheduleGreater()
workingDayChangePage.fieldReplacementSchedule()
workingDayChangePage.fieldNote("Test Working Day Change")
workingDayChangePage.fieldUpload("/Users/ifanmuhammad/Downloads/TEST-FILE-DOWNLOAD.pdf")
workingDayChangePage.fieldNotifyMember("V")
workingDayChangePage.btnSubmit()
workingDayChangePage.verifyTxtWorkScheduleGreaterError()

WebUI.delay(2)

WebUI.closeBrowser()