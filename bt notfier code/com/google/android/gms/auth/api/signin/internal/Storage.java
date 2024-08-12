/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.common.internal.Preconditions
 *  org.json.JSONException
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class Storage {
    private static final Lock zaa = new ReentrantLock();
    private static Storage zab;
    private final Lock zac = new ReentrantLock();
    private final SharedPreferences zad;

    Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static Storage getInstance(Context object) {
        Preconditions.checkNotNull((Object)object);
        zaa.lock();
        try {
            if (zab == null) {
                Storage storage;
                zab = storage = new Storage(object.getApplicationContext());
            }
            object = zab;
            return object;
        }
        finally {
            zaa.unlock();
        }
    }

    private static final String zae(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void clear() {
        this.zac.lock();
        try {
            this.zad.edit().clear().apply();
            return;
        }
        finally {
            this.zac.unlock();
        }
    }

    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String string = this.zab("defaultGoogleSignInAccount");
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        Object var3_4 = null;
        if (bl) {
            string = var3_4;
        } else {
            String string2 = this.zab(Storage.zae("googleSignInAccount", string));
            string = var3_4;
            if (string2 == null) return string;
            try {
                string = GoogleSignInAccount.zaa((String)string2);
            }
            catch (JSONException jSONException) {
                string = var3_4;
            }
        }
        return string;
    }

    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String string = this.zab("defaultGoogleSignInAccount");
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        Object var3_4 = null;
        if (bl) {
            string = var3_4;
        } else {
            String string2 = this.zab(Storage.zae("googleSignInOptions", string));
            string = var3_4;
            if (string2 == null) return string;
            try {
                string = GoogleSignInOptions.zaa((String)string2);
            }
            catch (JSONException jSONException) {
                string = var3_4;
            }
        }
        return string;
    }

    public String getSavedRefreshToken() {
        return this.zab("refreshToken");
    }

    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull((Object)googleSignInAccount);
        Preconditions.checkNotNull((Object)googleSignInOptions);
        this.zaa("defaultGoogleSignInAccount", googleSignInAccount.zac());
        Preconditions.checkNotNull((Object)googleSignInAccount);
        Preconditions.checkNotNull((Object)googleSignInOptions);
        String string = googleSignInAccount.zac();
        this.zaa(Storage.zae("googleSignInAccount", string), googleSignInAccount.zad());
        this.zaa(Storage.zae("googleSignInOptions", string), googleSignInOptions.zab());
    }

    protected final void zaa(String string, String string2) {
        this.zac.lock();
        try {
            this.zad.edit().putString(string, string2).apply();
            return;
        }
        finally {
            this.zac.unlock();
        }
    }

    protected final String zab(String string) {
        this.zac.lock();
        try {
            string = this.zad.getString(string, null);
            return string;
        }
        finally {
            this.zac.unlock();
        }
    }

    public final void zac() {
        String string = this.zab("defaultGoogleSignInAccount");
        this.zad("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        this.zad(Storage.zae("googleSignInAccount", string));
        this.zad(Storage.zae("googleSignInOptions", string));
    }

    protected final void zad(String string) {
        this.zac.lock();
        try {
            this.zad.edit().remove(string).apply();
            return;
        }
        finally {
            this.zac.unlock();
        }
    }
}
