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

public class WorkExitPermitPageSubmission {

	//Button Menu
	private TestObject clickMenuServices = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
	private TestObject clickWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[5]/li')
	private TestObject lblWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Work Exit Permit']")
	private TestObject lblWorkExitPermitRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Work Exit Permit Request']")
	private TestObject openDataDetail = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h3[contains(text(), 'Submission Status')]/following-sibling::div//span[contains(., 'Waiting For Approval')]")


	//Input
	private TestObject inputNote = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'Note\']')
	private TestObject inputDateRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[1]/div/input')
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")


	//Button
	private TestObject clickBtnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div[2]/a')
	private TestObject clickBtnSubmit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-primary') and normalize-space()='Submit']")
	private TestObject btnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'swal2-confirm') and normalize-space()='OK']")
	private TestObject btnDownload = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div/div[1]/div/div/div[6]/div/div')
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject clickBtnSubmitFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'btn-primary') and text()='Submit']")
	private TestObject clickBtnResetFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[normalize-space(text())='Reset' and contains(@class,'btn-primary')]")


	//Select Option
	private TestObject selectFieldCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div/select')
	private TestObject selectFieldValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div/div/div[5]')
	private TestObject selectFirstDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[2]/div/div[1]/span/input')
	private TestObject selectValueHoursFirstDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[19]')
	private TestObject selectValueMinutesFirstDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[8]')

	private TestObject selectSecondDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[2]/div/div[2]/span/input')
	private TestObject selectValueHoursSecondDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[1]/ul/li[22]')
	private TestObject selectValueMinutesSecondDuration = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[2]/ul/li[6]')

	private TestObject selectSelectMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div/select')
	private TestObject selectValueSelectMember = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div/div/div[6]')
	
	private TestObject selectStatus = new TestObject().addProperty("xpath", ConditionType.EQUALS, "((//select)[1])/parent::div[contains(@class, 'cursor-pointer')]")
	private TestObject selectValueStatus = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Waiting for Approval') and contains(@class, 'cursor-pointer')]")
	private TestObject selectCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "((//select)[2])/parent::div[contains(@class, 'cursor-pointer')]")
	private TestObject selectValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Keperluan Keluarga') and contains(@class, 'cursor-pointer')]")
	
	private TestObject selectFirstDurationError = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[2]/div/div[1]/span/input')
	private TestObject selectValueHoursFirstDurationError = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[22]')
	private TestObject selectValueMinutesFirstDurationError = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[2]/div/div/div/div[2]/div[2]/ul/li[8]')
	 
	private TestObject selectSecondDurationError = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[2]/div/div[2]/span/input')
	private TestObject selectValueHoursSecondDurationError = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[1]/ul/li[20]')
	private TestObject selectValueMinutesSecondDurationError = new TestObject().addProperty("xpath", ConditionType.EQUALS, '/html/body/div[3]/div/div/div/div[2]/div[2]/ul/li[6]')
	
	
	//Select Date
	private TestObject selectValueDate = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[27]')
	private TestObject inputDateRange = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//input[@placeholder='DD-MM-YYYY - DD-MM-YYYY']"
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
	private TestObject txtCategoryRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[normalize-space(text())='Category is required']")
	private TestObject txtDateRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[normalize-space(text())='Start date is required']")
	private TestObject txtStartDateRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[normalize-space(text())='Start time is required']")
	private TestObject txtEndDateRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[normalize-space(text())='End time is required']")
	private TestObject txtNoteRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[normalize-space(text())='Note is required']")
	private TestObject txtMemberRequired = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[normalize-space(text())='Notify at least one']")
	private TestObject txtEndTimeLaterThanStartTime = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space(text())='End time must be later than start time']")

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

	def menuWorkExitPermit() {
		WebUI.click(clickWorkExitPermit)
		WebUI.verifyElementPresent(lblWorkExitPermit, 3)
	}

	def btnRequest() {
		WebUI.click(clickBtnRequest)
	}

	def fieldCategory() {
		WebUI.click(selectFieldCategory)
		WebUI.click(selectFieldValueCategory)
	}

	def fieldDate() {
		WebUI.click(inputDateRequest)
		WebUI.click(selectValueDate)
	}

	def fieldDurationValid() {
		WebUI.click(selectFirstDuration)
		WebUI.click(selectValueHoursFirstDuration)
		WebUI.click(selectValueMinutesFirstDuration)
		WebUI.click(selectSecondDuration)
		WebUI.click(selectValueHoursSecondDuration)
		WebUI.click(selectValueMinutesSecondDuration)
		WebUI.click(lblWorkExitPermitRequest)
	}
	
	def fieldDurationError() {
		WebUI.click(selectFirstDurationError)
		WebUI.click(selectValueHoursFirstDurationError)
		WebUI.click(selectValueMinutesFirstDurationError)
		WebUI.click(selectSecondDurationError)
		WebUI.click(selectValueHoursSecondDurationError)
		WebUI.click(selectValueMinutesSecondDurationError)
	}

	def fieldNote(String note) {
		WebUI.setText(inputNote, note)
	}

	def fieldUpload(String upload) {
		WebUI.uploadFile(uploadFile, upload)
	}

	def fieldMember() {
		WebUI.click(selectSelectMember)
		WebUI.click(selectValueSelectMember)
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
		WebUI.verifyElementText(lblWorkExitPermit, "Work Exit Permit")
	}

	def viewDetail() {
		WebUI.click(openDataDetail)
		WebUI.click(btnDownload)
	}
	
	def verifyTxtEndTimeLaterThanStartTime() {
		WebUI.verifyElementPresent(txtEndTimeLaterThanStartTime, 3)
	}
	
	def verifyTxtBigFileError() {
		WebUI.verifyElementText(txtBigFileError, "File size exceeds maximum limit 5 MB.")
		WebUI.click(btnOk)
	}
	
	def verifyNoteRequired() {
		WebUI.verifyElementText(txtNoteRequired, "Note is required")
	}
	
	def verifyAllField() {
		WebUI.verifyElementText(txtCategoryRequired, "Category is required")
		WebUI.verifyElementText(txtDateRequired, "Start date is required")
		WebUI.verifyElementText(txtStartDateRequired, "Start time is required")
		WebUI.verifyElementText(txtEndDateRequired, "End time is required")
		WebUI.verifyElementText(txtNoteRequired, "Note is required")
		WebUI.verifyElementText(txtMemberRequired, "Notify at least one")
	}

	def search(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}
	
	def filterSuccess(String startDate, String endDate) {
		WebUI.click(clickBtnFilter)
		WebUI.click(selectStatus)
		WebUI.click(selectValueStatus)
		WebUI.click(selectCategory)
		WebUI.click(selectValueCategory)
		WebUI.click(inputDateRange)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
	}
	
	def btnSubmitFilter() {
		WebUI.click(clickBtnSubmitFilter)
	}
	
	def resetFilter(String startDate, String endDate) {
		WebUI.click(clickBtnFilter)
		WebUI.click(selectStatus)
		WebUI.click(selectValueStatus)
		WebUI.click(selectCategory)
		WebUI.click(selectValueCategory)
		WebUI.click(inputDateRange)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		btnSubmitFilter()
		WebUI.click(clickBtnFilter)
		WebUI.click(clickBtnResetFilter)
	}
	
	def workExitPermit() {
		menuService()
		menuAttendance()
		menuSubmission()
		menuWorkExitPermit()
	}
}
