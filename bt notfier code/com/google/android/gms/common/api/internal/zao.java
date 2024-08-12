/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  com.google.android.gms.common.api.internal.zabq
 *  com.google.android.gms.common.api.internal.zam
 *  com.google.android.gms.common.api.internal.zan
 *  com.google.android.gms.common.api.internal.zap
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.api.internal.zan;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.common.internal.Preconditions;

final class zao
implements Runnable {
    final zap zaa;
    private final zam zab;

    zao(zap zap2, zam zam2) {
        this.zaa = zap2;
        this.zab = zam2;
    }

    @Override
    public final void run() {
        if (!this.zaa.zaa) {
            return;
        }
        ConnectionResult connectionResult = this.zab.zab();
        if (connectionResult.hasResolution()) {
            this.zaa.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa((Context)this.zaa.getActivity(), (PendingIntent)((PendingIntent)Preconditions.checkNotNull((Object)connectionResult.getResolution())), (int)this.zab.zaa(), (boolean)false), 1);
            return;
        }
        zap zap2 = this.zaa;
        if (zap2.zac.getErrorResolutionIntent((Context)zap2.getActivity(), connectionResult.getErrorCode(), null) != null) {
            zap2 = this.zaa;
            zap2.zac.zaa(zap2.getActivity(), this.zaa.mLifecycleFragment, connectionResult.getErrorCode(), 2, (DialogInterface.OnCancelListener)this.zaa);
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            connectionResult = this.zaa;
            zap2 = connectionResult.zac.zad(connectionResult.getActivity(), (DialogInterface.OnCancelListener)this.zaa);
            connectionResult = this.zaa;
            connectionResult.zac.zae(connectionResult.getActivity().getApplicationContext(), (zabq)new zan(this, (Dialog)zap2));
            return;
        }
        zap.zah((zap)this.zaa, (ConnectionResult)connectionResult, (int)this.zab.zaa());
    }
}
