/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.internal.zaal
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabb
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zaal;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zaak
extends zabb {
    final BaseGmsClient.ConnectionProgressReportCallbacks zaa;

    zaak(zaal zaal2, zaba zaba2, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zaa = connectionProgressReportCallbacks;
        super(zaba2);
    }

    public final void zaa() {
        this.zaa.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
