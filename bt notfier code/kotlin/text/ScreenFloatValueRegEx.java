/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.text.Regex
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    public static final Regex value;

    static {
        CharSequence charSequence = new StringBuilder();
        charSequence.append('(');
        charSequence.append("(\\p{Digit}+)");
        charSequence.append("(\\.)?(");
        charSequence.append("(\\p{Digit}+)");
        charSequence.append("?)(");
        charSequence.append("[eE][+-]?(\\p{Digit}+)");
        charSequence.append(")?)|");
        charSequence.append("(\\.(");
        charSequence.append("(\\p{Digit}+)");
        charSequence.append(")(");
        charSequence.append("[eE][+-]?(\\p{Digit}+)");
        charSequence.append(")?)|");
        charSequence.append("((");
        charSequence.append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
        charSequence.append(")[pP][+-]?");
        charSequence.append("(\\p{Digit}+)");
        charSequence.append(')');
        charSequence = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        stringBuilder.append((String)charSequence);
        stringBuilder.append(")[fFdD]?))[\\x00-\\x20]*");
        value = new Regex(stringBuilder.toString());
    }

    private ScreenFloatValueRegEx() {
    }
}
