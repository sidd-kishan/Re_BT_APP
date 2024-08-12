/*
 * Decompiled with CFR 0.152.
 */
package retrofit2.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@Nonnull
@TypeQualifierDefault(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface EverythingIsNonNull {
}
