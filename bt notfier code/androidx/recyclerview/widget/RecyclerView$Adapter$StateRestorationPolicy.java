/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static final class RecyclerView.Adapter.StateRestorationPolicy
extends Enum<RecyclerView.Adapter.StateRestorationPolicy> {
    private static final RecyclerView.Adapter.StateRestorationPolicy[] $VALUES;
    public static final /* enum */ RecyclerView.Adapter.StateRestorationPolicy ALLOW;
    public static final /* enum */ RecyclerView.Adapter.StateRestorationPolicy PREVENT;
    public static final /* enum */ RecyclerView.Adapter.StateRestorationPolicy PREVENT_WHEN_EMPTY;

    static {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy;
        ALLOW = new RecyclerView.Adapter.StateRestorationPolicy();
        PREVENT_WHEN_EMPTY = new RecyclerView.Adapter.StateRestorationPolicy();
        PREVENT = stateRestorationPolicy = new RecyclerView.Adapter.StateRestorationPolicy();
        $VALUES = new RecyclerView.Adapter.StateRestorationPolicy[]{ALLOW, PREVENT_WHEN_EMPTY, stateRestorationPolicy};
    }

    public static RecyclerView.Adapter.StateRestorationPolicy valueOf(String string) {
        return Enum.valueOf(RecyclerView.Adapter.StateRestorationPolicy.class, string);
    }

    public static RecyclerView.Adapter.StateRestorationPolicy[] values() {
        return (RecyclerView.Adapter.StateRestorationPolicy[])$VALUES.clone();
    }
}
