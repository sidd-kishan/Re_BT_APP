/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposePlugins
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposePlugins;

public class OutsideScopeException
extends RuntimeException {
    public OutsideScopeException(String string) {
        super(string);
    }

    @Override
    public final Throwable fillInStackTrace() {
        synchronized (this) {
            if (!AutoDisposePlugins.getFillInOutsideScopeExceptionStacktraces()) return this;
            Throwable throwable = super.fillInStackTrace();
            return throwable;
        }
    }
}
