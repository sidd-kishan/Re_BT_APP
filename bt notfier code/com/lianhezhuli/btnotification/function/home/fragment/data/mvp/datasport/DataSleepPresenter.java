/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract$Model
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract$Presenter
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract$View
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSleepModel
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBean
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport;

import android.text.TextUtils;
import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSleepModel;
import com.lianhezhuli.btnotification.greendao.bean.SleepDataBean;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class DataSleepPresenter
extends BasePresenter<DataSleepContract.View>
implements DataSleepContract.Presenter {
    private DataSleepContract.Model model = new DataSleepModel();

    public void getWeekData(List<String> object, String string) {
        ArrayList<BarChartBean> arrayList = new ArrayList<BarChartBean>();
        int n = TextUtils.isEmpty((CharSequence)string) ? 6 : 0;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= object.size()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("weekData maxValue == ");
                ((StringBuilder)object).append(n3);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                ((DataSleepContract.View)this.mView).setWeekData(arrayList, n3, n);
                return;
            }
            String string2 = object.get(n2);
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("weekData date == ");
            ((StringBuilder)object2).append(string2);
            Logger.e((String)((StringBuilder)object2).toString(), (Object[])new Object[0]);
            int n4 = n;
            if (string2.equals(string)) {
                n4 = n2;
            }
            if ((object2 = this.model.getSleepData(string2)) != null) {
                int n5 = 0;
                int n6 = 0;
                while (true) {
                    n = n6;
                    if (n5 < object2.size()) {
                        n6 += ((SleepDataBean)object2.get(n5)).getTotalSleep();
                        ++n5;
                        continue;
                    }
                    break;
                }
            } else {
                n = 0;
            }
            if (n3 <= n) {
                n3 = n;
            }
            arrayList.add(new BarChartBean(DateUtil.getDayOfWeek((String)string2), string2, n));
            ++n2;
            n = n4;
        }
    }
}
