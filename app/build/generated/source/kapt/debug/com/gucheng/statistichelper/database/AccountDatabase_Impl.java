package com.gucheng.statistichelper.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.gucheng.statistichelper.database.dao.DailyReportDao;
import com.gucheng.statistichelper.database.dao.DailyReportDao_Impl;
import com.gucheng.statistichelper.database.dao.ItemRecordDao;
import com.gucheng.statistichelper.database.dao.ItemRecordDao_Impl;
import com.gucheng.statistichelper.database.dao.ItemTypeDao;
import com.gucheng.statistichelper.database.dao.ItemTypeDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AccountDatabase_Impl extends AccountDatabase {
  private volatile ItemRecordDao _itemRecordDao;

  private volatile ItemTypeDao _itemTypeDao;

  private volatile DailyReportDao _dailyReportDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_record` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `typeId` INTEGER, `amount` REAL, `typeName` TEXT, `createTime` TEXT, `isDel` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `item_type` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `typeName` TEXT, `createTime` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `daily_report` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `items` TEXT, `total` REAL, `date` TEXT, `createTime` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a8d8c81cffded3ce2f5c6c60e643a9b7')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `item_record`");
        _db.execSQL("DROP TABLE IF EXISTS `item_type`");
        _db.execSQL("DROP TABLE IF EXISTS `daily_report`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsItemRecord = new HashMap<String, TableInfo.Column>(6);
        _columnsItemRecord.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemRecord.put("typeId", new TableInfo.Column("typeId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemRecord.put("amount", new TableInfo.Column("amount", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemRecord.put("typeName", new TableInfo.Column("typeName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemRecord.put("createTime", new TableInfo.Column("createTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemRecord.put("isDel", new TableInfo.Column("isDel", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemRecord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemRecord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemRecord = new TableInfo("item_record", _columnsItemRecord, _foreignKeysItemRecord, _indicesItemRecord);
        final TableInfo _existingItemRecord = TableInfo.read(_db, "item_record");
        if (! _infoItemRecord.equals(_existingItemRecord)) {
          return new RoomOpenHelper.ValidationResult(false, "item_record(com.gucheng.statistichelper.database.entity.ItemRecord).\n"
                  + " Expected:\n" + _infoItemRecord + "\n"
                  + " Found:\n" + _existingItemRecord);
        }
        final HashMap<String, TableInfo.Column> _columnsItemType = new HashMap<String, TableInfo.Column>(3);
        _columnsItemType.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemType.put("typeName", new TableInfo.Column("typeName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItemType.put("createTime", new TableInfo.Column("createTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItemType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItemType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItemType = new TableInfo("item_type", _columnsItemType, _foreignKeysItemType, _indicesItemType);
        final TableInfo _existingItemType = TableInfo.read(_db, "item_type");
        if (! _infoItemType.equals(_existingItemType)) {
          return new RoomOpenHelper.ValidationResult(false, "item_type(com.gucheng.statistichelper.database.entity.ItemType).\n"
                  + " Expected:\n" + _infoItemType + "\n"
                  + " Found:\n" + _existingItemType);
        }
        final HashMap<String, TableInfo.Column> _columnsDailyReport = new HashMap<String, TableInfo.Column>(5);
        _columnsDailyReport.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyReport.put("items", new TableInfo.Column("items", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyReport.put("total", new TableInfo.Column("total", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyReport.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyReport.put("createTime", new TableInfo.Column("createTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDailyReport = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDailyReport = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDailyReport = new TableInfo("daily_report", _columnsDailyReport, _foreignKeysDailyReport, _indicesDailyReport);
        final TableInfo _existingDailyReport = TableInfo.read(_db, "daily_report");
        if (! _infoDailyReport.equals(_existingDailyReport)) {
          return new RoomOpenHelper.ValidationResult(false, "daily_report(com.gucheng.statistichelper.database.entity.DailyReport).\n"
                  + " Expected:\n" + _infoDailyReport + "\n"
                  + " Found:\n" + _existingDailyReport);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "a8d8c81cffded3ce2f5c6c60e643a9b7", "96f20aa18b81fb4a6ca68b3f3beccd4e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "item_record","item_type","daily_report");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `item_record`");
      _db.execSQL("DELETE FROM `item_type`");
      _db.execSQL("DELETE FROM `daily_report`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ItemRecordDao.class, ItemRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemTypeDao.class, ItemTypeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DailyReportDao.class, DailyReportDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public ItemRecordDao itemRecordDao() {
    if (_itemRecordDao != null) {
      return _itemRecordDao;
    } else {
      synchronized(this) {
        if(_itemRecordDao == null) {
          _itemRecordDao = new ItemRecordDao_Impl(this);
        }
        return _itemRecordDao;
      }
    }
  }

  @Override
  public ItemTypeDao itemTypeDao() {
    if (_itemTypeDao != null) {
      return _itemTypeDao;
    } else {
      synchronized(this) {
        if(_itemTypeDao == null) {
          _itemTypeDao = new ItemTypeDao_Impl(this);
        }
        return _itemTypeDao;
      }
    }
  }

  @Override
  public DailyReportDao dailyReportDao() {
    if (_dailyReportDao != null) {
      return _dailyReportDao;
    } else {
      synchronized(this) {
        if(_dailyReportDao == null) {
          _dailyReportDao = new DailyReportDao_Impl(this);
        }
        return _dailyReportDao;
      }
    }
  }
}
