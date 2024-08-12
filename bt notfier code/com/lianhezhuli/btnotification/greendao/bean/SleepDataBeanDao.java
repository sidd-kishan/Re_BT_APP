/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteStatement
 *  com.lianhezhuli.btnotification.greendao.bean.DaoSession
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBean
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseStatement
 *  org.greenrobot.greendao.internal.DaoConfig
 */
package com.lianhezhuli.btnotification.greendao.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.lianhezhuli.btnotification.greendao.bean.DaoSession;
import com.lianhezhuli.btnotification.greendao.bean.SleepDataBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class SleepDataBeanDao
extends AbstractDao<SleepDataBean, Long> {
    public static final String TABLENAME = "SLEEP_DATA_BEAN";

    public SleepDataBeanDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public SleepDataBeanDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, (AbstractDaoSession)daoSession);
    }

    public static void createTable(Database database, boolean bl) {
        String string = bl ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(string);
        stringBuilder.append("\"SLEEP_DATA_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" TEXT,\"IS_UPDATE\" INTEGER NOT NULL ,\"BIN_TIME\" TEXT,\"TOTAL_SLEEP\" INTEGER NOT NULL ,\"DEEP_SLEEP\" INTEGER NOT NULL ,\"LIGHT_SLEEP\" INTEGER NOT NULL ,\"AWAKE_TIME\" INTEGER NOT NULL ,\"MAC\" TEXT);");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DROP TABLE ");
        String string = bl ? "IF EXISTS " : "";
        stringBuilder.append(string);
        stringBuilder.append("\"SLEEP_DATA_BEAN\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, SleepDataBean object) {
        sQLiteStatement.clearBindings();
        Object object2 = object.getId();
        if (object2 != null) {
            sQLiteStatement.bindLong(1, ((Long)object2).longValue());
        }
        if ((object2 = object.getUserId()) != null) {
            sQLiteStatement.bindString(2, (String)object2);
        }
        long l = object.getIsUpdate() ? 1L : 0L;
        sQLiteStatement.bindLong(3, l);
        object2 = object.getBinTime();
        if (object2 != null) {
            sQLiteStatement.bindString(4, (String)object2);
        }
        sQLiteStatement.bindLong(5, (long)object.getTotalSleep());
        sQLiteStatement.bindLong(6, (long)object.getDeepSleep());
        sQLiteStatement.bindLong(7, (long)object.getLightSleep());
        sQLiteStatement.bindLong(8, (long)object.getAwakeTime());
        object = object.getMac();
        if (object == null) return;
        sQLiteStatement.bindString(9, (String)object);
    }

    protected final void bindValues(DatabaseStatement databaseStatement, SleepDataBean object) {
        databaseStatement.clearBindings();
        Object object2 = object.getId();
        if (object2 != null) {
            databaseStatement.bindLong(1, ((Long)object2).longValue());
        }
        if ((object2 = object.getUserId()) != null) {
            databaseStatement.bindString(2, (String)object2);
        }
        long l = object.getIsUpdate() ? 1L : 0L;
        databaseStatement.bindLong(3, l);
        object2 = object.getBinTime();
        if (object2 != null) {
            databaseStatement.bindString(4, (String)object2);
        }
        databaseStatement.bindLong(5, (long)object.getTotalSleep());
        databaseStatement.bindLong(6, (long)object.getDeepSleep());
        databaseStatement.bindLong(7, (long)object.getLightSleep());
        databaseStatement.bindLong(8, (long)object.getAwakeTime());
        object = object.getMac();
        if (object == null) return;
        databaseStatement.bindString(9, (String)object);
    }

    public Long getKey(SleepDataBean sleepDataBean) {
        if (sleepDataBean == null) return null;
        return sleepDataBean.getId();
    }

    public boolean hasKey(SleepDataBean sleepDataBean) {
        boolean bl = sleepDataBean.getId() != null;
        return bl;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public SleepDataBean readEntity(Cursor object, int n) {
        int n2 = n + 0;
        Long l = object.isNull(n2) ? null : Long.valueOf(object.getLong(n2));
        n2 = n + 1;
        String string = object.isNull(n2) ? null : object.getString(n2);
        boolean bl = object.getShort(n + 2) != 0;
        n2 = n + 3;
        String string2 = object.isNull(n2) ? null : object.getString(n2);
        int n3 = object.getInt(n + 4);
        int n4 = object.getInt(n + 5);
        n2 = object.getInt(n + 6);
        int n5 = object.getInt(n + 7);
        object = object.isNull(n += 8) ? null : object.getString(n);
        return new SleepDataBean(l, string, bl, string2, n3, n4, n2, n5, (String)object);
    }

    public void readEntity(Cursor object, SleepDataBean sleepDataBean, int n) {
        int n2 = n + 0;
        boolean bl = object.isNull(n2);
        Object var7_6 = null;
        Object object2 = bl ? null : Long.valueOf(object.getLong(n2));
        sleepDataBean.setId((Long)object2);
        n2 = n + 1;
        object2 = object.isNull(n2) ? null : object.getString(n2);
        sleepDataBean.setUserId((String)object2);
        bl = object.getShort(n + 2) != 0;
        sleepDataBean.setIsUpdate(bl);
        n2 = n + 3;
        object2 = object.isNull(n2) ? null : object.getString(n2);
        sleepDataBean.setBinTime((String)object2);
        sleepDataBean.setTotalSleep(object.getInt(n + 4));
        sleepDataBean.setDeepSleep(object.getInt(n + 5));
        sleepDataBean.setLightSleep(object.getInt(n + 6));
        sleepDataBean.setAwakeTime(object.getInt(n + 7));
        object = object.isNull(n += 8) ? var7_6 : object.getString(n);
        sleepDataBean.setMac((String)object);
    }

    public Long readKey(Cursor object, int n) {
        object = object.isNull(n += 0) ? null : Long.valueOf(object.getLong(n));
        return object;
    }

    protected final Long updateKeyAfterInsert(SleepDataBean sleepDataBean, long l) {
        sleepDataBean.setId(Long.valueOf(l));
        return l;
    }
}
