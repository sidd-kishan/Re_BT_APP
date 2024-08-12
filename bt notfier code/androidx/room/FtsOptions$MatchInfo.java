/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

public static final class FtsOptions.MatchInfo
extends Enum<FtsOptions.MatchInfo> {
    private static final FtsOptions.MatchInfo[] $VALUES;
    public static final /* enum */ FtsOptions.MatchInfo FTS3;
    public static final /* enum */ FtsOptions.MatchInfo FTS4;

    static {
        FtsOptions.MatchInfo matchInfo;
        FTS3 = new FtsOptions.MatchInfo();
        FTS4 = matchInfo = new FtsOptions.MatchInfo();
        $VALUES = new FtsOptions.MatchInfo[]{FTS3, matchInfo};
    }

    public static FtsOptions.MatchInfo valueOf(String string) {
        return Enum.valueOf(FtsOptions.MatchInfo.class, string);
    }

    public static FtsOptions.MatchInfo[] values() {
        return (FtsOptions.MatchInfo[])$VALUES.clone();
    }
}
