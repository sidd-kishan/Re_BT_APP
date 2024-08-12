/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract$Model
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract$Presenter
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract$View
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.sport.SportModel
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.function.home.fragment.mvp.sport;

import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract;
import com.lianhezhuli.btnotification.function.home.fragment.mvp.sport.SportModel;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.orhanobut.logger.Logger;
import java.util.Date;
import java.util.List;

public class SportPresenter
extends BasePresenter<SportContract.View>
implements SportContract.Presenter {
    private SportContract.Model model = new SportModel();

    public void getStepData(int n) {
        List list = this.model.getStepData(StringUtils.yyyy_M_d.format(DateUtil.getTheDayAfter((Date)new Date(), (int)(-n))));
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getStepData size == ");
            stringBuilder.append(list.size());
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
            int n2 = 0;
            for (int i = 0; i < list.size(); n2 += ((StepDataBean)list.get(i)).getStep(), ++i) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("getStepData getStep == ");
                stringBuilder.append(((StepDataBean)list.get(i)).getStep());
                Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
                stringBuilder = new StringBuilder();
                stringBuilder.append("getStepData getBinTime == ");
                stringBuilder.append(((StepDataBean)list.get(i)).getBinTime());
                Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
            }
            ((SportContract.View)this.mView).setStepData(n2, n);
        } else {
            ((SportContract.View)this.mView).setStepData(0, n);
        }
    }
}
