/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.InitializedLazyImpl
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.SafePublicationLazyImpl$Companion
 *  kotlin.UNINITIALIZED_VALUE
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SafePublicationLazyImpl;
import kotlin.UNINITIALIZED_VALUE;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class SafePublicationLazyImpl<T>
implements Lazy<T>,
Serializable {
    public static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;
    private final Object final;
    private volatile Function0<? extends T> initializer;

    public SafePublicationLazyImpl(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"initializer");
        this.initializer = function0;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        this.final = UNINITIALIZED_VALUE.INSTANCE;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(this.getValue());
    }

    public T getValue() {
        Object object = this._value;
        if (object != UNINITIALIZED_VALUE.INSTANCE) {
            return (T)object;
        }
        object = this.initializer;
        if (object == null) return (T)this._value;
        if (!valueUpdater.compareAndSet(this, UNINITIALIZED_VALUE.INSTANCE, object = object.invoke())) return (T)this._value;
        this.initializer = null;
        return (T)object;
    }

    public boolean isInitialized() {
        boolean bl = this._value != UNINITIALIZED_VALUE.INSTANCE;
        return bl;
    }

    public String toString() {
        String string = this.isInitialized() ? String.valueOf(this.getValue()) : "Lazy value not initialized yet.";
        return string;
    }
}
