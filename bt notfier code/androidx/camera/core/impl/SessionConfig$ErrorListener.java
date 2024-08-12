/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$SessionError
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SessionConfig;

public static interface SessionConfig.ErrorListener {
    public void onError(SessionConfig var1, SessionConfig.SessionError var2);
}
