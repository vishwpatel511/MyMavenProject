package data;

import java.util.ArrayList;
import java.util.List;

import utils.Xls_Reader;

public class ExcelDatareader {
	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\vishw\\Desktop\\dataFordemo.xlsx");
	
	public ArrayList<String> retrivingExcel() {
	
	ArrayList<String> members = new ArrayList<String>();
	
	for(int j=2; j<=reader.getRowCount("Sheet1"); j++) {
		
	for(int i=0; i<reader.getColumnCount("Sheet1"); i++) {
		members.add(reader.getCellData("Sheet1", i, j));		
		}
	}
	System.out.println(members);
	return members;
	}
	
}
/*	
	public String firstName1 = reader.getCellData("Sheet1", 0, 2);
	public String lastName1 = reader.getCellData("Sheet1", 1, 2);
	public String address1 = reader.getCellData("Sheet1", 2, 2);
	public String email1 = reader.getCellData("Sheet1", 3, 2);
	*/

