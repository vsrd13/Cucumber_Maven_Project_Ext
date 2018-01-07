package com.cucumber.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ResultSheetHelper {
	public static int RowNo = 1;
	public static int ScenarioNo = 1;
	protected static WritableWorkbook resultWritebook;
	protected static WritableSheet resultWriteSheet;
	public String NewFileNamePath;
	public static Date TestEndDate;
	public static String NewTime;
	public static String StartTime;

	protected WritableSheet addLables() throws IOException, Exception {

		File dir = new File(".//");
		if (resultWriteSheet == null) {
			String DataTime = xGetDateTime();
			File fileExisting = new File(dir.getCanonicalPath() + "\\Results" + "\\Cucumber_TestResults" + ".xls");
			if (fileExisting.exists()) {
				Path RSource = Paths.get(dir.getCanonicalPath() + "\\Results" + "\\Cucumber_TestResults" + ".xls");
				Path RTarget = Paths
						.get(dir.getCanonicalPath() + "\\Results" + "\\Cucumber_TestResults" + DataTime + ".xls");
				Files.copy(RSource, RTarget);
			}
			resultWritebook = Workbook
					.createWorkbook(new File(dir.getCanonicalPath() + "\\Results" + "\\Cucumber_TestResults.xls"));
			resultWriteSheet = resultWritebook.createSheet("Results", 0);
			resultWriteSheet.addCell(new Label(0, 0, "TestCaseID", xFillCell(Colour.AQUA)));
			resultWriteSheet.addCell(new Label(1, 0, "Scenario Name", xFillCell(Colour.GRAY_50)));
			resultWriteSheet.addCell(new Label(2, 0, "Steps", xFillCell(Colour.GRAY_50)));
			resultWriteSheet.addCell(new Label(3, 0, "Status", xFillCell(Colour.GRAY_50)));
			resultWriteSheet.addCell(new Label(4, 0, "ActualResult", xFillCell(Colour.GRAY_50)));
			resultWriteSheet.addCell(new Label(5, 0, "ExpectedResult", xFillCell(Colour.GRAY_50)));
			/*
			 * resultWriteSheet.addCell(new Label(5, 0, "Snapshot",
			 * xFillCell(Colour.GRAY_50))); resultWriteSheet.addCell(new
			 * Label(6, 0, "Start Time", xFillCell(Colour.YELLOW2)));
			 * resultWriteSheet.addCell(new Label(7, 0, "End Time",
			 * xFillCell(Colour.YELLOW2))); resultWriteSheet.addCell(new
			 * Label(8, 0, "Total Time", xFillCell(Colour.YELLOW2)));
			 */
		}
		return resultWriteSheet;
	}

	public void resultwriteScenario(String ScenarioName, String StepName) throws Exception {
		RowNo = RowNo + 1;
		ScenarioNo = ScenarioNo + 1;
		resultWriteSheet.addCell(new Label(0, RowNo - 1, String.valueOf(ScenarioNo - 1)));
		resultWriteSheet.addCell(new Label(1, RowNo - 1, ScenarioName));
		resultWriteSheet.addCell(new Label(2, RowNo, StepName));
		resultWriteSheet.addCell(new Label(3, RowNo, "Pass", xFillCell(Colour.GREEN)));

	}

	public void resultwriteScenarioFail(String ScenarioName, String StepName, String ActualResult,
			String ExpectedResult) throws Exception {
		RowNo = RowNo + 1;
		ScenarioNo = ScenarioNo + 1;
		resultWriteSheet.addCell(new Label(0, RowNo - 1, String.valueOf(ScenarioNo - 1)));
		resultWriteSheet.addCell(new Label(1, RowNo - 1, ScenarioName));
		resultWriteSheet.addCell(new Label(2, RowNo, StepName));
		resultWriteSheet.addCell(new Label(3, RowNo, "Fail", xFillCell(Colour.RED)));
		resultWriteSheet.addCell(new Label(4, RowNo, ActualResult));
		resultWriteSheet.addCell(new Label(5, RowNo, ExpectedResult));

		// resultWriteSheet.addCell(new Label(4, RowNo, object));
		/*
		 * File scrFile = ((TakesScreenshot)
		 * aDriver).getScreenshotAs(OutputType.FILE); String FilePath =
		 * xRandomTimeStampName(MethodName); FileUtils.copyFile(scrFile, new
		 * File(FilePath)); WritableHyperlink hyperlink = new
		 * WritableHyperlink(5, RowNo, new File(FilePath), MethodName);
		 * resultWriteSheet.addHyperlink(hyperlink);
		 */
	}

	public void resultwriteStepsPass(String StepName) throws RowsExceededException, WriteException {
		RowNo = RowNo + 1;
		resultWriteSheet.addCell(new Label(2, RowNo, StepName));
		resultWriteSheet.addCell(new Label(3, RowNo, "Pass", xFillCell(Colour.GREEN)));
	}

	public void resultwriteStepsFail(String StepName, String ActualResult, String ExpectedResult) throws Exception {
		RowNo = RowNo + 1;
		resultWriteSheet.addCell(new Label(2, RowNo, StepName));
		resultWriteSheet.addCell(new Label(3, RowNo, "Fail", xFillCell(Colour.RED)));
		resultWriteSheet.addCell(new Label(4, RowNo, ActualResult));
		resultWriteSheet.addCell(new Label(5, RowNo, ExpectedResult));

	}

	public String xRandomTimeStampName(String MethodName) throws Exception {

		File directory = new File(".//");
		DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy__hh_mm_ssaa");
		Date date = new Date();
		InetAddress ownIP = InetAddress.getLocalHost();
		NewFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\" + MethodName + "_" + dateFormat.format(date)
				+ "_" + ownIP.getHostAddress() + ".png";
		return NewFileNamePath;
	}

	/**
	 * Get Date Time Sec stamp
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static String RND() throws Exception {
		String DTStamp = (((new Date()).getMonth()) + 1) + ((new Date()).getDate()) + ((new Date()).getYear()) + ""
				+ ((new Date()).getHours()) + ((new Date()).getMinutes()) + ((new Date()).getSeconds());
		return (DTStamp);
	}

	public void xResultwritesendmail() throws Exception {
		String EndTime = xGetCurrentTime();
		String TotalTime = xTotalExecutionTime(StartTime, EndTime);
		resultWriteSheet.addCell(new Label(7, 1, EndTime));
		resultWriteSheet.addCell(new Label(8, 1, TotalTime));
		autoResizeColumns();
		resultWritebook.write();
		resultWritebook.close();
		sendMail();
	}

	public void xResultstartTime() throws Exception {
		StartTime = xGetCurrentTime();
		resultWriteSheet.addCell(new Label(6, 1, StartTime));
	}

	public void sendMail() throws Exception {
		File directory = new File(".//");
		String MainFolder = directory.getCanonicalPath();
		// Print(MethodName);
		try {
			Runtime.getRuntime().exec("wscript.exe " + directory.getCanonicalPath() + "\\sendemail.vbs " + MainFolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String xTotalExecutionTime(String StartTime, String EndTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(StartTime);
		Date date2 = format.parse(EndTime);
		String strDate1 = format.format(date1);
		String strDate2 = format.format(date2);
		if (strDate2.split(":")[0].contains("00") && (!strDate1.split(":")[0].contains("00"))) {
			String endtime24 = strDate2.split(":")[0].replace("00", "24");
			String formatdatenew = endtime24 + ":" + strDate2.split(":")[1] + ":" + strDate2.split(":")[2];
			TestEndDate = format.parse(formatdatenew);
		} else {
			TestEndDate = format.parse(strDate2);
		}
		long difference = TestEndDate.getTime() - date1.getTime();
		long diffSeconds = difference / 1000 % 60;
		long diffMin = difference / (60 * 1000) % 60;
		long diffHours = difference / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);
		String TotalTime = diffHours + ":" + diffMin + ":" + diffSeconds;
		return (TotalTime);
	}

	public static WritableCellFormat xFillCell(Colour colour) throws WriteException {
		WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 12);
		WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setBackground(colour);
		return cellFormat;
	}

	// Get date time
	public java.lang.String xGetDateTime() throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaadd_MMM_yyyy");
		// get current date time with Date()
		Date date = new Date();
		return (dateFormat.format(date));
	}

	public java.lang.String xGetCurrentTime() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		NewTime = dateFormat.format(new Date());
		return (NewTime);
	}

	public void autoResizeColumns() {
		int columns = resultWriteSheet.getColumns();
		for (int i = 0; i < columns; i++) {
			if (i != 100) {
				CellView cell = resultWriteSheet.getColumnView(i);
				cell.setAutosize(true);
				resultWriteSheet.setColumnView(i, cell);
			}
		}
	}

}
