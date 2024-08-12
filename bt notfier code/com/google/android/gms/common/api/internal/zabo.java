/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zabn
 *  com.google.android.gms.common.api.internal.zacn
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.IAccountAccessor
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zabn;
import com.google.android.gms.common.api.internal.zacn;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

final class zabo
implements BaseGmsClient.ConnectionProgressReportCallbacks,
zacn {
    final GoogleApiManager zaa;
    private final Api.Client zab;
    private final ApiKey<?> zac;
    private IAccountAccessor zad;
    private Set<Scope> zae;
    private boolean zaf;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zabo(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.zaa = googleApiManager;
        this.zad = null;
        this.zae = null;
        this.zaf = false;
        this.zab = client;
        this.zac = apiKey;
    }

    static /* synthetic */ ApiKey zac(zabo zabo2) {
        return zabo2.zac;
    }

    static /* synthetic */ boolean zad(zabo zabo2, boolean bl) {
        zabo2.zaf = true;
        return true;
    }

    static /* synthetic */ Api.Client zae(zabo zabo2) {
        return zabo2.zab;
    }

    static /* synthetic */ void zaf(zabo zabo2) {
        zabo2.zag();
    }

    private final void zag() {
        if (!this.zaf) return;
        IAccountAccessor iAccountAccessor = this.zad;
        if (iAccountAccessor == null) return;
        this.zab.getRemoteService(iAccountAccessor, this.zae);
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        GoogleApiManager.zas((GoogleApiManager)this.zaa).post((Runnable)new zabn(this, connectionResult));
    }

    public final void zaa(ConnectionResult connectionResult) {
        zabl zabl2 = (zabl)GoogleApiManager.zaG((GoogleApiManager)this.zaa).get(this.zac);
        if (zabl2 == null) return;
        zabl2.zab(connectionResult);
    }

    public final void zab(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        if (iAccountAccessor != null && set != null) {
            this.zad = iAccountAccessor;
            this.zae = set;
            this.zag();
            return;
        }
        Log.wtf((String)"GoogleApiManager", (String)"Received null response from onSignInSuccess", (Throwable)new Exception());
        this.zaa(new ConnectionResult(4));
    }
}
