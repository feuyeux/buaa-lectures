package org.feuyeux.pattern.behavioral.strategy;

import org.feuyeux.pattern.behavioral.strategy.crazyif.CrazyIfDevice;
import org.feuyeux.pattern.behavioral.strategy.crazyif.Device;
import org.feuyeux.pattern.behavioral.strategy.crazyif.strategy.Gateway105;
import org.feuyeux.pattern.behavioral.strategy.crazyif.strategy.IDevice;
import org.feuyeux.pattern.behavioral.strategy.crazyif.strategy.Tablet2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TestDevice {
    final Logger log = LogManager.getLogger(getClass());

    @Test
    public void testCrazyIf() {
        CrazyIfDevice thiz = new CrazyIfDevice();
        Device tablet = new Device("10.11.58.141", "Tablet2");
        String communication = thiz.call(tablet);
        log.debug(communication);
    }

    @Test
    public void testDevice() {
        IDevice tablet = new Tablet2("10.11.58.141");
        String communication1 = tablet.call("hello world");

        IDevice gateway = new Gateway105("10.11.58.184");
        String communication2 = gateway.call("hello world");

        log.debug(communication1);
        Assert.assertEquals("Android-C-Linux--10.11.58.141--hello world", communication1);
        log.debug(communication2);
        Assert.assertEquals("openwrt::10.11.58.184::hello world", communication2);
    }
}
