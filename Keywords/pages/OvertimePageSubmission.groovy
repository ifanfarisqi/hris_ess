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

public class OvertimePageSubmission {

	//Button Menu
	private TestObject clickMenuServices = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
	private TestObject clickMenuOvertime = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[2]/li')
	private TestObject lblOvertime = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Overtime']")
	private TestObject openDataDetail = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div[1]/div')
	private TestObject clickTitle = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/main/div[2]/div[1]/div/h1')


	//Input
	private TestObject inputNote = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'Note\']')
	private TestObject inputEmployee = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='Add Employee']")
	private TestObject clickValueEmployee = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[@data-test='result']//span[text()='V']")
	private TestObject inputSearchNotifyEmployee = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='Add Member to be notified them']")
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")


	//Button
	private TestObject clickBtnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[normalize-space()='Request']")
	private TestObject clickBtnSubmit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[normalize-space()='Submit']")
	private TestObject btnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'swal2-confirm') and normalize-space()='OK']")
	private TestObject clickFileDownload = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div/div[1]/div[1]/div[5]/div/div')
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject clickBtnApply = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[text()='Apply']")
	private TestObject clickBtnReset = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[text()='Reset']")


	//Select Option
	private TestObject clickValueNotifyEmployee = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[@data-test='result']//span[text()='Otavia Ulandari']")
	private TestObject selectStatus = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'cursor-pointer') and .//select]")
	private TestObject selectValueStatus = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[text()='Waiting For Approval']")


	//Select Date
	private TestObject selectDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/form/div[1]/div[1]/div/button")
	private TestObject selectValueDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/form/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[12]")
	private TestObject clickFirstDuration = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div[1]/div[1]/span/input')
	private TestObject selectFirstTime = new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[15]')
	private TestObject clickLastDuration = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div[1]/div[3]/span/input')
	private TestObject selectLastTime = new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[1]/ul/li[16]')
	private TestObject selectStartDateFilter(String startDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + startDate + "']")
	}
	private TestObject selectEndDateFilter(String endDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + endDate + "']")
	}
	private TestObject clickFirstDurationError = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div[1]/div[1]/span/input')
	private TestObject selectFirstTimeError = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[20]")
	private TestObject clickLastDurationError = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'root\']/div[2]/div/main/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div[1]/div[3]/span/input')
	private TestObject selectLastTimeError = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[3]/div/div/div/div[2]/div[1]/ul/li[19]")


	//Verify Message
	private TestObject txtConfirmSendRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Are you sure to send the request?']")
	private TestObject txtConfirmSendSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Request was successfully sent']")
	private TestObject txtDateRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[text()='Date is required']")
	private TestObject txtOvertimeDurationRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class,'text-danger') and contains(text(),'time start is required')]")
	private TestObject txtNoteRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[contains(@class,'text-red-500') and text()='Note is required']")
	private TestObject txtEmployeeRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[contains(@class,'text-red-500') and text()='Employees is required']")
	private TestObject txtMemberRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[contains(@class,'text-red-500') and text()='Member is required']")
	private TestObject txtBigFileError = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(),'File size exceeds maximum limit 5 MB.')]")
	private TestObject txtDetailOverTime = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h1[text()='Overtime Detail']")
	private TestObject txtMessageErrorDuration = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@class='text-danger text-sm mt-1' and normalize-space(text())='Ended time must be more than start time']")


	//Upload File
	private TestObject uploadFile = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')


	def menuService() {
		WebUI.click(clickMenuServices)
	}

	def menuAttendance() {
		WebUI.click(clickMenuAttendance)
	}

	def menuSubmission() {
		WebUI.click(clickMenuSubmission)
	}

	def menuOvertime() {
		WebUI.click(clickMenuOvertime)
	}

	def verifyLblOvertime() {
		WebUI.verifyElementPresent(lblOvertime, 5)
	}

	def btnRequest() {
		WebUI.click(clickBtnRequest)
	}

	def fieldDate() {
		WebUI.click(selectDate)
		WebUI.click(selectValueDate)
	}

	def fieldDuration() {
		WebUI.click(clickFirstDuration)
		WebUI.click(selectFirstTime)
		WebUI.click(clickLastDuration)
		WebUI.click(selectLastTime)
		WebUI.click(clickTitle)
	}

	def fieldDurationError() {
		WebUI.click(clickFirstDurationError)
		WebUI.click(selectFirstTimeError)
		WebUI.click(clickLastDurationError)
		WebUI.click(selectLastTimeError)
	}

	def fieldNote(String note) {
		WebUI.setText(inputNote, note)
	}

	def fieldUpload(String upload) {
		WebUI.uploadFile(uploadFile, upload)
	}

	def fieldEmployee(String employee) {
		WebUI.setText(inputEmployee, employee)
		WebUI.click(clickValueEmployee)
	}

	def fieldNotifyEmployee(String notify) {
		WebUI.setText(inputSearchNotifyEmployee, notify)
		WebUI.click(clickValueNotifyEmployee)
	}

	def btnSubmit() {
		WebUI.click(clickBtnSubmit)
	}

	def ConfirmSendRequest() {
		WebUI.verifyElementText(txtConfirmSendRequest, "Are you sure to send the request?")
		WebUI.click(btnOk)
	}

	def ConfirmSendSuccess() {
		WebUI.verifyElementText(txtConfirmSendSuccess, "Request was successfully sent")
		WebUI.click(btnOk)
		WebUI.verifyElementText(lblOvertime, "Overtime")
	}

	def verifyAllField() {
		WebUI.verifyElementText(txtDateRequired, "Date is required")
		WebUI.verifyElementText(txtOvertimeDurationRequired, "time start is required, time end is required")
		WebUI.verifyElementText(txtNoteRequired, "Note is required")
		WebUI.verifyElementText(txtEmployeeRequired, "Employees is required")
		WebUI.verifyElementText(txtMemberRequired, "Member is required")
	}

	def verifyNoteRequired() {
		WebUI.verifyElementText(txtNoteRequired, "Note is required")
	}

	def verifyTxtBigFileError() {
		WebUI.verifyElementText(txtBigFileError, "File size exceeds maximum limit 5 MB.")
		WebUI.click(btnOk)
	}

	def verifyTxtMessageErrorDuration() {
		WebUI.verifyElementPresent(txtMessageErrorDuration, 3)
	}

	def dataDetail() {
		WebUI.click(openDataDetail)
		WebUI.verifyElementText(txtDetailOverTime, "Overtime Detail")
		WebUI.click(clickFileDownload)
	}

	def search(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}

	def filterSuccess(String startDate, String endDate) {
		WebUI.click(clickBtnFilter)
		WebUI.click(selectStatus)
		WebUI.click(selectValueStatus)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		WebUI.click(clickBtnApply)
	}

	def resetFilter(String startDate, String endDate) {
		WebUI.click(clickBtnFilter)
		WebUI.click(selectStatus)
		WebUI.click(selectValueStatus)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		WebUI.click(clickBtnApply)
		WebUI.click(clickBtnFilter)
		WebUI.click(clickBtnReset)
		WebUI.click(clickBtnApply)
	}

	def Overtime() {
		menuService()
		menuAttendance()
		menuSubmission()
		menuOvertime()
		verifyLblOvertime()
	}
}