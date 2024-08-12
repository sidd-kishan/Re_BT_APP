/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.Request
 */
package com.bumptech.glide.request;

import com.bumptech.glide.request.Request;

public interface RequestCoordinator {
    public boolean canNotifyCleared(Request var1);

    public boolean canNotifyStatusChanged(Request var1);

    public boolean canSetImage(Request var1);

    public boolean isAnyResourceSet();

    public void onRequestFailed(Request var1);

    public void onRequestSuccess(Request var1);
}
