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

public class ShiftChangePageSubmission {

	//Button Menu
	private TestObject clickMenuServices = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
	private TestObject clickMenuShiftChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[4]/li')
	private TestObject lblShiftChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Shift Change']")
	private TestObject clickDataDetail = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div[2]/div')

	//Input
	private TestObject inputNote = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")


	//Button
	private TestObject clickBtnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[normalize-space()='Request']")
	private TestObject clickBtnSubmit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class, 'btn-primary')]")
	private TestObject btnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'swal2-confirm') and normalize-space()='OK']")
	private TestObject btnDownload = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div/div[1]/div/div[7]/div/div')
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject clickBtnApply = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class, 'btn-primary') and text()='Apply']")
	private TestObject btnResetDisabled = new TestObject("btnResetDisabled").addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and text()='Reset' and contains(@class,'btn-disabled')]")


	//Select Option
	private TestObject selectSchedule = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div')
	private TestObject selectValueSchedule = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div/div/div[4]')
	private TestObject selectEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[3]/div/div')
	private TestObject selectValueEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[3]/div/div/div/div[4]')
	private TestObject inputSearchMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='Add Member to be notified them']")
	private TestObject selectValueMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[@data-test='result']//span[text()='Otavia Ulandari']")
	private TestObject selectStatusFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
	private TestObject selectValueStatusFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")


	//Select Date
	//private TestObject inputTanggal = new TestObject("inputTanggal").addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYYY']")
	private TestObject selectDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[1]/div/input')
	private TestObject selectValueDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/form/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[26]')
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
	private TestObject txtBigFileError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(),'File size exceeds maximum limit 5 MB.')]")
	private TestObject txtNoteRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[contains(@class,'text-red-500') and text()='Note is required']")
	private TestObject txtDateRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[text()='Date is required']")
	private TestObject txtMemberRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[contains(@class,'text-red-500') and text()='Member is required']")
	private TestObject txtShiftingRequired = new TestObject("lblShiftingRequired").addProperty("xpath", ConditionType.EQUALS, "//span[normalize-space(text())='Shifting is required']")
	private TestObject txtReplacementRequired = new TestObject("lblReplacementRequired").addProperty("xpath", ConditionType.EQUALS, "//span[normalize-space(text())='Replacement is required']")
	private TestObject txtDetailShiftChange = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h1[normalize-space(text())='Shift Change Detail']")


	//Upload File
	private TestObject uploadFile = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")


	def menuService() {
		WebUI.click(clickMenuServices)
	}

	def menuAttendance() {
		WebUI.click(clickMenuAttendance)
	}

	def menuSubmission() {
		WebUI.click(clickMenuSubmission)
	}

	def menuShiftChange() {
		WebUI.click(clickMenuShiftChange)
	}

	def verifyLblShiftChange() {
		WebUI.verifyElementPresent(lblShiftChange, 5)
	}

	def btnRequest() {
		WebUI.click(clickBtnRequest)
	}

	def fieldWorkSchedule() {
		WebUI.click(selectDate)
		WebUI.click(selectValueDate)
	}

	def fieldReplacementSchedule() {
		WebUI.click(selectSchedule)
		WebUI.click(selectValueSchedule)
	}

	def fieldReplacementEmployee() {
		WebUI.click(selectEmployee)
		WebUI.click(selectValueEmployee)
	}

	def fieldNote(String note) {
		WebUI.setText(inputNote, note)
	}

	def fieldUpload(String upload) {
		WebUI.uploadFile(uploadFile, upload)
	}

	def fieldMember(String keywords) {
		WebUI.setText(inputSearchMember, keywords)
		WebUI.click(selectValueMember)
	}

	def btnSubmit() {
		WebUI.click(clickBtnSubmit)
	}

	def confirmSendRequest() {
		WebUI.verifyElementText(txtConfirmSendRequest, "Are you sure to send the request?")
		WebUI.click(btnOk)
	}

	def confirmSendSuccess() {
		WebUI.verifyElementText(txtConfirmSendSuccess, "Request was successfully sent")
		WebUI.click(btnOk)
		WebUI.verifyElementText(lblShiftChange, "Shift Change")
	}

	def verifyTxtBigFileError() {
		WebUI.verifyElementText(txtBigFileError, "File size exceeds maximum limit 5 MB.")
		WebUI.click(btnOk)
	}

	def verifyNoteRequired() {
		WebUI.verifyElementText(txtNoteRequired, "Note is required")
	}

	def verifyAllField() {
		WebUI.verifyElementText(txtDateRequired, "Date is required")
		WebUI.verifyElementText(txtShiftingRequired, "Shifting is required")
		WebUI.verifyElementText(txtReplacementRequired, "Replacement is required")
		WebUI.verifyElementText(txtNoteRequired, "Note is required")
		WebUI.verifyElementText(txtMemberRequired, "Member is required")
	}

	def dataDetail() {
		WebUI.click(clickDataDetail)
		WebUI.verifyElementPresent(txtDetailShiftChange, 3)
		WebUI.click(btnDownload)
	}

	def search(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}

	def filterSuccess(String startDate, String endDate) {
		WebUI.click(clickBtnFilter)
		WebUI.click(selectStatusFilter)
		WebUI.click(selectValueStatusFilter)
		WebUI.click(inputDateRange)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		WebUI.click(clickBtnApply)
	}

	def resetFilter(String startDate, String endDate) {
		WebUI.click(clickBtnFilter)
		WebUI.click(selectStatusFilter)
		WebUI.click(selectValueStatusFilter)
		WebUI.click(inputDateRange)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		WebUI.click(clickBtnApply)
		WebUI.click(clickBtnFilter)
		WebUI.click(btnResetDisabled)
		WebUI.click(clickBtnApply)
	}

	def shiftChange() {
		menuService()
		menuAttendance()
		menuSubmission()
		menuShiftChange()
		verifyLblShiftChange()
	}
}
