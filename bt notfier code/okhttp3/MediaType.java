/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.MediaType$Companion
 */
package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u0019"}, d2={"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "parameterNamesAndValues", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "parameter", "name", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaType {
    public static final Companion Companion = new Companion(null);
    private static final Pattern PARAMETER;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE;
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;

    static {
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String string, String string2, String string3, String[] stringArray) {
        this.mediaType = string;
        this.type = string2;
        this.subtype = string3;
        this.parameterNamesAndValues = stringArray;
    }

    public /* synthetic */ MediaType(String string, String string2, String string3, String[] stringArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(string, string2, string3, stringArray);
    }

    public static final /* synthetic */ Pattern access$getPARAMETER$cp() {
        return PARAMETER;
    }

    public static final /* synthetic */ Pattern access$getTYPE_SUBTYPE$cp() {
        return TYPE_SUBTYPE;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int n, Object object) {
        if ((n & 1) == 0) return mediaType.charset(charset);
        charset = null;
        return mediaType.charset(charset);
    }

    @JvmStatic
    public static final MediaType get(String string) {
        return Companion.get(string);
    }

    @JvmStatic
    public static final MediaType parse(String string) {
        return Companion.parse(string);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="subtype", imports={}))
    public final String _deprecated_subtype() {
        return this.subtype;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="type", imports={}))
    public final String _deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return MediaType.charset$default(this, null, 1, null);
    }

    /*
     * Enabled force condition propagation
     */
    public final Charset charset(Charset object) {
        Object object2 = this.parameter("charset");
        if (object2 == null) {
            return object;
        }
        try {
            return object2 = Charset.forName((String)object2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return object;
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof MediaType && Intrinsics.areEqual((Object)((MediaType)object).mediaType, (Object)this.mediaType);
        return bl;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        int n = this.parameterNamesAndValues.length;
        int n2 = 0;
        n = ProgressionUtilKt.getProgressionLastElement((int)0, (int)(n - 1), (int)2);
        if (n < 0) return null;
        while (!StringsKt.equals((String)this.parameterNamesAndValues[n2], (String)string, (boolean)true)) {
            if (n2 == n) {
                return null;
            }
            n2 += 2;
        }
        return this.parameterNamesAndValues[n2 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }
}
