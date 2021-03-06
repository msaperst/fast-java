package com.testpros.fast;

import com.testpros.fast.reporter.Step;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.http.HttpClient;

import java.net.URL;

public class AndroidDriver<T extends WebElement> extends RemoteWebDriver {

    public AndroidDriver(HttpCommandExecutor executor, Capabilities capabilities) {
        this.executor = executor;
        this.capabilities = capabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(executor, capabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        this.remoteAddress = remoteAddress;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(remoteAddress, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(URL remoteAddress, HttpClient.Factory httpClientFactory,
                         Capabilities desiredCapabilities) {
        this.remoteAddress = remoteAddress;
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(remoteAddress,
                    httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(AppiumDriverLocalService service, Capabilities desiredCapabilities) {
        this.service = service;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(service, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(AppiumDriverLocalService service, HttpClient.Factory httpClientFactory,
                         Capabilities desiredCapabilities) {
        this.service = service;
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(service,
                    httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(AppiumServiceBuilder builder, Capabilities desiredCapabilities) {
        this.builder = builder;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(builder,
                    desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(AppiumServiceBuilder builder, HttpClient.Factory httpClientFactory,
                         Capabilities desiredCapabilities) {
        this.builder = builder;
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(builder,
                    httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(httpClientFactory,
                    desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public AndroidDriver(Capabilities desiredCapabilities) {
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.android.AndroidDriver<>(desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    @Override
    String getDeviceName() {
        return "Android";
    }
}
