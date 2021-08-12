package com.gucheng.statistichelper.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/gucheng/statistichelper/activity/EditTypeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/gucheng/statistichelper/adapter/EditTypeAdapter$TypeListener;", "()V", "addBtn", "Landroid/widget/Button;", "list", "Ljava/util/ArrayList;", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "mAdapter", "Lcom/gucheng/statistichelper/adapter/EditTypeAdapter;", "typeEdt", "Landroid/widget/EditText;", "viewModel", "Lcom/gucheng/statistichelper/vm/EditTypeViewModel;", "getViewModel", "()Lcom/gucheng/statistichelper/vm/EditTypeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "delete", "", "type", "edit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_tencentDebug"})
public final class EditTypeActivity extends androidx.appcompat.app.AppCompatActivity implements com.gucheng.statistichelper.adapter.EditTypeAdapter.TypeListener {
    private com.gucheng.statistichelper.adapter.EditTypeAdapter mAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.ArrayList<com.gucheng.statistichelper.database.entity.ItemType> list;
    private android.widget.Button addBtn;
    private android.widget.EditText typeEdt;
    
    private final com.gucheng.statistichelper.vm.EditTypeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void edit(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType type) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType type) {
    }
    
    public EditTypeActivity() {
        super();
    }
}