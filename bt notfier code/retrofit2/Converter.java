/*
 * Decompiled with CFR 0.152.
 */
package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;

public interface Converter<F, T> {
    @Nullable
    public T convert(F var1) throws IOException;
}
