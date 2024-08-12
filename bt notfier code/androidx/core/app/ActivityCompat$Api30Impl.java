/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.LocusId
 *  android.os.Bundle
 *  androidx.core.content.LocusIdCompat
 */
package androidx.core.app;

import android.app.Activity;
import android.content.LocusId;
import android.os.Bundle;
import androidx.core.content.LocusIdCompat;

static class ActivityCompat.Api30Impl {
    private ActivityCompat.Api30Impl() {
    }

    static void setLocusContext(Activity activity, LocusIdCompat object, Bundle bundle) {
        object = object == null ? null : object.toLocusId();
        activity.setLocusContext((LocusId)object, bundle);
    }
}
