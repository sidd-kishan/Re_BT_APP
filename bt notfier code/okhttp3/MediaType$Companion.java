/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.MediaType
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u0007H\u0007\u00a2\u0006\u0002\b\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0007\u00a2\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class MediaType.Companion {
    private MediaType.Companion() {
    }

    public /* synthetic */ MediaType.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="mediaType.toMediaType()", imports={"okhttp3.MediaType.Companion.toMediaType"}))
    public final MediaType _deprecated_get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"mediaType");
        return this.get(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="mediaType.toMediaTypeOrNull()", imports={"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
    public final MediaType _deprecated_parse(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"mediaType");
        return this.parse(string);
    }

    @JvmStatic
    public final MediaType get(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Object object2 = MediaType.access$getTYPE_SUBTYPE$cp();
        Object object3 = (String[])object;
        object2 = ((Pattern)object2).matcher((CharSequence)object3);
        if (!((Matcher)object2).lookingAt()) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("No subtype found for: \"");
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append('\"');
            object = new IllegalArgumentException(((StringBuilder)object3).toString().toString());
            throw object;
        }
        String string = ((Matcher)object2).group(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"typeSubtype.group(1)");
        Object object4 = Locale.US;
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"US");
        object4 = string.toLowerCase((Locale)object4);
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"(this as java.lang.String).toLowerCase(locale)");
        string = ((Matcher)object2).group(2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"typeSubtype.group(2)");
        Object object5 = Locale.US;
        Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"US");
        string = string.toLowerCase((Locale)object5);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toLowerCase(locale)");
        object5 = new ArrayList();
        Matcher matcher = MediaType.access$getPARAMETER$cp().matcher((CharSequence)object3);
        int n = ((Matcher)object2).end();
        while (true) {
            if (n >= ((String)object).length()) {
                object3 = ((Collection)object5).toArray(new String[0]);
                if (object3 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                return new MediaType((String)object, (String)object4, string, (String[])object3, null);
            }
            matcher.region(n, ((String)object).length());
            if (!matcher.lookingAt()) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Parameter is not formatted correctly: \"");
                object2 = ((String)object).substring(n);
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"(this as java.lang.String).substring(startIndex)");
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("\" for: \"");
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append('\"');
                throw (Throwable)new IllegalArgumentException(((StringBuilder)object3).toString().toString());
            }
            String string2 = matcher.group(1);
            if (string2 == null) {
                n = matcher.end();
                continue;
            }
            object2 = matcher.group(2);
            if (object2 == null) {
                object3 = matcher.group(3);
            } else {
                object3 = object2;
                if (StringsKt.startsWith$default((String)object2, (String)"'", (boolean)false, (int)2, null)) {
                    object3 = object2;
                    if (StringsKt.endsWith$default((String)object2, (String)"'", (boolean)false, (int)2, null)) {
                        object3 = object2;
                        if (((String)object2).length() > 2) {
                            object3 = ((String)object2).substring(1, ((String)object2).length() - 1);
                            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        }
                    }
                }
            }
            object2 = (Collection)object5;
            object2.add(string2);
            object2.add(object3);
            n = matcher.end();
        }
    }

    @JvmStatic
    public final MediaType parse(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        try {
            string = this.get(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            string = null;
        }
        return string;
    }
}
