package com.gucheng.statistichelper.adapter;

import java.lang.System;

/**
 * Created on 2021/7/11.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/gucheng/statistichelper/adapter/EditTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$EditTypeViewHolder;", "typeList", "", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "listener", "Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$TypeListener;", "(Ljava/util/List;Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$TypeListener;)V", "getListener", "()Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$TypeListener;", "mTypeList", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "EditTypeViewHolder", "TypeListener", "app_tencentRelease"})
public final class EditTypeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.gucheng.statistichelper.adapter.EditTypeAdapter.EditTypeViewHolder> {
    private java.util.List<com.gucheng.statistichelper.database.entity.ItemType> mTypeList;
    @org.jetbrains.annotations.NotNull()
    private final com.gucheng.statistichelper.adapter.EditTypeAdapter.TypeListener listener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.gucheng.statistichelper.adapter.EditTypeAdapter.EditTypeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.adapter.EditTypeAdapter.EditTypeViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gucheng.statistichelper.adapter.EditTypeAdapter.TypeListener getListener() {
        return null;
    }
    
    public EditTypeAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gucheng.statistichelper.database.entity.ItemType> typeList, @org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.adapter.EditTypeAdapter.TypeListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$EditTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "editBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getEditBtn", "()Landroid/widget/Button;", "typeName", "Landroid/widget/TextView;", "getTypeName", "()Landroid/widget/TextView;", "app_tencentRelease"})
    public static final class EditTypeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView typeName = null;
        private final android.widget.Button editBtn = null;
        
        public final android.widget.TextView getTypeName() {
            return null;
        }
        
        public final android.widget.Button getEditBtn() {
            return null;
        }
        
        public EditTypeViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$TypeListener;", "", "edit", "", "type", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "app_tencentRelease"})
    public static abstract interface TypeListener {
        
        public abstract void edit(@org.jetbrains.annotations.NotNull()
        com.gucheng.statistichelper.database.entity.ItemType type);
    }
}