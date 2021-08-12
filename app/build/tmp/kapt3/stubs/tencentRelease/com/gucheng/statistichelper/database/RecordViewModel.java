package com.gucheng.statistichelper.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0010R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/gucheng/statistichelper/database/RecordViewModel;", "Landroidx/lifecycle/ViewModel;", "recordRepository", "Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "typeRepository", "Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;", "dailyReportRepository", "Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;", "(Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;)V", "allRecords", "Landroidx/lifecycle/LiveData;", "", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "getAllRecords", "()Landroidx/lifecycle/LiveData;", "allTypes", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "getAllTypes", "selectType", "getSelectType", "()Lcom/gucheng/statistichelper/database/entity/ItemType;", "setSelectType", "(Lcom/gucheng/statistichelper/database/entity/ItemType;)V", "deleteTypeRecord", "Lkotlinx/coroutines/Job;", "itemRecord", "getAll", "Lcom/gucheng/statistichelper/database/entity/DailyReport;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecord", "insertType", "itemType", "app_tencentRelease"})
public final class RecordViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> allRecords = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.gucheng.statistichelper.database.entity.ItemType>> allTypes = null;
    @org.jetbrains.annotations.NotNull()
    public com.gucheng.statistichelper.database.entity.ItemType selectType;
    private final com.gucheng.statistichelper.database.repository.ItemRecordRepository recordRepository = null;
    private final com.gucheng.statistichelper.database.repository.ItemTypeRepository typeRepository = null;
    private final com.gucheng.statistichelper.database.repository.DailyReportRepository dailyReportRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> getAllRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.gucheng.statistichelper.database.entity.ItemType>> getAllTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.database.entity.ItemType getSelectType() {
        return null;
    }
    
    public final void setSelectType(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertRecord(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemRecord itemRecord) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteTypeRecord(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemRecord itemRecord) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertType(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.DailyReport>> p0) {
        return null;
    }
    
    public RecordViewModel(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemRecordRepository recordRepository, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemTypeRepository typeRepository, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.DailyReportRepository dailyReportRepository) {
        super();
    }
}