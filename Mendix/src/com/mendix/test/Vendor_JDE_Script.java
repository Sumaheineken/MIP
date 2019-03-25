package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mendix.tool.SharedDriver;
import com.mendix.util.DataProviderUtil.staticProviderClass;
import com.mendix.page.VendorPage;

public class Vendor_JDE_Script {


	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE_Local_Purchasing(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{

		//		SharedDriver.pageContainer.vendorPage.clickLocalAction();
//		SharedDriver.pageContainer.vendorPage.disableBankData();
		SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
		SharedDriver.pageContainer.vendor_JDE_Page.clickAddPlantData();
		SharedDriver.pageContainer.vendor_JDE_Page.selectingAdjustmentSchedule(dataMap.get("Adjustment Schedule"));
		//SharedDriver.pageContainer.vendor_JDE_Page.selectselectSendMethod("3, Email");
		SharedDriver.pageContainer.vendor_JDE_Page.selectingSendMethod(dataMap.get("Send Method"));
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();


	}

	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE_Local_Finance(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{

		SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
		SharedDriver.pageContainer.vendor_JDE_Page.clickFinancetab();
		SharedDriver.pageContainer.vendor_JDE_Page.clickAddFinanceData();
		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment1();
		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment3();
		SharedDriver.pageContainer.vendor_JDE_Page.selectABAmountCurrency();
		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentTerms();
		SharedDriver.pageContainer.vendor_JDE_Page.selectTaxRateArea();
		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentCreation();
		SharedDriver.pageContainer.vendor_JDE_Page.selectHoldPayment();
		SharedDriver.pageContainer.vendor_JDE_Page.selectGlClass();
		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment2();
		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment4();
		SharedDriver.pageContainer.vendor_JDE_Page.selectDefaultCurrency();
		SharedDriver.pageContainer.vendor_JDE_Page.selectTaxExplCode();
		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentMethods();
		SharedDriver.pageContainer.vendor_JDE_Page.selectBankBearer();
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		//		SharedDriver.pageContainer.materialNavPage.clickLocalAction();
		SharedDriver.pageContainer.materialNavPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.vendorPage.duplicateCheck();
		SharedDriver.pageContainer.vendorPage.getRequestId_Vendor();
//		SharedDriver.pageContainer.materialPage.getRequestId_Create();

	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_LDS(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.materialPage.switchToPopup();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
//		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendor_JDE_Page.scrollToCommentsNew();
		SharedDriver.pageContainer.vendor_JDE_Page.clickCommentNew();
		SharedDriver.pageContainer.vendor_JDE_Page.clickCommentsArea();
		SharedDriver.pageContainer.vendor_JDE_Page.enterCommentsArea();
		SharedDriver.pageContainer.vendor_JDE_Page.clickSaveComments();
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendor_JDE_Page.rejectLocalBtnClick();
		SharedDriver.pageContainer.vendor_JDE_Page.submitRequestOkBtnClick();

	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_Discard_LDR(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.materialPage.switchToPopup();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendorPage.discardLocalButtonClick();
		SharedDriver.pageContainer.vendor_JDE_Page.submitRequestOkBtnClick();
		

	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_Bank_Local(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{

		
		SharedDriver.pageContainer.vendor_JDE_Page.enterBankData();
		SharedDriver.pageContainer.vendor_JDE_Page.clickNewBankButton();
		SharedDriver.pageContainer.vendor_JDE_Page.selectBankCountry();
		SharedDriver.pageContainer.vendor_JDE_Page.clickBankKey();
		SharedDriver.pageContainer.vendor_JDE_Page.selectBankKey();
		SharedDriver.pageContainer.vendor_JDE_Page.clickSelectBankKey();
		SharedDriver.pageContainer.vendor_JDE_Page.selectCurrencyCode();
		SharedDriver.pageContainer.vendor_JDE_Page.selectPartnerBankType();
		SharedDriver.pageContainer.vendor_JDE_Page.clickSaveBankDetails();
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
		SharedDriver.pageContainer.vendorPage.submitBankRequestTest();
		

	}
     @Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	
	public void Vendor_Extend_Create_Fill_In_Data_JDE_Local_Purchasing(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{

		SharedDriver.pageContainer.vendor_JDE_Page.localAddInNewPurchasingJDE();
		//SharedDriver.pageContainer.vendor_JDE_Page.selectingAdjustmentSchedule(dataMap.get("Adjustment Schedule"));
		SharedDriver.pageContainer.vendor_JDE_Page.selectAdjustmentSchedule();
		SharedDriver.pageContainer.vendor_JDE_Page.selectSendMethod();
		//SharedDriver.pageContainer.vendor_JDE_Page.selectingSendMethod(dataMap.get("Send Method"));
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
	}
     
     @Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
 	public void Vendor_Extend_Create_Fill_In_Data_JDE_Local_Finance(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
 	{
 		//SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
 		SharedDriver.pageContainer.vendor_JDE_Page.clickFinancetab();
 		SharedDriver.pageContainer.vendor_JDE_Page.localAddInNewFinanceJDE();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment1();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment3();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectABAmountCurrency();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentTerms();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectTaxRateArea();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentCreation();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectHoldPayment();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectGlClass();			
 		/*SharedDriver.pageContainer.vendor_JDE_Page.selectingABAmountCurrency(dataMap.get("A/B Amount Currency"));	
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingPaymentTerms(dataMap.get("Payment Terms"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingTaxRateArea(dataMap.get("Text Rate Area"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingPaymentCreation(dataMap.get("Payment creation"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingHoldPayment(dataMap.get("Hold Payment"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingGLClass(dataMap.get("GL Class"));*/
 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment2();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment4();	
 		SharedDriver.pageContainer.vendor_JDE_Page.selectDefaultCurrency();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectTaxExplCode();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentMethods();
 		SharedDriver.pageContainer.vendor_JDE_Page.selectBankBearer();
 		/*SharedDriver.pageContainer.vendor_JDE_Page.selectingDefaultCurrency(dataMap.get("Default Currency"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingTaxEplCode(dataMap.get("Tax EPL Code"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingPaymentMethod(dataMap.get("Payment Metods"));
 		SharedDriver.pageContainer.vendor_JDE_Page.selectingBankBearer(dataMap.get("Bank Bearer"));*/
 		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
 		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();

 	}



	
	

}

