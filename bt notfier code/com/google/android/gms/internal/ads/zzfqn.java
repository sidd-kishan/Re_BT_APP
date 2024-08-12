/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.OutputStream;

final class zzfqn
extends OutputStream {
    zzfqn() {
    }

    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override
    public final void write(int n) {
    }

    @Override
    public final void write(byte[] byArray) {
        if (byArray == null) throw null;
    }

    @Override
    public final void write(byte[] byArray, int n, int n2) {
        if (byArray == null) throw null;
    }
}
