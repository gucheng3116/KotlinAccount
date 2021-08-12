package com.gucheng.statistichelper.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gucheng.statistichelper.database.entity.ItemType;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemTypeDao_Impl implements ItemTypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemType> __insertionAdapterOfItemType;

  private final EntityDeletionOrUpdateAdapter<ItemType> __deletionAdapterOfItemType;

  private final EntityDeletionOrUpdateAdapter<ItemType> __updateAdapterOfItemType;

  public ItemTypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemType = new EntityInsertionAdapter<ItemType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_type` (`id`,`typeName`,`createTime`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTypeName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTypeName());
        }
        if (value.getCreateTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCreateTime());
        }
      }
    };
    this.__deletionAdapterOfItemType = new EntityDeletionOrUpdateAdapter<ItemType>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item_type` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfItemType = new EntityDeletionOrUpdateAdapter<ItemType>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item_type` SET `id` = ?,`typeName` = ?,`createTime` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTypeName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTypeName());
        }
        if (value.getCreateTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCreateTime());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertItemType(final ItemType itemType, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfItemType.insert(itemType);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final ItemType itemType, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfItemType.handle(itemType);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateType(final ItemType itemType, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfItemType.handle(itemType);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Flow<List<ItemType>> getAllItem() {
    final String _sql = "select * from item_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"item_type"}, new Callable<List<ItemType>>() {
      @Override
      public List<ItemType> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "typeName");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<ItemType> _result = new ArrayList<ItemType>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemType _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpTypeName;
            if (_cursor.isNull(_cursorIndexOfTypeName)) {
              _tmpTypeName = null;
            } else {
              _tmpTypeName = _cursor.getString(_cursorIndexOfTypeName);
            }
            final String _tmpCreateTime;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmpCreateTime = null;
            } else {
              _tmpCreateTime = _cursor.getString(_cursorIndexOfCreateTime);
            }
            _item = new ItemType(_tmpId,_tmpTypeName,_tmpCreateTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
