package com.bridgelabiz.generic;

import com.bridgelabz.pom.LoginPage;
import org.testng.annotations.Test;

public class FaceBookTest extends BaseTest {


    @Test
    public void loginToFaceBook() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        //User name - 1st Row and 0th Column value
        int rowCount=Library.getRowCount("/home/user/IdeaProjects/DataDrivenFaceBook/sheet/userdata.xlsx","sheet1");

        for(int i=0;i<rowCount;i++) {
            String un = Library.getCellValue(EXCEL_PATH, "Sheet1", 1, 0);
            //Password - 1st Row and 1st Column value
            String pw = Library.getCellValue(EXCEL_PATH, "Sheet1", 1, 1);
            //Calling Methods of LoginPage
            loginPage.setUsername(un);
            Thread.sleep(1000);
            loginPage.setPassword(pw);
            Thread.sleep(500);
            loginPage.clickLogin();
            Thread.sleep(5000);
        }
    }

}
