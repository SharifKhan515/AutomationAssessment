package org.qa.sharif.dataproviders;

import org.qa.sharif.commonutils.ExcelHelper;
import org.qa.sharif.environment.Environment;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class ReadData extends ExcelHelper {

    public static String filePath = Environment.testDataFile;

    @DataProvider(name = "autoEmptyFileTest")
    public static Object[][] autoEmptyFileTest(Method m) {
        return getTableArray(filePath, "autoEmptyFileTest", m.getName());
    }

    @DataProvider(name = "CountryCurrencyUpdateTest")
    public static Object[][] CountryCurrencyUpdateTest(Method m) {
        return getTableArray(filePath, "CountryCurrencyUpdateTest", m.getName());
    }
}
