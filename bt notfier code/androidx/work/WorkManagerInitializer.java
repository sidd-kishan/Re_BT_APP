/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.startup.Initializer
 *  androidx.work.Configuration
 *  androidx.work.Configuration$Builder
 *  androidx.work.Logger
 *  androidx.work.WorkManager
 */
package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkManager;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer
implements Initializer<WorkManager> {
    private static final String TAG = Logger.tagWithPrefix((String)"WrkMgrInitializer");

    public WorkManager create(Context context) {
        Logger.get().debug(TAG, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManager.initialize((Context)context, (Configuration)new Configuration.Builder().build());
        return WorkManager.getInstance((Context)context);
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
