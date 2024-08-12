/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

static class ContextCompat.Api26Impl {
    private ContextCompat.Api26Impl() {
    }

    static ComponentName startForegroundService(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }
}
