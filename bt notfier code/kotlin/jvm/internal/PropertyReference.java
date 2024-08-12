/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.CallableReference
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

public abstract class PropertyReference
extends CallableReference
implements KProperty {
    public PropertyReference() {
    }

    public PropertyReference(Object object) {
        super(object);
    }

    public PropertyReference(Object object, Class clazz, String string, String string2, int n) {
        boolean bl = (n & 1) == 1;
        super(object, clazz, string, string2, bl);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof PropertyReference)) {
            if (!(object instanceof KProperty)) return false;
            return object.equals(this.compute());
        }
        object = (PropertyReference)((Object)object);
        if (this.getOwner().equals(object.getOwner()) && this.getName().equals(object.getName()) && this.getSignature().equals(object.getSignature()) && Intrinsics.areEqual((Object)this.getBoundReceiver(), (Object)object.getBoundReceiver())) return bl;
        bl = false;
        return bl;
    }

    protected KProperty getReflected() {
        return (KProperty)super.getReflected();
    }

    public int hashCode() {
        return (this.getOwner().hashCode() * 31 + this.getName().hashCode()) * 31 + this.getSignature().hashCode();
    }

    public boolean isConst() {
        return this.getReflected().isConst();
    }

    public boolean isLateinit() {
        return this.getReflected().isLateinit();
    }

    public String toString() {
        Object object = this.compute();
        if (object != this) {
            return object.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("property ");
        ((StringBuilder)object).append(this.getName());
        ((StringBuilder)object).append(" (Kotlin reflection is not available)");
        return ((StringBuilder)object).toString();
    }
}
