package com.mendix.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.ExcelUtil;

public class MaterialPage {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public MaterialPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Materials')]")
	WebElement textMaterial;

	@FindBy(how=How.XPATH, using="(//*[starts-with(text(),' Create')])[1]")
	WebElement menuCreate;

	@FindBy(how=How.XPATH, using="//span[contains(text(),'Production | Raw material, ingredient or processing aid')]")
	WebElement btnMaterialTypeSelect;

	@FindBy(how=How.XPATH, using=".//div[@class='mx-referenceselector-input-wrapper']/select")
	WebElement slctOpCo;

	@FindBy(how=How.XPATH, using="//*[@class='glyphicon glyphicon-forward']")
	WebElement btnCreate;

	@FindBy(how=How.XPATH, using="//*[text()='Local Data']")
	WebElement textLocalData;

	@FindBy(how=How.XPATH, using=".//*[@class='glyphicon glyphicon-flash']")
	WebElement	btnLocalActions;

	@FindBy(how=How.XPATH, using="//*[text()='Disable Local Request']")
	WebElement	btnDisableLocalRequest;

	@FindBy(how=How.XPATH, using="//*[text()='Proceed']")
	WebElement	btnProceed;

	@FindBy(how=How.XPATH, using="(.//*[@class='glyphicon glyphicon-edit'])[1]")
	WebElement	btnEditDesc;

	@FindBy(how=How.CSS, using ="div[id^='mxui_widget_TextInput_'][class*='col-sm-8'] :nth-child(1)")
	WebElement txtboxDesc;


	@FindBy(how=How.CSS, using ="button[id^='mxui_widget_ActionButton'][class='btn mx-button mx-name-actionButton1 editableByCondition btn-success']")
	WebElement btnMaterialDescSave;

	@FindBy(how=How.XPATH, using="//*[text()='Material Group']/../div/button/span")
	WebElement btnMaterialGrpselection;

	@FindBy(how=How.XPATH, using=".//*[@id='mxui_widget_SearchInput_0']/div[2]/input")
	WebElement txtboxMaterialGrpSearch;

	@FindBy(how=How.XPATH, using="//button[text()='Search']")
	WebElement btnMaterialGrpSearch;

	@FindBy(how=How.XPATH, using="(//div[contains(text(),'CMG')]/../../../../../../table[2]/tbody/tr[1]/td/div)[1]")
	WebElement txtCMGSelect;

	@FindBy(how=How.XPATH, using="//button[text()='Select']")
	WebElement btnMaterialGroupSelect;

	@FindBy(how=How.XPATH, using="//*[text()='Gross Weight Base UoM']/../div/input")
	WebElement txtBoxGrossWeightUOM;

	@FindBy(how=How.XPATH, using="//*[text()='Unit of Weight']/../div/button/span")
	WebElement btnUnitofWeight;

	@FindBy(how=How.XPATH, using="//label[text()='Commercial Unit']/../../div[2]/input")
	WebElement txtboxUnitofWeightInput;

	@FindBy(how=How.XPATH, using="//button[text()='Search']")
	WebElement btnUnitofWeightSearch;

	@FindBy(how=How.XPATH, using="//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")
	WebElement txtUnitofWeightDisplay;

	@FindBy(how=How.XPATH, using="(.//*[@class='mx-grid-toolbar'])[19]/button[1]")
	WebElement btnUnitofWeightSelect;

	@FindBy(how=How.XPATH, using="//*[text()='Base UoM']/../div/button/span")
	WebElement btnBaseUOMSelection;

	@FindBy(how=How.XPATH, using="//label[text()='Commercial Unit']/../../div[2]/input")
	WebElement txtboxBaseUOM;

	@FindBy(how=How.XPATH, using="//button[text()='Search']")
	WebElement btnBaseUOMSearch;


	@FindBy(how=How.XPATH, using="//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")
	WebElement txtBaseUOMDisplay;

	@FindBy(how=How.XPATH, using="(.//*[@class='mx-grid-toolbar'])[19]/button[1]")
	WebElement btnBaseUOMSelect;

