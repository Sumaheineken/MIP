package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.DataProviderUtil.staticProviderClass;

public class VendorScript {
	
	WebDriver driver;

	@Test
	public void Vendor_Create_Fill_In_Questionnaire() throws InterruptedException
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.vendorPage.clickVendor();
		SharedDriver.pageContainer.vendorPage.createVendorNavigate();
		SharedDriver.pageContainer.vendorPage.VendorTypeSelection();
		SharedDriver.pageContainer.vendorPage.createButtonClick();
	}
	


	@Test(dataProvider="Vendor_Create_Global_Disable_BankData",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Data_Global_Nav(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		//SharedDriver.pageContainer.vendorPage.disableLocaData();
		//Sync.waitForSeconds(Constants.WAIT_10);
		SharedDriver.pageContainer.vendorPage.disableBankData();
		SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
		SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
		SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
		SharedDriver.pageContainer.vendorPage.AddresPostalCode("2551"); //dataMap.get("Postal Code")
		SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
		SharedDriver.pageContainer.vendorPage.ScrollDown();
		//'DropDowns
		SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
		SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
		SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
		SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
		SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
		SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
		SharedDriver.pageContainer.vendorPage.validateTestCreate();
		SharedDriver.pageContainer.materialPage.duplicateCheckButton();
		SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
		//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
//		SharedDriver.pageContainer.vendorPage.getRequestId();
				
	}

/****************************************************************************************************/	

	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		SharedDriver.pageContainer.vendorPage.disableLocaData();
		Sync.waitForSeconds(Constants.WAIT_10);
		SharedDriver.pageContainer.vendorPage.disableBankData();
		SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
		SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
		SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
		SharedDriver.pageContainer.vendorPage.AddresPostalCode("2551"); //dataMap.get("Postal Code")
		SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
		SharedDriver.pageContainer.vendorPage.ScrollDown();
		//'DropDowns
		SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
		SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
		SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
		SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
		SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
		SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
		SharedDriver.pageContainer.vendorPage.validateTestCreate();
		SharedDriver.pageContainer.materialPage.duplicateCheckButton();
		SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
		//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.vendorPage.getRequestId();
				
	}
	
	
	/****************************************************************************************************/	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		/*SharedDriver.pageContainer.vendorPage.disableLocaData();
		SharedDriver.pageContainer.vendorPage.disableBankData();*/
		SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
		SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
		SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
		SharedDriver.pageContainer.vendorPage.AddresPostalCode("255121"); //dataMap.get("Postal Code")
		SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
		SharedDriver.pageContainer.vendorPage.ScrollDown();
		//'DropDowns
		SharedDriver.pageContainer.vendorPage.AddresCountry("SG, Singapore"); //dataMap.get("Country")
		SharedDriver.pageContainer.vendorPage.AddresRegion("SG, Singapore");  //dataMap.get("Region")
		SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
		
		SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
		SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
		SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendorPage.validateTestCreate();
		
		/*SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.vendorPage.getRequestId();*/
				
	}
	/****************************************************************************************************/
	@Test(dataProvider="Vendor_Create_Global_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE_Bank(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		
		SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
		SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
		SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
		SharedDriver.pageContainer.vendorPage.AddresPostalCode("2551"); //dataMap.get("Postal Code")
		SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
		SharedDriver.pageContainer.vendorPage.ScrollDown();
		//'DropDowns
		SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
		SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
		SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
		
		SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
		SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
		SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
		SharedDriver.pageContainer.vendorPage.validateTestCreate();
		
		SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.vendorPage.getRequestId();
	}
		

	
	
	
	

