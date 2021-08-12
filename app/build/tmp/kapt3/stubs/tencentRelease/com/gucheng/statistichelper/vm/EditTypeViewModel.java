package com.gucheng.statistichelper.vm;

import java.lang.System;

/**
 * Created on 2021/8/5.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/gucheng/statistichelper/vm/EditTypeViewModel;", "Landroidx/lifecycle/ViewModel;", "itemTypeRepository", "Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;", "itemRecordRepository", "Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;", "(Lcom/gucheng/statistichelper/database/repository/ItemTypeRepository;Lcom/gucheng/statistichelper/database/repository/ItemRecordRepository;)V", "delete", "", "itemType", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "insert", "queryAllType", "Lkotlinx/coroutines/flow/Flow;", "", "updateType", "app_tencentRelease"})
public final class EditTypeViewModel extends androidx.lifecycle.ViewModel {
    private final com.gucheng.statistichelper.database.repository.ItemTypeRepository itemTypeRepository = null;
    private final com.gucheng.statistichelper.database.repository.ItemRecordRepository itemRecordRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.gucheng.statistichelper.database.entity.ItemType>> queryAllType() {
        return null;
    }
    
    public final void updateType(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType) {
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType) {
    }
    
    public EditTypeViewModel(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemTypeRepository itemTypeRepository, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.repository.ItemRecordRepository itemRecordRepository) {
        super();
    }
}