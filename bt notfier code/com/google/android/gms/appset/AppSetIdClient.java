/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.appset.AppSetIdInfo
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.appset;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;

public interface AppSetIdClient {
    public Task<AppSetIdInfo> getAppSetIdInfo();
}
