package com.tomjerry.appscovid19.module.MPAndroidChart.interfaces.dataprovider;

import com.tomjerry.appscovid19.module.MPAndroidChart.components.YAxis;
import com.tomjerry.appscovid19.module.MPAndroidChart.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}

