/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.model.Headers
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl
implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    public GlideUrl(String string) {
        this(string, Headers.DEFAULT);
    }

    public GlideUrl(String string, Headers headers) {
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty((String)string);
        this.headers = (Headers)Preconditions.checkNotNull((Object)headers);
    }

    public GlideUrl(URL uRL) {
        this(uRL, Headers.DEFAULT);
    }

    public GlideUrl(URL uRL, Headers headers) {
        this.url = (URL)Preconditions.checkNotNull((Object)uRL);
        this.stringUrl = null;
        this.headers = (Headers)Preconditions.checkNotNull((Object)headers);
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) return this.cacheKeyBytes;
        this.cacheKeyBytes = this.getCacheKey().getBytes(CHARSET);
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        String string;
        if (!TextUtils.isEmpty((CharSequence)this.safeStringUrl)) return this.safeStringUrl;
        String string2 = string = this.stringUrl;
        if (TextUtils.isEmpty((CharSequence)string)) {
            string2 = ((URL)Preconditions.checkNotNull((Object)this.url)).toString();
        }
        this.safeStringUrl = Uri.encode((String)string2, (String)ALLOWED_URI_CHARS);
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl != null) return this.safeUrl;
        this.safeUrl = new URL(this.getSafeStringUrl());
        return this.safeUrl;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof GlideUrl;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (GlideUrl)object;
        bl3 = bl;
        if (!this.getCacheKey().equals(((GlideUrl)object).getCacheKey())) return bl3;
        bl3 = bl;
        if (!this.headers.equals(((GlideUrl)object).headers)) return bl3;
        bl3 = true;
        return bl3;
    }

    public String getCacheKey() {
        String string = this.stringUrl;
        if (string != null) return string;
        string = ((URL)Preconditions.checkNotNull((Object)this.url)).toString();
        return string;
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    public int hashCode() {
        int n;
        if (this.hashCode != 0) return this.hashCode;
        this.hashCode = n = this.getCacheKey().hashCode();
        this.hashCode = n * 31 + this.headers.hashCode();
        return this.hashCode;
    }

    public String toString() {
        return this.getCacheKey();
    }

    public String toStringUrl() {
        return this.getSafeStringUrl();
    }

    public URL toURL() throws MalformedURLException {
        return this.getSafeUrl();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.getCacheKeyBytes());
    }
}
