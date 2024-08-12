/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzgfg
extends IOException {
    zzgfg() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzgfg(String string, Throwable throwable) {
        string = (string = String.valueOf(string)).length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(string) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
        super(string, throwable);
    }

    zzgfg(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}
