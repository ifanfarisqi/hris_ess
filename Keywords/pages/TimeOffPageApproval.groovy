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

public class TimeOffPageApproval {

	//Button Menu
	private TestObject clickMenuService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuApproval = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/div/div')
	private TestObject clickMenuTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/ul/a[1]/li')
	private TestObject lblTimeOff = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Time Off Approval']")
	private TestObject dataDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div/div[1]/div')


	//Button
	private TestObject clickBtnApprove = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'bg-success') and text()='Approve']")
	private TestObject clickBtnSend = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-primary')]")
	private TestObject clickBtnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and contains(@class,'swal2-confirm') and contains(@class,'btn-primary')]")
	private TestObject clickBtnOkSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and contains(@class,'swal2-confirm') and normalize-space()='OK']")
	private TestObject clickBtnReject = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'bg-danger') and text()='Reject']")
	private TestObject clickBtnDownload = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[7]/div/div')
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject clickBtnSubmitFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'btn-primary') and text()='Submit']")
	private TestObject clickBtnReset = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'btn-primary') and normalize-space(text())='Reset']")
	private TestObject clickBtnEdit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class,'btn-primary-outline')]//p[normalize-space()='Edit']")
	private TestObject clickBtnSave = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-primary')]")


	//Select Date
	private TestObject inputDateRange = new TestObject('inputDateRange').addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYYY - DD-MM-YYYY']")
	private TestObject clickTglAwal = new TestObject('tglAwal').addProperty('xpath', ConditionType.EQUALS, "//button[@type='button' and normalize-space()='5']")
	private TestObject clickTglAkhir = new TestObject('tglAkhir').addProperty('xpath', ConditionType.EQUALS, "//button[@type='button' and normalize-space()='6']")


	//Input
	private TestObject inputNote = new TestObject().addProperty("id", ConditionType.EQUALS, "note")
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")
	private TestObject inputNoteEdit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Note']")


	//Select Option
	private TestObject selectStatusFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
	private TestObject selectValueStatusFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")
	private TestObject selectCategoryFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "((//select)[2])/parent::div[contains(@class, 'cursor-pointer')]")
	private TestObject selectValueCategoryFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Cuti Mendadak') and contains(@class, 'cursor-pointer')]")
	private TestObject selectCategory = new TestObject('categorySelect').addProperty('xpath', ConditionType.EQUALS, "//select[contains(@class,'flex-grow-1')]")
	private TestObject selectValueCategory = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[normalize-space()='Cuti Melahirkaan']")



	//Verify
	private TestObject txtApprove = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="swal2-html-container"]/div/div')
	private TestObject txtSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="swal2-html-container"]/div/div')
	private TestObject txtDataDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[contains(text(), 'Time Off Approval')]")
	private TestObject txtCategoryRequired = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(text(), 'Category is required')]")
	private TestObject txtNoteRequired = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(text(), 'Notes is required')]")


	def menuService() {
		WebUI.click(clickMenuService)
	}

	def MenuAttendance() {
		WebUI.click(clickMenuAttendance)
	}

	def MenuApproval() {
		WebUI.click(clickMenuApproval)
	}

	def MenuTimeOff() {
		WebUI.click(clickMenuTimeOff)
	}

	def verifyLblTimeOff() {
		WebUI.verifyElementPresent(lblTimeOff, 5)
	}


	def timeOffApprove(String note) {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnApprove)
		WebUI.setText(inputNote, note)
		WebUI.click(clickBtnSend)
	}

	def timeOffReject(String note) {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnReject)
		WebUI.setText(inputNote, note)
		WebUI.click(clickBtnSend)
	}

	def confirmModalVerify() {
		WebUI.verifyElementPresent(txtApprove, 3)
		WebUI.click(clickBtnOk)
	}

	def confirmModalSuccess() {
		WebUI.verifyElementPresent(txtSuccess, 3)
		WebUI.click(clickBtnOkSuccess)
		WebUI.verifyElementPresent(lblTimeOff, 5)
	}

	def detailDataTimeOff() {
		WebUI.click(dataDetail)
		WebUI.verifyElementPresent(txtDataDetail, 3)
		//WebUI.click(clickBtnDownload)
	}

	def searchValid(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}

	def btnFilter() {
		WebUI.click(clickBtnFilter)
	}

	def filterTimeOff() {
		WebUI.click(selectStatusFilter)
		WebUI.click(selectValueStatusFilter)
		WebUI.click(selectCategoryFilter)
		WebUI.click(selectValueCategoryFilter)
		WebUI.click(inputDateRange)
		WebUI.click(clickTglAwal)
		WebUI.click(clickTglAkhir)
	}

	def btnSubmit() {
		WebUI.click(clickBtnSubmitFilter)
	}

	def btnReset() {
		WebUI.click(clickBtnReset)
	}

	def editSuccess(String note) {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnEdit)
		WebUI.click(selectCategory)
		WebUI.click(selectValueCategory)
		WebUI.setText(inputNoteEdit, note)
		WebUI.click(clickBtnSave)
	}

	def editAllFieldEmpty() {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnEdit)
		WebUI.click(clickBtnSave)
		WebUI.verifyElementPresent(txtCategoryRequired, 3)
		WebUI.verifyElementPresent(txtNoteRequired, 3)
	}

	def editOneOfFieldEmpty() {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnEdit)
		WebUI.click(selectCategory)
		WebUI.click(selectValueCategory)
		WebUI.click(clickBtnSave)
		WebUI.verifyElementPresent(txtNoteRequired, 3)
	}


	def timeOffApproval() {
		menuService()
		MenuAttendance()
		MenuApproval()
		MenuTimeOff()
		verifyLblTimeOff()
	}
}
