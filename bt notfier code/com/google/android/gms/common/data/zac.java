/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.data;

public final class zac
extends RuntimeException {
    public zac(String string) {
        super("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
    }
}
