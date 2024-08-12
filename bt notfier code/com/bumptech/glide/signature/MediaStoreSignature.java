/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 */
package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature
implements Key {
    private final long dateModified;
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(String string, long l, int n) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        }
        this.mimeType = string2;
        this.dateModified = l;
        this.orientation = n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (MediaStoreSignature)object;
        if (this.dateModified != ((MediaStoreSignature)object).dateModified) {
            return false;
        }
        if (this.orientation != ((MediaStoreSignature)object).orientation) {
            return false;
        }
        if (this.mimeType.equals(((MediaStoreSignature)object).mimeType)) return true;
        return false;
    }

    public int hashCode() {
        int n = this.mimeType.hashCode();
        long l = this.dateModified;
        return (n * 31 + (int)(l ^ l >>> 32)) * 31 + this.orientation;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes(CHARSET));
    }
}
