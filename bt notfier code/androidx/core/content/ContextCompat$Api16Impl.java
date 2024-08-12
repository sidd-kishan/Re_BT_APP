/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

static class ContextCompat.Api16Impl {
    private ContextCompat.Api16Impl() {
    }

    static void startActivities(Context context, Intent[] intentArray, Bundle bundle) {
        context.startActivities(intentArray, bundle);
    }

    static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
