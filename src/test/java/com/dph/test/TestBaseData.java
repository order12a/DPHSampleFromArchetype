package com.dph.test;

import model.User;
import org.testng.annotations.DataProvider;

public class TestBaseData extends TestNgTestBase {

    @DataProvider(name = "User")
    public static Object[][] createSimpleUser(){
        return new Object[][]{
                {new User("usefOne", "1")},
                {new User("VinsOrder", "123456")}
        };
    }

    @DataProvider(name = "SEARCH_REQUESTS")
    public static Object[][] createRequestList(){
        return new Object[][]{
                {"Cat"},
                {"Dog"},
                {"Dark night"},
                {"Solar system"},
                {"Water"},
                {"Girl at the beach"}
        };
    }
}
