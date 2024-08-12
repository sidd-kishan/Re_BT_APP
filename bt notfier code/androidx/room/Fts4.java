/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.FtsOptions$MatchInfo
 *  androidx.room.FtsOptions$Order
 */
package androidx.room;

import androidx.room.FtsOptions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.TYPE})
public @interface Fts4 {
    public Class<?> contentEntity() default Object.class;

    public String languageId() default "";

    public FtsOptions.MatchInfo matchInfo() default FtsOptions.MatchInfo.FTS4;

    public String[] notIndexed() default {};

    public FtsOptions.Order order() default FtsOptions.Order.ASC;

    public int[] prefix() default {};

    public String tokenizer() default "simple";

    public String[] tokenizerArgs() default {};
}
