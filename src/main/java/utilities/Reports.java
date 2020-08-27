package utilities;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@SuppressWarnings("deprecation")
public class Reports {

	public ExtentReports report;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlreport;

	@BeforeSuite(alwaysRun = true)
	public void intiateReports() {
		try {
			File file = new File(System.getProperty("user.dir") + "//Reports//SecureWatch.html");
			if (!file.exists()) {
				file.createNewFile();
			}
			htmlreport = new ExtentHtmlReporter(file);
			report = new ExtentReports();
			report.attachReporter(htmlreport);
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Environment", "QA Env");
			report.setSystemInfo("username", System.getProperty("user.name"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void flushReports() {
		report.flush();
	}

}
