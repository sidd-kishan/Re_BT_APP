/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.disklrucache.DiskLruCache
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.engine.cache.DiskCache$Writer
 *  com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker
 *  com.bumptech.glide.load.engine.cache.SafeKeyGenerator
 */
package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper
implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long l) {
        this.directory = file;
        this.maxSize = l;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public static DiskCache create(File file, long l) {
        return new DiskLruCacheWrapper(file, l);
    }

    @Deprecated
    public static DiskCache get(File object, long l) {
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                DiskLruCacheWrapper diskLruCacheWrapper;
                wrapper = diskLruCacheWrapper = new DiskLruCacheWrapper((File)object, l);
            }
            object = wrapper;
            return object;
        }
    }

    private DiskLruCache getDiskCache() throws IOException {
        synchronized (this) {
            if (this.diskLruCache == null) {
                this.diskLruCache = DiskLruCache.open((File)this.directory, (int)1, (int)1, (long)this.maxSize);
            }
            DiskLruCache diskLruCache = this.diskLruCache;
            return diskLruCache;
        }
    }

    private void resetDiskCache() {
        synchronized (this) {
            this.diskLruCache = null;
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void clear() {
        // MONITORENTER : this
        this.getDiskCache().delete();
lbl4:
        // 3 sources

        while (true) {
            this.resetDiskCache();
            return;
            break;
        }
        {
            catch (Throwable var1_1) {
            }
            catch (IOException var1_2) {}
            {
                if (!Log.isLoggable((String)"DiskLruCacheWrapper", (int)5)) ** GOTO lbl4
                Log.w((String)"DiskLruCacheWrapper", (String)"Unable to clear disk cache or disk cache cleared externally", (Throwable)var1_2);
                ** continue;
            }
        }
        this.resetDiskCache();
        throw var1_1;
    }

    public void delete(Key object) {
        object = this.safeKeyGenerator.getSafeKey(object);
        try {
            this.getDiskCache().remove((String)object);
        }
        catch (IOException iOException) {
            if (!Log.isLoggable((String)TAG, (int)5)) return;
            Log.w((String)TAG, (String)"Unable to delete from disk cache", (Throwable)iOException);
        }
    }

    public File get(Key object) {
        StringBuilder stringBuilder;
        String string = this.safeKeyGenerator.getSafeKey(object);
        if (Log.isLoggable((String)TAG, (int)2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Get: Obtained: ");
            stringBuilder.append(string);
            stringBuilder.append(" for for Key: ");
            stringBuilder.append(object);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        stringBuilder = null;
        try {
            string = this.getDiskCache().get(string);
            object = stringBuilder;
            if (string == null) return object;
            object = string.getFile(0);
        }
        catch (IOException iOException) {
            object = stringBuilder;
            if (!Log.isLoggable((String)TAG, (int)5)) return object;
            Log.w((String)TAG, (String)"Unable to get from disk cache", (Throwable)iOException);
            object = stringBuilder;
        }
        return object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void put(Key var1_1, DiskCache.Writer var2_4) {
        block13: {
            var3_6 = this.safeKeyGenerator.getSafeKey(var1_1 /* !! */ );
            this.writeLocker.acquire(var3_6);
            if (Log.isLoggable((String)"DiskLruCacheWrapper", (int)2)) {
                var4_7 = new StringBuilder();
                var4_7.append("Put: Obtained: ");
                var4_7.append(var3_6);
                var4_7.append(" for for Key: ");
                var4_7.append(var1_1 /* !! */ );
                Log.v((String)"DiskLruCacheWrapper", (String)var4_7.toString());
            }
            try {
                var4_7 = this.getDiskCache();
                var1_1 /* !! */  = var4_7.get(var3_6);
                if (var1_1 /* !! */  != null) {
                    break block13;
                }
                ** GOTO lbl-1000
            }
            catch (IOException var1_2) {
                if (Log.isLoggable((String)"DiskLruCacheWrapper", (int)5) == false) return;
                Log.w((String)"DiskLruCacheWrapper", (String)"Unable to put to disk cache", (Throwable)var1_2);
            }
        }
        this.writeLocker.release(var3_6);
        return;
lbl-1000:
        // 1 sources

        {
            var1_1 /* !! */  = var4_7.edit(var3_6);
            if (var1_1 /* !! */  == null) ** GOTO lbl-1000
        }
        try {
            if (var2_4.write(var1_1 /* !! */ .getFile(0)) == false) return;
            var1_1 /* !! */ .commit();
        }
        finally {
            var1_1 /* !! */ .abortUnlessCommitted();
        }
lbl-1000:
        // 1 sources

        {
            var2_4 = new StringBuilder();
            var2_4.append("Had two simultaneous puts for: ");
            var2_4.append(var3_6);
            var1_1 /* !! */  = new IllegalStateException(var2_4.toString());
            throw var1_1 /* !! */ ;
        }
    }
}
