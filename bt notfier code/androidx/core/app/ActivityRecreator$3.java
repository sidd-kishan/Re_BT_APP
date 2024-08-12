/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.core.app.ActivityRecreator
 */
package androidx.core.app;

import android.util.Log;
import androidx.core.app.ActivityRecreator;

class ActivityRecreator.3
implements Runnable {
    final Object val$activityThread;
    final Object val$token;

    ActivityRecreator.3(Object object, Object object2) {
        this.val$activityThread = object;
        this.val$token = object2;
    }

    @Override
    public void run() {
        block4: {
            try {
                if (ActivityRecreator.performStopActivity3ParamsMethod != null) {
                    ActivityRecreator.performStopActivity3ParamsMethod.invoke(this.val$activityThread, this.val$token, false, "AppCompat recreation");
                    break block4;
                }
                ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, false);
            }
            catch (Throwable throwable) {
                Log.e((String)"ActivityRecreator", (String)"Exception while invoking performStopActivity", (Throwable)throwable);
            }
            catch (RuntimeException runtimeException) {
                if (runtimeException.getClass() != RuntimeException.class) return;
                if (runtimeException.getMessage() == null) return;
                if (runtimeException.getMessage().startsWith("Unable to stop")) throw runtimeException;
            }
        }
    }
}
