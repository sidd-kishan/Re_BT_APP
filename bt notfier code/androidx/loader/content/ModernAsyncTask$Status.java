/*
 * Decompiled with CFR 0.152.
 */
package androidx.loader.content;

public static final class ModernAsyncTask.Status
extends Enum<ModernAsyncTask.Status> {
    private static final ModernAsyncTask.Status[] $VALUES;
    public static final /* enum */ ModernAsyncTask.Status FINISHED;
    public static final /* enum */ ModernAsyncTask.Status PENDING;
    public static final /* enum */ ModernAsyncTask.Status RUNNING;

    static {
        ModernAsyncTask.Status status;
        PENDING = new ModernAsyncTask.Status();
        RUNNING = new ModernAsyncTask.Status();
        FINISHED = status = new ModernAsyncTask.Status();
        $VALUES = new ModernAsyncTask.Status[]{PENDING, RUNNING, status};
    }

    public static ModernAsyncTask.Status valueOf(String string) {
        return Enum.valueOf(ModernAsyncTask.Status.class, string);
    }

    public static ModernAsyncTask.Status[] values() {
        return (ModernAsyncTask.Status[])$VALUES.clone();
    }
}
