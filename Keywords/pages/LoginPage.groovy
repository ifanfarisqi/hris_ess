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

public class LoginPage {

	private TestObject inputEmail = new TestObject().addProperty("id", ConditionType.EQUALS, 'email')
	private TestObject inputPassword = new TestObject().addProperty("id", ConditionType.EQUALS, 'password')
	private TestObject btnLogin = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[normalize-space()='Login']")
	private TestObject lblDashboard = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//*[@id='root']/div[2]/div/header/nav/div/div[1]/a/p")
	private TestObject txtErrorEmail = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='text-red-500' and normalize-space()='Email is required']")
	private TestObject txtErrorPassword = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='text-red-500' and normalize-space()='Password is required']")
	private TestObject txtErrorEmailNotRegistered = new TestObject().addProperty("xpath", ConditionType.EQUALS, '//*[@id="root"]/div[2]/div[2]/div[2]/form/div[3]/p')
	private TestObject txtErrorPasswordWrong = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@class='text-red-500' and normalize-space()='Invalid email or password']")

	def fieldEmail(String email) {
		WebUI.setText(inputEmail, email)
	}

	def fieldPassword(String password) {
		WebUI.setText(inputPassword, password)
	}

	def clickLogin() {
		WebUI.click(btnLogin)
	}

	def verifyLblDashboard() {
		WebUI.verifyElementPresent(lblDashboard, 25)
	}

	def verifyTxtErrorEmail(){
		WebUI.verifyElementPresent(txtErrorEmail, 5)
	}

	def verifyTxtErrorPassword() {
		WebUI.verifyElementPresent(txtErrorPassword, 5)
	}

	def verifyTxtPasswordWrong() {
		WebUI.verifyElementPresent(txtErrorPasswordWrong, 5)
	}

	def verifyTxtErrorEmailNotRegistered() {
		WebUI.verifyElementPresent(txtErrorEmailNotRegistered, 5)
	}

	def login(String email, String password) {
		fieldEmail(email)
		fieldPassword(password)
		clickLogin()
	}
}