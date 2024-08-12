/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.event;

public class RemoteAlarmEvent {
    private boolean isSuccess;

    public RemoteAlarmEvent() {
    }

    public RemoteAlarmEvent(boolean bl) {
        this.isSuccess = bl;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean bl) {
        this.isSuccess = bl;
    }
}
