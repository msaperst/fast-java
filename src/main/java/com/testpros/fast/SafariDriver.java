package com.testpros.fast;

import com.testpros.fast.reporter.Step;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriver extends RemoteWebDriver {

    @Deprecated
    public SafariDriver(Capabilities desiredCapabilities) {
        this.capabilities = desiredCapabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.safari.SafariDriver();
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public SafariDriver(SafariOptions safariOptions) {
        this.options = safariOptions;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.safari.SafariDriver(safariOptions);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public SafariDriver(SafariDriverService safariService) {
        this.service = safariService;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.safari.SafariDriver(safariService);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public SafariDriver(SafariDriverService safariServer, SafariOptions safariOptions) {
        this.service = safariServer;
        this.options = safariOptions;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.safari.SafariDriver(safariServer, safariOptions);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    @Override
    String getDeviceName() {
        return "Safari";
    }
}
