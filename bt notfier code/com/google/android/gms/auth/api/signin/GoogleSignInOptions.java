/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
 *  com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable
 *  com.google.android.gms.auth.api.signin.internal.HashAccumulator
 *  com.google.android.gms.auth.api.signin.zac
 *  com.google.android.gms.auth.api.signin.zad
 *  com.google.android.gms.common.api.Api$ApiOptions$Optional
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.auth.api.signin.zac;
import com.google.android.gms.auth.api.signin.zad;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
extends AbstractSafeParcelable
implements Api.ApiOptions.Optional,
ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    public static final Scope zaa;
    public static final Scope zab;
    public static final Scope zac;
    public static final Scope zad;
    public static final Scope zae;
    private static Comparator<Scope> zaq;
    final int zaf;
    private final ArrayList<Scope> zag;
    private Account zah;
    private boolean zai;
    private final boolean zaj;
    private final boolean zak;
    private String zal;
    private String zam;
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zan;
    private String zao;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zap;

    static {
        zaa = new Scope("profile");
        zab = new Scope("email");
        zac = new Scope("openid");
        zad = new Scope("https://www.googleapis.com/auth/games_lite");
        zae = new Scope("https://www.googleapis.com/auth/games");
        Builder builder = new Builder();
        builder.requestId();
        builder.requestProfile();
        DEFAULT_SIGN_IN = builder.build();
        builder = new Builder();
        builder.requestScopes(zad, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = builder.build();
        CREATOR = new zad();
        zaq = new zac();
    }

    GoogleSignInOptions(int n, ArrayList<Scope> arrayList, Account account, boolean bl, boolean bl2, boolean bl3, String string, String string2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, String string3) {
        this(n, arrayList, account, bl, bl2, bl3, string, string2, GoogleSignInOptions.zam(arrayList2), string3);
    }

    private GoogleSignInOptions(int n, ArrayList<Scope> arrayList, Account account, boolean bl, boolean bl2, boolean bl3, String string, String string2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String string3) {
        this.zaf = n;
        this.zag = arrayList;
        this.zah = account;
        this.zai = bl;
        this.zaj = bl2;
        this.zak = bl3;
        this.zal = string;
        this.zam = string2;
        this.zan = new ArrayList<GoogleSignInOptionsExtensionParcelable>(map.values());
        this.zap = map;
        this.zao = string3;
    }

    /* synthetic */ GoogleSignInOptions(int n, ArrayList arrayList, Account account, boolean bl, boolean bl2, boolean bl3, String string, String string2, Map map, String string3, zac zac2) {
        this(3, (ArrayList<Scope>)arrayList, account, bl, bl2, bl3, string, string2, map, string3);
    }

    public static GoogleSignInOptions zaa(String string) throws JSONException {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        String string2 = null;
        if (bl) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(string);
        Object object = new HashSet<Scope>();
        string = jSONObject.getJSONArray("scopes");
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            object.add(new Scope(string.getString(i)));
        }
        string = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        string = !TextUtils.isEmpty((CharSequence)string) ? new Account(string, "com.google") : null;
        ArrayList<Scope> arrayList = new ArrayList<Scope>((Collection<Scope>)object);
        boolean bl2 = jSONObject.getBoolean("idTokenRequested");
        boolean bl3 = jSONObject.getBoolean("serverAuthRequested");
        bl = jSONObject.getBoolean("forceCodeForRefreshToken");
        object = jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null;
        if (!jSONObject.has("hostedDomain")) return new GoogleSignInOptions(3, arrayList, (Account)string, bl2, bl3, bl, (String)object, string2, new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>(), null);
        string2 = jSONObject.optString("hostedDomain");
        return new GoogleSignInOptions(3, arrayList, (Account)string, bl2, bl3, bl, (String)object, string2, new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>(), null);
    }

    static /* synthetic */ ArrayList zac(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zag;
    }

    static /* synthetic */ boolean zad(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaj;
    }

    static /* synthetic */ boolean zae(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zak;
    }

    static /* synthetic */ boolean zaf(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zai;
    }

    static /* synthetic */ String zag(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zal;
    }

    static /* synthetic */ Account zah(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zah;
    }

    static /* synthetic */ String zai(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zam;
    }

    static /* synthetic */ ArrayList zaj(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zan;
    }

    static /* synthetic */ Map zak(List list) {
        return GoogleSignInOptions.zam(list);
    }

    static /* synthetic */ String zal(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zao;
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zam(List<GoogleSignInOptionsExtensionParcelable> object) {
        HashMap<Integer, GoogleSignInOptionsExtensionParcelable> hashMap = new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>();
        if (object == null) {
            return hashMap;
        }
        object = object.iterator();
        while (object.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable)object.next();
            hashMap.put(googleSignInOptionsExtensionParcelable.getType(), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public boolean equals(Object object) {
        block8: {
            if (object == null) {
                return false;
            }
            try {
                object = (GoogleSignInOptions)((Object)object);
                if (this.zan.size() > 0) return false;
                if (((GoogleSignInOptions)((Object)object)).zan.size() > 0) break block8;
                if (this.zag.size() != ((GoogleSignInOptions)((Object)object)).getScopes().size()) return false;
                if (!this.zag.containsAll(((GoogleSignInOptions)((Object)object)).getScopes())) break block8;
                Account account = this.zah;
                if (account == null) {
                    if (((GoogleSignInOptions)((Object)object)).getAccount() != null) return false;
                } else if (!account.equals((Object)((GoogleSignInOptions)((Object)object)).getAccount())) return false;
                if (TextUtils.isEmpty((CharSequence)this.zal)) {
                    if (!TextUtils.isEmpty((CharSequence)((GoogleSignInOptions)((Object)object)).getServerClientId())) return false;
                } else if (!this.zal.equals(((GoogleSignInOptions)((Object)object)).getServerClientId())) break block8;
                if (this.zak != ((GoogleSignInOptions)((Object)object)).isForceCodeForRefreshToken()) return false;
                if (this.zai != ((GoogleSignInOptions)((Object)object)).isIdTokenRequested()) return false;
                if (this.zaj != ((GoogleSignInOptions)((Object)object)).isServerAuthCodeRequested()) return false;
                boolean bl = TextUtils.equals((CharSequence)this.zao, (CharSequence)((GoogleSignInOptions)((Object)object)).getLogSessionId());
                if (!bl) return false;
                return true;
            }
            catch (ClassCastException classCastException) {}
        }
        return false;
    }

    public Account getAccount() {
        return this.zah;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zan;
    }

    public String getLogSessionId() {
        return this.zao;
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zag;
        return arrayList.toArray(new Scope[arrayList.size()]);
    }

    public ArrayList<Scope> getScopes() {
        return new ArrayList<Scope>(this.zag);
    }

    public String getServerClientId() {
        return this.zal;
    }

    public int hashCode() {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashAccumulator hashAccumulator = this.zag;
        int n = hashAccumulator.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                Collections.sort(arrayList);
                hashAccumulator = new HashAccumulator();
                hashAccumulator.addObject(arrayList);
                hashAccumulator.addObject((Object)this.zah);
                hashAccumulator.addObject((Object)this.zal);
                hashAccumulator.zaa(this.zak);
                hashAccumulator.zaa(this.zai);
                hashAccumulator.zaa(this.zaj);
                hashAccumulator.addObject((Object)this.zao);
                return hashAccumulator.hash();
            }
            arrayList.add(((Scope)hashAccumulator.get(n2)).getScopeUri());
            ++n2;
        }
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zak;
    }

    public boolean isIdTokenRequested() {
        return this.zai;
    }

    public boolean isServerAuthCodeRequested() {
        return this.zaj;
    }

    public void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaf);
        SafeParcelWriter.writeTypedList((Parcel)parcel, (int)2, this.getScopes(), (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.getAccount(), (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)4, (boolean)this.isIdTokenRequested());
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)6, (boolean)this.isForceCodeForRefreshToken());
        SafeParcelWriter.writeString((Parcel)parcel, (int)7, (String)this.getServerClientId(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)8, (String)this.zam, (boolean)false);
        SafeParcelWriter.writeTypedList((Parcel)parcel, (int)9, this.getExtensions(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)10, (String)this.getLogSessionId(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final String zab() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zag, zaq);
            Iterator<Scope> iterator = this.zag.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)iterator.next().getScopeUri());
            }
            jSONObject.put("scopes", (Object)jSONArray);
            jSONArray = this.zah;
            if (jSONArray != null) {
                jSONObject.put("accountName", (Object)jSONArray.name);
            }
            jSONObject.put("idTokenRequested", this.zai);
            jSONObject.put("forceCodeForRefreshToken", this.zak);
            jSONObject.put("serverAuthRequested", this.zaj);
            if (!TextUtils.isEmpty((CharSequence)this.zal)) {
                jSONObject.put("serverClientId", (Object)this.zal);
            }
            if (TextUtils.isEmpty((CharSequence)this.zam)) return jSONObject.toString();
            jSONObject.put("hostedDomain", (Object)this.zam);
        }
        catch (JSONException jSONException) {
            RuntimeException runtimeException = new RuntimeException(jSONException);
            throw runtimeException;
        }
        return jSONObject.toString();
    }
}
