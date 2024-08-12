/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.GoogleApiClient$Builder
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.zab
 *  com.google.android.gms.signin.SignInOptions
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class ClientSettings {
    @Nullable
    private final Account zaa;
    private final Set<Scope> zab;
    private final Set<Scope> zac;
    private final Map<Api<?>, zab> zad;
    private final int zae;
    @Nullable
    private final View zaf;
    private final String zag;
    private final String zah;
    private final SignInOptions zai;
    private Integer zaj;

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, zab> map, int n, @Nullable View view, String string, String string2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, n, view, string, string2, signInOptions, false);
    }

    public ClientSettings(@Nullable Account object, Set<Scope> object2, Map<Api<?>, zab> map, int n, @Nullable View view, String string, String string2, @Nullable SignInOptions signInOptions, boolean bl) {
        this.zaa = object;
        object = object2 == null ? Collections.emptySet() : Collections.unmodifiableSet(object2);
        this.zab = object;
        object = map;
        if (map == null) {
            object = Collections.emptyMap();
        }
        this.zad = object;
        this.zaf = view;
        this.zae = n;
        this.zag = string;
        this.zah = string2;
        object = signInOptions;
        if (signInOptions == null) {
            object = SignInOptions.zaa;
        }
        this.zai = object;
        object = new HashSet<Scope>(this.zab);
        object2 = this.zad.values().iterator();
        while (true) {
            if (!object2.hasNext()) {
                this.zac = Collections.unmodifiableSet(object);
                return;
            }
            object.addAll(((zab)object2.next()).zaa);
        }
    }

    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).buildClientSettings();
    }

    public Account getAccount() {
        return this.zaa;
    }

    @Deprecated
    public String getAccountName() {
        Account account = this.zaa;
        if (account == null) return null;
        return account.name;
    }

    public Account getAccountOrDefault() {
        Account account = this.zaa;
        if (account == null) return new Account("<<default account>>", "com.google");
        return account;
    }

    public Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    public Set<Scope> getApplicableScopes(Api<?> zab2) {
        if ((zab2 = this.zad.get(zab2)) == null) return this.zab;
        if (zab2.zaa.isEmpty()) {
            return this.zab;
        }
        HashSet<Scope> hashSet = new HashSet<Scope>(this.zab);
        hashSet.addAll(zab2.zaa);
        return hashSet;
    }

    public int getGravityForPopups() {
        return this.zae;
    }

    public String getRealClientPackageName() {
        return this.zag;
    }

    public Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    public View getViewForPopups() {
        return this.zaf;
    }

    public final Map<Api<?>, zab> zaa() {
        return this.zad;
    }

    public final String zab() {
        return this.zah;
    }

    public final SignInOptions zac() {
        return this.zai;
    }

    public final Integer zad() {
        return this.zaj;
    }

    public final void zae(Integer n) {
        this.zaj = n;
    }
}
