/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.FormBody
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Companion
 */
package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.HttpUrl;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lokhttp3/FormBody$Builder;", "", "charset", "Ljava/nio/charset/Charset;", "(Ljava/nio/charset/Charset;)V", "names", "", "", "values", "add", "name", "value", "addEncoded", "build", "Lokhttp3/FormBody;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class FormBody.Builder {
    private final Charset charset;
    private final List<String> names;
    private final List<String> values;

    public FormBody.Builder() {
        this(null, 1, null);
    }

    public FormBody.Builder(Charset charset) {
        this.charset = charset;
        this.names = new ArrayList();
        this.values = new ArrayList();
    }

    public /* synthetic */ FormBody.Builder(Charset charset, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            charset = null;
        }
        this(charset);
    }

    public final FormBody.Builder add(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        FormBody.Builder builder = this;
        ((Collection)builder.names).add(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" !\"#$&'()+,/:;<=>?@[\\]^`{|}~", (boolean)false, (boolean)false, (boolean)false, (boolean)false, (Charset)builder.charset, (int)91, null));
        ((Collection)builder.values).add(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string2, (int)0, (int)0, (String)" !\"#$&'()+,/:;<=>?@[\\]^`{|}~", (boolean)false, (boolean)false, (boolean)false, (boolean)false, (Charset)builder.charset, (int)91, null));
        return builder;
    }

    public final FormBody.Builder addEncoded(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        FormBody.Builder builder = this;
        ((Collection)builder.names).add(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)0, (int)0, (String)" !\"#$&'()+,/:;<=>?@[\\]^`{|}~", (boolean)true, (boolean)false, (boolean)true, (boolean)false, (Charset)builder.charset, (int)83, null));
        ((Collection)builder.values).add(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string2, (int)0, (int)0, (String)" !\"#$&'()+,/:;<=>?@[\\]^`{|}~", (boolean)true, (boolean)false, (boolean)true, (boolean)false, (Charset)builder.charset, (int)83, null));
        return builder;
    }

    public final FormBody build() {
        return new FormBody(this.names, this.values);
    }
}