	@FindBy(how=How.XPATH, using="//*[text()='Net Weight Base UoM']/../div/input")
	WebElement txtboxNetWeight;

	@FindBy(how=How.CSS, using="select[id^='mxui_widget_ReferenceSelector_28_input'][class='form-control']")
	WebElement slctUOMPrimary;


	@FindBy(how=How.XPATH, using="//div[@class='mx-placeholder']/button")
	WebElement btnlocalAction;

	@FindBy(how=How.XPATH, using=".//*[text()='Request complies to all Validations']")
	WebElement txtValidationMsg;

	
	//**********************************Global Actions*****************************************************************
	
	@FindBy(how=How.XPATH, using=".//button[text()='Submit Global Request']")
	WebElement btnGlobalRequest;
	
	@FindBy(how=How.XPATH, using=".//button[text()='Save As Draft']")
	WebElement btnSaveAsDraft;
	
	@FindBy(how=How.XPATH, using="//*[text()='Validate']")
	WebElement btnValidate;
	
	@FindBy(how=How.XPATH, using="//*[text()='Duplicate Check']")
	WebElement btnDuplicateCheck;
	
	@FindBy(how=How.XPATH, using="//*[text()='Reject Global Request']")
	WebElement btnRejectGlobalRequest;
	
	@FindBy(how=How.XPATH, using="//*[text()='Discard Create']")
	WebElement btnDiscardCreate;
	
	
	//*************************************************************************************************
	@FindBy(how=How.XPATH, using=".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")
	WebElement msgRequestSuccess;
	
	@FindBy(how=How.XPATH, using="//*[text()='No matches / possible duplicates have been found.']")
	WebElement msgDuplicateInfo;
	
	@FindBy(how=How.XPATH, using="//*[text()='OK']")
	WebElement btnOK;
	
	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;
	
//	@FindBy(how=How.XPATH, using="(.//*[text()='New'])[4]")
	@FindBy(how=How.XPATH, using="(.//*[starts-with(@id,'uniqName') And text()='New'])[4]")
	WebElement btnCommentNew;
	
	@FindBy(how=How.XPATH, using="(.//*[starts-with(@id,'mxui_widget_TextArea')])[4]")
	WebElement textComment;
	
	@FindBy(how=How.XPATH, using="//*[text()='Save']")
	WebElement btnSave;
	

	@FindBy(how=How.XPATH, using="//*[text()='Request ID']/../../td[4]/div/input")
	WebElement txtboxReqIdEnter;
	
	@FindBy(how=How.XPATH, using="(//*[starts-with(text(),' Dashboard')])[1]")
	WebElement menuMaterialDashboard;


	@FindBy(how=How.XPATH, using="//*[@class='glyphicon glyphicon-plus']")
	WebElement btnAdvancedSearch;

	@FindBy(how=How.XPATH, using="//button[text()='Search']")
	WebElement btnReqIdEnter;

	@FindBy(how=How.XPATH, using="//*[text()='Created On']/../../td[4]/div/div/div/input")
	WebElement txtboxCreateOnEnter;

	@FindBy(how=How.XPATH, using="//button[text()='Get Full Material Data']")
	WebElement btnFullMaterailData;
			
	/**
	 * Enter UserName.
	 * Enter Password
	 * 
	 * Click Login
	 *
	 * @param strMenuName the str menu name
	 * @return true, if successful
	 */
	/*	public boolean LoginPage(String strPageName){
		//Click Search Icon
		Sync.waitUntilObjectDisappears(driver, "Loading Indicator", By.xpath("//span[.='L�DT']/preceding-sibling::img"));
		Sync.waitForSeconds(Constants.WAIT_1);
		if(Button.verifyObject(btnLogin)){
			Sync.waitForObject(driver ,"Jobs", btnLogin);
			Button.NewmouseOver("Jobs", driver, btnLogin);

			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click(strPageName, Sync.waitForObject(driver, strPageName, By.xpath("//a[normalize-space(.)='"+strPageName+"']")));
		}else{
			return Button.click(strPageName, Sync.waitForObject(driver, strPageName, By.xpath("//a[normalize-space(.)='"+strPageName+"']")));
		}

	}*/

