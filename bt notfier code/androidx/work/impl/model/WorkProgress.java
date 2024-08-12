/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 */
package androidx.work.impl.model;

import androidx.work.Data;

public class WorkProgress {
    public final Data mProgress;
    public final String mWorkSpecId;

    public WorkProgress(String string, Data data) {
        this.mWorkSpecId = string;
        this.mProgress = data;
    }
}
