package com.tomjerry.appscovid19.module.MPAndroidChart.interfaces.datasets;

import com.tomjerry.appscovid19.module.MPAndroidChart.data.Entry;

/**
 * Created by philipp on 21/10/15.
 */
public interface IBarLineScatterCandleBubbleDataSet<T extends Entry> extends IDataSet<T> {

    /**
     * Returns the color that is used for drawing the highlight indicators.
     *
     * @return
     */
    int getHighLightColor();
}