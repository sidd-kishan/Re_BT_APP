/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public final class NetworkType
extends Enum<NetworkType> {
    private static final NetworkType[] $VALUES;
    public static final /* enum */ NetworkType CONNECTED;
    public static final /* enum */ NetworkType METERED;
    public static final /* enum */ NetworkType NOT_REQUIRED;
    public static final /* enum */ NetworkType NOT_ROAMING;
    public static final /* enum */ NetworkType TEMPORARILY_UNMETERED;
    public static final /* enum */ NetworkType UNMETERED;

    static {
        NetworkType networkType;
        NOT_REQUIRED = new NetworkType();
        CONNECTED = new NetworkType();
        UNMETERED = new NetworkType();
        NOT_ROAMING = new NetworkType();
        METERED = new NetworkType();
        TEMPORARILY_UNMETERED = networkType = new NetworkType();
        $VALUES = new NetworkType[]{NOT_REQUIRED, CONNECTED, UNMETERED, NOT_ROAMING, METERED, networkType};
    }

    public static NetworkType valueOf(String string) {
        return Enum.valueOf(NetworkType.class, string);
    }

    public static NetworkType[] values() {
        return (NetworkType[])$VALUES.clone();
    }
}
