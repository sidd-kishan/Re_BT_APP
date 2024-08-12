/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.SQLException
 *  org.greenrobot.greendao.DaoLog
 */
package org.greenrobot.greendao;

import android.database.SQLException;
import org.greenrobot.greendao.DaoLog;

public class DaoException
extends SQLException {
    private static final long serialVersionUID = -5877937327907457779L;

    public DaoException() {
    }

    public DaoException(String string) {
        super(string);
    }

    public DaoException(String string, Throwable throwable) {
        super(string);
        this.safeInitCause(throwable);
    }

    public DaoException(Throwable throwable) {
        this.safeInitCause(throwable);
    }

    protected void safeInitCause(Throwable throwable) {
        try {
            this.initCause(throwable);
        }
        catch (Throwable throwable2) {
            DaoLog.e((String)"Could not set initial cause", (Throwable)throwable2);
            DaoLog.e((String)"Initial cause is:", (Throwable)throwable);
        }
    }
}
