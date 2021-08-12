package com.gucheng.statistichelper.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\'\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/gucheng/statistichelper/database/RecordViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "recordRepository", "Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "typeRepository", "Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;", "dailyReportRepository", "Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;", "(Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;Lcom/gucheng/statistichelper/database/repository/DailyReportRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_tencentRelease"})
public final class RecordViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    private final com.gucheng.statistichelper.database.repository.ItemRecordRepository recordRepository = null;
    private final com.gucheng.statistichelper.database.repository.ItemTypeRepository typeRepository = null;
    private final com.gucheng.statistichelper.database.repository.DailyReportRepository dailyReportRepository = null;
    
    @java.lang.Override()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    public RecordViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemRecordRepository recordRepository, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemTypeRepository typeRepository, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.DailyReportRepository dailyReportRepository) {
        super();
    }
}