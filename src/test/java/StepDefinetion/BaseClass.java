package StepDefinetion;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.IncubyteAccountPage;
import PageObject.Sign_inPage;
import TestRunner.ReadConfig;

public class BaseClass {

	public static  WebDriver driver;
	public static Logger log;
	public static IncubyteAccountPage Account;
	public static Sign_inPage Sign;
	public ReadConfig readConfig;
}
