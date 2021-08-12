package com.gucheng.statistichelper.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gucheng.statistichelper.database.entity.DailyReport;
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

@SuppressWarnings({"unchecked", "deprecation"})
public final class DailyReportDao_Impl implements DailyReportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DailyReport> __insertionAdapterOfDailyReport;

  private final EntityDeletionOrUpdateAdapter<DailyReport> __deletionAdapterOfDailyReport;

  private final EntityDeletionOrUpdateAdapter<DailyReport> __updateAdapterOfDailyReport;

  public DailyReportDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDailyReport = new EntityInsertionAdapter<DailyReport>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `daily_report` (`id`,`items`,`total`,`date`,`createTime`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DailyReport value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getItems() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItems());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getTotal());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getCreateTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreateTime());
        }
      }
    };
    this.__deletionAdapterOfDailyReport = new EntityDeletionOrUpdateAdapter<DailyReport>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `daily_report` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DailyReport value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfDailyReport = new EntityDeletionOrUpdateAdapter<DailyReport>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `daily_report` SET `id` = ?,`items` = ?,`total` = ?,`date` = ?,`createTime` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DailyReport value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getItems() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItems());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getTotal());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getCreateTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreateTime());
        }
        if (value.getId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final DailyReport dailyReport, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDailyReport.insert(dailyReport);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final DailyReport dailyReport, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDailyReport.handle(dailyReport);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final DailyReport dailyReport, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDailyReport.handle(dailyReport);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public List<DailyReport> queryAll() {
    final String _sql = "select * from daily_report";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final List<DailyReport> _result = new ArrayList<DailyReport>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DailyReport _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpItems;
        if (_cursor.isNull(_cursorIndexOfItems)) {
          _tmpItems = null;
        } else {
          _tmpItems = _cursor.getString(_cursorIndexOfItems);
        }
        final Double _tmpTotal;
        if (_cursor.isNull(_cursorIndexOfTotal)) {
          _tmpTotal = null;
        } else {
          _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final String _tmpCreateTime;
        if (_cursor.isNull(_cursorIndexOfCreateTime)) {
          _tmpCreateTime = null;
        } else {
          _tmpCreateTime = _cursor.getString(_cursorIndexOfCreateTime);
        }
        _item = new DailyReport(_tmpId,_tmpItems,_tmpTotal,_tmpDate,_tmpCreateTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object queryLast10(final Continuation<? super List<DailyReport>> p0) {
    final String _sql = "select * from (select * from daily_report order by id desc limit 10) order by date";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<DailyReport>>() {
      @Override
      public List<DailyReport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<DailyReport> _result = new ArrayList<DailyReport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DailyReport _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpItems;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmpItems = null;
            } else {
              _tmpItems = _cursor.getString(_cursorIndexOfItems);
            }
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpCreateTime;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmpCreateTime = null;
            } else {
              _tmpCreateTime = _cursor.getString(_cursorIndexOfCreateTime);
            }
            _item = new DailyReport(_tmpId,_tmpItems,_tmpTotal,_tmpDate,_tmpCreateTime);
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
  public Object queryMonthlyReport(final Continuation<? super List<DailyReport>> p0) {
    final String _sql = "select * from daily_report where date in (select max(date) from daily_report group by substr(date,0,8)) order by date ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<DailyReport>>() {
      @Override
      public List<DailyReport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<DailyReport> _result = new ArrayList<DailyReport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DailyReport _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpItems;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmpItems = null;
            } else {
              _tmpItems = _cursor.getString(_cursorIndexOfItems);
            }
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpCreateTime;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmpCreateTime = null;
            } else {
              _tmpCreateTime = _cursor.getString(_cursorIndexOfCreateTime);
            }
            _item = new DailyReport(_tmpId,_tmpItems,_tmpTotal,_tmpDate,_tmpCreateTime);
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
  public Object queryWeeklyReport(final Continuation<? super List<DailyReport>> p0) {
    final String _sql = "select * from daily_report where date in (select max(date)  from daily_report group by strftime('%W', date)) order by date ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<DailyReport>>() {
      @Override
      public List<DailyReport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<DailyReport> _result = new ArrayList<DailyReport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DailyReport _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpItems;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmpItems = null;
            } else {
              _tmpItems = _cursor.getString(_cursorIndexOfItems);
            }
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpCreateTime;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmpCreateTime = null;
            } else {
              _tmpCreateTime = _cursor.getString(_cursorIndexOfCreateTime);
            }
            _item = new DailyReport(_tmpId,_tmpItems,_tmpTotal,_tmpDate,_tmpCreateTime);
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
  public Object queryDateReport(final String date,
      final Continuation<? super List<DailyReport>> p1) {
    final String _sql = "select * from daily_report where date=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<DailyReport>>() {
      @Override
      public List<DailyReport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItems = CursorUtil.getColumnIndexOrThrow(_cursor, "items");
          final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<DailyReport> _result = new ArrayList<DailyReport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DailyReport _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpItems;
            if (_cursor.isNull(_cursorIndexOfItems)) {
              _tmpItems = null;
            } else {
              _tmpItems = _cursor.getString(_cursorIndexOfItems);
            }
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpCreateTime;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmpCreateTime = null;
            } else {
              _tmpCreateTime = _cursor.getString(_cursorIndexOfCreateTime);
            }
            _item = new DailyReport(_tmpId,_tmpItems,_tmpTotal,_tmpDate,_tmpCreateTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
