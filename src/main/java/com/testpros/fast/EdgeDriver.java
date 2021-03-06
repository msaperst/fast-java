package com.testpros.fast;

import com.testpros.fast.reporter.Step;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriver extends RemoteWebDriver {

    public EdgeDriver() {
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.edge.EdgeDriver();
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public EdgeDriver(EdgeDriverService service) {
        this.service = service;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.edge.EdgeDriver(service);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    @Deprecated
    public EdgeDriver(Capabilities capabilities) {
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.edge.EdgeDriver(capabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public EdgeDriver(EdgeOptions options) {
        this.options = options;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.edge.EdgeDriver(options);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    public EdgeDriver(EdgeDriverService service, EdgeOptions options) {
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.edge.EdgeDriver(service, options);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    @Deprecated
    public EdgeDriver(EdgeDriverService service, Capabilities capabilities) {
        this.service = service;
        this.capabilities = capabilities;
        Step step = setupStep();
        try {
            seleniumRemoteWebDriver = new org.openqa.selenium.edge.EdgeDriver(service, capabilities);
            passStep(step);
        } catch (Exception e) {
            failStep(step, e);
        } finally {
            reporter.addStep(step);
        }
    }

    @Override
    String getDeviceName() {
        return "Edge";
    }
}
