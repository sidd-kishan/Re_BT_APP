/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.async.AsyncOperation
 */
package org.greenrobot.greendao.async;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.async.AsyncOperation;

public class AsyncDaoException
extends DaoException {
    private static final long serialVersionUID = 5872157552005102382L;
    private final AsyncOperation failedOperation;

    public AsyncDaoException(AsyncOperation asyncOperation, Throwable throwable) {
        super(throwable);
        this.failedOperation = asyncOperation;
    }

    public AsyncOperation getFailedOperation() {
        return this.failedOperation;
    }
}
