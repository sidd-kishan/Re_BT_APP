/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.zzt
 *  com.google.android.gms.tasks.zzu
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new zzu();
    static final Executor zza = new zzt();

    private TaskExecutors() {
    }
}
