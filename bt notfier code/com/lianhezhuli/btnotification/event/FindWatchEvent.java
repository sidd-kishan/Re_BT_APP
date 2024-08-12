/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.event;

public class FindWatchEvent {
    private boolean isSuccess;

    public FindWatchEvent() {
    }

    public FindWatchEvent(boolean bl) {
        this.isSuccess = bl;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean bl) {
        this.isSuccess = bl;
    }
}
