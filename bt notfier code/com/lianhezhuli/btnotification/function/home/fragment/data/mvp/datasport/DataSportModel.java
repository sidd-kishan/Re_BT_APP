/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract$Model
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.greendao.manager.ManagerFactory
 *  com.lianhezhuli.btnotification.utils.SpUtils
 */
package com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport;

import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.greendao.manager.ManagerFactory;
import com.lianhezhuli.btnotification.utils.SpUtils;
import java.util.List;

public class DataSportModel
implements DataSportContract.Model {
    public List<StepDataBean> getStepData(String string) {
        return ManagerFactory.getInstance().getStepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), string);
    }
}
