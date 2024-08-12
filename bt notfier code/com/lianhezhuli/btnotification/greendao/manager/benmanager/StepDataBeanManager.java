/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.greendao.dao.StepDataBeanDao$Properties
 *  com.lianhezhuli.btnotification.greendao.manager.benmanager.BaseBeanManager
 *  com.lianhezhuli.btnotification.utils.JsonUtils
 *  com.orhanobut.logger.Logger
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.query.WhereCondition
 */
package com.lianhezhuli.btnotification.greendao.manager.benmanager;

import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.greendao.dao.StepDataBeanDao;
import com.lianhezhuli.btnotification.greendao.manager.benmanager.BaseBeanManager;
import com.lianhezhuli.btnotification.utils.JsonUtils;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.WhereCondition;

public class StepDataBeanManager
extends BaseBeanManager<StepDataBean, Long> {
    public StepDataBeanManager(AbstractDao abstractDao) {
        super(abstractDao);
    }

    public List<StepDataBean> queryByDate(String object, String string) {
        Object object2 = this.queryBuilder();
        object = StepDataBeanDao.Properties.UserId.eq(object);
        Property property = StepDataBeanDao.Properties.BinTime;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("%");
        object2 = object2.where((WhereCondition)object, new WhereCondition[]{property.like(stringBuilder.toString())}).list();
        object = new StringBuilder();
        ((StringBuilder)object).append("sport data list == ");
        ((StringBuilder)object).append(JsonUtils.toJson((Object)object2));
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        object = new ArrayList();
        if (object2 == null) return object;
        if (object2.size() <= 0) return object;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            stringBuilder = (StepDataBean)object2.next();
            if (!stringBuilder.getBinTime().split(" ")[0].equals(string)) continue;
            object.add(stringBuilder);
        }
        return object;
    }
}
