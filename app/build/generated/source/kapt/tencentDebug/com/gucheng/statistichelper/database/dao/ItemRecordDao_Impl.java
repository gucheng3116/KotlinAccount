package com.gucheng.statistichelper.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gucheng.statistichelper.database.entity.ItemRecord;
import java.lang.Class;
import java.lang.Double;
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
public final class ItemRecordDao_Impl implements ItemRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemRecord> __insertionAdapterOfItemRecord;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTypeRecord;

  public ItemRecordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemRecord = new EntityInsertionAdapter<ItemRecord>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_record` (`id`,`typeId`,`amount`,`typeName`,`createTime`,`isDel`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemRecord value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTypeId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getTypeId());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getAmount());
        }
        if (value.getTypeName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTypeName());
        }
        if (value.getCreateTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreateTime());
        }
        if (value.isDel() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.isDel());
        }
      }
    };
    this.__preparedStmtOfDeleteTypeRecord = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update item_record set isDel=1 where typeId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertItemRecord(final ItemRecord record, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfItemRecord.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteTypeRecord(final int typeId, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTypeRecord.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, typeId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteTypeRecord.release(_stmt);
        }
      }
    }, p1);
  }

  @Override
  public Flow<List<ItemRecord>> getAllRecord() {
    final String _sql = "select * from item_record where id in (select max(id) from item_record where isDel = 0 group by typeId) order by typeName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"item_record"}, new Callable<List<ItemRecord>>() {
      @Override
      public List<ItemRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "typeId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "typeName");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "isDel");
          final List<ItemRecord> _result = new ArrayList<ItemRecord>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemRecord _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final Integer _tmpTypeId;
            if (_cursor.isNull(_cursorIndexOfTypeId)) {
              _tmpTypeId = null;
            } else {
              _tmpTypeId = _cursor.getInt(_cursorIndexOfTypeId);
            }
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
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
            final Integer _tmpIsDel;
            if (_cursor.isNull(_cursorIndexOfIsDel)) {
              _tmpIsDel = null;
            } else {
              _tmpIsDel = _cursor.getInt(_cursorIndexOfIsDel);
            }
            _item = new ItemRecord(_tmpId,_tmpTypeId,_tmpAmount,_tmpTypeName,_tmpCreateTime,_tmpIsDel);
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

  @Override
  public List<ItemRecord> getAllRecordByTime(final String time) {
    final String _sql = "select * from item_record where id in (select max(id) from item_record group by typeId) and isDel = 0 and createTime <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (time == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, time);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "typeId");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "typeName");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "isDel");
      final List<ItemRecord> _result = new ArrayList<ItemRecord>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemRecord _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpTypeId;
        if (_cursor.isNull(_cursorIndexOfTypeId)) {
          _tmpTypeId = null;
        } else {
          _tmpTypeId = _cursor.getInt(_cursorIndexOfTypeId);
        }
        final Double _tmpAmount;
        if (_cursor.isNull(_cursorIndexOfAmount)) {
          _tmpAmount = null;
        } else {
          _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
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
        final Integer _tmpIsDel;
        if (_cursor.isNull(_cursorIndexOfIsDel)) {
          _tmpIsDel = null;
        } else {
          _tmpIsDel = _cursor.getInt(_cursorIndexOfIsDel);
        }
        _item = new ItemRecord(_tmpId,_tmpTypeId,_tmpAmount,_tmpTypeName,_tmpCreateTime,_tmpIsDel);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getEarlistRecord(final Continuation<? super ItemRecord> p0) {
    final String _sql = "select * from item_record order by id asc limit 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ItemRecord>() {
      @Override
      public ItemRecord call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "typeId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "typeName");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "isDel");
          final ItemRecord _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final Integer _tmpTypeId;
            if (_cursor.isNull(_cursorIndexOfTypeId)) {
              _tmpTypeId = null;
            } else {
              _tmpTypeId = _cursor.getInt(_cursorIndexOfTypeId);
            }
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
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
            final Integer _tmpIsDel;
            if (_cursor.isNull(_cursorIndexOfIsDel)) {
              _tmpIsDel = null;
            } else {
              _tmpIsDel = _cursor.getInt(_cursorIndexOfIsDel);
            }
            _result = new ItemRecord(_tmpId,_tmpTypeId,_tmpAmount,_tmpTypeName,_tmpCreateTime,_tmpIsDel);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getPositiveItems(final Continuation<? super List<ItemRecord>> p0) {
    final String _sql = "select * from item_record where id in (select max(id) from item_record where isDel = 0 and amount > 0 group by typeId) order by typeName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ItemRecord>>() {
      @Override
      public List<ItemRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "typeId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "typeName");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "isDel");
          final List<ItemRecord> _result = new ArrayList<ItemRecord>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemRecord _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final Integer _tmpTypeId;
            if (_cursor.isNull(_cursorIndexOfTypeId)) {
              _tmpTypeId = null;
            } else {
              _tmpTypeId = _cursor.getInt(_cursorIndexOfTypeId);
            }
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
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
            final Integer _tmpIsDel;
            if (_cursor.isNull(_cursorIndexOfIsDel)) {
              _tmpIsDel = null;
            } else {
              _tmpIsDel = _cursor.getInt(_cursorIndexOfIsDel);
            }
            _item = new ItemRecord(_tmpId,_tmpTypeId,_tmpAmount,_tmpTypeName,_tmpCreateTime,_tmpIsDel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getNegativeItems(final Continuation<? super List<ItemRecord>> p0) {
    final String _sql = "select * from item_record where id in (select max(id) from item_record where isDel = 0 and amount < 0 group by typeId) order by typeName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ItemRecord>>() {
      @Override
      public List<ItemRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "typeId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfTypeName = CursorUtil.getColumnIndexOrThrow(_cursor, "typeName");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "isDel");
          final List<ItemRecord> _result = new ArrayList<ItemRecord>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemRecord _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final Integer _tmpTypeId;
            if (_cursor.isNull(_cursorIndexOfTypeId)) {
              _tmpTypeId = null;
            } else {
              _tmpTypeId = _cursor.getInt(_cursorIndexOfTypeId);
            }
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
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
            final Integer _tmpIsDel;
            if (_cursor.isNull(_cursorIndexOfIsDel)) {
              _tmpIsDel = null;
            } else {
              _tmpIsDel = _cursor.getInt(_cursorIndexOfIsDel);
            }
            _item = new ItemRecord(_tmpId,_tmpTypeId,_tmpAmount,_tmpTypeName,_tmpCreateTime,_tmpIsDel);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
