/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  androidx.collection.ArraySet
 *  com.google.android.gms.auth.api.signin.zaa
 *  com.google.android.gms.auth.api.signin.zab
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.common.util.DefaultClock
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.google.android.gms.auth.api.signin.zaa;
import com.google.android.gms.auth.api.signin.zab;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    public static Clock zaa = DefaultClock.getInstance();
    final int zab;
    List<Scope> zac;
    private String zad;
    private String zae;
    private String zaf;
    private String zag;
    private Uri zah;
    private String zai;
    private long zaj;
    private String zak;
    private String zal;
    private String zam;
    private Set<Scope> zan = new HashSet<Scope>();

    GoogleSignInAccount(int n, String string, String string2, String string3, String string4, Uri uri, String string5, long l, String string6, List<Scope> list, String string7, String string8) {
        this.zab = n;
        this.zad = string;
        this.zae = string2;
        this.zaf = string3;
        this.zag = string4;
        this.zah = uri;
        this.zai = string5;
        this.zaj = l;
        this.zak = string6;
        this.zac = list;
        this.zal = string7;
        this.zam = string8;
    }

    public static GoogleSignInAccount createDefault() {
        return GoogleSignInAccount.zae(new Account("<<default account>>", "com.google"), new HashSet<Scope>());
    }

    public static GoogleSignInAccount fromAccount(Account account) {
        return GoogleSignInAccount.zae(account, (Set<Scope>)new ArraySet());
    }

    public static GoogleSignInAccount zaa(String string) throws JSONException {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        Object var11_2 = null;
        if (bl) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(string);
        string = !TextUtils.isEmpty((CharSequence)(string = jSONObject.optString("photoUrl"))) ? Uri.parse((String)string) : null;
        long l = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet<Scope> hashSet = new HashSet<Scope>();
        Object object = jSONObject.getJSONArray("grantedScopes");
        int n = object.length();
        for (int i = 0; i < n; ++i) {
            hashSet.add(new Scope(object.getString(i)));
        }
        String string2 = jSONObject.optString("id");
        object = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String string3 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String string4 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String string5 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String string6 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        object = GoogleSignInAccount.zab(string2, (String)object, string3, string4, string5, string6, (Uri)string, l, jSONObject.getString("obfuscatedIdentifier"), hashSet);
        string = var11_2;
        if (jSONObject.has("serverAuthCode")) {
            string = jSONObject.optString("serverAuthCode");
        }
        object.zai = string;
        return object;
    }

    public static GoogleSignInAccount zab(String string, String string2, String string3, String string4, String string5, String string6, Uri uri, Long l, String string7, Set<Scope> set) {
        return new GoogleSignInAccount(3, string, string2, string3, string4, uri, null, l, Preconditions.checkNotEmpty((String)string7), new ArrayList<Scope>((Collection)Preconditions.checkNotNull(set)), string5, string6);
    }

    private static GoogleSignInAccount zae(Account account, Set<Scope> set) {
        return GoogleSignInAccount.zab(null, null, account.name, null, null, null, null, 0L, account.name, set);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof GoogleSignInAccount)) {
            return false;
        }
        object = (GoogleSignInAccount)((Object)object);
        if (!((GoogleSignInAccount)((Object)object)).zak.equals(this.zak)) return false;
        if (!((GoogleSignInAccount)((Object)object)).getRequestedScopes().equals(this.getRequestedScopes())) return false;
        return true;
    }

    public Account getAccount() {
        String string = this.zaf;
        if (string != null) return new Account(string, "com.google");
        return null;
    }

    public String getDisplayName() {
        return this.zag;
    }

    public String getEmail() {
        return this.zaf;
    }

    public String getFamilyName() {
        return this.zam;
    }

    public String getGivenName() {
        return this.zal;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet<Scope>(this.zac);
    }

    public String getId() {
        return this.zad;
    }

    public String getIdToken() {
        return this.zae;
    }

    public Uri getPhotoUrl() {
        return this.zah;
    }

    public Set<Scope> getRequestedScopes() {
        HashSet<Scope> hashSet = new HashSet<Scope>(this.zac);
        hashSet.addAll(this.zan);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.zai;
    }

    public int hashCode() {
        return (this.zak.hashCode() + 527) * 31 + this.getRequestedScopes().hashCode();
    }

    public boolean isExpired() {
        if (zaa.currentTimeMillis() / 1000L < this.zaj - 300L) return false;
        return true;
    }

    public GoogleSignInAccount requestExtraScopes(Scope ... scopeArray) {
        if (scopeArray == null) return this;
        Collections.addAll(this.zan, scopeArray);
        return this;
    }

    public void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zab);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.getId(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.getIdToken(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.getEmail(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)5, (String)this.getDisplayName(), (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)6, (Parcelable)this.getPhotoUrl(), (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)7, (String)this.getServerAuthCode(), (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)8, (long)this.zaj);
        SafeParcelWriter.writeString((Parcel)parcel, (int)9, (String)this.zak, (boolean)false);
        SafeParcelWriter.writeTypedList((Parcel)parcel, (int)10, this.zac, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)11, (String)this.getGivenName(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)12, (String)this.getFamilyName(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final String zac() {
        return this.zak;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final String zad() {
        Object object;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.getId() != null) {
                jSONObject.put("id", (Object)this.getId());
            }
            if (this.getIdToken() != null) {
                jSONObject.put("tokenId", (Object)this.getIdToken());
            }
            if (this.getEmail() != null) {
                jSONObject.put("email", (Object)this.getEmail());
            }
            if (this.getDisplayName() != null) {
                jSONObject.put("displayName", (Object)this.getDisplayName());
            }
            if (this.getGivenName() != null) {
                jSONObject.put("givenName", (Object)this.getGivenName());
            }
            if (this.getFamilyName() != null) {
                jSONObject.put("familyName", (Object)this.getFamilyName());
            }
            if ((object = this.getPhotoUrl()) != null) {
                jSONObject.put("photoUrl", (Object)object.toString());
            }
            if ((object = this.getServerAuthCode()) != null) {
                jSONObject.put("serverAuthCode", (Object)this.getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zaj);
            jSONObject.put("obfuscatedIdentifier", (Object)this.zak);
            object = new JSONArray();
            Scope[] scopeArray = this.zac;
            scopeArray = scopeArray.toArray(new Scope[scopeArray.size()]);
            Arrays.sort(scopeArray, com.google.android.gms.auth.api.signin.zaa.zaa);
            int n = scopeArray.length;
            for (int i = 0; i < n; ++i) {
                object.put((Object)scopeArray[i].getScopeUri());
            }
        }
        catch (JSONException jSONException) {
            RuntimeException runtimeException = new RuntimeException(jSONException);
            throw runtimeException;
        }
        {
            jSONObject.put("grantedScopes", object);
        }
        jSONObject.remove("serverAuthCode");
        return jSONObject.toString();
    }
}
