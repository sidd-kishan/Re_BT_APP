/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.haibin.calendarview.Calendar$Scheme
 *  com.haibin.calendarview.CalendarUtil
 */
package com.haibin.calendarview;

import android.text.TextUtils;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Calendar
implements Serializable,
Comparable<Calendar> {
    private static final long serialVersionUID = 141315161718191143L;
    private int day;
    private String gregorianFestival;
    private boolean isCurrentDay;
    private boolean isCurrentMonth;
    private boolean isLeapYear;
    private boolean isWeekend;
    private int leapMonth;
    private String lunar;
    private Calendar lunarCalendar;
    private int month;
    private String scheme;
    private int schemeColor;
    private List<Scheme> schemes;
    private String solarTerm;
    private String traditionFestival;
    private int week;
    private int year;

    public void addScheme(int n, int n2, String string) {
        if (this.schemes == null) {
            this.schemes = new ArrayList<Scheme>();
        }
        this.schemes.add(new Scheme(n, n2, string));
    }

    public void addScheme(int n, int n2, String string, String string2) {
        if (this.schemes == null) {
            this.schemes = new ArrayList<Scheme>();
        }
        this.schemes.add(new Scheme(n, n2, string, string2));
    }

    public void addScheme(int n, String string) {
        if (this.schemes == null) {
            this.schemes = new ArrayList<Scheme>();
        }
        this.schemes.add(new Scheme(n, string));
    }

    public void addScheme(int n, String string, String string2) {
        if (this.schemes == null) {
            this.schemes = new ArrayList<Scheme>();
        }
        this.schemes.add(new Scheme(n, string, string2));
    }

    public void addScheme(Scheme scheme) {
        if (this.schemes == null) {
            this.schemes = new ArrayList<Scheme>();
        }
        this.schemes.add(scheme);
    }

    final void clearScheme() {
        this.setScheme("");
        this.setSchemeColor(0);
        this.setSchemes(null);
    }

    @Override
    public int compareTo(Calendar calendar) {
        if (calendar != null) return this.toString().compareTo(calendar.toString());
        return 1;
    }

    public final int differ(Calendar calendar) {
        return CalendarUtil.differ((Calendar)this, (Calendar)calendar);
    }

    public boolean equals(Object object) {
        if (object == null) return super.equals(object);
        if (!(object instanceof Calendar)) return super.equals(object);
        Calendar calendar = (Calendar)object;
        if (calendar.getYear() != this.year) return super.equals(object);
        if (calendar.getMonth() != this.month) return super.equals(object);
        if (calendar.getDay() != this.day) return super.equals(object);
        return true;
    }

    public int getDay() {
        return this.day;
    }

    public String getGregorianFestival() {
        return this.gregorianFestival;
    }

    public int getLeapMonth() {
        return this.leapMonth;
    }

    public String getLunar() {
        return this.lunar;
    }

    public Calendar getLunarCalendar() {
        return this.lunarCalendar;
    }

    public int getMonth() {
        return this.month;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int getSchemeColor() {
        return this.schemeColor;
    }

    public List<Scheme> getSchemes() {
        return this.schemes;
    }

    public String getSolarTerm() {
        return this.solarTerm;
    }

    public long getTimeInMillis() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        return calendar.getTimeInMillis();
    }

    public String getTraditionFestival() {
        return this.traditionFestival;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public boolean hasScheme() {
        List<Scheme> list = this.schemes;
        if (list != null && list.size() != 0) {
            return true;
        }
        if (TextUtils.isEmpty((CharSequence)this.scheme)) return false;
        return true;
    }

    public boolean isAvailable() {
        int n = this.year;
        int n2 = 1;
        n = n > 0 ? 1 : 0;
        int n3 = this.month > 0 ? 1 : 0;
        int n4 = this.day > 0 ? 1 : 0;
        int n5 = this.day <= 31 ? 1 : 0;
        int n6 = this.month <= 12 ? 1 : 0;
        int n7 = this.year >= 1900 ? 1 : 0;
        if (this.year <= 2099) return (n & n3 & n4 & n5 & n6 & n7 & n2) != 0;
        n2 = 0;
        return (n & n3 & n4 & n5 & n6 & n7 & n2) != 0;
    }

    public boolean isCurrentDay() {
        return this.isCurrentDay;
    }

    public boolean isCurrentMonth() {
        return this.isCurrentMonth;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    public boolean isSameMonth(Calendar calendar) {
        boolean bl = this.year == calendar.getYear() && this.month == calendar.getMonth();
        return bl;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    final void mergeScheme(Calendar calendar, String string) {
        if (calendar == null) {
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)calendar.getScheme())) {
            string = calendar.getScheme();
        }
        this.setScheme(string);
        this.setSchemeColor(calendar.getSchemeColor());
        this.setSchemes(calendar.getSchemes());
    }

    public void setCurrentDay(boolean bl) {
        this.isCurrentDay = bl;
    }

    public void setCurrentMonth(boolean bl) {
        this.isCurrentMonth = bl;
    }

    public void setDay(int n) {
        this.day = n;
    }

    public void setGregorianFestival(String string) {
        this.gregorianFestival = string;
    }

    public void setLeapMonth(int n) {
        this.leapMonth = n;
    }

    public void setLeapYear(boolean bl) {
        this.isLeapYear = bl;
    }

    public void setLunar(String string) {
        this.lunar = string;
    }

    public void setLunarCalendar(Calendar calendar) {
        this.lunarCalendar = calendar;
    }

    public void setMonth(int n) {
        this.month = n;
    }

    public void setScheme(String string) {
        this.scheme = string;
    }

    public void setSchemeColor(int n) {
        this.schemeColor = n;
    }

    public void setSchemes(List<Scheme> list) {
        this.schemes = list;
    }

    public void setSolarTerm(String string) {
        this.solarTerm = string;
    }

    public void setTraditionFestival(String string) {
        this.traditionFestival = string;
    }

    public void setWeek(int n) {
        this.week = n;
    }

    public void setWeekend(boolean bl) {
        this.isWeekend = bl;
    }

    public void setYear(int n) {
        this.year = n;
    }

    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.year);
        stringBuilder.append("");
        int n = this.month;
        if (n < 10) {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append(this.month);
            object = ((StringBuilder)object).toString();
        } else {
            object = n;
        }
        stringBuilder.append(object);
        stringBuilder.append("");
        n = this.day;
        if (n < 10) {
            object = new StringBuilder();
            ((StringBuilder)object).append("0");
            ((StringBuilder)object).append(this.day);
            object = ((StringBuilder)object).toString();
        } else {
            object = n;
        }
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}
