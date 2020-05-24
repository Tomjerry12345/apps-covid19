package com.tomjerry.appscovid19.module.MPAndroidChart.interfaces.dataprovider;

import com.tomjerry.appscovid19.module.MPAndroidChart.components.YAxis.AxisDependency;
import com.tomjerry.appscovid19.module.MPAndroidChart.data.BarLineScatterCandleBubbleData;
import com.tomjerry.appscovid19.module.MPAndroidChart.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);

    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
