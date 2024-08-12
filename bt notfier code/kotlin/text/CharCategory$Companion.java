/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.text.CharCategory
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharCategory;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/text/CharCategory$Companion;", "", "()V", "valueOf", "Lkotlin/text/CharCategory;", "category", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class CharCategory.Companion {
    private CharCategory.Companion() {
    }

    public /* synthetic */ CharCategory.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final CharCategory valueOf(int n) {
        block4: {
            CharCategory charCategory;
            block3: {
                block2: {
                    if (n < 0 || 16 < n) break block2;
                    charCategory = CharCategory.values()[n];
                    break block3;
                }
                if (18 > n || 30 < n) break block4;
                charCategory = CharCategory.values()[n - 1];
            }
            return charCategory;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Category #");
        stringBuilder.append(n);
        stringBuilder.append(" is not defined.");
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }
}