	public void  switchToPopup()
			throws InterruptedException {
		String mainWindowHandl = driver.getWindowHandle();
		//Switch to child window and close it

		for (String childWindowHandle : driver.getWindowHandles()) {
			//If window handle is not main window handle then close it 
			if(!childWindowHandle.equals(mainWindowHandl)){
				driver.switchTo().window(childWindowHandle);

			}
		} 
		Sync.waitForObject(driver, textMaterial);
		Sync.waitUntilObjectDisappears(driver, "Loading Indicator", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

		driver.manage().window().maximize();
		
		
	}
	
	public boolean clickMaterial(String strPageName) throws InterruptedException{
	Sync.waitForSeconds(Constants.WAIT_6);
	if(Button.verifyObject(textMaterial)){
		Sync.waitForObject(driver ,"Materials", textMaterial);
		Button.NewmouseOver("Materials", driver, textMaterial);

		Sync.waitForSeconds(Constants.WAIT_1);		
		return Button.click(strPageName, Sync.waitForObject(driver, strPageName, By.xpath("//a[normalize-space(.)='"+strPageName+"']")));
	}else{
		Sync.waitForObject(driver ,"Materials", textMaterial);
		return Button.click(strPageName, Sync.waitForObject(driver, strPageName, By.xpath("//a[normalize-space(.)='"+strPageName+"']")));
	}
	}

	public boolean createMaterialNavigate() throws InterruptedException {

		if(Button.verifyObject(menuCreate)){
			Sync.waitForObject(driver ,"Create", menuCreate);
			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click("Create", menuCreate);
		}else{
			return Button.click("Create", menuCreate);
		}
	}

	public boolean materialTypeSelection() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_6);
		if(Button.verifyObject(btnMaterialTypeSelect)){
			Sync.waitForObject(driver ,"Material Type Select", btnMaterialTypeSelect);
			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click("Material Type Select", btnMaterialTypeSelect);
		}else{
			return Button.click("Material Type Selection", btnMaterialTypeSelect);
		}
	}

	public boolean createButtonClick() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_2);
		if(Button.verifyObject(btnCreate)){
			Sync.waitForObject(driver ,"Create Button Click", btnCreate);
			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click("Create Button Click", btnCreate);
		}else{
			return Button.click("Create Button Click", btnCreate);
		}
		
	}

	public boolean disableLocaData() {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		Button.click("Local Data", textLocalData);
		Button.click("Local Actions button", btnLocalActions);
		Button.click("Disable Local Request", btnDisableLocalRequest);
		return Button.click("Proceed", btnProceed);
	}
	
	public void Localactionbutton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnLocalActions);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
	}

	public boolean materialDescCreate(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_6);
		Button.jsclick("Edit Description button Click", btnEditDesc, driver);
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, txtboxDesc);
		Button.mouseClick(driver, "Click Material Desc Field", txtboxDesc);
		Textbox.enterValue("Enter Material Desc", txtboxDesc, strValue);
		return Button.click("Material Description Save", btnMaterialDescSave);
	}

	public boolean materialGrpSelectionTest(String strValue) throws InterruptedException {

		try{
			System.out.println("No Error Popup");
		}catch(Exception e){
			Thread.sleep(4000);
			Sync.waitForObject(driver, btnOK);
			Button.click("Click On Ok on Error Popup", btnOK);		
		}
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.jsclick("Click Material Group Selection button", btnMaterialGrpselection, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Textbox.click("Enter Material Group", txtboxMaterialGrpSearch);
		Textbox.clear("Enter Material Group", txtboxMaterialGrpSearch);
		Textbox.enterValue("Enter Material Group", txtboxMaterialGrpSearch, strValue);
		Button.click("Click Search Button", btnMaterialGrpSearch);
		Button.click("Click CMG Search result", txtCMGSelect);
		Sync.waitForSeconds(Constants.WAIT_1);
		return Button.click("Click Material Group Select", btnMaterialGroupSelect);

	}

	public boolean grossWeightEntestTest(String strValue) {

		Sync.waitForSeconds(Constants.WAIT_2);
		Textbox.click("Click Gross Weight Base UOM", txtBoxGrossWeightUOM);
		//		driver.findElement(By.xpath("//*[text()='Gross Weight Base UoM']/../div/input")).click();
		Sync.waitForSeconds(Constants.WAIT_1);
		return Textbox.enterValue("Enter Gross Weight Base UOM", txtBoxGrossWeightUOM, strValue);

		//		driver.findElement(By.xpath("//*[text()='Gross Weight Base UoM']/../div/input")).sendKeys("1");
		//		return false;
	}

	public boolean unitOfWeightSelectionTest(String strValue) throws InterruptedException {
		//		Thread.sleep(1000);

		Sync.waitForSeconds(Constants.WAIT_1);

		Button.click("Click Unit of Weight selecction button", btnUnitofWeight);
		//		driver.findElement(By.xpath("//*[text()='Unit of Weight']/../div/button/span")).click();

		Sync.waitForObject(driver, "Wait for UOM popup", txtboxUnitofWeightInput);
		//		WebDriverWait wait = new WebDriverWait(driver,30);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Commercial Unit']/../../div[2]/input")));


		Textbox.enterValue("Enter Unit of Weight", txtboxUnitofWeightInput, strValue);
		//		driver.findElement(By.xpath("//label[text()='Commercial Unit']/../../div[2]/input")).sendKeys("KG");

		Button.click("Click Search Unit of Weight button", btnUnitofWeightSearch);
		//		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Sync.waitForSeconds(Constants.WAIT_2);
		//		Thread.sleep(2000);

		//		Button.click("Click Display Value", txtUnitofWeightDisplay);
		driver.findElement(By.xpath("//*[text()='"+strValue+"']")).click();
		//		driver.findElement(By.xpath("//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")).click();
		return Button.click("Click Unit of Weight Select button", btnUnitofWeightSelect);
		//		driver.findElement(By.xpath("(.//*[@class='mx-grid-toolbar'])[19]/button[1]")).click();

	}

	public boolean baseUOMSelectionTest(String strValue) throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_1);
	
		Button.click("Click Base UOM selection button", btnBaseUOMSelection);
	
		Sync.waitForSeconds(Constants.WAIT_1);
	
		Textbox.enterValue("Enter Base UOM", txtboxBaseUOM, strValue);
	
		Sync.waitForSeconds(Constants.WAIT_1);
	
		Button.click("Click Base UOM Search button", btnBaseUOMSearch);
	
		Sync.waitForSeconds(Constants.WAIT_1);
	
		Button.click("Click Base UOM Display", txtBaseUOMDisplay);
	
		Sync.waitForSeconds(Constants.WAIT_1);
	
		return Button.click("Click Base UOM select button", btnBaseUOMSelect);
	
	}


	public boolean netWeightEnterTest(String strValue) throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_1);

		Button.click("Click Net Weight Enter TextBox", txtboxNetWeight);

		return Textbox.enterValue("Enter Net Weight", txtboxNetWeight, strValue);
	}

	public void uomPrimarySelectionTest() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_2);
		Select dropdownUOM= new Select(slctUOMPrimary);
		Sync.waitForSeconds(Constants.WAIT_2);
		dropdownUOM.selectByIndex(1);
	}

	public boolean validateTestCreate() {

		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForSeconds(Constants.WAIT_1);
		return Button.click("Click Validate", btnValidate);

	}
	
	public void DuplicateCheck() {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Click Duplicate check", btnDuplicateCheck);
		//click on popup No matches / possible duplicates have been found.
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On Ok on duplicate check info popup", btnOK);
		
						
	}

	
	public void RejectGDA() throws InterruptedException, AWTException {

		System.out.println("Scrolling action");

		Thread.sleep(3000);
		System.out.println("Scrolling");
		String test = driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).getText();
		driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).click();
		System.out.println(test);
		Thread.sleep(2000);		
		
		Robot robot = new Robot();  // Robot class throws AWT Exception	
        Thread.sleep(4000); // Thread.sleep throws InterruptedException	
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_DOWN);
        
        Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
	
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
        
		Sync.waitForObject(driver, btnCommentNew);
		Thread.sleep(5000);
		System.out.println("checking for new button");
		
		String text1=driver.findElement(By.xpath(".//*[@id='mxui_widget_NumberInput_3']/p")).getText();
		System.out.println(text1);
		String text2=driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")).getText();
		System.out.println(text2);
		
		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")).click();
		
		System.out.println("clicked new button");
		Thread.sleep(2000);

		Textbox.enterValue("typing comment", textComment, "material data");
		Textbox.click("Click on Save Button", btnSave);
		Thread.sleep(2000);
		
		
		Button.click("Local Actions button click", btnLocalActions);
		Thread.sleep(2000);
		Sync.waitForObject(driver, btnRejectGlobalRequest);
		Textbox.click("Click on reject button in locl action", btnRejectGlobalRequest);
		Thread.sleep(3000);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Thread.sleep(2000);
	}
	
	public void DiscardCreateGDA() throws InterruptedException {

		Thread.sleep(6000);
		Button.click("Local Actions button click", btnLocalActions);
		Thread.sleep(2000);
		Sync.waitForObject(driver, btnDiscardCreate);
		Textbox.click("Click on reject button in locl action", btnDiscardCreate);
		Thread.sleep(4000);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Thread.sleep(2000);
	}

	public void submitGlobalRequestTest() throws InterruptedException {


		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Button.click("Click Global submit Global Request", btnGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}

	public  String getRequestId()
			throws InterruptedException, FileNotFoundException, IOException {
		
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);
		String reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		ExcelUtil.excelWrite(Id);
		System.out.println("Excel write is done");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, btnOK);
		
		Button.click("Click Ok Button", btnOK);
		return Id;
	}

	//***********************************************************************************
	
	public void SaveAsDraft() throws InterruptedException {


		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Button.click("Click Save as Draft", btnSaveAsDraft);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_6);
