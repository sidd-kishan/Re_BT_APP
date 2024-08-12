/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.core.os.ExecutorCompat$HandlerExecutor
 */
package androidx.core.os;

import android.os.Handler;
import androidx.core.os.ExecutorCompat;
import java.util.concurrent.Executor;

public final class ExecutorCompat {
    private ExecutorCompat() {
    }

    public static Executor create(Handler handler) {
        return new HandlerExecutor(handler);
    }
}
