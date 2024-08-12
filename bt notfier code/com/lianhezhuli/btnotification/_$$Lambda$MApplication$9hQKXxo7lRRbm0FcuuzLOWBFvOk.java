/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.lianhezhuli.btnotification.MApplication
 */
package com.lianhezhuli.btnotification;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.lianhezhuli.btnotification.MApplication;

public final class _$$Lambda$MApplication$9hQKXxo7lRRbm0FcuuzLOWBFvOk
implements OnInitializationCompleteListener {
    public static final _$$Lambda$MApplication$9hQKXxo7lRRbm0FcuuzLOWBFvOk INSTANCE = new _$$Lambda$MApplication$9hQKXxo7lRRbm0FcuuzLOWBFvOk();

    private /* synthetic */ _$$Lambda$MApplication$9hQKXxo7lRRbm0FcuuzLOWBFvOk() {
    }

    public final void onInitializationComplete(InitializationStatus initializationStatus) {
        MApplication.lambda$onCreate$0((InitializationStatus)initializationStatus);
    }
}
