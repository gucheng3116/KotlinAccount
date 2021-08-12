package com.gucheng.statistichelper.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/gucheng/statistichelper/activity/NewItemActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/gucheng/statistichelper/ItemFragment$TypeSelectListener;", "()V", "fragment", "Lcom/gucheng/statistichelper/ItemFragment;", "viewModel", "Lcom/gucheng/statistichelper/database/RecordViewModel;", "getViewModel", "()Lcom/gucheng/statistichelper/database/RecordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "editType", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "typeSelect", "itemType", "Lcom/gucheng/statistichelper/database/entity/ItemType;", "Companion", "app_tencentRelease"})
public final class NewItemActivity extends androidx.appcompat.app.AppCompatActivity implements com.gucheng.statistichelper.ItemFragment.TypeSelectListener {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.gucheng.statistichelper.ItemFragment fragment;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_NEW_ITEM = "new_item";
    @org.jetbrains.annotations.NotNull()
    public static android.widget.EditText amountEdt;
    @org.jetbrains.annotations.NotNull()
    public static android.widget.EditText typeEdt;
    private static int type = 0;
    public static final com.gucheng.statistichelper.activity.NewItemActivity.Companion Companion = null;
    
    private final com.gucheng.statistichelper.database.RecordViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void typeSelect(@org.jetbrains.annotations.NotNull()
    com.gucheng.statistichelper.database.entity.ItemType itemType) {
    }
    
    public final void editType(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public NewItemActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/gucheng/statistichelper/activity/NewItemActivity$Companion;", "", "()V", "EXTRA_NEW_ITEM", "", "getEXTRA_NEW_ITEM", "()Ljava/lang/String;", "amountEdt", "Landroid/widget/EditText;", "getAmountEdt", "()Landroid/widget/EditText;", "setAmountEdt", "(Landroid/widget/EditText;)V", "type", "", "getType", "()I", "setType", "(I)V", "typeEdt", "getTypeEdt", "setTypeEdt", "app_tencentRelease"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEXTRA_NEW_ITEM() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getAmountEdt() {
            return null;
        }
        
        public final void setAmountEdt(@org.jetbrains.annotations.NotNull()
        android.widget.EditText p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getTypeEdt() {
            return null;
        }
        
        public final void setTypeEdt(@org.jetbrains.annotations.NotNull()
        android.widget.EditText p0) {
        }
        
        public final int getType() {
            return 0;
        }
        
        public final void setType(int p0) {
        }
        
        private Companion() {
            super();
        }
    }
}