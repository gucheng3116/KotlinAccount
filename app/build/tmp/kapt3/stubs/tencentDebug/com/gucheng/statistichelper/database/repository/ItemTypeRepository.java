package com.gucheng.statistichelper.database.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0007J\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;", "", "itemTypeDao", "Lcom/gucheng/statistichelper/database/dao/ItemTypeDao;", "(Lcom/gucheng/statistichelper/database/dao/ItemTypeDao;)V", "allTypes", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "getAllTypes", "()Lkotlinx/coroutines/flow/Flow;", "delete", "", "itemType", "(Lcom/gucheng/statistichelper/database/entity/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "queryAll", "updateType", "app_tencentDebug"})
public final class ItemTypeRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemType>> allTypes = null;
    private final com.gucheng.statistichelper.database.dao.ItemTypeDao itemTypeDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemType>> getAllTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemType>> queryAll() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object updateType(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public ItemTypeRepository(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.dao.ItemTypeDao itemTypeDao) {
        super();
    }
}