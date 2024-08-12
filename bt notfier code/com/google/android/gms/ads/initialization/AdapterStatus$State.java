/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads.initialization;

public static final class AdapterStatus.State
extends Enum<AdapterStatus.State> {
    public static final /* enum */ AdapterStatus.State NOT_READY;
    public static final /* enum */ AdapterStatus.State READY;
    private static final AdapterStatus.State[] zza;

    static {
        AdapterStatus.State state;
        NOT_READY = new AdapterStatus.State();
        READY = state = new AdapterStatus.State();
        zza = new AdapterStatus.State[]{NOT_READY, state};
    }

    public static AdapterStatus.State valueOf(String string) {
        return Enum.valueOf(AdapterStatus.State.class, string);
    }

    public static AdapterStatus.State[] values() {
        return (AdapterStatus.State[])zza.clone();
    }
}
