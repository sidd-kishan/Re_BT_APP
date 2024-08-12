/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.images.zah
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.zah;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zah();
    final int zaa;
    private final Uri zab;
    private final int zac;
    private final int zad;

    WebImage(int n, Uri uri, int n2, int n3) {
        this.zaa = n;
        this.zab = uri;
        this.zac = n2;
        this.zad = n3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int n, int n2) throws IllegalArgumentException {
        this(1, uri, n, n2);
        if (uri == null) throw new IllegalArgumentException("url cannot be null");
        if (n < 0) throw new IllegalArgumentException("width and height must not be negative");
        if (n2 < 0) throw new IllegalArgumentException("width and height must not be negative");
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        Uri uri;
        Uri uri2 = uri = Uri.EMPTY;
        if (jSONObject.has("url")) {
            try {
                uri2 = Uri.parse((String)jSONObject.getString("url"));
            }
            catch (JSONException jSONException) {
                uri2 = uri;
            }
        }
        this(uri2, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (!(object instanceof WebImage)) {
            return false;
        }
        object = (WebImage)((Object)object);
        if (!Objects.equal((Object)this.zab, (Object)((WebImage)((Object)object)).zab)) return false;
        if (this.zac != ((WebImage)((Object)object)).zac) return false;
        if (this.zad != ((WebImage)((Object)object)).zad) return false;
        return true;
    }

    public int getHeight() {
        return this.zad;
    }

    public Uri getUrl() {
        return this.zab;
    }

    public int getWidth() {
        return this.zac;
    }

    public int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zab, this.zac, this.zad});
    }

    /*
     * Enabled force condition propagation
     */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", (Object)this.zab.toString());
            jSONObject.put("width", this.zac);
            jSONObject.put("height", this.zad);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return jSONObject;
        }
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", this.zac, this.zad, this.zab.toString());
    }

    public void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.getUrl(), (int)n, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.getWidth());
        SafeParcelWriter.writeInt((Parcel)parcel, (int)4, (int)this.getHeight());
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
