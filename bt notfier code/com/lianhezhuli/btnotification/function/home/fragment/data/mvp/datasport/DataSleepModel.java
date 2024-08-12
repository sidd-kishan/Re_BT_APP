/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract$Model
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBean
 *  com.lianhezhuli.btnotification.greendao.manager.ManagerFactory
 *  com.lianhezhuli.btnotification.utils.SpUtils
 */
package com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport;

import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract;
import com.lianhezhuli.btnotification.greendao.bean.SleepDataBean;
import com.lianhezhuli.btnotification.greendao.manager.ManagerFactory;
import com.lianhezhuli.btnotification.utils.SpUtils;
import java.util.List;

public class DataSleepModel
implements DataSleepContract.Model {
    public List<SleepDataBean> getSleepData(String string) {
        return ManagerFactory.getInstance().getSleepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), string);
    }
}
