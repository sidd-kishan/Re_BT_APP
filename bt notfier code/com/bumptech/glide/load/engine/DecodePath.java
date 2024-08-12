/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.engine.DecodePath$DecodeCallback
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    public DecodePath(Class<DataType> clazz, Class<ResourceType> clazz2, Class<Transcode> clazz3, List<? extends ResourceDecoder<DataType, ResourceType>> object, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = clazz;
        this.decoders = object;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed DecodePath{");
        ((StringBuilder)object).append(clazz.getSimpleName());
        ((StringBuilder)object).append("->");
        ((StringBuilder)object).append(clazz2.getSimpleName());
        ((StringBuilder)object).append("->");
        ((StringBuilder)object).append(clazz3.getSimpleName());
        ((StringBuilder)object).append("}");
        this.failureMessage = ((StringBuilder)object).toString();
    }

    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int n, int n2, Options options) throws GlideException {
        List list = (List)Preconditions.checkNotNull((Object)this.listPool.acquire());
        try {
            dataRewinder = this.decodeResourceWithList(dataRewinder, n, n2, options, list);
            return dataRewinder;
        }
        finally {
            this.listPool.release((Object)list);
        }
    }

    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> glideException, int n, int n2, Options options, List<Throwable> list) throws GlideException {
        Resource resource;
        int n3 = this.decoders.size();
        Resource resource2 = null;
        int n4 = 0;
        while (true) {
            block8: {
                resource = resource2;
                if (n4 >= n3) break;
                ResourceDecoder<DataType, ResourceType> resourceDecoder = this.decoders.get(n4);
                resource = resource2;
                try {
                    if (resourceDecoder.handles(glideException.rewindAndGet(), options)) {
                        resource = resourceDecoder.decode(glideException.rewindAndGet(), n, n2, options);
                    }
                    break block8;
                }
                catch (OutOfMemoryError outOfMemoryError) {
                }
                catch (RuntimeException runtimeException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                if (Log.isLoggable((String)TAG, (int)2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to decode data for ");
                    stringBuilder.append(resourceDecoder);
                    Log.v((String)TAG, (String)stringBuilder.toString(), (Throwable)resource);
                }
                list.add((Throwable)resource);
                resource = resource2;
            }
            if (resource != null) break;
            ++n4;
            resource2 = resource;
        }
        if (resource != null) {
            return resource;
        }
        glideException = new GlideException(this.failureMessage, new ArrayList<Throwable>(list));
        throw glideException;
    }

    public Resource<Transcode> decode(DataRewinder<DataType> resource, int n, int n2, Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        resource = decodeCallback.onResourceDecoded(this.decodeResource((DataRewinder<DataType>)resource, n, n2, options));
        return this.transcoder.transcode(resource, options);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecodePath{ dataClass=");
        stringBuilder.append(this.dataClass);
        stringBuilder.append(", decoders=");
        stringBuilder.append(this.decoders);
        stringBuilder.append(", transcoder=");
        stringBuilder.append(this.transcoder);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