/****************************************************************************************************/
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_SavaASDraft(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		SharedDriver.pageContainer.vendorPage.disableLocaData();
		SharedDriver.pageContainer.vendorPage.disableBankData();
		SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
		SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
		SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
		SharedDriver.pageContainer.vendorPage.AddresPostalCode("2551"); //dataMap.get("Postal Code")
		SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
		SharedDriver.pageContainer.vendorPage.ScrollDown();
		//'DropDowns
		SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
		SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
		SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
		SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
		SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
		SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
		SharedDriver.pageContainer.vendorPage.validateTestCreate();
		
		SharedDriver.pageContainer.vendorPage.SaveAsDraft();
		SharedDriver.pageContainer.vendorPage.getRequestId_Draft();
		SharedDriver.pageContainer.processInfoPage.browserClose();
				
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_in_Data_Save_as_Draft_Submit (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.processInfoPage.processInfoSearch();
		SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.Localactionbutton();
		SharedDriver.pageContainer.vendorPage.validateTestCreate();
		SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.vendorPage.submitRequestPopup();
		
	}
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		
		SharedDriver.pageContainer.processInfoPage.processInfoSearch();
		SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.browserClose();
	}
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Approve_GDA(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
		SharedDriver.pageContainer.vendorPage.duplicateCheck();
	
	}
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_GDA(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.RejectGDA();
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_LDP(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.RejectGDA();
		SharedDriver.pageContainer.vendorPage.getRequestId_Flag_For_Deletion();
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

		
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Vendor_Rejections_with_Discard  (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		try{
		System.out.println("Start:Create_Vendor_Rejections_with_Discard");

		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.DiscardCreateLDR();
		
		System.out.println("End:Create_Vendor_Rejections_with_Discard-Done");
		
	}catch(Exception e){
		
		System.out.println("Create_vendor_Rejections_with_Discard is not completed");
		driver.close();
	}
	}
	
/****************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Syndication_Check_SAP (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.vendorPage.navigateToDashboard();
		SharedDriver.pageContainer.vendorPage.advancedSearch();		
		SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("Global_ID"));
		SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();		
		SharedDriver.pageContainer.vendorPage.getVendorAccountNumber();
		SharedDriver.pageContainer.processInfoPage.browserClose();
	}
	

	
	
	@Test
	public void launchUFT_SAP_Vendor() throws IOException, InterruptedException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTSAPVendor();
	}
	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Syndication_Check_NAV (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.vendorPage.navigateToDashboard();
		SharedDriver.pageContainer.vendorPage.advancedSearch();
		//SharedDriver.pageContainer.vendorPage.scrolltoGlobalSearch();
		SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("Global_ID"));
		SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
		//SharedDriver.pageContainer.vendorPage.getGlobalId();
		//SharedDriver.pageContainer.vendorPage.GetFullVendorData();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.vendorPage.getVendorAccountNumber();
		SharedDriver.pageContainer.processInfoPage.browserClose();
	}
	@Test
	public void launchUFT_NAV_Vendor() throws IOException, InterruptedException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFT_NAV_Vendor();
	}

	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Syndication_Check (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.vendorPage.navigateToDashboard();
		SharedDriver.pageContainer.vendorPage.advancedSearch();
		//SharedDriver.pageContainer.vendorPage.scrolltoGlobalSearch();
		SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("Global_ID"));
		SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
		//SharedDriver.pageContainer.vendorPage.getGlobalId();
		//SharedDriver.pageContainer.vendorPage.GetFullVendorData();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.vendorPage.getVendorAccountNumber();
		SharedDriver.pageContainer.processInfoPage.browserClose();
		//Thread.sleep(1200000);
		//SharedDriver.pageContainer.materialApprovalPage.launchUFTJDEVendor();
	}

	@Test
	public void launchUFT_JDE() throws IOException, InterruptedException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTJDEVendor();
	}

	
/****************************************************************************************************/	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_Discard (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		System.out.println("Start:Process_Information_Check_Discard");
	try{
		SharedDriver.pageContainer.processInfoPage.processInfoSearch();
		SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.ValidateStateDiscarded(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.browserClose();
		System.out.println("Process_Information_Check_Discard-Done");
		
	}catch(Exception e){
		
		System.out.println("Process_Information_Check_Discard is not completed");
		driver.close();
	}
				
	}
	
/****************************************************************************************************/	
	@Test
	public void Vendor_Change_DashBoard() throws InterruptedException
	{
		System.out.println("test");
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.vendorPage.clickVendor();
		SharedDriver.pageContainer.vendorPage.clickVendorDashboard();
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_DashBoard_SearchWith_GlobalID(Map<String,String> dataMap) throws InterruptedException
	{
		SharedDriver.pageContainer.vendorPage.SearchGlobalID(dataMap.get("Global_Id"));
		SharedDriver.pageContainer.vendorPage.GetFullVendorData();
		SharedDriver.pageContainer.vendorPage.EditVendorData();
	}
/************************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_DashBoard_SearchWith_GlobalID_EDit_GlobalLocal(Map<String,String> dataMap) throws InterruptedException
	{
		SharedDriver.pageContainer.materialPage.globalSearch(dataMap.get("Global_ID"));
		SharedDriver.pageContainer.vendorPage.GetFullVendorData();
		SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
		SharedDriver.pageContainer.vendorPage.EditVendorDataGlobalLocal();
		SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
	}
/************************************************************************************************************/
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		/*SharedDriver.pageContainer.vendorPage.disableLocaData();
		SharedDriver.pageContainer.vendorPage.disableBankData();*/
		SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
		SharedDriver.pageContainer.vendorPage.AddressStreet("Change Hauptstrasse");//dataMap.get("Street")
		SharedDriver.pageContainer.vendorPage.AddresHouseNumber("12"); //dataMap.get("House number")
		SharedDriver.pageContainer.vendorPage.AddresPostalCode("3551"); //dataMap.get("Postal Code")
		SharedDriver.pageContainer.vendorPage.AddresCity("Change Enzesfeld");
		SharedDriver.pageContainer.vendorPage.ScrollDown();
		//'DropDowns
		SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
		SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
		SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
		SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("201536819");
		SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
		SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-RAW, PR-Raw Materials");
		SharedDriver.pageContainer.vendorPage.BtnLocalActions();
		SharedDriver.pageContainer.vendorPage.validateTestCreate();		
		SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.vendorPage.getRequestId();
				
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Extend_Dashboard_Check(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.vendorPage.GetFullVendorData();	
	SharedDriver.pageContainer.vendorPage.clickExtendButton();
	SharedDriver.pageContainer.vendorPage.clickGlobalDataButton();
	SharedDriver.pageContainer.vendorPage.clickToConfirm();
	SharedDriver.pageContainer.vendorPage.clickConfirmExtension();
	SharedDriver.pageContainer.vendorPage.clickOkToHandlePopup();
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Happy_Flag_Deletion(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("GlobalId"));	
	SharedDriver.pageContainer.vendorPage.clickflagDeletion();
	SharedDriver.pageContainer.vendorPage.clickOk();
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Global_LockCheck(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	/*SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.vendorPage.GetFullVendorData();
	SharedDriver.pageContainer.vendorPage.getGlobalIdNew();
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();*/
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.vendorPage.checkGlobalIdYes();
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.vendorPage.checkGlobalIdYes();
	
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Global_Data_Approve_LBDA(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.materialPage.switchToPopup();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
		Sync.waitForSeconds(Constants.WAIT_10);
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.materialPage.browserClose();

	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Global_Data_Reject_LBDA(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.materialPage.switchToPopup();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.rejectLBDAVendor();
		Sync.waitForSeconds(Constants.WAIT_10);
		SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.materialPage.browserClose();
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Confirm_Extension_Nav(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException
	{
		SharedDriver.pageContainer.vendorPageNAV.switchToGlobal();
		SharedDriver.pageContainer.materialPage.clickLocalAction();
		SharedDriver.pageContainer.vendorPage.clickConfirmExtension();
		SharedDriver.pageContainer.vendorPage.getRequestId();
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}
	
	/**********************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Extend_Global_Nav_With_Rejections(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	//SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("Global_ID"));
	//SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.materialPage.globalSearch(dataMap.get("Global_ID"));
	SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
	SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
	SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
	SharedDriver.pageContainer.vendorPage.clickExtendButton();
	}
	
	/*******************************************************************************************************************************/
	
	@Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Local_Finance_Tab(Map<String,String> dataMap) throws InterruptedException
	{
		SharedDriver.pageContainer.materialNavPage.switchToLocal();
		SharedDriver.pageContainer.vendorPageNAV.localAddInNewFinanceNav();
		SharedDriver.pageContainer.vendorPageNAV.clickAndSelectVendorPostingGroupDropDown(dataMap.get("Vendor Posting Group"));
		SharedDriver.pageContainer.vendorPageNAV.clickAndSelectVATBusPostingGroupDropDown(dataMap.get("VAT Bus. Posting Group"));
		SharedDriver.pageContainer.vendorPageNAV.validateAndSaveLocalData();
	}

	/*********************************************************************************************************************************/
	
	@Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Local_Purchasing_Tab(Map<String,String> dataMap) throws InterruptedException
	{
		SharedDriver.pageContainer.vendorPageNAV.localAddInPurchasingNav();
		SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentTCDropDown(dataMap.get("Payment Terms Code"));
		SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentMCDropDown(dataMap.get("Payment Method Code"));
		SharedDriver.pageContainer.vendorPageNAV.validateAndSaveLocalData();
	}

	/***************************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Local_Data_Approve_LDS(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.materialApprovalPage.approvalBtnClickLocalLDS();
		Sync.waitForSeconds(Constants.WAIT_5);
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}
	
/***********************************************************************************************************************************/
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Reject_Resubmit_LDR(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException
	{
		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		//SharedDriver.pageContainer.vendorPage.validateTestCreate();		
		SharedDriver.pageContainer.vendorPage.clickResubmitGlobalRequest();
		SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		
	}
	/*****************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Extend_Global_Sap_With_Rejections(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	//SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("Global_ID"));
	//SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
	SharedDriver.pageContainer.materialPage.globalSearch(dataMap.get("Global_ID"));
	SharedDriver.pageContainer.vendorPage.GetFullVendorData();	
	SharedDriver.pageContainer.vendorPage.clickExtendButton();
	//SharedDriver.pageContainer.vendorPage.clickGlobalDataButton();
	SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
	//SharedDriver.pageContainer.vendorPage.clickToConfirm();
	SharedDriver.pageContainer.materialPage.clickLocalAction();
	SharedDriver.pageContainer.vendorPage.clickConfirmExtension();
	SharedDriver.pageContainer.vendorPage.getRequestId();
	SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}
	
	/*****************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Happy_Flag_Deletion_Nav(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.homePage.navigateToWorkflow();
	SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
	SharedDriver.pageContainer.vendorPage.navigateToDashboard();
	SharedDriver.pageContainer.vendorPage.advancedSearch();
	SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("Global_ID"));	
	SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
	SharedDriver.pageContainer.vendorPage.clickflagDeletion();
	SharedDriver.pageContainer.vendorPage.clickLocalAction();
	SharedDriver.pageContainer.vendorPage.clickConfirmFlagForDeletionButton();	
	SharedDriver.pageContainer.vendorPage.getRequestId_Flag_For_Deletion();
	SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}
	
	public void Create_Vendor_Rejections_with_Discard_Extension  (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		try{
		System.out.println("Start:Create_Vendor_Rejections_with_Discard");

		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.vendorPage.DiscardExtensionLDR();
		
		System.out.println("End:Create_Vendor_Rejections_with_Discard-Done");
		
	}catch(Exception e){
		
		System.out.println("Create_vendor_Rejections_with_Discard is not completed");
		driver.close();
	}
	}
		@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
		public void Create_Vendor_Resubmit_Request  (Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
		{
			try{
			System.out.println("Start:Create_Vendor_Rejections_with_Discard");

			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.vendorPage.resubmitLocalRequest();
			
			System.out.println("End:Create_Vendor_Rejections_with_Discard-Done");
			
		}catch(Exception e){
			
			System.out.println("Create_vendor_Rejections_with_Discard is not completed");
			driver.close();
		}
			
	
}
		
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Extend_Global_JDE(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
     {
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
			SharedDriver.pageContainer.vendorPage.advancedSearch();
			//SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("Global_ID"));
			//SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
			SharedDriver.pageContainer.materialPage.globalSearch(dataMap.get("Global_ID"));
			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();	
			SharedDriver.pageContainer.vendorPage.clickExtendButton();
			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();	
     }
		
}

