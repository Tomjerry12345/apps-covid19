package com.tomjerry.appscovid19.module.MPAndroidChart.interfaces.dataprovider;

import com.tomjerry.appscovid19.module.MPAndroidChart.data.BarData;

public interface BarDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BarData getBarData();
    boolean isDrawBarShadowEnabled();
    boolean isDrawValueAboveBarEnabled();
    boolean isHighlightFullBarEnabled();
}

