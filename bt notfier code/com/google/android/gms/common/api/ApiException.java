/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Status;

public class ApiException
extends Exception {
    @Deprecated
    protected final Status mStatus;

    public ApiException(Status status) {
        int n = status.getStatusCode();
        String string = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 13);
        stringBuilder.append(n);
        stringBuilder.append(": ");
        stringBuilder.append(string);
        super(stringBuilder.toString());
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
