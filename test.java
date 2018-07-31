package com.example.gperez.test2;

import android.util.Log;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

/**
 * Created by gperez on 4/16/2018.
 */

public class test {


    WebDriver driver;
    WebElement boton,numtelefono,pass,btniniciar;
    String telefono = "4171070437";
    String password = "Om1234#/";


    @Before
    public void setup() throws MalformedURLException {
        File appDir = new File("C:/Users/ogarcia/Downloads");
        File app = new File(appDir, "MiSeguroMty_prod_2.0.2.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus5X");
        capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
        capabilities.setCapability("platformName", "Android");
        // capabilities.setCapability("appPackage", "com.medic.medicapp");
        //capabilities.setCapability("appActivity", "com.medic.medicapp.navigations.splash.SplashActivity");
        capabilities.setCapability("App", app.getAbsolutePath());;
        driver = new AppiumDriver(new URL("http://127.0.0.2:8081/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void splash() throws Exception {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boton = driver.findElement(By.id("com.medic.medicapp:id/tv_end_tutorial"));
        boton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement iniciarsesion = driver.findElement(By.id("com.medic.medicapp:id/btn_pass_login"));
        iniciarsesion.click();
        numtelefono = driver.findElement(By.id("com.medic.medicapp:id/til_phone"));
        numtelefono.sendKeys(telefono);

        List<WebElement> lista = driver.findElements(By.className("android.widget.TextView"));
        WebElement phone_error = lista.get(0);

        System.out.println(phone_error.getText());

        pass = driver.findElement(By.id("com.medic.medicapp:id/til_password"));
        pass.sendKeys(password);
        btniniciar = driver.findElement(By.id("com.medic.medicapp:id/btn_login"));
        btniniciar.click();
    }

    public void Error (){
        System.out.print("error");

    }

}
