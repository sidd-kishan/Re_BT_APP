/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteStatement
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.greendao.dao.DaoSession
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseStatement
 *  org.greenrobot.greendao.internal.DaoConfig
 */
package com.lianhezhuli.btnotification.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.greendao.dao.DaoSession;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class StepDataBeanDao
extends AbstractDao<StepDataBean, Long> {
    public static final String TABLENAME = "STEP_DATA_BEAN";

    public StepDataBeanDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public StepDataBeanDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, (AbstractDaoSession)daoSession);
    }

    public static void createTable(Database database, boolean bl) {
        String string = bl ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(string);
        stringBuilder.append("\"STEP_DATA_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" TEXT,\"IS_UPDATE\" INTEGER NOT NULL ,\"BIN_TIME\" TEXT,\"CALORIE\" TEXT,\"DISTANCE\" TEXT,\"STEP\" INTEGER NOT NULL ,\"ACTIVE_TIME\" INTEGER NOT NULL ,\"MAC\" TEXT);");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DROP TABLE ");
        String string = bl ? "IF EXISTS " : "";
        stringBuilder.append(string);
        stringBuilder.append("\"STEP_DATA_BEAN\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, StepDataBean object) {
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
        if ((object2 = object.getCalorie()) != null) {
            sQLiteStatement.bindString(5, (String)object2);
        }
        if ((object2 = object.getDistance()) != null) {
            sQLiteStatement.bindString(6, (String)object2);
        }
        sQLiteStatement.bindLong(7, (long)object.getStep());
        sQLiteStatement.bindLong(8, (long)object.getActiveTime());
        object = object.getMac();
        if (object == null) return;
        sQLiteStatement.bindString(9, (String)object);
    }

    protected final void bindValues(DatabaseStatement databaseStatement, StepDataBean object) {
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
        if ((object2 = object.getCalorie()) != null) {
            databaseStatement.bindString(5, (String)object2);
        }
        if ((object2 = object.getDistance()) != null) {
            databaseStatement.bindString(6, (String)object2);
        }
        databaseStatement.bindLong(7, (long)object.getStep());
        databaseStatement.bindLong(8, (long)object.getActiveTime());
        object = object.getMac();
        if (object == null) return;
        databaseStatement.bindString(9, (String)object);
    }

    public Long getKey(StepDataBean stepDataBean) {
        if (stepDataBean == null) return null;
        return stepDataBean.getId();
    }

    public boolean hasKey(StepDataBean stepDataBean) {
        boolean bl = stepDataBean.getId() != null;
        return bl;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public StepDataBean readEntity(Cursor object, int n) {
        int n2 = n + 0;
        Long l = object.isNull(n2) ? null : Long.valueOf(object.getLong(n2));
        n2 = n + 1;
        String string = object.isNull(n2) ? null : object.getString(n2);
        boolean bl = object.getShort(n + 2) != 0;
        n2 = n + 3;
        String string2 = object.isNull(n2) ? null : object.getString(n2);
        n2 = n + 4;
        String string3 = object.isNull(n2) ? null : object.getString(n2);
        n2 = n + 5;
        String string4 = object.isNull(n2) ? null : object.getString(n2);
        n2 = object.getInt(n + 6);
        int n3 = object.getInt(n + 7);
        object = object.isNull(n += 8) ? null : object.getString(n);
        return new StepDataBean(l, string, bl, string2, string3, string4, n2, n3, (String)object);
    }

    public void readEntity(Cursor object, StepDataBean stepDataBean, int n) {
        int n2 = n + 0;
        boolean bl = object.isNull(n2);
        Object var7_6 = null;
        Object object2 = bl ? null : Long.valueOf(object.getLong(n2));
        stepDataBean.setId((Long)object2);
        n2 = n + 1;
        object2 = object.isNull(n2) ? null : object.getString(n2);
        stepDataBean.setUserId((String)object2);
        bl = object.getShort(n + 2) != 0;
        stepDataBean.setIsUpdate(bl);
        n2 = n + 3;
        object2 = object.isNull(n2) ? null : object.getString(n2);
        stepDataBean.setBinTime((String)object2);
        n2 = n + 4;
        object2 = object.isNull(n2) ? null : object.getString(n2);
        stepDataBean.setCalorie((String)object2);
        n2 = n + 5;
        object2 = object.isNull(n2) ? null : object.getString(n2);
        stepDataBean.setDistance((String)object2);
        stepDataBean.setStep(object.getInt(n + 6));
        stepDataBean.setActiveTime(object.getInt(n + 7));
        object = object.isNull(n += 8) ? var7_6 : object.getString(n);
        stepDataBean.setMac((String)object);
    }

    public Long readKey(Cursor object, int n) {
        object = object.isNull(n += 0) ? null : Long.valueOf(object.getLong(n));
        return object;
    }

    protected final Long updateKeyAfterInsert(StepDataBean stepDataBean, long l) {
        stepDataBean.setId(Long.valueOf(l));
        return l;
    }
}
