package com.gucheng.statistichelper.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/gucheng/statistichelper/database/dao/DailyReportDao;", "", "delete", "", "dailyReport", "Lcom/gucheng/statistichelper/database/entity/DailyReport;", "(Lcom/gucheng/statistichelper/database/entity/DailyReport;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "queryAll", "", "queryDateReport", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryLast10", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMonthlyReport", "queryWeeklyReport", "update", "app_debug"})
public abstract interface DailyReportDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.DailyReport dailyReport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.DailyReport dailyReport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.DailyReport dailyReport, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from daily_report")
    public abstract java.util.List<com.gucheng.statistichelper.database.entity.DailyReport> queryAll();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from (select * from daily_report order by id desc limit 10) order by date")
    public abstract java.lang.Object queryLast10(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from daily_report where date in (select max(date) from daily_report group by substr(date,0,8)) order by date ")
    public abstract java.lang.Object queryMonthlyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from daily_report where date in (select max(date)  from daily_report group by strftime(\'%W\', date)) order by date ")
    public abstract java.lang.Object queryWeeklyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from daily_report where date=:date")
    public abstract java.lang.Object queryDateReport(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p1);
}