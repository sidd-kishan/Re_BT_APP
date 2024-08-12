/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.internal.Storage
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$LegacyClientCallbackAdapter
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.GmsClient
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zat
 *  com.google.android.gms.signin.internal.zae
 *  com.google.android.gms.signin.internal.zaf
 *  com.google.android.gms.signin.internal.zai
 *  com.google.android.gms.signin.internal.zak
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zaf;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;

public class SignInClientImpl
extends GmsClient<zaf>
implements com.google.android.gms.signin.zae {
    public static final int zaa = 0;
    private final boolean zab;
    private final ClientSettings zac;
    private final Bundle zad;
    private final Integer zae;

    public SignInClientImpl(Context context, Looper looper, boolean bl, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zab = true;
        this.zac = clientSettings;
        this.zad = bundle;
        this.zae = clientSettings.zad();
    }

    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        clientSettings.zac();
        Integer n = clientSettings.zad();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)clientSettings.getAccount());
        if (n != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", n.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    protected final Bundle getGetServiceRequestExtraArgs() {
        String string = this.zac.getRealClientPackageName();
        if (this.getContext().getPackageName().equals(string)) return this.zad;
        this.zad.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zac.getRealClientPackageName());
        return this.zad;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.zab;
    }

    public final void zaa(zae zae2) {
        Preconditions.checkNotNull((Object)zae2, (Object)"Expecting a valid ISignInCallbacks");
        try {
            Account account = this.zac.getAccountOrDefault();
            GoogleSignInAccount googleSignInAccount = "<<default account>>".equals(account.name) ? Storage.getInstance((Context)this.getContext()).getSavedDefaultGoogleSignInAccount() : null;
            zat zat2 = new zat(account, ((Integer)Preconditions.checkNotNull((Object)this.zae)).intValue(), googleSignInAccount);
            account = (zaf)this.getService();
            googleSignInAccount = new zai(1, zat2);
            account.zag((zai)googleSignInAccount, zae2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when signIn is called");
            try {
                ConnectionResult connectionResult = new ConnectionResult(8, null);
                zak zak2 = new zak(1, connectionResult, null);
                zae2.zab(zak2);
                return;
            }
            catch (RemoteException remoteException2) {
                Log.wtf((String)"SignInClientImpl", (String)"ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)remoteException);
                return;
            }
        }
    }

    public final void zab(IAccountAccessor iAccountAccessor, boolean bl) {
        try {
            ((zaf)this.getService()).zaf(iAccountAccessor, ((Integer)Preconditions.checkNotNull((Object)this.zae)).intValue(), bl);
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when saveDefaultAccount is called");
            return;
        }
    }

    public final void zac() {
        try {
            ((zaf)this.getService()).zae(((Integer)Preconditions.checkNotNull((Object)this.zae)).intValue());
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when clearAccountFromSessionStore is called");
            return;
        }
    }

    public final void zad() {
        this.connect((BaseGmsClient.ConnectionProgressReportCallbacks)new BaseGmsClient.LegacyClientCallbackAdapter((BaseGmsClient)this));
    }
}
