/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgx
extends IOException {
    zzgx() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzgx(String string, Throwable throwable) {
        string = (string = String.valueOf(string)).length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(string) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
        super(string, throwable);
    }

    zzgx(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}
