/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnTokenCanceledListener
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnTokenCanceledListener;

public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken onCanceledRequested(OnTokenCanceledListener var1);
}
