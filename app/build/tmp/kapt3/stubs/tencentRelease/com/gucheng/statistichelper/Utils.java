package com.gucheng.statistichelper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/gucheng/statistichelper/Utils;", "", "()V", "Companion", "app_tencentRelease"})
public final class Utils {
    private static final java.lang.String APP_PREF_NAME = "statistic_helper";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String APP_CHANNEL = "";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UMEN_KEY = "610e49de3451547e683fecae";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final com.gucheng.statistichelper.Utils.Companion Companion = null;
    
    public Utils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/gucheng/statistichelper/Utils$Companion;", "", "()V", "APP_CHANNEL", "", "getAPP_CHANNEL", "()Ljava/lang/String;", "APP_PREF_NAME", "TIME_FORMAT", "getTIME_FORMAT", "UMEN_KEY", "dateToTimestamp", "", "date", "getAppPref", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "timestampToDate", "milli", "app_tencentRelease"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAPP_CHANNEL() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTIME_FORMAT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String timestampToDate(long milli) {
            return null;
        }
        
        public final long dateToTimestamp(@org.jetbrains.annotations.Nullable()
        java.lang.String date) {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences getAppPref(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}