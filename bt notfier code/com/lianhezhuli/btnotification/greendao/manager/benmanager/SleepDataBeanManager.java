/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBean
 *  com.lianhezhuli.btnotification.greendao.dao.SleepDataBeanDao$Properties
 *  com.lianhezhuli.btnotification.greendao.manager.benmanager.BaseBeanManager
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.query.WhereCondition
 */
package com.lianhezhuli.btnotification.greendao.manager.benmanager;

import com.lianhezhuli.btnotification.greendao.bean.SleepDataBean;
import com.lianhezhuli.btnotification.greendao.dao.SleepDataBeanDao;
import com.lianhezhuli.btnotification.greendao.manager.benmanager.BaseBeanManager;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.WhereCondition;

public class SleepDataBeanManager
extends BaseBeanManager<SleepDataBean, Long> {
    public SleepDataBeanManager(AbstractDao abstractDao) {
        super(abstractDao);
    }

    public List<SleepDataBean> queryByDate(String object, String string) {
        Object object2 = this.queryBuilder();
        object = SleepDataBeanDao.Properties.UserId.eq(object);
        Property property = SleepDataBeanDao.Properties.BinTime;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("%");
        object2 = object2.where((WhereCondition)object, new WhereCondition[]{property.like(stringBuilder.toString())}).list();
        object = new ArrayList();
        if (object2 == null) return object;
        if (object2.size() <= 0) return object;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            stringBuilder = (SleepDataBean)object2.next();
            if (!stringBuilder.getBinTime().split(" ")[0].equals(string)) continue;
            object.add(stringBuilder);
        }
        return object;
    }
}
