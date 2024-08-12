/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.bumptech.glide.load.model.Headers
 *  com.bumptech.glide.load.model.LazyHeaderFactory
 */
package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaderFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class LazyHeaders
implements Headers {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<LazyHeaderFactory>> headers;

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    private String buildHeaderValue(List<LazyHeaderFactory> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            String string = list.get(n2).buildHeader();
            if (!TextUtils.isEmpty((CharSequence)string)) {
                stringBuilder.append(string);
                if (n2 != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    private Map<String, String> generateHeaders() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator<Map.Entry<String, List<LazyHeaderFactory>>> iterator = this.headers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<LazyHeaderFactory>> entry = iterator.next();
            String string = this.buildHeaderValue(entry.getValue());
            if (TextUtils.isEmpty((CharSequence)string)) continue;
            hashMap.put(entry.getKey(), string);
        }
        return hashMap;
    }

    public boolean equals(Object object) {
        if (!(object instanceof LazyHeaders)) return false;
        object = (LazyHeaders)object;
        return this.headers.equals(((LazyHeaders)object).headers);
    }

    public Map<String, String> getHeaders() {
        if (this.combinedHeaders != null) return this.combinedHeaders;
        synchronized (this) {
            if (this.combinedHeaders != null) return this.combinedHeaders;
            this.combinedHeaders = Collections.unmodifiableMap(this.generateHeaders());
        }
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LazyHeaders{headers=");
        stringBuilder.append(this.headers);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
