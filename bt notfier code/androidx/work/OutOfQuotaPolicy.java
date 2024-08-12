/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public final class OutOfQuotaPolicy
extends Enum<OutOfQuotaPolicy> {
    private static final OutOfQuotaPolicy[] $VALUES;
    public static final /* enum */ OutOfQuotaPolicy DROP_WORK_REQUEST;
    public static final /* enum */ OutOfQuotaPolicy RUN_AS_NON_EXPEDITED_WORK_REQUEST;

    static {
        OutOfQuotaPolicy outOfQuotaPolicy;
        RUN_AS_NON_EXPEDITED_WORK_REQUEST = new OutOfQuotaPolicy();
        DROP_WORK_REQUEST = outOfQuotaPolicy = new OutOfQuotaPolicy();
        $VALUES = new OutOfQuotaPolicy[]{RUN_AS_NON_EXPEDITED_WORK_REQUEST, outOfQuotaPolicy};
    }

    public static OutOfQuotaPolicy valueOf(String string) {
        return Enum.valueOf(OutOfQuotaPolicy.class, string);
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[])$VALUES.clone();
    }
}
