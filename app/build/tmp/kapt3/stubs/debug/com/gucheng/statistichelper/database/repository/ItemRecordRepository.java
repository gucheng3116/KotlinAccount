package com.gucheng.statistichelper.database.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "", "itemRecordDao", "Lcom/gucheng/statistichelper/database/dao/ItemRecordDao;", "(Lcom/gucheng/statistichelper/database/dao/ItemRecordDao;)V", "allRecords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "getAllRecords", "()Lkotlinx/coroutines/flow/Flow;", "deleteTypeRecord", "", "typeId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecordByTime", "time", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNegativeItems", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPositiveItems", "insert", "itemRecord", "(Lcom/gucheng/statistichelper/database/entity/ItemRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ItemRecordRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> allRecords = null;
    private final com.gucheng.statistichelper.database.dao.ItemRecordDao itemRecordDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> getAllRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemRecord itemRecord, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object deleteTypeRecord(int typeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getAllRecordByTime(@org.jetbrains.annotations.NotNull()
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getPositiveItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object getNegativeItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> p0) {
        return null;
    }
    
    public ItemRecordRepository(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.dao.ItemRecordDao itemRecordDao) {
        super();
    }
}