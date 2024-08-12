/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/internal/RequireKotlinVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class RequireKotlinVersionKind
extends Enum<RequireKotlinVersionKind> {
    private static final RequireKotlinVersionKind[] $VALUES;
    public static final /* enum */ RequireKotlinVersionKind API_VERSION;
    public static final /* enum */ RequireKotlinVersionKind COMPILER_VERSION;
    public static final /* enum */ RequireKotlinVersionKind LANGUAGE_VERSION;

    static {
        RequireKotlinVersionKind requireKotlinVersionKind;
        RequireKotlinVersionKind requireKotlinVersionKind2;
        RequireKotlinVersionKind requireKotlinVersionKind3;
        LANGUAGE_VERSION = requireKotlinVersionKind3 = new RequireKotlinVersionKind();
        COMPILER_VERSION = requireKotlinVersionKind2 = new RequireKotlinVersionKind();
        API_VERSION = requireKotlinVersionKind = new RequireKotlinVersionKind();
        $VALUES = new RequireKotlinVersionKind[]{requireKotlinVersionKind3, requireKotlinVersionKind2, requireKotlinVersionKind};
    }

    public static RequireKotlinVersionKind valueOf(String string) {
        return Enum.valueOf(RequireKotlinVersionKind.class, string);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[])$VALUES.clone();
    }
}
