/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.mediation.MediationExtrasReceiver
 */
package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.mediation.MediationExtrasReceiver;

@Deprecated
public interface MediationAdapter
extends MediationExtrasReceiver {
    public void onDestroy();

    public void onPause();

    public void onResume();
}
