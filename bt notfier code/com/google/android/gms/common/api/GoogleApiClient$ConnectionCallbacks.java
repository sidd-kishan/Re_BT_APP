/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.ConnectionCallbacks;

@Deprecated
public static interface GoogleApiClient.ConnectionCallbacks
extends ConnectionCallbacks {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
}
