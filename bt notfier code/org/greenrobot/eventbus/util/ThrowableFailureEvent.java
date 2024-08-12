/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.util.HasExecutionScope
 */
package org.greenrobot.eventbus.util;

import org.greenrobot.eventbus.util.HasExecutionScope;

public class ThrowableFailureEvent
implements HasExecutionScope {
    private Object executionContext;
    protected final boolean suppressErrorUi;
    protected final Throwable throwable;

    public ThrowableFailureEvent(Throwable throwable) {
        this.throwable = throwable;
        this.suppressErrorUi = false;
    }

    public ThrowableFailureEvent(Throwable throwable, boolean bl) {
        this.throwable = throwable;
        this.suppressErrorUi = bl;
    }

    public Object getExecutionScope() {
        return this.executionContext;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    public void setExecutionScope(Object object) {
        this.executionContext = object;
    }
}
