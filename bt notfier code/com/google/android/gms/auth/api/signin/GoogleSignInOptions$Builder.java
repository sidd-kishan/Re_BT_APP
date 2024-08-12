/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
 *  com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class GoogleSignInOptions.Builder {
    private Set<Scope> zaa = new HashSet<Scope>();
    private boolean zab;
    private boolean zac;
    private boolean zad;
    private String zae;
    private Account zaf;
    private String zag;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zah = new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>();
    private String zai;

    public GoogleSignInOptions.Builder() {
    }

    public GoogleSignInOptions.Builder(GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull((Object)googleSignInOptions);
        this.zaa = new HashSet<Scope>(GoogleSignInOptions.zac((GoogleSignInOptions)googleSignInOptions));
        this.zab = GoogleSignInOptions.zad((GoogleSignInOptions)googleSignInOptions);
        this.zac = GoogleSignInOptions.zae((GoogleSignInOptions)googleSignInOptions);
        this.zad = GoogleSignInOptions.zaf((GoogleSignInOptions)googleSignInOptions);
        this.zae = GoogleSignInOptions.zag((GoogleSignInOptions)googleSignInOptions);
        this.zaf = GoogleSignInOptions.zah((GoogleSignInOptions)googleSignInOptions);
        this.zag = GoogleSignInOptions.zai((GoogleSignInOptions)googleSignInOptions);
        this.zah = GoogleSignInOptions.zak((List)GoogleSignInOptions.zaj((GoogleSignInOptions)googleSignInOptions));
        this.zai = GoogleSignInOptions.zal((GoogleSignInOptions)googleSignInOptions);
    }

    private final String zaa(String string) {
        boolean bl;
        Preconditions.checkNotEmpty((String)string);
        String string2 = this.zae;
        boolean bl2 = bl = true;
        if (string2 != null) {
            bl2 = string2.equals(string) ? bl : false;
        }
        Preconditions.checkArgument((boolean)bl2, (Object)"two different server client ids provided");
        return string;
    }

    public GoogleSignInOptions.Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        if (this.zah.containsKey(googleSignInOptionsExtension.getExtensionType())) throw new IllegalStateException("Only one extension per type may be added");
        List list = googleSignInOptionsExtension.getImpliedScopes();
        if (list != null) {
            this.zaa.addAll(list);
        }
        this.zah.put(googleSignInOptionsExtension.getExtensionType(), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
        return this;
    }

    public GoogleSignInOptions build() {
        if (this.zaa.contains(GoogleSignInOptions.zae) && this.zaa.contains(GoogleSignInOptions.zad)) {
            this.zaa.remove(GoogleSignInOptions.zad);
        }
        if (!this.zad) return new GoogleSignInOptions(3, new ArrayList<Scope>(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
        if (this.zaf != null) {
            if (this.zaa.isEmpty()) return new GoogleSignInOptions(3, new ArrayList<Scope>(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
        }
        this.requestId();
        return new GoogleSignInOptions(3, new ArrayList<Scope>(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
    }

    public GoogleSignInOptions.Builder requestEmail() {
        this.zaa.add(GoogleSignInOptions.zab);
        return this;
    }

    public GoogleSignInOptions.Builder requestId() {
        this.zaa.add(GoogleSignInOptions.zac);
        return this;
    }

    public GoogleSignInOptions.Builder requestIdToken(String string) {
        this.zad = true;
        this.zaa(string);
        this.zae = string;
        return this;
    }

    public GoogleSignInOptions.Builder requestProfile() {
        this.zaa.add(GoogleSignInOptions.zaa);
        return this;
    }

    public GoogleSignInOptions.Builder requestScopes(Scope scope, Scope ... scopeArray) {
        this.zaa.add(scope);
        this.zaa.addAll(Arrays.asList(scopeArray));
        return this;
    }

    public GoogleSignInOptions.Builder requestServerAuthCode(String string) {
        this.requestServerAuthCode(string, false);
        return this;
    }

    public GoogleSignInOptions.Builder requestServerAuthCode(String string, boolean bl) {
        this.zab = true;
        this.zaa(string);
        this.zae = string;
        this.zac = bl;
        return this;
    }

    public GoogleSignInOptions.Builder setAccountName(String string) {
        this.zaf = new Account(Preconditions.checkNotEmpty((String)string), "com.google");
        return this;
    }

    public GoogleSignInOptions.Builder setHostedDomain(String string) {
        this.zag = Preconditions.checkNotEmpty((String)string);
        return this;
    }

    public GoogleSignInOptions.Builder setLogSessionId(String string) {
        this.zai = string;
        return this;
    }
}
