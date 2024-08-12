/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract$Model
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.greendao.manager.ManagerFactory
 *  com.lianhezhuli.btnotification.utils.SpUtils
 */
package com.lianhezhuli.btnotification.function.home.fragment.mvp.sport;

import com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.greendao.manager.ManagerFactory;
import com.lianhezhuli.btnotification.utils.SpUtils;
import java.util.List;

public class SportModel
implements SportContract.Model {
    public List<StepDataBean> getStepData(String string) {
        return ManagerFactory.getInstance().getStepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), string);
    }
}
