/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$Builder
 *  android.app.Notification$MessagingStyle
 *  android.content.res.ColorStateList
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.style.TextAppearanceSpan
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat$MessagingStyle$Message
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.app.Person
 *  androidx.core.app.Person$Builder
 *  androidx.core.text.BidiFormatter
 */
package androidx.core.app;

import android.app.Notification;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.text.BidiFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static class NotificationCompat.MessagingStyle
extends NotificationCompat.Style {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
    private CharSequence mConversationTitle;
    private final List<Message> mHistoricMessages;
    private Boolean mIsGroupConversation;
    private final List<Message> mMessages = new ArrayList<Message>();
    private Person mUser;

    NotificationCompat.MessagingStyle() {
        this.mHistoricMessages = new ArrayList<Message>();
    }

    public NotificationCompat.MessagingStyle(Person person) {
        this.mHistoricMessages = new ArrayList<Message>();
        if (TextUtils.isEmpty((CharSequence)person.getName())) throw new IllegalArgumentException("User's name must not be empty.");
        this.mUser = person;
    }

    @Deprecated
    public NotificationCompat.MessagingStyle(CharSequence charSequence) {
        this.mHistoricMessages = new ArrayList<Message>();
        this.mUser = new Person.Builder().setName(charSequence).build();
    }

    public static NotificationCompat.MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
        if (!((notification = NotificationCompat.Style.extractStyleFromNotification((Notification)notification)) instanceof NotificationCompat.MessagingStyle)) return null;
        return (NotificationCompat.MessagingStyle)notification;
    }

    private Message findLatestIncomingMessage() {
        int n = this.mMessages.size() - 1;
        while (true) {
            Object object;
            if (n < 0) {
                if (this.mMessages.isEmpty()) return null;
                object = this.mMessages;
                return (Message)object.get(object.size() - 1);
            }
            object = this.mMessages.get(n);
            if (object.getPerson() != null && !TextUtils.isEmpty((CharSequence)object.getPerson().getName())) {
                return object;
            }
            --n;
        }
    }

    private boolean hasMessagesWithoutSender() {
        int n = this.mMessages.size() - 1;
        while (n >= 0) {
            Message message = this.mMessages.get(n);
            if (message.getPerson() != null && message.getPerson().getName() == null) {
                return true;
            }
            --n;
        }
        return false;
    }

    private TextAppearanceSpan makeFontColorSpan(int n) {
        return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf((int)n), null);
    }

    private CharSequence makeMessageLine(Message object) {
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean bl = Build.VERSION.SDK_INT >= 21;
        int n = bl ? -16777216 : -1;
        Object object2 = object.getPerson();
        String string = "";
        object2 = object2 == null ? "" : object.getPerson().getName();
        int n2 = n;
        Object object3 = object2;
        if (TextUtils.isEmpty((CharSequence)object2)) {
            object2 = this.mUser.getName();
            n2 = n;
            object3 = object2;
            if (bl) {
                n2 = n;
                object3 = object2;
                if (this.mBuilder.getColor() != 0) {
                    n2 = this.mBuilder.getColor();
                    object3 = object2;
                }
            }
        }
        object2 = bidiFormatter.unicodeWrap((CharSequence)object3);
        spannableStringBuilder.append((CharSequence)object2);
        spannableStringBuilder.setSpan((Object)this.makeFontColorSpan(n2), spannableStringBuilder.length() - object2.length(), spannableStringBuilder.length(), 33);
        object = object.getText() == null ? string : object.getText();
        spannableStringBuilder.append((CharSequence)"  ").append(bidiFormatter.unicodeWrap((CharSequence)object));
        return spannableStringBuilder;
    }

    public void addCompatExtras(Bundle bundle) {
        Boolean bl;
        super.addCompatExtras(bundle);
        bundle.putCharSequence("android.selfDisplayName", this.mUser.getName());
        bundle.putBundle("android.messagingStyleUser", this.mUser.toBundle());
        bundle.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
        if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
            bundle.putCharSequence("android.conversationTitle", this.mConversationTitle);
        }
        if (!this.mMessages.isEmpty()) {
            bundle.putParcelableArray("android.messages", (Parcelable[])Message.getBundleArrayForMessages(this.mMessages));
        }
        if (!this.mHistoricMessages.isEmpty()) {
            bundle.putParcelableArray("android.messages.historic", (Parcelable[])Message.getBundleArrayForMessages(this.mHistoricMessages));
        }
        if ((bl = this.mIsGroupConversation) == null) return;
        bundle.putBoolean("android.isGroupConversation", bl.booleanValue());
    }

    public NotificationCompat.MessagingStyle addHistoricMessage(Message message) {
        if (message == null) return this;
        this.mHistoricMessages.add(message);
        if (this.mHistoricMessages.size() <= 25) return this;
        this.mHistoricMessages.remove(0);
        return this;
    }

    public NotificationCompat.MessagingStyle addMessage(Message message) {
        if (message == null) return this;
        this.mMessages.add(message);
        if (this.mMessages.size() <= 25) return this;
        this.mMessages.remove(0);
        return this;
    }

    public NotificationCompat.MessagingStyle addMessage(CharSequence charSequence, long l, Person person) {
        this.addMessage(new Message(charSequence, l, person));
        return this;
    }

    @Deprecated
    public NotificationCompat.MessagingStyle addMessage(CharSequence charSequence, long l, CharSequence charSequence2) {
        this.mMessages.add(new Message(charSequence, l, new Person.Builder().setName(charSequence2).build()));
        if (this.mMessages.size() <= 25) return this;
        this.mMessages.remove(0);
        return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        this.setGroupConversation(this.isGroupConversation());
        if (Build.VERSION.SDK_INT >= 24) {
            Notification.MessagingStyle messagingStyle = Build.VERSION.SDK_INT >= 28 ? new Notification.MessagingStyle(this.mUser.toAndroidPerson()) : new Notification.MessagingStyle(this.mUser.getName());
            Iterator<Message> iterator = this.mMessages.iterator();
            while (iterator.hasNext()) {
                messagingStyle.addMessage(iterator.next().toAndroidMessage());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                iterator = this.mHistoricMessages.iterator();
                while (iterator.hasNext()) {
                    messagingStyle.addHistoricMessage(iterator.next().toAndroidMessage());
                }
            }
            if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                messagingStyle.setConversationTitle(this.mConversationTitle);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                messagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue());
            }
            messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
        } else {
            Notification.Builder builder;
            Object object = this.findLatestIncomingMessage();
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (object != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle((CharSequence)"");
                if (object.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(object.getPerson().getName());
                }
            }
            if (object != null) {
                builder = notificationBuilderWithBuilderAccessor.getBuilder();
                object = this.mConversationTitle != null ? this.makeMessageLine((Message)object) : object.getText();
                builder.setContentText((CharSequence)object);
            }
            if (Build.VERSION.SDK_INT < 16) return;
            builder = new SpannableStringBuilder();
            boolean bl = this.mConversationTitle != null || this.hasMessagesWithoutSender();
            for (int i = this.mMessages.size() - 1; i >= 0; --i) {
                object = this.mMessages.get(i);
                object = bl ? this.makeMessageLine((Message)object) : object.getText();
                if (i != this.mMessages.size() - 1) {
                    builder.insert(0, (CharSequence)"\n");
                }
                builder.insert(0, (CharSequence)object);
            }
            new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText((CharSequence)builder);
        }
    }

    protected void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.messagingStyleUser");
        bundle.remove("android.selfDisplayName");
        bundle.remove("android.conversationTitle");
        bundle.remove("android.hiddenConversationTitle");
        bundle.remove("android.messages");
        bundle.remove("android.messages.historic");
        bundle.remove("android.isGroupConversation");
    }

    protected String getClassName() {
        return "androidx.core.app.NotificationCompat$MessagingStyle";
    }

    public CharSequence getConversationTitle() {
        return this.mConversationTitle;
    }

    public List<Message> getHistoricMessages() {
        return this.mHistoricMessages;
    }

    public List<Message> getMessages() {
        return this.mMessages;
    }

    public Person getUser() {
        return this.mUser;
    }

    @Deprecated
    public CharSequence getUserDisplayName() {
        return this.mUser.getName();
    }

    public boolean isGroupConversation() {
        Object object = this.mBuilder;
        boolean bl = false;
        boolean bl2 = false;
        if (object != null && this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.mIsGroupConversation == null) {
            bl = bl2;
            if (this.mConversationTitle == null) return bl;
            bl = true;
            return bl;
        }
        object = this.mIsGroupConversation;
        if (object == null) return bl;
        bl = (Boolean)object;
        return bl;
    }

    protected void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        this.mMessages.clear();
        this.mUser = bundle.containsKey("android.messagingStyleUser") ? Person.fromBundle((Bundle)bundle.getBundle("android.messagingStyleUser")) : new Person.Builder().setName((CharSequence)bundle.getString("android.selfDisplayName")).build();
        Parcelable[] parcelableArray = bundle.getCharSequence("android.conversationTitle");
        this.mConversationTitle = parcelableArray;
        if (parcelableArray == null) {
            this.mConversationTitle = bundle.getCharSequence("android.hiddenConversationTitle");
        }
        if ((parcelableArray = bundle.getParcelableArray("android.messages")) != null) {
            this.mMessages.addAll(Message.getMessagesFromBundleArray((Parcelable[])parcelableArray));
        }
        if ((parcelableArray = bundle.getParcelableArray("android.messages.historic")) != null) {
            this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray((Parcelable[])parcelableArray));
        }
        if (!bundle.containsKey("android.isGroupConversation")) return;
        this.mIsGroupConversation = bundle.getBoolean("android.isGroupConversation");
    }

    public NotificationCompat.MessagingStyle setConversationTitle(CharSequence charSequence) {
        this.mConversationTitle = charSequence;
        return this;
    }

    public NotificationCompat.MessagingStyle setGroupConversation(boolean bl) {
        this.mIsGroupConversation = bl;
        return this;
    }
}
