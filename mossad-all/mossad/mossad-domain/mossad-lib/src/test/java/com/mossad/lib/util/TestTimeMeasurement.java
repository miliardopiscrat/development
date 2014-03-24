/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mmigdal
 */
public class TestTimeMeasurement {

    private TimeMeasurement timeMeasurement;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

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
        assertEquals(0, timeMeasurement.getResultInMiliseconds());
    }

    @Test
    public void testDefaultBehaviour() {
        timeMeasurement.reset();
        assertEquals(0, timeMeasurement.getResultInMiliseconds());

        timeMeasurement.start();

        for (int x = 0; x < 1000000000; x++) {
        }

        timeMeasurement.stop();

        assertTrue(checkValue());
    }

    private boolean checkValue() {
        return timeMeasurement.getResultInMiliseconds() > 0 ? true : false;
    }
}
