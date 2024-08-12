/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  androidx.collection.ArrayMap
 *  androidx.fragment.app.FragmentActivity
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.Api$ApiOptions$HasOptions
 *  com.google.android.gms.common.api.Api$ApiOptions$NotRequiredOptions
 *  com.google.android.gms.common.api.Api$BaseClientBuilder
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.internal.LifecycleActivity
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.common.api.internal.zak
 *  com.google.android.gms.common.api.internal.zas
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zab
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.zad
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Exception performing whole class analysis ignored.
 */
@Deprecated
public static final class GoogleApiClient.Builder {
    private Account zaa;
    private final Set<Scope> zab = new HashSet<Scope>();
    private final Set<Scope> zac = new HashSet<Scope>();
    private int zad;
    private View zae;
    private String zaf;
    private String zag;
    private final Map<Api<?>, zab> zah = new ArrayMap();
    private final Context zai;
    private final Map<Api<?>, Api.ApiOptions> zaj = new ArrayMap();
    private LifecycleActivity zak;
    private int zal = -1;
    private GoogleApiClient.OnConnectionFailedListener zam;
    private Looper zan;
    private GoogleApiAvailability zao = GoogleApiAvailability.getInstance();
    private Api.AbstractClientBuilder<? extends zae, SignInOptions> zap = com.google.android.gms.signin.zad.zac;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaq = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zar = new ArrayList();

    public GoogleApiClient.Builder(Context context) {
        this.zai = context;
        this.zan = context.getMainLooper();
        this.zaf = context.getPackageName();
        this.zag = context.getClass().getName();
    }

