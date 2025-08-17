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

public class TimeOffPage {

	//Button Menu
	private TestObject clickMenuServices = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
	private TestObject clickMenuTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[1]/li")
	private TestObject lblTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Time Off']")
	private TestObject clickDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[3]/div/div[1]/div")

	//Input
	private TestObject inputNote = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")
	private TestObject inputSearchMember = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div/div/div[2]/input")
	TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")


	//Button
	private TestObject btnRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[normalize-space()='Request']")
	private TestObject btnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'swal2-confirm') and normalize-space()='OK']")
	private TestObject btnSubmit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[normalize-space()='Submit']")
	private TestObject btnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject btnSubmitFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[text()='Submit']")
	private TestObject btnResetFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[text()='Reset']")


	//Select Option
	private TestObject selectCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div")
	private TestObject selectValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[1]/div/div/div/div[7]")
	private TestObject selectReplacementEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[2]/div")
	private TestObject selectValueReplacementEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[2]/div/div/div[6]")
	private TestObject selectValueMember = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div/div/div[3]")
	private TestObject clickFieldMember = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[3]/div[2]/div[1]/div")
	private TestObject selectFilterStatus = new TestObject().addProperty("xpath", ConditionType.EQUALS, "((//select)[1])/parent::div[contains(@class, 'cursor-pointer')]")
	private TestObject selectFilterValueStatus = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Waiting for Approval') and contains(@class, 'cursor-pointer')]")
	private TestObject selectFilterCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "((//select)[2])/parent::div[contains(@class, 'cursor-pointer')]")
	private TestObject selectFilterValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Cuti Khitan/Baptis Anak') and contains(@class, 'cursor-pointer')]")


	//Select Date
	private TestObject selectPastDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[12]')
	private TestObject clickRadioButtonMultipleDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[1]/div/button[2]/div[1]")
	private TestObject clickFieldDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/input")
	private TestObject selectStartMultipleDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/button[30]")
	private TestObject selectEndMultipleDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/button[31]")
	private TestObject clickFieldDateFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYYY - DD-MM-YYYY']")
	private TestObject selectStartDateFilter(String startDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + startDate + "']")
	}
	private TestObject selectEndDateFilter(String endDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + endDate + "']")
	}


	//Verify Message
	private TestObject txtConfirmSendRequest = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Are you sure to send the request?']")
	private TestObject txtConfirmSendSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Request was successfully sent']")
	private TestObject txtErrorFieldCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[text()='Category is required']")
	private TestObject txtErrorFieldReplacementEmployee = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[text()='Replacement is required']")
	private TestObject txtErrorStartDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[text()='Start date is required']")
	private TestObject txtErrorEndDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[text()='End date is required']")
	private TestObject txtErrorFieldNote = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[text()='Note is required']")
	private TestObject txtErrorFieldMember = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[text()='Notify at least one']")
	private TestObject lblDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[text()='Detail Time Off']")
	private TestObject txtErrorPastDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space(text())='Pengajuan cuti melebihi batas waktu pengajuan']")


	//Upload File
	private TestObject uploadFile = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")


	def menuServices() {
		WebUI.click(clickMenuServices)
	}

	def menuAttendance() {
		WebUI.click(clickMenuAttendance)
	}

	def menuSubmission() {
		WebUI.click(clickMenuSubmission)
	}

	def menuTimeOff() {
		WebUI.click(clickMenuTimeOff)
	}

	def verifyLblTimeOff() {
		WebUI.verifyElementText(lblTimeOff, "Time Off")
	}

	def clickRequest() {
		WebUI.click(btnRequest)
	}

	def clickCategory() {
		WebUI.click(selectCategory)
		WebUI.delay(0.5)
		WebUI.click(selectValueCategory)
	}

	def clickReplacementEmployee() {
		WebUI.click(selectReplacementEmployee)
		WebUI.delay(0.5)
		WebUI.click(selectValueReplacementEmployee)
	}

	def radioButtonMultipleDate() {
		WebUI.click(clickRadioButtonMultipleDate)
	}

	def fieldDate() {
		WebUI.click(clickFieldDate)
		WebUI.click(selectStartMultipleDate)
		WebUI.click(selectEndMultipleDate)
	}

	def fieldDatePast() {
		WebUI.click(clickFieldDate)
		WebUI.click(selectPastDate)
	}

	def fieldNote(String note) {
		WebUI.setText(inputNote, note)
	}

	def fieldUpload(String upload) {
		WebUI.uploadFile(uploadFile, upload)
	}

	def fieldMember(String keywordSearch) {
		WebUI.click(clickFieldMember)
		WebUI.delay(0.5)
		WebUI.setText(inputSearchMember, keywordSearch)
		WebUI.click(selectValueMember)
	}

	def clickSubmit() {
		WebUI.click(btnSubmit)
	}

	def ConfirmSendRequest() {
		WebUI.verifyElementText(txtConfirmSendRequest, "Are you sure to send the request?")
		WebUI.click(btnOk)
	}

	def ConfirmSendSuccess() {
		WebUI.verifyElementText(txtConfirmSendSuccess, "Request was successfully sent")
		WebUI.click(btnOk)
		WebUI.verifyElementText(lblTimeOff, "Time Off")
	}

	def verifyTxtErrorFieldCategory() {
		WebUI.verifyElementPresent(txtErrorFieldCategory, 3)
	}

	def verifyTxtErrorFieldReplacementEmployee() {
		WebUI.verifyElementPresent(txtErrorFieldReplacementEmployee, 3)
	}

	def verifyFieldDate() {
		WebUI.verifyElementPresent(txtErrorStartDate, 3)
		WebUI.verifyElementPresent(txtErrorEndDate, 3)
	}

	def verifyTxtErrorFieldNote() {
		WebUI.verifyElementPresent(txtErrorFieldNote, 3)
	}

	def verifyTxtErrorFieldMember() {
		WebUI.verifyElementPresent(txtErrorFieldMember, 3)
	}

	def verifyTxtErrorPastDate() {
		WebUI.delay(1)
		WebUI.verifyElementPresent(txtErrorPastDate, 3)
		WebUI.click(btnOk)
	}

	def viewDetail() {
		WebUI.click(clickDetail)
		WebUI.verifyElementPresent(lblDetail, 3)
	}

	def fieldSearch(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}

	def filter(String startDate, String endDate) {
		WebUI.click(btnFilter)
		WebUI.click(selectFilterStatus)
		WebUI.click(selectFilterValueStatus)
		WebUI.click(selectFilterCategory)
		WebUI.click(selectFilterValueCategory)
		WebUI.click(clickFieldDateFilter)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		WebUI.click(btnSubmitFilter)
	}

	def resetFilter(String startDate, String endDate) {
		WebUI.click(btnFilter)
		WebUI.click(selectFilterStatus)
		WebUI.click(selectFilterValueStatus)
		WebUI.click(selectFilterCategory)
		WebUI.click(selectFilterValueCategory)
		WebUI.click(clickFieldDateFilter)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
		WebUI.click(btnSubmitFilter)
		WebUI.click(btnFilter)
		WebUI.click(btnResetFilter)
	}

	def timeOff() {
		menuServices()
		menuAttendance()
		menuSubmission()
		menuTimeOff()
		verifyLblTimeOff()
	}
}
