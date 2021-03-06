package com.testpros.fast;

import com.testpros.fast.reporter.Step;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.http.HttpClient;

import java.net.URL;

public class IOSDriver<T extends WebElement> extends RemoteWebDriver {

    public IOSDriver(HttpCommandExecutor executor, Capabilities capabilities) {
        this.executor = executor;
        this.capabilities = capabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(executor, capabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        this.remoteAddress = remoteAddress;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(remoteAddress, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(URL remoteAddress, HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        this.remoteAddress = remoteAddress;
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(remoteAddress, httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(AppiumDriverLocalService service, Capabilities desiredCapabilities) {
        this.service = service;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(service, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(AppiumDriverLocalService service, HttpClient.Factory httpClientFactory,
                     Capabilities desiredCapabilities) {
        this.service = service;
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(service, httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(AppiumServiceBuilder builder, Capabilities desiredCapabilities) {
        this.builder = builder;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(builder, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(AppiumServiceBuilder builder, HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        this.builder = builder;
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(builder, httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(HttpClient.Factory httpClientFactory, Capabilities desiredCapabilities) {
        this.httpClientFactory = httpClientFactory;
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(httpClientFactory, desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public IOSDriver(Capabilities desiredCapabilities) {
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new io.appium.java_client.ios.IOSDriver<>(desiredCapabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    @Override
    String getDeviceName() {
        return "iOS";
    }

    @Override
    String getDriverName() {
        return "IOSDriver";
    }
}
