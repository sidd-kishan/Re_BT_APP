/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.ForeignKey
 *  androidx.room.Index
 */
package androidx.room;

import androidx.room.ForeignKey;
import androidx.room.Index;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.TYPE})
public @interface Entity {
    public ForeignKey[] foreignKeys() default {};

    public String[] ignoredColumns() default {};

    public Index[] indices() default {};

    public boolean inheritSuperIndices() default false;

    public String[] primaryKeys() default {};

    public String tableName() default "";
}
