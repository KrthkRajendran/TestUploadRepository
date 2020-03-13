package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import base.TestBase;

public class TestUtil extends TestBase {
	public static Properties prop;
	private static FileInputStream fisProp;
	private static FileInputStream fisExcel;
	private static Sheet sheet;

	public static void init() {
//		Initiating Logger
//		initLogs()
//		Initiating Properties File
		initProperties();

//		initiating WorkBook
		initWebDriver();

//		initiating Excel Sheet
		initWorkbook();

//		Set currentValue for Execution
//		setCurrentExecValue();

//		Open DB Connection
//		DBConn.open();

//		startMob();

	}

	public static void initProperties() {
		String Path = System.getProperty("user.dir") + "//src//test//resources//properties//config.properties";
		prop = new Properties();
		try {
			fisProp = new FileInputStream(Path);
			prop.load(fisProp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void initWorkbook() {
		String TestData = System.getProperty("user.dir")+ "\\src\\test\\resources\\excel\\TestData.xlsx";
		try {
			fisExcel = new FileInputStream(TestData);
			Workbook book = WorkbookFactory.create(fisExcel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void initWebDriver() {
		
	}
	
	
	
	

}
