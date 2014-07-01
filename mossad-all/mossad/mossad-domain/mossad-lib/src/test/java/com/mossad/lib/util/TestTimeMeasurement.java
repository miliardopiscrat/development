/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mmigdal
 */
public class TestTimeMeasurement {

    private TimeMeasurement timeMeasurement;

    @Before
    public void setUp() {
        timeMeasurement = new TimeMeasurement();
    }

    @After
    public void tearDown() {
        timeMeasurement = null;
    }

    @Test
    public void testReset() {
        timeMeasurement.reset();
        Assert.assertEquals(0, timeMeasurement.getResultInMiliseconds());
    }

    @Test
    public void testDefaultBehaviour() {
        timeMeasurement.reset();
        Assert.assertEquals(0, timeMeasurement.getResultInMiliseconds());

        timeMeasurement.start();

        for (int x = 0; x < 1000000000; x++) {
        }

        timeMeasurement.stop();

        Assert.assertTrue(checkValue());
    }

    private boolean checkValue() {
        return timeMeasurement.getResultInMiliseconds() > 0 ? true : false;
    }
}
