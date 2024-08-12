/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  androidx.work.Logger
 */
package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WakeLocks {
    private static final String TAG = Logger.tagWithPrefix((String)"WakeLocks");
    private static final WeakHashMap<PowerManager.WakeLock, String> sWakeLocks = new WeakHashMap();

    private WakeLocks() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static void checkWakeLocks() {
        HashMap<PowerManager.WakeLock, String> hashMap = new HashMap<PowerManager.WakeLock, String>();
        Object object = sWakeLocks;
        synchronized (object) {
            hashMap.putAll(sWakeLocks);
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl6 : MonitorExitStatement: MONITOREXIT : var1_2
            object = hashMap.keySet().iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (object.hasNext()) {
            Object object2 = (PowerManager.WakeLock)object.next();
            if (object2 == null || !object2.isHeld()) continue;
            object2 = String.format("WakeLock held for %s", hashMap.get(object2));
            Logger.get().warning(TAG, (String)object2, new Throwable[0]);
        }
    }

    public static PowerManager.WakeLock newWakeLock(Context object, String string) {
        object = (PowerManager)object.getApplicationContext().getSystemService("power");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkManager: ");
        stringBuilder.append(string);
        string = stringBuilder.toString();
        stringBuilder = object.newWakeLock(1, string);
        object = sWakeLocks;
        synchronized (object) {
            sWakeLocks.put((PowerManager.WakeLock)stringBuilder, string);
            return stringBuilder;
        }
    }
}
