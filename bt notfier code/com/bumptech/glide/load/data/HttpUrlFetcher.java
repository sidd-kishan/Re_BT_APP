/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.HttpException
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.data.HttpUrlFetcher$DefaultHttpUrlConnectionFactory
 *  com.bumptech.glide.load.data.HttpUrlFetcher$HttpUrlConnectionFactory
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.util.ContentLengthInputStream
 *  com.bumptech.glide.util.LogTime
 */
package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher
implements DataFetcher<InputStream> {
    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    private static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    public HttpUrlFetcher(GlideUrl glideUrl, int n) {
        this(glideUrl, n, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl glideUrl, int n, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.timeout = n;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty((CharSequence)httpURLConnection.getContentEncoding())) {
            int n = httpURLConnection.getContentLength();
            this.stream = ContentLengthInputStream.obtain((InputStream)httpURLConnection.getInputStream(), (long)n);
        } else {
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Got non empty content encoding: ");
                stringBuilder.append(httpURLConnection.getContentEncoding());
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    private static boolean isHttpOk(int n) {
        boolean bl = n / 100 == 2;
        return bl;
    }

    private static boolean isHttpRedirect(int n) {
        boolean bl = n / 100 == 3;
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private InputStream loadDataWithRedirects(URL uRL, int n, URL object2, Map<String, String> map) throws IOException {
        void var4_11;
        if (n >= 5) {
            uRL = new HttpException("Too many (> 5) redirects!");
            throw uRL;
        }
        if (object2 != null) {
            try {
                if (uRL.toURI().equals(((URL)object2).toURI())) {
                    HttpException uRISyntaxException = new HttpException("In re-direct loop");
                    throw uRISyntaxException;
                }
            }
            catch (URISyntaxException uRISyntaxException) {}
        }
        this.urlConnection = this.connectionFactory.build(uRL);
        for (Map.Entry entry : var4_11.entrySet()) {
            this.urlConnection.addRequestProperty((String)entry.getKey(), (String)entry.getValue());
        }
        this.urlConnection.setConnectTimeout(this.timeout);
        this.urlConnection.setReadTimeout(this.timeout);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.setInstanceFollowRedirects(false);
        this.urlConnection.connect();
        this.stream = this.urlConnection.getInputStream();
        if (this.isCancelled) {
            return null;
        }
        int n2 = this.urlConnection.getResponseCode();
        if (HttpUrlFetcher.isHttpOk(n2)) {
            return this.getStreamForSuccessfulRequest(this.urlConnection);
        }
        if (HttpUrlFetcher.isHttpRedirect(n2)) {
            String string = this.urlConnection.getHeaderField("Location");
            if (TextUtils.isEmpty((CharSequence)string)) throw new HttpException("Received empty or null redirect url");
            URL uRL2 = new URL(uRL, string);
            this.cleanup();
            return this.loadDataWithRedirects(uRL2, n + 1, uRL, (Map<String, String>)var4_11);
        }
        if (n2 != -1) throw new HttpException(this.urlConnection.getResponseMessage(), n2);
        throw new HttpException(n2);
    }

    public void cancel() {
        this.isCancelled = true;
    }

    public void cleanup() {
        Object object = this.stream;
        if (object != null) {
            try {
                ((InputStream)object).close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        if ((object = this.urlConnection) != null) {
            ((HttpURLConnection)object).disconnect();
        }
        this.urlConnection = null;
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void loadData(Priority object, DataFetcher.DataCallback<? super InputStream> object2) {
        Throwable throwable2222222;
        long l;
        block5: {
            block6: {
                l = LogTime.getLogTime();
                object2.onDataReady((Object)this.loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
                {
                    catch (Throwable throwable2222222) {
                        break block5;
                    }
                    catch (IOException iOException) {}
                    {
                        if (Log.isLoggable((String)TAG, (int)3)) {
                            Log.d((String)TAG, (String)"Failed to load data for url", (Throwable)iOException);
                        }
                        object2.onLoadFailed((Exception)iOException);
                    }
                    if (!Log.isLoggable((String)TAG, (int)2)) return;
                    object = new StringBuilder();
                    break block6;
                }
                if (!Log.isLoggable((String)TAG, (int)2)) return;
                object = new StringBuilder();
            }
            ((StringBuilder)object).append("Finished http url fetcher fetch in ");
            ((StringBuilder)object).append(LogTime.getElapsedMillis((long)l));
            Log.v((String)TAG, (String)((StringBuilder)object).toString());
            return;
        }
        if (!Log.isLoggable((String)TAG, (int)2)) throw throwable2222222;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Finished http url fetcher fetch in ");
        ((StringBuilder)object2).append(LogTime.getElapsedMillis((long)l));
        Log.v((String)TAG, (String)((StringBuilder)object2).toString());
        throw throwable2222222;
    }
}
