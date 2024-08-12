/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.versionedparcelable.VersionedParcelStream
 */
package androidx.versionedparcelable;

import androidx.versionedparcelable.VersionedParcelStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class VersionedParcelStream.1
extends FilterInputStream {
    final VersionedParcelStream this$0;

    VersionedParcelStream.1(VersionedParcelStream versionedParcelStream, InputStream inputStream) {
        this.this$0 = versionedParcelStream;
        super(inputStream);
    }

    @Override
    public int read() throws IOException {
        if (this.this$0.mFieldSize != -1) {
            if (this.this$0.mCount >= this.this$0.mFieldSize) throw new IOException();
        }
        int n = super.read();
        VersionedParcelStream versionedParcelStream = this.this$0;
        ++versionedParcelStream.mCount;
        return n;
    }

    @Override
    public int read(byte[] object, int n, int n2) throws IOException {
        if (this.this$0.mFieldSize != -1) {
            if (this.this$0.mCount >= this.this$0.mFieldSize) throw new IOException();
        }
        if ((n = super.read((byte[])object, n, n2)) <= 0) return n;
        object = this.this$0;
        object.mCount += n;
        return n;
    }

    @Override
    public long skip(long l) throws IOException {
        if (this.this$0.mFieldSize != -1) {
            if (this.this$0.mCount >= this.this$0.mFieldSize) throw new IOException();
        }
        if ((l = super.skip(l)) <= 0L) return l;
        VersionedParcelStream versionedParcelStream = this.this$0;
        versionedParcelStream.mCount += (int)l;
        return l;
    }
}
