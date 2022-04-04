package ${YYAndroidPackageName};

import androidx.annotation.WorkerThread;

import android.util.Log;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ${YYAndroidPackageName}.R;
import ${YYAndroidPackageName}.RunnerActivity;
import com.yoyogames.runner.RunnerJNILib;

import java.lang.reflect.Method;

import android.content.Intent;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class GenericTest
{
    private static final int EVENT_OTHER_SOCIAL = 70;

    public void ReturnAsync(double arg0, double arg1)
    {            
            int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString( dsMapIndex, "type", "finished");
            RunnerJNILib.DsMapAddDouble( dsMapIndex, "argument0", arg0);
            RunnerJNILib.DsMapAddDouble( dsMapIndex, "argument1", arg1);
            RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
            PrintMethods();
    }

    public void PrintMethods() {
        Class c = RunnerJNILib.class;
        Method[] methods = c.getMethods();
        Log.i("yoyo","The public methods of the java.lang.Thread class are:");
        for (int i = 0; i < methods.length; i++) {
            Log.i("yoyo",methods[i].toString());
        }
        Log.i("yoyo","--end--");
    }

    public double AddTwoNumbers(double arg0, double arg1)
    {
            double value = arg0 + arg1;
            Log.i("yoyo", arg0 + "+" + arg1 + " = " + value);

            return value;
    }

    public String BuildAString(String arg0, String arg1)
    {
            String myString = arg0 + " " + arg1;
            Log.i("yoyo", myString);

            return myString;
    }

    public String HowManyObjects(double arg0, double arg1, String arg2)
    {
            double value = arg0 + arg1;
            Log.i("yoyo", arg0 + "+" + arg1 + " = " + value);

            String myString = String.valueOf(value) + " " + arg2;
            Log.i("yoyo", myString);

            return myString;
    }

    public void OpenClientX(String arg0) {
        Log.i("yoyo", "OpenClientX: " + arg0);
        Intent intent = new Intent(RunnerActivity.CurrentActivity, WebviewActivity.class);
        //RunnerActivity.CurrentActivity.onNewIntent(intent);
        RunnerActivity.CurrentActivity.startActivity(intent);
    }

    

    

    
    
}


