/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.DiskLruCache
 *  com.bumptech.glide.disklrucache.DiskLruCache$Entry
 *  com.bumptech.glide.disklrucache.Util
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.Util;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
 * Exception performing whole class analysis ignored.
 */
public final class DiskLruCache.Editor {
    private boolean committed;
    private final DiskLruCache.Entry entry;
    final DiskLruCache this$0;
    private final boolean[] written;

    private DiskLruCache.Editor(DiskLruCache object, DiskLruCache.Entry entry) {
        this.this$0 = object;
        this.entry = entry;
        object = DiskLruCache.Entry.access$700((DiskLruCache.Entry)entry) ? null : (Object)new boolean[DiskLruCache.access$1900((DiskLruCache)object)];
        this.written = (boolean[])object;
    }

    static /* synthetic */ DiskLruCache.Entry access$1500(DiskLruCache.Editor editor) {
        return editor.entry;
    }

    static /* synthetic */ boolean[] access$1600(DiskLruCache.Editor editor) {
        return editor.written;
    }

    private InputStream newInputStream(int n) throws IOException {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (DiskLruCache.Entry.access$800((DiskLruCache.Entry)this.entry) != this) {
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            if (!DiskLruCache.Entry.access$700((DiskLruCache.Entry)this.entry)) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(n));
                return fileInputStream;
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
        }
    }

    public void abort() throws IOException {
        DiskLruCache.access$2100((DiskLruCache)this.this$0, (DiskLruCache.Editor)this, (boolean)false);
    }

    /*
     * Enabled force condition propagation
     */
    public void abortUnlessCommitted() {
        if (this.committed) return;
        try {
            this.abort();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public void commit() throws IOException {
        DiskLruCache.access$2100((DiskLruCache)this.this$0, (DiskLruCache.Editor)this, (boolean)true);
        this.committed = true;
    }

    public File getFile(int n) throws IOException {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (DiskLruCache.Entry.access$800((DiskLruCache.Entry)this.entry) != this) {
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            if (!DiskLruCache.Entry.access$700((DiskLruCache.Entry)this.entry)) {
                this.written[n] = true;
            }
            File file = this.entry.getDirtyFile(n);
            if (DiskLruCache.access$2000((DiskLruCache)this.this$0).exists()) return file;
            DiskLruCache.access$2000((DiskLruCache)this.this$0).mkdirs();
            return file;
        }
    }

    public String getString(int n) throws IOException {
        Object object = this.newInputStream(n);
        object = object != null ? DiskLruCache.access$1800((InputStream)object) : null;
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public void set(int n, String string) throws IOException {
        void var2_5;
        OutputStreamWriter outputStreamWriter;
        block4: {
            OutputStreamWriter outputStreamWriter2;
            outputStreamWriter = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.getFile(n));
                outputStreamWriter2 = new OutputStreamWriter((OutputStream)fileOutputStream, Util.UTF_8);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block4;
            }
            try {
                outputStreamWriter2.write(string);
            }
            catch (Throwable throwable) {
                outputStreamWriter = outputStreamWriter2;
                break block4;
            }
            Util.closeQuietly((Closeable)outputStreamWriter2);
            return;
        }
        Util.closeQuietly(outputStreamWriter);
        throw var2_5;
    }
}
