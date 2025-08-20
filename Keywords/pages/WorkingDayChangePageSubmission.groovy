package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType

import internal.GlobalVariable

public class WorkingDayChangePageSubmission {

	//Button Menu
	private TestObject clickMenuServices = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
	private TestObject clickMenuWorkingDayChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[3]/li')
	private TestObject lblWorkingDayChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Working Day Change']")
	private TestObject dataDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div/div[1]/div')


	//Input
	private TestObject inputNote = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")
	private TestObject inputSearchMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='Add Member to be notified them']")
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")


	//Button
	private TestObject clickBtnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[normalize-space()='Request']")
	private TestObject clickBtnSubmit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[normalize-space()='Submit']")
	private TestObject clickBtnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'swal2-confirm') and normalize-space()='OK']")
	private TestObject clickBtnDownload = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/div/main/div[2]/div[2]/div[1]/div[5]/div/div')
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div[1]/button')
	private TestObject clickBtnReset = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class,'btn-primary') and contains(normalize-space(.),'Reset')]")


	//Select Option
	private TestObject clickValueMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[@data-test='result']//span[text()='Otavia Ulandari']")
	private TestObject selectStatusFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
	private TestObject selectValueStatusFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")


	//Select Date
	private TestObject inputDateWorkSchedule = new TestObject().addProperty("xpath", ConditionType.EQUALS, "(//input[@placeholder='DD/MM/YYYY'])[1]")
	private TestObject selectDateValueWorkSchedule = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and text()='21']")
	private TestObject inputDateReplacementSchedule = new TestObject().addProperty("xpath", ConditionType.EQUALS, "(//input[@placeholder='DD/MM/YYYY'])[2]")
	private TestObject selectDateValueReplacementSchedule = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/div/main/div[2]/form/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[26]')
	private TestObject selectDateValueWorkScheduleGreater = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and text()='20']")
	private TestObject selectDateValueReplacementScheduleGreater = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/div/main/div[2]/form/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[25]')
	private TestObject inputDateRange = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//input[@placeholder='YYYY-MM-DD - YYYY-MM-DD']"
	)
	private TestObject selectStartDateFilter(String startDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + startDate + "']")
	}
	private TestObject selectEndDateFilter(String endDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + endDate + "']")
	}


	//Verify Message
	private TestObject txtConfirmSendRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Are you sure to send the request?']")
	private TestObject txtConfirmSendSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Request was successfully sent']")
	private TestObject txtMessageErrorFileUpload = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space(text())='File size exceeds maximum limit 5 MB.']")
	private TestObject txtWorkScheduleError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(normalize-space(.),'Work Schedule is required')]")
	private TestObject txtReplacementScheduleError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(normalize-space(.),'Replacement Schedule is required')]")
	private TestObject txtNoteError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(normalize-space(.),'Note is required')]")
	private TestObject txtMemberError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(normalize-space(.),'Member is required')]")
	private TestObject txtWorkScheduleGreaterError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(normalize-space(.),'Work Schedule must be greater than today')]")
	private TestObject txtReplacementScheduleGreaterError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(normalize-space(.),'Replacement Schedule must be greater than today')]")

	//Upload File
	private TestObject uploadFile = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')

	def BtnRequset() {
		WebUI.click(clickBtnRequest)
	}

	def fieldWorkSchedule() {
		WebUI.click(inputDateWorkSchedule)
		WebUI.click(selectDateValueWorkSchedule)
	}

	def fieldReplacementSchedule(String day) {
		WebUI.click(inputDateReplacementSchedule)
		WebUI.click(selectDateValueReplacementSchedule)
	}

	def fieldNote(String note) {
		WebUI.setText(inputNote, note)
	}

	def fieldUpload(String upload) {
		WebUI.uploadFile(uploadFile, upload)
	}

	def fieldNotifyMember(String keywords) {
		WebUI.setText(inputSearchMember, keywords)
		WebUI.click(clickValueMember)
	}

	def btnSubmit() {
		WebUI.click(clickBtnSubmit)
	}

	def confirmSendRequest() {
		WebUI.verifyElementText(txtConfirmSendRequest, "Are you sure to send the request?")
		WebUI.click(clickBtnOk)
	}

	def confirmSendSuccess() {
		WebUI.verifyElementText(txtConfirmSendSuccess, "Request was successfully sent")
		WebUI.click(clickBtnOk)
		WebUI.verifyElementText(lblWorkingDayChange, "Working Day Change")
	}

	def WorkScheduleGreater() {
		WebUI.click(inputDateWorkSchedule)
		WebUI.click(selectDateValueWorkScheduleGreater)
	}

	def ReplacementScheduleGreater() {
		WebUI.click(inputDateReplacementSchedule)
		WebUI.click(selectDateValueReplacementScheduleGreater)
	}

	def verifyTxtWorkScheduleGreaterError() {
		WebUI.verifyElementPresent(txtWorkScheduleGreaterError, 3)
	}

	def verifyTxtReplacementScheduleGreaterError() {
		WebUI.verifyElementPresent(txtReplacementScheduleGreaterError, 3)
	}

	def verifyTxtAllField() {
		WebUI.verifyElementPresent(txtWorkScheduleError, 3)
		WebUI.verifyElementPresent(txtReplacementScheduleError, 3)
		WebUI.verifyElementPresent(txtNoteError, 3)
		WebUI.verifyElementPresent(txtMemberError, 3)
	}

	def verifyTxtNoteError() {
		WebUI.verifyElementPresent(txtNoteError, 3)
	}

	def confirmTxtMessageErrorFileUpload() {
		WebUI.verifyElementPresent(txtMessageErrorFileUpload, 3)
		WebUI.click(clickBtnOk)
	}

	def viewDetail() {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnDownload)
	}

	def search(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}

	def btnFilter() {
		WebUI.click(clickBtnFilter)
	}

	def filterSuccess(String startDate, String endDate) {
		WebUI.click(selectStatusFilter)
		WebUI.click(selectValueStatusFilter)
		WebUI.click(inputDateRange)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
	}

	def btnReset() {
		WebUI.click(clickBtnReset)
	}

	def workingDayChange() {
		WebUI.click(clickMenuServices)
		WebUI.click(clickMenuAttendance)
		WebUI.click(clickMenuSubmission)
		WebUI.click(clickMenuWorkingDayChange)
		WebUI.verifyElementPresent(lblWorkingDayChange, 5)
	}
}