    public GoogleApiClient.Builder(Context context, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context);
        Preconditions.checkNotNull((Object)connectionCallbacks, (Object)"Must provide a connected listener");
        this.zaq.add(connectionCallbacks);
        Preconditions.checkNotNull((Object)onConnectionFailedListener, (Object)"Must provide a connection failed listener");
        this.zar.add(onConnectionFailedListener);
    }

    private final <O extends Api.ApiOptions> void zaa(Api<O> api, O object, Scope ... scopeArray) {
        object = new HashSet(((Api.BaseClientBuilder)Preconditions.checkNotNull((Object)api.zaa(), (Object)"Base client builder must not be null")).getImpliedScopes(object));
        int n = scopeArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zah.put(api, new zab((Set)object));
                return;
            }
            object.add((Scope)scopeArray[n2]);
            ++n2;
        }
    }

    public GoogleApiClient.Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> object) {
        Preconditions.checkNotNull(object, (Object)"Api must not be null");
        this.zaj.put((Api<?>)object, (Api.ApiOptions)null);
        object = ((Api.BaseClientBuilder)Preconditions.checkNotNull((Object)object.zaa(), (Object)"Base client builder must not be null")).getImpliedScopes(null);
        this.zac.addAll((Collection<Scope>)object);
        this.zab.addAll((Collection<Scope>)object);
        return this;
    }

    public <O extends Api.ApiOptions.HasOptions> GoogleApiClient.Builder addApi(Api<O> object, O o) {
        Preconditions.checkNotNull(object, (Object)"Api must not be null");
        Preconditions.checkNotNull(o, (Object)"Null options are not permitted for this Api");
        this.zaj.put((Api<?>)object, (Api.ApiOptions)o);
        object = ((Api.BaseClientBuilder)Preconditions.checkNotNull((Object)object.zaa(), (Object)"Base client builder must not be null")).getImpliedScopes(o);
        this.zac.addAll((Collection<Scope>)object);
        this.zab.addAll((Collection<Scope>)object);
        return this;
    }

    public <O extends Api.ApiOptions.HasOptions> GoogleApiClient.Builder addApiIfAvailable(Api<O> api, O o, Scope ... scopeArray) {
        Preconditions.checkNotNull(api, (Object)"Api must not be null");
        Preconditions.checkNotNull(o, (Object)"Null options are not permitted for this Api");
        this.zaj.put(api, (Api.ApiOptions)o);
        this.zaa(api, o, scopeArray);
        return this;
    }

    public <T extends Api.ApiOptions.NotRequiredOptions> GoogleApiClient.Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope ... scopeArray) {
        Preconditions.checkNotNull(api, (Object)"Api must not be null");
        this.zaj.put(api, null);
        this.zaa(api, null, scopeArray);
        return this;
    }

    public GoogleApiClient.Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull((Object)connectionCallbacks, (Object)"Listener must not be null");
        this.zaq.add(connectionCallbacks);
        return this;
    }

    public GoogleApiClient.Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull((Object)onConnectionFailedListener, (Object)"Listener must not be null");
        this.zar.add(onConnectionFailedListener);
        return this;
    }

    public GoogleApiClient.Builder addScope(Scope scope) {
        Preconditions.checkNotNull((Object)scope, (Object)"Scope must not be null");
        this.zab.add(scope);
        return this;
    }

    public GoogleApiClient.Builder addScopeNames(String[] stringArray) {
        int n = 0;
        while (n < stringArray.length) {
            this.zab.add(new Scope(stringArray[n]));
            ++n;
        }
        return this;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public GoogleApiClient build() {
        int n;
        boolean bl;
        Object object;
        Preconditions.checkArgument((boolean)(this.zaj.isEmpty() ^ true), (Object)"must call addApi() to add at least one API");
        ClientSettings clientSettings = this.buildClientSettings();
        Map map = clientSettings.zaa();
        Object object2 = new ArrayMap();
        ArrayMap arrayMap = new ArrayMap();
        ArrayList<zas> arrayList = new ArrayList<zas>();
        Iterator<Api<?>> iterator = this.zaj.keySet().iterator();
        Object object3 = null;
        int n2 = 0;
        while (iterator.hasNext()) {
            object = iterator.next();
            Api.ApiOptions apiOptions = this.zaj.get(object);
            bl = map.get(object) != null;
            object2.put(object, bl);
            zas zas2 = new zas((Api)object, bl);
            arrayList.add(zas2);
            Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder)Preconditions.checkNotNull((Object)object.zab());
            zas2 = abstractClientBuilder.buildClient(this.zai, this.zan, clientSettings, (Object)apiOptions, (GoogleApiClient.ConnectionCallbacks)zas2, (GoogleApiClient.OnConnectionFailedListener)zas2);
            arrayMap.put(object.zac(), zas2);
            n = n2;
            if (abstractClientBuilder.getPriority() == 1) {
                n = apiOptions != null ? 1 : 0;
            }
            n2 = n;
            if (!zas2.providesSignIn()) continue;
            if (object3 != null) {
                object = object.zad();
                object3 = object3.zad();
                object2 = new StringBuilder(String.valueOf(object).length() + 21 + String.valueOf(object3).length());
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" cannot be used with ");
                ((StringBuilder)object2).append((String)object3);
                throw new IllegalStateException(((StringBuilder)object2).toString());
            }
            object3 = object;
            n2 = n;
        }
        if (object3 != null) {
            if (n2 != 0) {
                object3 = object3.zad();
                object = new StringBuilder(String.valueOf(object3).length() + 82);
                ((StringBuilder)object).append("With using ");
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            bl = this.zaa == null;
            Preconditions.checkState((boolean)bl, (String)"Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", (Object[])new Object[]{object3.zad()});
            Preconditions.checkState((boolean)this.zab.equals(this.zac), (String)"Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", (Object[])new Object[]{object3.zad()});
        }
        n = zaaz.zaf(arrayMap.values(), (boolean)true);
        object = new zaaz(this.zai, (Lock)new ReentrantLock(), this.zan, clientSettings, this.zao, this.zap, (Map)object2, this.zaq, this.zar, (Map)arrayMap, this.zal, n, arrayList);
        object3 = GoogleApiClient.zaq();
        synchronized (object3) {
            GoogleApiClient.zaq().add(object);
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl63 : MonitorExitStatement: MONITOREXIT : var4_7
            if (this.zal < 0) return object;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        com.google.android.gms.common.api.internal.zak.zaa((LifecycleActivity)this.zak).zab(this.zal, (GoogleApiClient)object, this.zam);
        return object;
    }

    public ClientSettings buildClientSettings() {
        SignInOptions signInOptions = SignInOptions.zaa;
        if (!this.zaj.containsKey(com.google.android.gms.signin.zad.zag)) return new ClientSettings(this.zaa, this.zab, this.zah, this.zad, this.zae, this.zaf, this.zag, signInOptions, false);
        signInOptions = (SignInOptions)this.zaj.get(com.google.android.gms.signin.zad.zag);
        return new ClientSettings(this.zaa, this.zab, this.zah, this.zad, this.zae, this.zaf, this.zag, signInOptions, false);
    }

    public GoogleApiClient.Builder enableAutoManage(FragmentActivity fragmentActivity, int n, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        fragmentActivity = new LifecycleActivity((Activity)fragmentActivity);
        boolean bl = n >= 0;
        Preconditions.checkArgument((boolean)bl, (Object)"clientId must be non-negative");
        this.zal = n;
        this.zam = onConnectionFailedListener;
        this.zak = fragmentActivity;
        return this;
    }

    public GoogleApiClient.Builder enableAutoManage(FragmentActivity fragmentActivity, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        return this;
    }

    public GoogleApiClient.Builder setAccountName(String string) {
        string = string == null ? null : new Account(string, "com.google");
        this.zaa = string;
        return this;
    }

    public GoogleApiClient.Builder setGravityForPopups(int n) {
        this.zad = n;
        return this;
    }

    public GoogleApiClient.Builder setHandler(Handler handler) {
        Preconditions.checkNotNull((Object)handler, (Object)"Handler must not be null");
        this.zan = handler.getLooper();
        return this;
    }

    public GoogleApiClient.Builder setViewForPopups(View view) {
        Preconditions.checkNotNull((Object)view, (Object)"View must not be null");
        this.zae = view;
        return this;
    }

    public GoogleApiClient.Builder useDefaultAccount() {
        this.setAccountName("<<default account>>");
        return this;
    }
}
