package com.njumzc.gitlabtss;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.njumzc.gitlabtss.utils.RetrofitHelper;
import com.njumzc.gitlabtss.api.form.LoginInform;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.njumzc.gitlabtss", appContext.getPackageName());

        //test login
        LoginInform loginInform = new LoginInform();
        loginInform.setUsername("nanguangtailang");
        loginInform.setPassword("123");

        RetrofitHelper.getAuthService().login(loginInform);
    }
}
