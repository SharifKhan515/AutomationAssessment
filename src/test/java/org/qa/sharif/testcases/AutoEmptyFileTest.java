package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.ReadData;
import org.testng.annotations.Test;

public class AutoEmptyFileTest extends BaseTestClass{



    @Test(dataProvider = "autoEmptyFileTest",dataProviderClass = ReadData.class)
    public void test1(String country, String cur){

        System.out.println(country);
        System.out.println(cur);

    }


}
