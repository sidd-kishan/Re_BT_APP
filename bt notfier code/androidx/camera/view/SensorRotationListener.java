/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;

public abstract class SensorRotationListener
extends OrientationEventListener {
    public static final int INVALID_SURFACE_ROTATION = -1;
    private int mRotation = -1;

    public SensorRotationListener(Context context) {
        super(context);
    }

    public void onOrientationChanged(int n) {
        if (n == -1) {
            return;
        }
        n = n < 315 && n >= 45 ? (n >= 225 ? 1 : (n >= 135 ? 2 : 3)) : 0;
        if (this.mRotation == n) return;
        this.mRotation = n;
        this.onRotationChanged(n);
    }

    public abstract void onRotationChanged(int var1);
}
