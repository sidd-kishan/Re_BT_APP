/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

public static final class FtsOptions.Order
extends Enum<FtsOptions.Order> {
    private static final FtsOptions.Order[] $VALUES;
    public static final /* enum */ FtsOptions.Order ASC;
    public static final /* enum */ FtsOptions.Order DESC;

    static {
        FtsOptions.Order order;
        ASC = new FtsOptions.Order();
        DESC = order = new FtsOptions.Order();
        $VALUES = new FtsOptions.Order[]{ASC, order};
    }

    public static FtsOptions.Order valueOf(String string) {
        return Enum.valueOf(FtsOptions.Order.class, string);
    }

    public static FtsOptions.Order[] values() {
        return (FtsOptions.Order[])$VALUES.clone();
    }
}
