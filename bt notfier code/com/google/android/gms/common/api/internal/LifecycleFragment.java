/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public interface LifecycleFragment {
    public void addCallback(String var1, LifecycleCallback var2);

    public <T extends LifecycleCallback> T getCallbackOrNull(String var1, Class<T> var2);

    public Activity getLifecycleActivity();

    public boolean isCreated();

    public boolean isStarted();

    public void startActivityForResult(Intent var1, int var2);
}
