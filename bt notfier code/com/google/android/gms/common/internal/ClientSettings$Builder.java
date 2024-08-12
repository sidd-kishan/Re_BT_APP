/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  androidx.collection.ArraySet
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.signin.SignInOptions
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import javax.annotation.Nullable;

public static final class ClientSettings.Builder {
    @Nullable
    private Account zaa;
    private ArraySet<Scope> zab;
    private String zac;
    private String zad;
    private SignInOptions zae = SignInOptions.zaa;

    public ClientSettings build() {
        return new ClientSettings(this.zaa, this.zab, null, 0, null, this.zac, this.zad, this.zae, false);
    }

    public ClientSettings.Builder setRealClientPackageName(String string) {
        this.zac = string;
        return this;
    }

    public final ClientSettings.Builder zaa(@Nullable Account account) {
        this.zaa = account;
        return this;
    }

    public final ClientSettings.Builder zab(Collection<Scope> collection) {
        if (this.zab == null) {
            this.zab = new ArraySet();
        }
        this.zab.addAll(collection);
        return this;
    }

    public final ClientSettings.Builder zac(String string) {
        this.zad = string;
        return this;
    }
}
