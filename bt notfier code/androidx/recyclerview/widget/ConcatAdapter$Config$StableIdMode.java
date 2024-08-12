/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static final class ConcatAdapter.Config.StableIdMode
extends Enum<ConcatAdapter.Config.StableIdMode> {
    private static final ConcatAdapter.Config.StableIdMode[] $VALUES;
    public static final /* enum */ ConcatAdapter.Config.StableIdMode ISOLATED_STABLE_IDS;
    public static final /* enum */ ConcatAdapter.Config.StableIdMode NO_STABLE_IDS;
    public static final /* enum */ ConcatAdapter.Config.StableIdMode SHARED_STABLE_IDS;

    static {
        ConcatAdapter.Config.StableIdMode stableIdMode;
        NO_STABLE_IDS = new ConcatAdapter.Config.StableIdMode();
        ISOLATED_STABLE_IDS = new ConcatAdapter.Config.StableIdMode();
        SHARED_STABLE_IDS = stableIdMode = new ConcatAdapter.Config.StableIdMode();
        $VALUES = new ConcatAdapter.Config.StableIdMode[]{NO_STABLE_IDS, ISOLATED_STABLE_IDS, stableIdMode};
    }

    public static ConcatAdapter.Config.StableIdMode valueOf(String string) {
        return Enum.valueOf(ConcatAdapter.Config.StableIdMode.class, string);
    }

    public static ConcatAdapter.Config.StableIdMode[] values() {
        return (ConcatAdapter.Config.StableIdMode[])$VALUES.clone();
    }
}
