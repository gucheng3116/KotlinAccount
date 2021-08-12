package com.gucheng.statistichelper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/gucheng/statistichelper/AccountApplication;", "Landroid/app/Application;", "()V", "dailyReportRepository", "Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;", "getDailyReportRepository", "()Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;", "dailyReportRepository$delegate", "Lkotlin/Lazy;", "database", "Lcom/gucheng/statistichelper/database/AccountDatabase;", "getDatabase", "()Lcom/gucheng/statistichelper/database/AccountDatabase;", "database$delegate", "itemRepository", "Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "getItemRepository", "()Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "itemRepository$delegate", "typeRepository", "Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;", "getTypeRepository", "()Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;", "typeRepository$delegate", "init", "", "onCreate", "Companion", "app_tencentRelease"})
public final class AccountApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy itemRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy typeRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy dailyReportRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CoroutineScope applicationScope = null;
    public static final com.gucheng.statistichelper.AccountApplication.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.database.AccountDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.database.repository.ItemRecordRepository getItemRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.database.repository.ItemTypeRepository getTypeRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.database.repository.DailyReportRepository getDailyReportRepository() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void init() {
    }
    
    public AccountApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gucheng/statistichelper/AccountApplication$Companion;", "", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationScope", "()Lkotlinx/coroutines/CoroutineScope;", "app_tencentRelease"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.coroutines.CoroutineScope getApplicationScope() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}