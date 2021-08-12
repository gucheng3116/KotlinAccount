package com.gucheng.statistichelper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/gucheng/statistichelper/TypeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "Lcom/gucheng/statistichelper/TypeAdapter$TypeViewHolder;", "selectListener", "Lcom/gucheng/statistichelper/ItemFragment$TypeSelectListener;", "(Lcom/gucheng/statistichelper/ItemFragment$TypeSelectListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "TypeViewHolder", "app_tencentDebug"})
public final class TypeAdapter extends androidx.recyclerview.widget.ListAdapter<com.gucheng.statistichelper.database.entity.ItemType, com.gucheng.statistichelper.TypeAdapter.TypeViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public static com.gucheng.statistichelper.ItemFragment.TypeSelectListener listener;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.gucheng.statistichelper.database.entity.ItemType> ITEM_COMPARATOR = null;
    public static final com.gucheng.statistichelper.TypeAdapter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.gucheng.statistichelper.TypeAdapter.TypeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.TypeAdapter.TypeViewHolder holder, int position) {
    }
    
    public TypeAdapter(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.ItemFragment.TypeSelectListener selectListener) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/gucheng/statistichelper/TypeAdapter$TypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "typeName", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "bind", "", "itemType", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "Companion", "app_tencentDebug"})
    public static final class TypeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView typeName = null;
        public static final com.gucheng.statistichelper.TypeAdapter.TypeViewHolder.Companion Companion = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.entity.ItemType itemType) {
        }
        
        public TypeViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gucheng/statistichelper/TypeAdapter$TypeViewHolder$Companion;", "", "()V", "create", "Lcom/gucheng/statistichelper/TypeAdapter$TypeViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_tencentDebug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final com.gucheng.statistichelper.TypeAdapter.TypeViewHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/gucheng/statistichelper/TypeAdapter$Companion;", "", "()V", "ITEM_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "listener", "Lcom/gucheng/statistichelper/ItemFragment$TypeSelectListener;", "getListener", "()Lcom/gucheng/statistichelper/ItemFragment$TypeSelectListener;", "setListener", "(Lcom/gucheng/statistichelper/ItemFragment$TypeSelectListener;)V", "app_tencentDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.gucheng.statistichelper.ItemFragment.TypeSelectListener getListener() {
            return null;
        }
        
        public final void setListener(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.ItemFragment.TypeSelectListener p0) {
        }
        
        private Companion() {
            super();
        }
    }
}