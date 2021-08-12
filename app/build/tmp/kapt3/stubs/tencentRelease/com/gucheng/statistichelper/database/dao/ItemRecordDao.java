package com.gucheng.statistichelper.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\f\u001a\u00020\rH\'J\u0011\u0010\u000e\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/gucheng/statistichelper/database/dao/ItemRecordDao;", "", "deleteTypeRecord", "", "typeId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecord", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "getAllRecordByTime", "time", "", "getEarlistRecord", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNegativeItems", "getPositiveItems", "insertItemRecord", "record", "(Lcom/gucheng/statistichelper/database/entity/ItemRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tencentRelease"})
public abstract interface ItemRecordDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertItemRecord(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemRecord record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from item_record where id in (select max(id) from item_record where isDel = 0 group by typeId) order by typeName")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> getAllRecord();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from item_record where id in (select max(id) from item_record group by typeId) and isDel = 0 and createTime <= :time")
    public abstract java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord> getAllRecordByTime(@org.jetbrains.annotations.NotNull()
    java.lang.String time);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "update item_record set isDel=1 where typeId = :typeId")
    public abstract java.lang.Object deleteTypeRecord(int typeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from item_record order by id asc limit 1")
    public abstract java.lang.Object getEarlistRecord(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gucheng.statistichelper.database.entity.ItemRecord> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from item_record where id in (select max(id) from item_record where isDel = 0 and amount > 0 group by typeId) order by typeName")
    public abstract java.lang.Object getPositiveItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from item_record where id in (select max(id) from item_record where isDel = 0 and amount < 0 group by typeId) order by typeName")
    public abstract java.lang.Object getNegativeItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gucheng.statistichelper.database.entity.ItemRecord>> p0);
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}