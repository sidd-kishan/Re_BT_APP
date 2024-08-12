/*
 * Decompiled with CFR 0.152.
 */
package androidx.fragment.app;

static final class SpecialEffectsController.Operation.LifecycleImpact
extends Enum<SpecialEffectsController.Operation.LifecycleImpact> {
    private static final SpecialEffectsController.Operation.LifecycleImpact[] $VALUES;
    public static final /* enum */ SpecialEffectsController.Operation.LifecycleImpact ADDING;
    public static final /* enum */ SpecialEffectsController.Operation.LifecycleImpact NONE;
    public static final /* enum */ SpecialEffectsController.Operation.LifecycleImpact REMOVING;

    static {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        NONE = new SpecialEffectsController.Operation.LifecycleImpact();
        ADDING = new SpecialEffectsController.Operation.LifecycleImpact();
        REMOVING = lifecycleImpact = new SpecialEffectsController.Operation.LifecycleImpact();
        $VALUES = new SpecialEffectsController.Operation.LifecycleImpact[]{NONE, ADDING, lifecycleImpact};
    }

    public static SpecialEffectsController.Operation.LifecycleImpact valueOf(String string) {
        return Enum.valueOf(SpecialEffectsController.Operation.LifecycleImpact.class, string);
    }

    public static SpecialEffectsController.Operation.LifecycleImpact[] values() {
        return (SpecialEffectsController.Operation.LifecycleImpact[])$VALUES.clone();
    }
}
