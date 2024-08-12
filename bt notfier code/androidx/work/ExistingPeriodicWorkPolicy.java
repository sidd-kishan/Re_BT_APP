/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public final class ExistingPeriodicWorkPolicy
extends Enum<ExistingPeriodicWorkPolicy> {
    private static final ExistingPeriodicWorkPolicy[] $VALUES;
    public static final /* enum */ ExistingPeriodicWorkPolicy KEEP;
    public static final /* enum */ ExistingPeriodicWorkPolicy REPLACE;

    static {
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy;
        REPLACE = new ExistingPeriodicWorkPolicy();
        KEEP = existingPeriodicWorkPolicy = new ExistingPeriodicWorkPolicy();
        $VALUES = new ExistingPeriodicWorkPolicy[]{REPLACE, existingPeriodicWorkPolicy};
    }

    public static ExistingPeriodicWorkPolicy valueOf(String string) {
        return Enum.valueOf(ExistingPeriodicWorkPolicy.class, string);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[])$VALUES.clone();
    }
}
