/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.data.CustomDate
 *  com.lianhezhuli.btnotification.utils.StringUtils
 */
package com.lianhezhuli.btnotification.utils;

import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.data.CustomDate;
import com.lianhezhuli.btnotification.utils.StringUtils;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    public static int getCurrentMonthDay() {
        return Calendar.getInstance().get(5);
    }

    public static Date getDateFromString(int n, int n2) {
        Object object;
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append(n);
        ((StringBuilder)serializable).append("-");
        if (n2 > 9) {
            object = n2;
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append(n2);
            object = ((StringBuilder)object).toString();
        }
        ((StringBuilder)serializable).append(object);
        ((StringBuilder)serializable).append("-01");
        String string = ((StringBuilder)serializable).toString();
        object = null;
        try {
            serializable = new SimpleDateFormat("yyyy-MM-dd");
            serializable = ((DateFormat)serializable).parse(string);
            object = serializable;
        }
        catch (ParseException parseException) {
            System.out.println(parseException.getMessage());
        }
        return object;
    }

    public static String getDayOfWeek(String string) {
        String string2 = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(StringUtils.yyyy_M_d.parse(string));
            switch (calendar.get(7)) {
                default: {
                    string = string2;
                    break;
                }
                case 7: {
                    string = MApplication.getInstance().getString(2131755256);
                    break;
                }
                case 6: {
                    string = MApplication.getInstance().getString(2131755242);
                    break;
                }
                case 5: {
                    string = MApplication.getInstance().getString(2131755266);
                    break;
                }
                case 4: {
                    string = MApplication.getInstance().getString(2131755272);
                    break;
                }
                case 3: {
                    string = MApplication.getInstance().getString(2131755267);
                    break;
                }
                case 2: {
                    string = MApplication.getInstance().getString(2131755251);
                    break;
                }
                case 1: {
                    string = MApplication.getInstance().getString(2131755263);
                    break;
                }
            }
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            string = string2;
        }
        return string;
    }

    public static int getHour() {
        return Calendar.getInstance().get(11);
    }

    public static List<String> getLast7Dates() {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = 6;
        while (n >= 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -n);
            arrayList.add(StringUtils.yyyy_M_d.format(calendar.getTime()));
            --n;
        }
        return arrayList;
    }

    public static String[] getLast7WeekDay(Date date) {
        String[] stringArray = new String[7];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int n = 0;
        while (n < 7) {
            switch (calendar.get(7)) {
                default: {
                    break;
                }
                case 7: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755256);
                    break;
                }
                case 6: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755242);
                    break;
                }
                case 5: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755266);
                    break;
                }
                case 4: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755272);
                    break;
                }
                case 3: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755267);
                    break;
                }
                case 2: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755251);
                    break;
                }
                case 1: {
                    stringArray[6 - n] = MApplication.getInstance().getString(2131755263);
                }
            }
            calendar.add(5, -1);
            ++n;
        }
        return stringArray;
    }

    public static int getMinute() {
        return Calendar.getInstance().get(12);
    }

    public static int getMonth() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int getMonthDays(int n, int n2) {
        int[] nArray;
        int n3;
        int n4;
        if (n2 > 12) {
            n4 = n + 1;
            n3 = 1;
        } else {
            n4 = n;
            n3 = n2;
            if (n2 < 1) {
                n4 = n - 1;
                n3 = 12;
            }
        }
        int[] nArray2 = nArray = new int[12];
        nArray[0] = 31;
        nArray2[1] = 28;
        nArray2[2] = 31;
        nArray2[3] = 30;
        nArray2[4] = 31;
        nArray2[5] = 30;
        nArray2[6] = 31;
        nArray2[7] = 31;
        nArray2[8] = 30;
        nArray2[9] = 31;
        nArray2[10] = 30;
        nArray2[11] = 31;
        n = 0;
        if (n4 % 4 == 0 && n4 % 100 != 0 || n4 % 400 == 0) {
            nArray[1] = 29;
        }
        n = nArray[n3 - 1];
        return n;
    }

    public static CustomDate getNextSunday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 7 - DateUtil.getWeekDay() + 1);
        return new CustomDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static Date getTheDayAfter(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, n);
        return calendar.getTime();
    }

    public static List<String> getWeek(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(StringUtils.yyyy_M_d.parse(string));
            int n = calendar.getFirstDayOfWeek();
            int n2 = 0;
            while (n2 < 7) {
                calendar.set(7, n + n2);
                arrayList.add(StringUtils.yyyy_M_d.format(calendar.getTime()));
                ++n2;
            }
            return arrayList;
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return arrayList;
    }

    public static int getWeekDay() {
        return Calendar.getInstance().get(7);
    }

    public static int getWeekDayFromDate(int n, int n2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.getDateFromString(n, n2));
        n = n2 = calendar.get(7) - 1;
        if (n2 >= 0) return n;
        n = 0;
        return n;
    }

    public static int[] getWeekSunday(int n, int n2, int n3, int n4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, n);
        calendar.set(2, n2);
        calendar.set(5, n3);
        calendar.add(5, n4);
        return new int[]{calendar.get(1), calendar.get(2) + 1, calendar.get(5)};
    }

    public static int getYear() {
        return Calendar.getInstance().get(1);
    }

    public static boolean isCurrentMonth(CustomDate customDate) {
        boolean bl = customDate.year == DateUtil.getYear() && customDate.month == DateUtil.getMonth();
        return bl;
    }

    public static boolean isToday(CustomDate customDate) {
        boolean bl = customDate.year == DateUtil.getYear() && customDate.month == DateUtil.getMonth() && customDate.day == DateUtil.getCurrentMonthDay();
        return bl;
    }
}
