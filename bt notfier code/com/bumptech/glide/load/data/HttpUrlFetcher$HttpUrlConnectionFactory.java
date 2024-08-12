/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

static interface HttpUrlFetcher.HttpUrlConnectionFactory {
    public HttpURLConnection build(URL var1) throws IOException;
}
