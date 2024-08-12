/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzafr
extends RuntimeException {
    public zzafr(int n) {
        String string = n != 1 ? (n != 2 ? "Detaching surface timed out." : "Setting foreground mode timed out.") : "Player release timed out.";
        super(string);
    }
}
