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

public class MyAttendancePageSubmission {
	
	//Button Menu
	private TestObject clickMenuServices = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/button/div")
	private TestObject clickMenuAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/div")
	private TestObject clickMenuSubmission = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/div/div")
	private TestObject clickMenuMyAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div/header/nav/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/ul/a[6]/li')
	private TestObject lblMyAttendance = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//h1[normalize-space(text())='My Attendances']")
	
	
	//Select Option
	private TestObject selectFilterDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[text()='2025-07-21 - 2025-08-20']")
	private TestObject selectValueFilterDate = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//span[contains(@class,'block truncate font-normal')]")
	private TestObject selectFilterStatus = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class,'cursor-pointer') and .//select]")
	private TestObject selectValueFilterStatus = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class,'hover:bg-blue-50') and text()='Approved']")
	
	
	def filterStatus() {
		WebUI.click(selectFilterStatus)
		WebUI.click(selectValueFilterStatus)
	}
	
	def filterDateSuccess() {
		WebUI.click(selectFilterDate)
		WebUI.click(selectValueFilterDate)
	}
	
	def myAttendance() {
		WebUI.click(clickMenuServices)
		WebUI.click(clickMenuAttendance)
		WebUI.click(clickMenuSubmission)
		WebUI.click(clickMenuMyAttendance)
		WebUI.verifyElementPresent(lblMyAttendance, 5)
		WebUI.delay(3)
	}
}