//		Sync.waitForObjectFluent(driver, element)
	}
		
	public  String getRequestId_draft()
			throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		String reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[13];
		System.out.println("RequestId is: " + Id);
		ExcelUtil.excelWrite(Id);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForElementToBeClickable(driver, btnMsgReqIdOk);
		Button.click("Click Ok Button", btnMsgReqIdOk);
		return Id;
	}

	
	public boolean navigateToDashboard() {

		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForObject(driver, "Wait until the Material appears", textMaterial);
		Button.click("Click Materials Menu", textMaterial);
		return Button.click("Click Dashboard Menu", menuMaterialDashboard);
	}

	public void advancedSearch() throws InterruptedException
	{

		TimeUnit.SECONDS.sleep(8);
		driver.switchTo().window("Application");
		TimeUnit.SECONDS.sleep(7);
		Button.click("Click Advanced Search", btnAdvancedSearch);
		TimeUnit.SECONDS.sleep(3);

	}

	public void scrolltoGlobalSearch() {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })");
	}

	public  void reqIdSearchGlobal(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_2);
		WebElement elementSearch=driver.findElement(By.xpath("//*[text()='Request ID']/../../td[4]/div/input"));
		Sync.waitForObject(driver, txtboxReqIdEnter);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		Textbox.clear("Clear TextBox Value", txtboxReqIdEnter);
		Textbox.enterValue("Enter TextBox Value", txtboxReqIdEnter, strValue);
		Textbox.enterValue("Enter TextBox Value", txtboxCreateOnEnter, dateFormatted);
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_2);	}

	public  String getGlobalId() throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Wait for Global Material Id", driver.findElement(By.xpath("//*[text()='Global Material ID']/../../../../../../table[2]/tbody/tr/td[4]/div")));
		String globalId=driver.findElement(By.xpath("//*[text()='Global Material ID']/../../../../../../table[2]/tbody/tr/td[4]/div")).getText();
		System.out.println(globalId);
		ExcelUtil.excelWriteGlobalId(globalId);;
		return globalId;
	}



	

}