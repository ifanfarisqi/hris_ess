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

public class ShiftChangePageApproval {
	
	//Button Menu
	private TestObject clickMenuService = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuApproval = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/div/div')
	private TestObject clickMenuShiftChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[3]/ul/a[4]/li')
	private TestObject lblShiftChange = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='Shift Change Approval']")
	private TestObject dataDetail = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[3]/div[1]/div')
	
	
	//Input
	private TestObject inputNote = new TestObject().addProperty("id", ConditionType.EQUALS, "note")
	private TestObject inputSearch = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='Search']")
	
	
	//Button
	private TestObject clickBtnApprove = new TestObject('btnApprove').addProperty('xpath', ConditionType.EQUALS, "//button[contains(., 'Approve')]")
	private TestObject clickBtnReject = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button/span[text()='Reject']")
	private TestObject clickBtnSend = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit']")
	private TestObject clickBtnOkSuccess = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and contains(@class,'swal2-confirm') and normalize-space()='OK']")
	private TestObject clickBtnDownload = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/main/div[2]/div[2]/div/div[1]/div/div[7]/div/div')
	private TestObject clickBtnFilter = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/main/div[2]/div[2]/div[1]/button")
	private TestObject clickBtnApply = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='submit' and contains(@class, 'btn-primary') and text()='Apply']")
	private TestObject clickBtnReset = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@type='button' and text()='Reset']")
	
	
	//Select Option
	private TestObject selectStatusFilter = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(@class, 'cursor-pointer') and .//select]")
	private TestObject selectValueStatusFilter = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[contains(text(), 'Approved') and contains(@class, 'cursor-pointer')]")
	
	
	//Select Date
	private TestObject selectDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@placeholder='YYYY-MM-DD - YYYY-MM-DD']")
	private TestObject selectStartDateFilter(String startDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + startDate + "']")
	}
	private TestObject selectEndDateFilter(String endDate) {
		return new TestObject("dayButton").addProperty("xpath", ConditionType.EQUALS, "//button[text()='" + endDate + "']")
	}
	
	
	//Verify
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

	def menuShiftChange() {
		WebUI.click(clickMenuShiftChange)
	}

	def verifyLblShiftChange() {
		WebUI.click(lblShiftChange)
	}
	
	
	def detail() {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnDownload)
	}
	
	def shiftChangeApprove(String note) {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnApprove)
		WebUI.setText(inputNote, note)
		WebUI.click(clickBtnSend)
	}
	
	def search(String keywords) {
		WebUI.setText(inputSearch, keywords)
	}
	
	def shiftChangeReject(String note) {
		WebUI.click(dataDetail)
		WebUI.click(clickBtnReject)
		WebUI.click(inputNote, note)
		WebUI.click(clickBtnSend)
	}
	
	def confirmModalSuccess() {
		WebUI.verifyElementPresent(txtSuccess, 3)
		WebUI.click(clickBtnOkSuccess)
		WebUI.verifyElementPresent(lblShiftChange, 5)
	}
	
	def btnFilter() {
		WebUI.click(clickBtnFilter)
	}
	
	def filter(String startDate, String endDate) {
		WebUI.click(selectStatusFilter)
		WebUI.click(selectValueStatusFilter)
		WebUI.click(selectDate)
		WebUI.click(selectStartDateFilter(startDate))
		WebUI.click(selectEndDateFilter(endDate))
	}
	
	def btnApply() {
		WebUI.click(clickBtnApply)
	}
	
	def btnReset() {
		WebUI.click(clickBtnReset)
	}
	
	def shiftChangeApproval() {
		menuService()
		menuAttendance()
		menuApproval()
		menuShiftChange()
		verifyLblShiftChange()
	}
}
