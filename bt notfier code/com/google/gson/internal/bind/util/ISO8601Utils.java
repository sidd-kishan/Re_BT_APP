/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String string, int n, char c) {
        boolean bl = n < string.length() && string.charAt(n) == c;
        return bl;
    }

    public static String format(Date date) {
        return ISO8601Utils.format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean bl) {
        return ISO8601Utils.format(date, bl, TIMEZONE_UTC);
    }

    public static String format(Date serializable, boolean bl, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime((Date)serializable);
        int n = bl ? 4 : 0;
        int n2 = timeZone.getRawOffset() == 0 ? 1 : 6;
        serializable = new StringBuilder(19 + n + n2);
        ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(1), 4);
        char c = '-';
        ((StringBuilder)serializable).append('-');
        ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(2) + 1, 2);
        ((StringBuilder)serializable).append('-');
        ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(5), 2);
        ((StringBuilder)serializable).append('T');
        ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(11), 2);
        ((StringBuilder)serializable).append(':');
        ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(12), 2);
        ((StringBuilder)serializable).append(':');
        ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(13), 2);
        if (bl) {
            ((StringBuilder)serializable).append('.');
            ISO8601Utils.padInt((StringBuilder)serializable, gregorianCalendar.get(14), 3);
        }
        if ((n2 = timeZone.getOffset(gregorianCalendar.getTimeInMillis())) != 0) {
            int n3 = n2 / 60000;
            n = Math.abs(n3 / 60);
            n3 = Math.abs(n3 % 60);
            if (n2 >= 0) {
                c = '+';
            }
            ((StringBuilder)serializable).append(c);
            ISO8601Utils.padInt((StringBuilder)serializable, n, 2);
            ((StringBuilder)serializable).append(':');
            ISO8601Utils.padInt((StringBuilder)serializable, n3, 2);
        } else {
            ((StringBuilder)serializable).append('Z');
        }
        return ((StringBuilder)serializable).toString();
    }

    private static int indexOfNonDigit(String string, int n) {
        while (n < string.length()) {
            char c = string.charAt(n);
            if (c < '0') return n;
            if (c > '9') {
                return n;
            }
            ++n;
        }
        return string.length();
    }

    private static void padInt(StringBuilder stringBuilder, int n, int n2) {
        String string = Integer.toString(n);
        n = n2 - string.length();
        while (true) {
            if (n <= 0) {
                stringBuilder.append(string);
                return;
            }
            stringBuilder.append('0');
            --n;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static Date parse(String object, ParsePosition parsePosition) throws ParseException {
        CharSequence charSequence;
        void var14_16;
        CharSequence charSequence2;
        block38: {
            block37: {
                try {
                    int n;
                    int n2;
                    int n3;
                    int n4;
                    int n5;
                    int n6;
                    int n7;
                    int n8;
                    block35: {
                        block36: {
                            block33: {
                                block34: {
                                    n8 = parsePosition.getIndex();
                                    n7 = n8 + 4;
                                    n6 = ISO8601Utils.parseInt((String)object, n8, n7);
                                    n8 = n7;
                                    if (ISO8601Utils.checkOffset((String)object, n7, '-')) {
                                        n8 = n7 + 1;
                                    }
                                    n7 = n8 + 2;
                                    n5 = ISO8601Utils.parseInt((String)object, n8, n7);
                                    n8 = n7;
                                    if (ISO8601Utils.checkOffset((String)object, n7, '-')) {
                                        n8 = n7 + 1;
                                    }
                                    n4 = n8 + 2;
                                    n3 = ISO8601Utils.parseInt((String)object, n8, n4);
                                    boolean bl = ISO8601Utils.checkOffset((String)object, n4, 'T');
                                    if (!bl && ((String)object).length() <= n4) {
                                        GregorianCalendar gregorianCalendar = new GregorianCalendar(n6, n5 - 1, n3);
                                        parsePosition.setIndex(n4);
                                        return gregorianCalendar.getTime();
                                    }
                                    if (!bl) break block33;
                                    n8 = n4 + 1;
                                    n7 = n8 + 2;
                                    n2 = ISO8601Utils.parseInt((String)object, n8, n7);
                                    n8 = n7;
                                    if (ISO8601Utils.checkOffset((String)object, n7, ':')) {
                                        n8 = n7 + 1;
                                    }
                                    n7 = n8 + 2;
                                    n = ISO8601Utils.parseInt((String)object, n8, n7);
                                    n8 = n7;
                                    if (ISO8601Utils.checkOffset((String)object, n7, ':')) {
                                        n8 = n7 + 1;
                                    }
                                    if (((String)object).length() <= n8 || (n7 = (int)((String)object).charAt(n8)) == 90 || n7 == 43 || n7 == 45) break block34;
                                    n4 = n8 + 2;
                                    n7 = n8 = ISO8601Utils.parseInt((String)object, n8, n4);
                                    if (n8 > 59) {
                                        n7 = n8;
                                        if (n8 < 63) {
                                            n7 = 59;
                                        }
                                    }
                                    if (ISO8601Utils.checkOffset((String)object, n4, '.')) {
                                        int n9 = n4 + 1;
                                        n4 = ISO8601Utils.indexOfNonDigit((String)object, n9 + 1);
                                        int n10 = Math.min(n4, n9 + 3);
                                        n8 = ISO8601Utils.parseInt((String)object, n9, n10);
                                        if ((n10 -= n9) != 1) {
                                            if (n10 == 2) {
                                                n8 *= 10;
                                            }
                                        } else {
                                            n8 *= 100;
                                        }
                                        n10 = n8;
                                        n8 = n2;
                                        n2 = n;
                                        n = n10;
                                        break block35;
                                    } else {
                                        n8 = n2;
                                        int n11 = 0;
                                        n2 = n;
                                        n = n11;
                                    }
                                    break block35;
                                }
                                n4 = n8;
                                n8 = n2;
                                n2 = n;
                                break block36;
                            }
                            n8 = 0;
                            n2 = 0;
                        }
                        n = 0;
                        n7 = 0;
                    }
                    if (((String)object).length() > n4) {
                        Object object2;
                        Object object3;
                        char c = ((String)object).charAt(n4);
                        if (c == 'Z') {
                            object3 = TIMEZONE_UTC;
                            ++n4;
                        } else {
                            if (c != '+' && c != '-') {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Invalid time zone indicator '");
                                stringBuilder.append(c);
                                stringBuilder.append("'");
                                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
                                throw indexOutOfBoundsException;
                            }
                            object3 = ((String)object).substring(n4);
                            if (((String)object3).length() < 5) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append((String)object3);
                                ((StringBuilder)object2).append("00");
                                object3 = ((StringBuilder)object2).toString();
                            }
                            n4 += ((String)object3).length();
                            if (!"+0000".equals(object3) && !"+00:00".equals(object3)) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("GMT");
                                ((StringBuilder)object2).append((String)object3);
                                object2 = ((StringBuilder)object2).toString();
                                object3 = TimeZone.getTimeZone((String)object2);
                                CharSequence charSequence3 = ((TimeZone)object3).getID();
                                if (!((String)charSequence3).equals(object2) && !((String)charSequence3).replace(":", "").equals(object2)) {
                                    charSequence3 = new StringBuilder();
                                    ((StringBuilder)charSequence3).append("Mismatching time zone indicator: ");
                                    ((StringBuilder)charSequence3).append((String)object2);
                                    ((StringBuilder)charSequence3).append(" given, resolves to ");
                                    ((StringBuilder)charSequence3).append(((TimeZone)object3).getID());
                                    IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(((StringBuilder)charSequence3).toString());
                                    throw indexOutOfBoundsException;
                                }
                            } else {
                                object3 = TIMEZONE_UTC;
                            }
                        }
                        object2 = new GregorianCalendar((TimeZone)object3);
                        ((Calendar)object2).setLenient(false);
                        ((Calendar)object2).set(1, n6);
                        ((Calendar)object2).set(2, n5 - 1);
                        ((Calendar)object2).set(5, n3);
                        ((Calendar)object2).set(11, n8);
                        ((Calendar)object2).set(12, n2);
                        ((Calendar)object2).set(13, n7);
                        ((Calendar)object2).set(14, n);
                        parsePosition.setIndex(n4);
                        return ((Calendar)object2).getTime();
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No time zone indicator");
                    throw illegalArgumentException;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (NumberFormatException numberFormatException) {
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
                if (object == null) {
                    object = null;
                } else {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append('\"');
                    ((StringBuilder)charSequence2).append((String)object);
                    ((StringBuilder)charSequence2).append('\"');
                    object = ((StringBuilder)charSequence2).toString();
                }
                charSequence = var14_16.getMessage();
                if (charSequence == null) break block37;
                charSequence2 = charSequence;
                if (!((String)charSequence).isEmpty()) break block38;
            }
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("(");
            ((StringBuilder)charSequence2).append(var14_16.getClass().getName());
            ((StringBuilder)charSequence2).append(")");
            charSequence2 = ((StringBuilder)charSequence2).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Failed to parse date [");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("]: ");
        ((StringBuilder)charSequence).append((String)charSequence2);
        object = new ParseException(((StringBuilder)charSequence).toString(), parsePosition.getIndex());
        ((Throwable)object).initCause((Throwable)var14_16);
        throw object;
    }

    private static int parseInt(String object, int n, int n2) throws NumberFormatException {
        if (n >= 0 && n2 <= ((String)object).length() && n <= n2) {
            int n3;
            int n4;
            if (n < n2) {
                n4 = n + 1;
                n3 = Character.digit(((String)object).charAt(n), 10);
                if (n3 < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid number: ");
                    stringBuilder.append(((String)object).substring(n, n2));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n3 = -n3;
            } else {
                n4 = n;
                n3 = 0;
            }
            while (n4 < n2) {
                int n5 = Character.digit(((String)object).charAt(n4), 10);
                if (n5 < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid number: ");
                    stringBuilder.append(((String)object).substring(n, n2));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n3 = n3 * 10 - n5;
                ++n4;
            }
            return -n3;
        }
        object = new NumberFormatException((String)object);
        throw object;
    }
}
