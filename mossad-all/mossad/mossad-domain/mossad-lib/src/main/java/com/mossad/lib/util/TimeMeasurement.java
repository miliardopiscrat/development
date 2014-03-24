/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.lib.util;

import java.util.Calendar;

/**
 *
 * @author mmigdal
 */
public class TimeMeasurement {

    private long start, stop;

    public TimeMeasurement() {
        start = 0;
        stop = 0;
    }

    public void reset() {
        start = 0;
        stop = 0;
    }

    public void start() {
        start = getTime();
    }

    public void stop() {
        stop = getTime();
    }

    public long getResultInMiliseconds() {
        return (stop - start);
    }

    private long getTime() {
        return Calendar.getInstance().getTimeInMillis();
    }
}
