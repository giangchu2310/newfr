package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    //DataProvider 1

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + ".\\src\\test\\testDatas\\AccLogin.xlsx";//taking xl file from testData

        ExcelUtility xlutil = new ExcelUtility(path);//creating an object for XLUtility

        int totalrows = xlutil.getRowCount("Sheet1"); //Row starts from 0
        int totalcols = xlutil.getCellCount("Sheet1", 1); //Col starts from 1

        String logindata[][] = new String[totalrows][totalcols];//created for 2D array to store data from excel file

        for (int i = 1; i <= totalrows; i++)  //read row
        {
            for (int j = 0; j < totalcols; j++)  //traverse every column in current row
            {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return logindata;//return 2D array

    }

    //DataProvider 2

    //DataProvider 3

    //DataProvider 4


}
