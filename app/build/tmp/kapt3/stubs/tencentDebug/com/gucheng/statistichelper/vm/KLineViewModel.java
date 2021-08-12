package com.gucheng.statistichelper.vm;

import java.lang.System;

/**
 * Created on 2021/7/21.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/gucheng/statistichelper/vm/KLineViewModel;", "Landroidx/lifecycle/ViewModel;", "recordRepository", "Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "dailyReportRepository", "Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;", "(Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;)V", "queryDailyReport", "", "Lcom/gucheng/statistichelper/database/entity/DailyReport;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMonthlyReport", "queryWeeklyReport", "app_tencentDebug"})
public final class KLineViewModel extends androidx.lifecycle.ViewModel {
    private final com.gucheng.statistichelper.database.repository.ItemRecordRepository recordRepository = null;
    private final com.gucheng.statistichelper.database.repository.DailyReportRepository dailyReportRepository = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object queryDailyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object queryWeeklyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object queryMonthlyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    public KLineViewModel(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemRecordRepository recordRepository, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.DailyReportRepository dailyReportRepository) {
        super();
    }
}