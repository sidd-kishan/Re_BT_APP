/*
 * Decompiled with CFR 0.152.
 */
package androidx.versionedparcelable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

private static class VersionedParcelStream.FieldBuffer {
    final DataOutputStream mDataStream;
    private final int mFieldId;
    final ByteArrayOutputStream mOutput = new ByteArrayOutputStream();
    private final DataOutputStream mTarget;

    VersionedParcelStream.FieldBuffer(int n, DataOutputStream dataOutputStream) {
        this.mDataStream = new DataOutputStream(this.mOutput);
        this.mFieldId = n;
        this.mTarget = dataOutputStream;
    }

    void flushField() throws IOException {
        this.mDataStream.flush();
        int n = this.mOutput.size();
        int n2 = this.mFieldId;
        int n3 = n >= 65535 ? 65535 : n;
        this.mTarget.writeInt(n2 << 16 | n3);
        if (n >= 65535) {
            this.mTarget.writeInt(n);
        }
        this.mOutput.writeTo(this.mTarget);
    }
}
