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

public class WorkExitPermitPageApproval {
	
	//Button Menu
	private TestObject clickMenuService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuApproval = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/div/div')
	private TestObject clickMenuWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/ul/a[5]/li')
	private TestObject lblWorkExitPermit = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Work Exit Permit Approval']")
	private TestObject dataDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div[1]/div')
	
	
	//Button
	private TestObject clickBtnDownload = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[6]/div/div')
	private TestObject clickBtnApprove = new TestObject('btnApprove').addProperty('xpath', ConditionType.EQUALS, "//button[contains(., 'Approve')]")
	private TestObject clickBtnReject = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button/span[text()='Reject']")
	private TestObject clickBtnSend = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit']")
	private TestObject clickBtnOk = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and contains(@class,'swal2-confirm') and contains(@class,'btn-primary')]")
	private TestObject clickBtnOkSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and contains(@class,'swal2-confirm') and normalize-space()='OK']")
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject clickBtnReset = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[contains(@class, 'btn-primary') and contains(@class, 'bg-gray-300') and text()='Reset']")
	private TestObject clickBtnSubmitFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[text()='Submit']")
	
	
	
	//Input
	private TestObject inputNote = new TestObject().addProperty("id", ConditionType.EQUALS, "note")
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")
	
	
	
	
	//Select Date
	private TestObject selectDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='DD-MM-YYYY - DD-MM-YYYY']")
	private TestObject selectStartDateFilter(String startDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + startDate + "']")
	}
	private TestObject selectEndDateFilter(String endDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + endDate + "']")
	}
	
	
	//Select Option
	private TestObject selectStatusFilter = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
	private TestObject selectValueStatusFilter = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")
	private TestObject selectCategoryFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "((//select)[2])/parent::div[contains(@class, 'cursor-pointer')]")
	private TestObject selectValueCategoryFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(text(), 'Keperluan Keluarga') and contains(@class, 'cursor-pointer')]")
	
	
	//Verify
	private TestObject txtApprove = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="swal2-html-container"]/div/div')
	private TestObject txtSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="swal2-html-container"]/div/div')
	
	
	
	
	def menuService() {
		WebUI.click(clickMenuService)
	}

	def menuAttendance() {
		WebUI.click(clickMenuAttendance)
	}

	def menuApproval() {
		WebUI.click(clickMenuApproval)
	}

	def menuWorkExitPermit() {
		WebUI.click(clickMenuWorkExitPermit)
	}

	def verifyLblWorkExitPermit() {
		WebUI.click(lblWorkExitPermit)
	}
	
	def workExitPermit() {
		menuService()
		menuAttendance()
		menuApproval()
		menuWorkExitPermit()
		verifyLblWorkExitPermit()
	}
	
	def workExitPermitApprove(String note) {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnApprove)
		WebUI.setText(inputNote, note)
		WebUI.click(clickBtnSend)
	}
	
	def workExitPermitReject(String note) {
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
		WebUI.verifyElementPresent(lblWorkExitPermit, 5)
	}
	
	
	def detail() {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnDownload)
	}
	
	def search(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}
	
	def btnFilter() {
		WebUI.click(clickBtnFilter)
	}
	
	def filter(String startDate, String endDate) {
		WebUI.click(selectStatusFilter)
		WebUI.click(selectValueStatusFilter)
		WebUI.click(selectCategoryFilter)
		WebUI.click(selectValueCategoryFilter)
		WebUI.click(selectDate)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
	}
	
	def btnSubmit() {
		WebUI.click(clickBtnSubmitFilter)
	}
	
	def btnReset() {
		WebUI.click(clickBtnReset)
	}
}
