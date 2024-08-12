/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.tasks.SuccessContinuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.Tasks
 */
package com.google.android.gms.common;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;

final class zaa
implements SuccessContinuation {
    static final SuccessContinuation zaa = new zaa();

    private zaa() {
    }

    public final Task then(Object object) {
        object = (Map)object;
        int n = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return Tasks.forResult(null);
    }
}
