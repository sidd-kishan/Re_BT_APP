/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.internal.zacl
 *  com.google.android.gms.common.api.internal.zacm
 *  com.google.android.gms.common.api.internal.zacn
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zav
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.internal.zac
 *  com.google.android.gms.signin.internal.zae
 *  com.google.android.gms.signin.internal.zak
 *  com.google.android.gms.signin.zad
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zacl;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zacn;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zaco
extends zac
implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener {
    private static final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> zaa = com.google.android.gms.signin.zad.zac;
    private final Context zab;
    private final Handler zac;
    private final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> zad;
    private final Set<Scope> zae;
    private final ClientSettings zaf;
    private com.google.android.gms.signin.zae zag;
    private zacn zah;

    public zaco(Context context, Handler handler, ClientSettings clientSettings) {
        Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = zaa;
        this.zab = context;
        this.zac = handler;
        this.zaf = (ClientSettings)Preconditions.checkNotNull((Object)clientSettings, (Object)"ClientSettings must not be null");
        this.zae = clientSettings.getRequiredScopes();
        this.zad = abstractClientBuilder;
    }

    static /* synthetic */ zacn zae(zaco zaco2) {
        return zaco2.zah;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static /* synthetic */ void zaf(zaco var0, zak var1_1) {
        var2_3 = var3_2 /* !! */  = var1_1.zaa();
        if (!var3_2 /* !! */ .isSuccess()) ** GOTO lbl13
        var2_3 = (var1_1 = (zav)Preconditions.checkNotNull((Object)var1_1.zab())).zab();
        if (!var2_3.isSuccess()) {
            var3_2 /* !! */  = String.valueOf(var2_3);
            var1_1 = new StringBuilder(String.valueOf(var3_2 /* !! */ ).length() + 48);
            var1_1.append("Sign-in succeeded with resolve account failure: ");
            var1_1.append((String)var3_2 /* !! */ );
            Log.wtf((String)"SignInCoordinator", (String)var1_1.toString(), (Throwable)new Exception());
lbl13:
            // 2 sources

            var0.zah.zaa(var2_3);
        } else {
            var0.zah.zab(var1_1.zaa(), var0.zae);
        }
        var0.zag.disconnect();
    }

    public final void onConnected(Bundle bundle) {
        this.zag.zaa((zae)this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.zaa(connectionResult);
    }

    public final void onConnectionSuspended(int n) {
        this.zag.disconnect();
    }

    public final void zab(zak zak2) {
        this.zac.post((Runnable)new zacm(this, zak2));
    }

    public final void zac(zacn object) {
        com.google.android.gms.signin.zae zae2 = this.zag;
        if (zae2 != null) {
            zae2.disconnect();
        }
        this.zaf.zae(Integer.valueOf(System.identityHashCode((Object)this)));
        Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = this.zad;
        Context context = this.zab;
        Looper looper = this.zac.getLooper();
        zae2 = this.zaf;
        this.zag = abstractClientBuilder.buildClient(context, looper, (ClientSettings)zae2, (Object)zae2.zac(), (GoogleApiClient.ConnectionCallbacks)this, (GoogleApiClient.OnConnectionFailedListener)this);
        this.zah = object;
        object = this.zae;
        if (object != null && !object.isEmpty()) {
            this.zag.zad();
            return;
        }
        this.zac.post((Runnable)new zacl(this));
    }

    public final void zad() {
        com.google.android.gms.signin.zae zae2 = this.zag;
        if (zae2 == null) return;
        zae2.disconnect();
    }
}
