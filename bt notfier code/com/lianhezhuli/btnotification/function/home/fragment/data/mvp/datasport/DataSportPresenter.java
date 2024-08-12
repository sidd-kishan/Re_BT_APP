/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract$Model
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract$Presenter
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract$View
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSportModel
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport;

import android.text.TextUtils;
import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSportModel;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class DataSportPresenter
extends BasePresenter<DataSportContract.View>
implements DataSportContract.Presenter {
    private DataSportContract.Model model = new DataSportModel();

    public void getWeekData(List<String> object, String string) {
        ArrayList<BarChartBean> arrayList = new ArrayList<BarChartBean>();
        int n = TextUtils.isEmpty((CharSequence)string) ? -1 : 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = n;
        n = n2;
        while (true) {
            int n7;
            List list;
            if (n >= object.size()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("weekData maxValue == ");
                ((StringBuilder)object).append(n3);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                object = new StringBuilder();
                ((StringBuilder)object).append("weekData activeTime == ");
                ((StringBuilder)object).append(n5);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                ((DataSportContract.View)this.mView).setWeekData(arrayList, n3, n4, n5, n6);
                return;
            }
            String string2 = object.get(n);
            if (string2.equals(string)) {
                n6 = n;
            }
            if ((list = this.model.getStepData(string2)) != null) {
                int n8 = 0;
                int n9 = 0;
                while (true) {
                    n7 = n5;
                    n2 = n9;
                    if (n8 < list.size()) {
                        n9 += ((StepDataBean)list.get(n8)).getStep();
                        n5 += ((StepDataBean)list.get(n8)).getActiveTime();
                        ++n8;
                        continue;
                    }
                    break;
                }
            } else {
                n2 = 0;
                n7 = n5;
            }
            if (n3 <= n2) {
                n3 = n2;
            }
            arrayList.add(new BarChartBean(DateUtil.getDayOfWeek((String)string2), string2, n2));
            n4 += n2;
            ++n;
            n5 = n7;
        }
    }
}
