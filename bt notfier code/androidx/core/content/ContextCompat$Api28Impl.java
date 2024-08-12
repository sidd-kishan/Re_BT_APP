/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.core.content;

import android.content.Context;
import java.util.concurrent.Executor;

static class ContextCompat.Api28Impl {
    private ContextCompat.Api28Impl() {
    }

    static Executor getMainExecutor(Context context) {
        return context.getMainExecutor();
    }
}
