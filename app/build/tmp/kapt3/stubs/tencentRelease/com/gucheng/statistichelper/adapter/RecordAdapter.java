package com.gucheng.statistichelper.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/gucheng/statistichelper/adapter/RecordAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "Lcom/gucheng/statistichelper/adapter/RecordAdapter$RecordViewHolder;", "itemListener", "Lcom/gucheng/statistichelper/adapter/RecordAdapter$ItemListener;", "(Lcom/gucheng/statistichelper/adapter/RecordAdapter$ItemListener;)V", "getItemListener", "()Lcom/gucheng/statistichelper/adapter/RecordAdapter$ItemListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemListener", "RecordViewHolder", "app_tencentRelease"})
public final class RecordAdapter extends androidx.recyclerview.widget.ListAdapter<com.gucheng.statistichelper.database.entity.ItemRecord, com.gucheng.statistichelper.adapter.RecordAdapter.RecordViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.gucheng.statistichelper.adapter.RecordAdapter.ItemListener itemListener = null;
    private static com.gucheng.statistichelper.adapter.RecordAdapter.ItemListener listener;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.gucheng.statistichelper.database.entity.ItemRecord> RECORD_COMPARATOR = null;
    public static final com.gucheng.statistichelper.adapter.RecordAdapter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.gucheng.statistichelper.adapter.RecordAdapter.RecordViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.adapter.RecordAdapter.RecordViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.adapter.RecordAdapter.ItemListener getItemListener() {
        return null;
    }
    
    public RecordAdapter(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.adapter.RecordAdapter.ItemListener itemListener) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/gucheng/statistichelper/adapter/RecordAdapter$RecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "editBtn", "Landroid/widget/Button;", "itemLayout", "itemName", "Landroid/widget/TextView;", "itemType", "bind", "", "itemRecord", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "Companion", "app_tencentRelease"})
    public static final class RecordViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView itemName = null;
        private final android.widget.TextView itemType = null;
        private final android.widget.Button editBtn = null;
        private final android.view.View itemLayout = null;
        public static final com.gucheng.statistichelper.adapter.RecordAdapter.RecordViewHolder.Companion Companion = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.entity.ItemRecord itemRecord) {
        }
        
        public RecordViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gucheng/statistichelper/adapter/RecordAdapter$RecordViewHolder$Companion;", "", "()V", "create", "Lcom/gucheng/statistichelper/adapter/RecordAdapter$RecordViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_tencentRelease"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final com.gucheng.statistichelper.adapter.RecordAdapter.RecordViewHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/gucheng/statistichelper/adapter/RecordAdapter$ItemListener;", "", "delete", "", "record", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "edit", "app_tencentRelease"})
    public static abstract interface ItemListener {
        
        public abstract void delete(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.entity.ItemRecord record);
        
        public abstract void edit(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.entity.ItemRecord record);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/gucheng/statistichelper/adapter/RecordAdapter$Companion;", "", "()V", "RECORD_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/gucheng/statistichelper/database/entity/ItemRecord;", "listener", "Lcom/gucheng/statistichelper/adapter/RecordAdapter$ItemListener;", "app_tencentRelease"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}