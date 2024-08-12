/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package androidx.core.os;

import android.os.Process;

static class ProcessCompat.Api24Impl {
    private ProcessCompat.Api24Impl() {
    }

    static boolean isApplicationUid(int n) {
        return Process.isApplicationUid((int)n);
    }
}
