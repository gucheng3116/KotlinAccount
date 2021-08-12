package com.gucheng.statistichelper.database;

import java.lang.System;

@androidx.room.Database(entities = {com.gucheng.statistichelper.database.entity.ItemRecord.class, com.gucheng.statistichelper.database.entity.ItemType.class, com.gucheng.statistichelper.database.entity.DailyReport.class}, version = 4, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/gucheng/statistichelper/database/AccountDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dailyReportDao", "Lcom/gucheng/statistichelper/database/dao/DailyReportDao;", "itemRecordDao", "Lcom/gucheng/statistichelper/database/dao/ItemRecordDao;", "itemTypeDao", "Lcom/gucheng/statistichelper/database/dao/ItemTypeDao;", "Companion", "app_tencentDebug"})
public abstract class AccountDatabase extends androidx.room.RoomDatabase {
    private static volatile com.gucheng.statistichelper.database.AccountDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGARATION_3_4 = null;
    public static final com.gucheng.statistichelper.database.AccountDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gucheng.statistichelper.database.dao.ItemRecordDao itemRecordDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gucheng.statistichelper.database.dao.ItemTypeDao itemTypeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gucheng.statistichelper.database.dao.DailyReportDao dailyReportDao();
    
    public AccountDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/gucheng/statistichelper/database/AccountDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/gucheng/statistichelper/database/AccountDatabase;", "MIGARATION_3_4", "Landroidx/room/migration/Migration;", "getMIGARATION_3_4", "()Landroidx/room/migration/Migration;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "populateDatabase", "", "itemRecordDao", "Lcom/gucheng/statistichelper/database/dao/ItemRecordDao;", "itemTypeDao", "Lcom/gucheng/statistichelper/database/dao/ItemTypeDao;", "(Lcom/gucheng/statistichelper/database/dao/ItemRecordDao;Lcom/gucheng/statistichelper/database/dao/ItemTypeDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AccountDatabaseCallback", "app_tencentDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGARATION_3_4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gucheng.statistichelper.database.AccountDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object populateDatabase(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.dao.ItemRecordDao itemRecordDao, @org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.dao.ItemTypeDao itemTypeDao, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/gucheng/statistichelper/database/AccountDatabase$Companion$AccountDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_tencentDebug"})
        static final class AccountDatabaseCallback extends androidx.room.RoomDatabase.Callback {
            private final kotlinx.coroutines.CoroutineScope scope = null;
            
            @java.lang.Override()
            public void onCreate(@org.jetbrains.annotations.NotNull()
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
            
            public AccountDatabaseCallback(@org.jetbrains.annotations.NotNull()
            kotlinx.coroutines.CoroutineScope scope) {
                super();
            }
        }
    }
}