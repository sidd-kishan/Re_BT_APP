/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.HttpUrlFetcher$HttpUrlConnectionFactory
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.HttpUrlFetcher;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

private static class HttpUrlFetcher.DefaultHttpUrlConnectionFactory
implements HttpUrlFetcher.HttpUrlConnectionFactory {
    HttpUrlFetcher.DefaultHttpUrlConnectionFactory() {
    }

    public HttpURLConnection build(URL uRL) throws IOException {
        return (HttpURLConnection)uRL.openConnection();
    }
}
