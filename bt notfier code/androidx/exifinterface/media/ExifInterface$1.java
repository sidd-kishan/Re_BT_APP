/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaDataSource
 *  androidx.exifinterface.media.ExifInterface
 *  androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
 */
package androidx.exifinterface.media;

import android.media.MediaDataSource;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;

class ExifInterface.1
extends MediaDataSource {
    long mPosition;
    final ExifInterface this$0;
    final ExifInterface.ByteOrderedDataInputStream val$in;

    ExifInterface.1(ExifInterface exifInterface, ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) {
        this.this$0 = exifInterface;
        this.val$in = byteOrderedDataInputStream;
    }

    public void close() throws IOException {
    }

    public long getSize() throws IOException {
        return -1L;
    }

    public int readAt(long l, byte[] byArray, int n, int n2) throws IOException {
        if (n2 == 0) {
            return 0;
        }
        if (l < 0L) {
            return -1;
        }
        try {
            if (this.mPosition != l) {
                if (this.mPosition >= 0L && l >= this.mPosition + (long)this.val$in.available()) {
                    return -1;
                }
                this.val$in.seek(l);
                this.mPosition = l;
            }
            int n3 = n2;
            if (n2 > this.val$in.available()) {
                n3 = this.val$in.available();
            }
            if ((n = this.val$in.read(byArray, n, n3)) >= 0) {
                this.mPosition += (long)n;
                return n;
            }
        }
        catch (IOException iOException) {}
        this.mPosition = -1L;
        return -1;
    }
}
