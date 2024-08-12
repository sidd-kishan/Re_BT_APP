/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public final class ExistingWorkPolicy
extends Enum<ExistingWorkPolicy> {
    private static final ExistingWorkPolicy[] $VALUES;
    public static final /* enum */ ExistingWorkPolicy APPEND;
    public static final /* enum */ ExistingWorkPolicy APPEND_OR_REPLACE;
    public static final /* enum */ ExistingWorkPolicy KEEP;
    public static final /* enum */ ExistingWorkPolicy REPLACE;

    static {
        ExistingWorkPolicy existingWorkPolicy;
        REPLACE = new ExistingWorkPolicy();
        KEEP = new ExistingWorkPolicy();
        APPEND = new ExistingWorkPolicy();
        APPEND_OR_REPLACE = existingWorkPolicy = new ExistingWorkPolicy();
        $VALUES = new ExistingWorkPolicy[]{REPLACE, KEEP, APPEND, existingWorkPolicy};
    }

    public static ExistingWorkPolicy valueOf(String string) {
        return Enum.valueOf(ExistingWorkPolicy.class, string);
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[])$VALUES.clone();
    }
}
