/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.text.CharDirectionality
 */
package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharDirectionality;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lkotlin/text/CharDirectionality$Companion;", "", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class CharDirectionality.Companion {
    private CharDirectionality.Companion() {
    }

    public /* synthetic */ CharDirectionality.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final Map<Integer, CharDirectionality> getDirectionalityMap() {
        Lazy lazy = CharDirectionality.access$getDirectionalityMap$cp();
        CharDirectionality.Companion companion = CharDirectionality.Companion;
        return (Map)lazy.getValue();
    }

    public final CharDirectionality valueOf(int n) {
        Object object = this.getDirectionalityMap().get(n);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Directionality #");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" is not defined.");
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
    }
}
