/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load;

public final class DataSource
extends Enum<DataSource> {
    private static final DataSource[] $VALUES;
    public static final /* enum */ DataSource DATA_DISK_CACHE;
    public static final /* enum */ DataSource LOCAL;
    public static final /* enum */ DataSource MEMORY_CACHE;
    public static final /* enum */ DataSource REMOTE;
    public static final /* enum */ DataSource RESOURCE_DISK_CACHE;

    static {
        DataSource dataSource;
        LOCAL = new DataSource();
        REMOTE = new DataSource();
        DATA_DISK_CACHE = new DataSource();
        RESOURCE_DISK_CACHE = new DataSource();
        MEMORY_CACHE = dataSource = new DataSource();
        $VALUES = new DataSource[]{LOCAL, REMOTE, DATA_DISK_CACHE, RESOURCE_DISK_CACHE, dataSource};
    }

    public static DataSource valueOf(String string) {
        return Enum.valueOf(DataSource.class, string);
    }

    public static DataSource[] values() {
        return (DataSource[])$VALUES.clone();
    }
}
