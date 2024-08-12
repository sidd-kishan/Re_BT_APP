/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public final class BackoffPolicy
extends Enum<BackoffPolicy> {
    private static final BackoffPolicy[] $VALUES;
    public static final /* enum */ BackoffPolicy EXPONENTIAL;
    public static final /* enum */ BackoffPolicy LINEAR;

    static {
        BackoffPolicy backoffPolicy;
        EXPONENTIAL = new BackoffPolicy();
        LINEAR = backoffPolicy = new BackoffPolicy();
        $VALUES = new BackoffPolicy[]{EXPONENTIAL, backoffPolicy};
    }

    public static BackoffPolicy valueOf(String string) {
        return Enum.valueOf(BackoffPolicy.class, string);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[])$VALUES.clone();
    }
}
