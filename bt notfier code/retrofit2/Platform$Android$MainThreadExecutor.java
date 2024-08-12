/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

static final class Platform.Android.MainThreadExecutor
implements Executor {
    private final Handler handler = new Handler(Looper.getMainLooper());

    Platform.Android.MainThreadExecutor() {
    }

    @Override
    public void execute(Runnable runnable) {
        this.handler.post(runnable);
    }
}
