/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 */
package com.lianhezhuli.btnotification.function.home.fragment.data.mvp;

import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import java.util.List;

public static interface DataSportContract.View
extends BaseView {
    public void setWeekData(List<BarChartBean> var1, int var2, int var3, int var4, int var5);
}
