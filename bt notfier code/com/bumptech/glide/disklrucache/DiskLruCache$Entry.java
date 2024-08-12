/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.DiskLruCache
 *  com.bumptech.glide.disklrucache.DiskLruCache$Editor
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/*
 * Exception performing whole class analysis ignored.
 */
private final class DiskLruCache.Entry {
    File[] cleanFiles;
    private DiskLruCache.Editor currentEditor;
    File[] dirtyFiles;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;
    final DiskLruCache this$0;

    private DiskLruCache.Entry(DiskLruCache diskLruCache, String charSequence) {
        this.this$0 = diskLruCache;
        this.key = charSequence;
        this.lengths = new long[DiskLruCache.access$1900((DiskLruCache)diskLruCache)];
        this.cleanFiles = new File[DiskLruCache.access$1900((DiskLruCache)diskLruCache)];
        this.dirtyFiles = new File[DiskLruCache.access$1900((DiskLruCache)diskLruCache)];
        charSequence = new StringBuilder((String)charSequence);
        ((StringBuilder)charSequence).append('.');
        int n = ((StringBuilder)charSequence).length();
        int n2 = 0;
        while (n2 < DiskLruCache.access$1900((DiskLruCache)diskLruCache)) {
            ((StringBuilder)charSequence).append(n2);
            this.cleanFiles[n2] = new File(DiskLruCache.access$2000((DiskLruCache)diskLruCache), ((StringBuilder)charSequence).toString());
            ((StringBuilder)charSequence).append(".tmp");
            this.dirtyFiles[n2] = new File(DiskLruCache.access$2000((DiskLruCache)diskLruCache), ((StringBuilder)charSequence).toString());
            ((StringBuilder)charSequence).setLength(n);
            ++n2;
        }
    }

    static /* synthetic */ long[] access$1100(DiskLruCache.Entry entry) {
        return entry.lengths;
    }

    static /* synthetic */ String access$1200(DiskLruCache.Entry entry) {
        return entry.key;
    }

    static /* synthetic */ long access$1300(DiskLruCache.Entry entry) {
        return entry.sequenceNumber;
    }

    static /* synthetic */ long access$1302(DiskLruCache.Entry entry, long l) {
        entry.sequenceNumber = l;
        return l;
    }

    static /* synthetic */ boolean access$700(DiskLruCache.Entry entry) {
        return entry.readable;
    }

    static /* synthetic */ boolean access$702(DiskLruCache.Entry entry, boolean bl) {
        entry.readable = bl;
        return bl;
    }

    static /* synthetic */ DiskLruCache.Editor access$800(DiskLruCache.Entry entry) {
        return entry.currentEditor;
    }

    static /* synthetic */ DiskLruCache.Editor access$802(DiskLruCache.Entry entry, DiskLruCache.Editor editor) {
        entry.currentEditor = editor;
        return editor;
    }

    static /* synthetic */ void access$900(DiskLruCache.Entry entry, String[] stringArray) throws IOException {
        entry.setLengths(stringArray);
    }

    private IOException invalidLengths(String[] stringArray) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal line: ");
        stringBuilder.append(Arrays.toString(stringArray));
        throw new IOException(stringBuilder.toString());
    }

    private void setLengths(String[] stringArray) throws IOException {
        if (stringArray.length != DiskLruCache.access$1900((DiskLruCache)this.this$0)) {
            stringArray = this.invalidLengths(stringArray);
            throw stringArray;
        }
        int n = 0;
        try {
            while (n < stringArray.length) {
                this.lengths[n] = Long.parseLong(stringArray[n]);
                ++n;
            }
            return;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.invalidLengths(stringArray);
        }
    }

    public File getCleanFile(int n) {
        return this.cleanFiles[n];
    }

    public File getDirtyFile(int n) {
        return this.dirtyFiles[n];
    }

    public String getLengths() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        long[] lArray = this.lengths;
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            long l = lArray[n2];
            stringBuilder.append(' ');
            stringBuilder.append(l);
            ++n2;
        }
        return stringBuilder.toString();
    }
}
