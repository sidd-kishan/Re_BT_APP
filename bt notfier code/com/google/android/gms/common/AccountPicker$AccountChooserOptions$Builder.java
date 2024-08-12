/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Bundle
 *  com.google.android.gms.common.AccountPicker$AccountChooserOptions
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common;

import android.accounts.Account;
import android.os.Bundle;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static class AccountPicker.AccountChooserOptions.Builder {
    private Account zza;
    private ArrayList<Account> zzb;
    private ArrayList<String> zzc;
    private boolean zzd = false;
    private String zze;
    private Bundle zzf;

    public AccountPicker.AccountChooserOptions build() {
        Preconditions.checkArgument((boolean)true, (Object)"We only support hostedDomain filter for account chip styled account picker");
        Preconditions.checkArgument((boolean)true, (Object)"Consent is only valid for account chip styled account picker");
        AccountPicker.AccountChooserOptions accountChooserOptions = new AccountPicker.AccountChooserOptions();
        AccountPicker.AccountChooserOptions.zzp((AccountPicker.AccountChooserOptions)accountChooserOptions, this.zzc);
        AccountPicker.AccountChooserOptions.zzq((AccountPicker.AccountChooserOptions)accountChooserOptions, this.zzb);
        AccountPicker.AccountChooserOptions.zzr((AccountPicker.AccountChooserOptions)accountChooserOptions, (boolean)this.zzd);
        AccountPicker.AccountChooserOptions.zzs((AccountPicker.AccountChooserOptions)accountChooserOptions, null);
        AccountPicker.AccountChooserOptions.zzt((AccountPicker.AccountChooserOptions)accountChooserOptions, null);
        AccountPicker.AccountChooserOptions.zzu((AccountPicker.AccountChooserOptions)accountChooserOptions, (Bundle)this.zzf);
        AccountPicker.AccountChooserOptions.zzv((AccountPicker.AccountChooserOptions)accountChooserOptions, (Account)this.zza);
        AccountPicker.AccountChooserOptions.zzw((AccountPicker.AccountChooserOptions)accountChooserOptions, (boolean)false);
        AccountPicker.AccountChooserOptions.zzx((AccountPicker.AccountChooserOptions)accountChooserOptions, (boolean)false);
        AccountPicker.AccountChooserOptions.zzy((AccountPicker.AccountChooserOptions)accountChooserOptions, null);
        AccountPicker.AccountChooserOptions.zzz((AccountPicker.AccountChooserOptions)accountChooserOptions, (int)0);
        AccountPicker.AccountChooserOptions.zzA((AccountPicker.AccountChooserOptions)accountChooserOptions, (String)this.zze);
        AccountPicker.AccountChooserOptions.zzB((AccountPicker.AccountChooserOptions)accountChooserOptions, (boolean)false);
        AccountPicker.AccountChooserOptions.zzC((AccountPicker.AccountChooserOptions)accountChooserOptions, (boolean)false);
        AccountPicker.AccountChooserOptions.zzD((AccountPicker.AccountChooserOptions)accountChooserOptions, (boolean)false);
        return accountChooserOptions;
    }

    public AccountPicker.AccountChooserOptions.Builder setAllowableAccounts(List<Account> list) {
        list = list == null ? null : new ArrayList<Account>(list);
        this.zzb = list;
        return this;
    }

    public AccountPicker.AccountChooserOptions.Builder setAllowableAccountsTypes(List<String> list) {
        list = list == null ? null : new ArrayList<String>(list);
        this.zzc = list;
        return this;
    }

    public AccountPicker.AccountChooserOptions.Builder setAlwaysShowAccountPicker(boolean bl) {
        this.zzd = bl;
        return this;
    }

    public AccountPicker.AccountChooserOptions.Builder setOptionsForAddingAccount(Bundle bundle) {
        this.zzf = bundle;
        return this;
    }

    public AccountPicker.AccountChooserOptions.Builder setSelectedAccount(Account account) {
        this.zza = account;
        return this;
    }

    public AccountPicker.AccountChooserOptions.Builder setTitleOverrideText(String string) {
        this.zze = string;
        return this;
    }
}
