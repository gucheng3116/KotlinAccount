package com.gucheng.statistichelper.database.repository;

import java.lang.System;

/**
 * Created on 2021/7/13.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;", "", "dailyReportDao", "Lcom/gucheng/statistichelper/database/dao/DailyReportDao;", "(Lcom/gucheng/statistichelper/database/dao/DailyReportDao;)V", "queryAll", "", "Lcom/gucheng/statistichelper/database/entity/DailyReport;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryLast10", "queryMonthlyReport", "queryWeeklyReport", "app_debug"})
public final class DailyReportRepository {
    private final com.gucheng.statistichelper.database.dao.DailyReportDao dailyReportDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object queryAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object queryLast10(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object queryMonthlyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object queryWeeklyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    public DailyReportRepository(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.dao.DailyReportDao dailyReportDao) {
        super();
    }
}