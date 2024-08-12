/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.bumptech.glide.load.model.LazyHeaderFactory
 *  com.bumptech.glide.load.model.LazyHeaders
 *  com.bumptech.glide.load.model.LazyHeaders$StringHeaderFactory
 */
package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.bumptech.glide.load.model.LazyHeaderFactory;
import com.bumptech.glide.load.model.LazyHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public static final class LazyHeaders.Builder {
    private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
    private static final String DEFAULT_USER_AGENT;
    private static final String USER_AGENT_HEADER = "User-Agent";
    private boolean copyOnModify = true;
    private Map<String, List<LazyHeaderFactory>> headers = DEFAULT_HEADERS;
    private boolean isUserAgentDefault = true;

    static {
        DEFAULT_USER_AGENT = LazyHeaders.Builder.getSanitizedUserAgent();
        HashMap<String, List<LazyHeaders.StringHeaderFactory>> hashMap = new HashMap<String, List<LazyHeaders.StringHeaderFactory>>(2);
        if (!TextUtils.isEmpty((CharSequence)DEFAULT_USER_AGENT)) {
            hashMap.put(USER_AGENT_HEADER, Collections.singletonList(new LazyHeaders.StringHeaderFactory(DEFAULT_USER_AGENT)));
        }
        DEFAULT_HEADERS = Collections.unmodifiableMap(hashMap);
    }

    private Map<String, List<LazyHeaderFactory>> copyHeaders() {
        HashMap<String, List<LazyHeaderFactory>> hashMap = new HashMap<String, List<LazyHeaderFactory>>(this.headers.size());
        Iterator<Map.Entry<String, List<LazyHeaderFactory>>> iterator = this.headers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<LazyHeaderFactory>> entry = iterator.next();
            ArrayList arrayList = new ArrayList(entry.getValue());
            hashMap.put(entry.getKey(), arrayList);
        }
        return hashMap;
    }

    private void copyIfNecessary() {
        if (!this.copyOnModify) return;
        this.copyOnModify = false;
        this.headers = this.copyHeaders();
    }

    private List<LazyHeaderFactory> getFactories(String string) {
        List<LazyHeaderFactory> list;
        List<LazyHeaderFactory> list2 = list = this.headers.get(string);
        if (list != null) return list2;
        list2 = new ArrayList<LazyHeaderFactory>();
        this.headers.put(string, list2);
        return list2;
    }

    static String getSanitizedUserAgent() {
        String string = System.getProperty("http.agent");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        int n = string.length();
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n2 = 0;
        while (n2 < n) {
            char c = string.charAt(n2);
            if ((c > '\u001f' || c == '\t') && c < '\u007f') {
                stringBuilder.append(c);
            } else {
                stringBuilder.append('?');
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public LazyHeaders.Builder addHeader(String string, LazyHeaderFactory lazyHeaderFactory) {
        if (this.isUserAgentDefault && USER_AGENT_HEADER.equalsIgnoreCase(string)) {
            return this.setHeader(string, lazyHeaderFactory);
        }
        this.copyIfNecessary();
        this.getFactories(string).add(lazyHeaderFactory);
        return this;
    }

    public LazyHeaders.Builder addHeader(String string, String string2) {
        return this.addHeader(string, (LazyHeaderFactory)new LazyHeaders.StringHeaderFactory(string2));
    }

    public LazyHeaders build() {
        this.copyOnModify = true;
        return new LazyHeaders(this.headers);
    }

    public LazyHeaders.Builder setHeader(String string, LazyHeaderFactory lazyHeaderFactory) {
        this.copyIfNecessary();
        if (lazyHeaderFactory == null) {
            this.headers.remove(string);
        } else {
            List<LazyHeaderFactory> list = this.getFactories(string);
            list.clear();
            list.add(lazyHeaderFactory);
        }
        if (!this.isUserAgentDefault) return this;
        if (!USER_AGENT_HEADER.equalsIgnoreCase(string)) return this;
        this.isUserAgentDefault = false;
        return this;
    }

    public LazyHeaders.Builder setHeader(String string, String string2) {
        string2 = string2 == null ? null : new LazyHeaders.StringHeaderFactory(string2);
        return this.setHeader(string, (LazyHeaderFactory)string2);
    }
}
