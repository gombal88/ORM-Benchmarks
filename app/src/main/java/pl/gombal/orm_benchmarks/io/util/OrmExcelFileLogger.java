package pl.gombal.orm_benchmarks.io.util;

import android.support.annotation.NonNull;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.gombal.orm_benchmarks.task.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.util.ExcelUtils;
import pl.gombal.orm_benchmarks.util.LogUtils;

/**
 * Created by gombal on 10.09.2015.
 */
public class OrmExcelFileLogger {

    public static final String TAG = "ORM BENCHMARK LOGGER";

    private Map<LogFileOperationType, List<CellProperties>> logMap;

    private String ormName;
    private boolean clearLogFiles;

    public OrmExcelFileLogger(String ormName) {
        this(ormName, false);
    }

    public OrmExcelFileLogger(String ormName, boolean clearLogFiles) {
        this.ormName = ormName;
        this.clearLogFiles = clearLogFiles;
        logMap = new HashMap<>();
    }

    public void logCreate(long time) {
        CellProperties properties = new CellProperties();
        properties.columnTitle = "Create DB";
        properties.rowTitle = "0";
        properties.value = time;

        putToLogMap(LogFileOperationType.CREATE_DB, properties);

        LogUtils.LOGD(TAG, "createDB: " + time);
    }

    public void logDropDb(long time) {
        CellProperties properties = new CellProperties();
        properties.columnTitle = "Drop DB";
        properties.rowTitle = "0";
        properties.value = time;

        putToLogMap(LogFileOperationType.DROP_DB, properties);

        LogUtils.LOGD(TAG, "dropDB: " + time);
    }

    public void logInsert(ORMBenchmarkTasks.EntityType entityType, boolean withTransaction, int rowCount, long time) {
        CellProperties properties = new CellProperties();
        String postfix = withTransaction ? " (withTransaction)" : "";
        properties.columnTitle = entityType.getEntityName() + postfix;
        properties.rowTitle = String.valueOf(rowCount);
        properties.value = time;

        putToLogMap(LogFileOperationType.INSERT, properties);

        LogUtils.LOGD(TAG, "insert to " + entityType + ": " + time);
    }

    public void logUpdate(ORMBenchmarkTasks.EntityType entityType, boolean withTransaction, int rowCount, long time) {
        CellProperties properties = new CellProperties();
        String postfix = withTransaction ? " (withTransaction)" : "";
        properties.columnTitle = entityType.getEntityName() + postfix;
        properties.rowTitle = String.valueOf(rowCount);
        properties.value = time;

        putToLogMap(LogFileOperationType.UPDATE, properties);

        LogUtils.LOGD(TAG, "update " + entityType + ": " + time);
    }

    public void logSelect(ORMBenchmarkTasks.EntityType entityType, ORMBenchmarkTasks.SelectionType selectionType, int rowCount, long time) {
        CellProperties properties = new CellProperties();
        String postfix = " (" + selectionType.getSelectionTypeName() + ")";
        properties.columnTitle = entityType.getEntityName() + postfix;
        properties.rowTitle = String.valueOf(rowCount);
        properties.value = time;

        putToLogMap(LogFileOperationType.SELECT, properties);

        LogUtils.LOGD(TAG, "select all " + entityType + ": " + time);
    }

    public void logSearchIindexed(ORMBenchmarkTasks.EntityType entityType, int rowCount, long time) {
        CellProperties properties = new CellProperties();
        properties.columnTitle = entityType.getEntityName();
        properties.rowTitle = String.valueOf(rowCount);
        properties.value = time;

        putToLogMap(LogFileOperationType.SEARCH_INDEXED, properties);

        LogUtils.LOGD(TAG, "search indexed " + entityType + ": " + time);
    }

    public void logSearch(ORMBenchmarkTasks.EntityType entityType, int rowCount, long time) {
        CellProperties properties = new CellProperties();
        properties.columnTitle = entityType.getEntityName();
        properties.rowTitle = String.valueOf(rowCount);
        properties.value = time;

        putToLogMap(LogFileOperationType.SEARCH, properties);

        LogUtils.LOGD(TAG, "search " + entityType + ": " + time);
    }

    private void putToLogMap(LogFileOperationType key, CellProperties properties) {
        List<CellProperties> cellPropertiesList = logMap.get(key);
        if (cellPropertiesList == null)
            cellPropertiesList = new ArrayList<>();
        cellPropertiesList.add(properties);
        logMap.put(key, cellPropertiesList);
    }


    public boolean commit() {
        boolean success = true;

        List<LogFileOperationType> logOperationList = Arrays.asList(LogFileOperationType.values());
        String fileName;

        for (LogFileOperationType oprType : logOperationList) {
            try {
                fileName = oprType.getFileName();

                if (clearLogFiles && ExcelUtils.isFileExist(fileName)) {
                    ExcelUtils.deleteFile(fileName);
                    ExcelUtils.createEmptyExcelFile(fileName);
                } else if (!ExcelUtils.isFileExist(fileName)) {
                    ExcelUtils.createEmptyExcelFile(fileName);
                }

                Workbook workbook = ExcelUtils.openWorkBook(fileName);

                if (workbook != null) {
                    Sheet sheet = workbook.getSheet(ormName);
                    if (sheet == null)
                        sheet = workbook.createSheet(ormName);

                    List<CellProperties> cellList = logMap.get(oprType);
                    Map<String, Integer> columnNumbers = new HashMap<>();
                    Map<String, Integer> rowNumbers = new HashMap<>();

                    for (CellProperties cellProperties : cellList) {
                        Integer columnID = getColumnID(sheet, columnNumbers, cellProperties);
                        Integer rowID = getRowID(sheet, rowNumbers, cellProperties);

                        Row row = ExcelUtils.getRowAt(sheet, 0);
                        Cell cell = ExcelUtils.getCellAt(row, columnID);
                        cell.setCellValue(cellProperties.columnTitle);

                        row = ExcelUtils.getRowAt(sheet, rowID);
                        cell = ExcelUtils.getCellAt(row, 0);
                        cell.setCellValue(cellProperties.rowTitle);

                        cell = ExcelUtils.getCellAt(row, columnID);
                        cell.setCellValue(cellProperties.value);
                    }
                    ExcelUtils.saveWorkBook(fileName, workbook);
                } else {
                    success = false;
                }

            } catch (IOException e) {
                e.printStackTrace();
                success = false;
            }
        }
        return success;
    }

    @NonNull
    private Integer getColumnID(Sheet sheet, Map<String, Integer> columnNumbers, CellProperties cell) {
        Integer columnID = columnNumbers.get(cell.columnTitle);
        if (columnID == null) {
            Row row = ExcelUtils.getRowAt(sheet, 0);
            columnID = ExcelUtils.getLastEmptyCellID(row) == 0 ? 1 : ExcelUtils.getLastEmptyCellID(row);
            columnNumbers.put(cell.columnTitle, columnID);
        }
        return columnID;
    }

    @NonNull
    private Integer getRowID(Sheet sheet, Map<String, Integer> rowNumbers, CellProperties cell) {
        int lastEmptyRowID = ExcelUtils.getLastEmptyRowID(sheet);
        Integer rowID = rowNumbers.get(cell.rowTitle);
        if (rowID == null) {
            rowID = lastEmptyRowID;
            rowNumbers.put(cell.rowTitle, rowID);
        }
        return rowID;
    }

    class CellProperties {
        String columnTitle;
        String rowTitle;
        long value;
    }


    enum LogFileOperationType {
        CREATE_DB("orm_benchmark_create_db.xls"),
        DROP_DB("orm_benchmark_drop_db"),
        INSERT("orm_benchmark_insert.xls"),
        UPDATE("orm_benchmark_update.xls"),
        SELECT("orm_benchmark_select.xls"),
        SEARCH_INDEXED("orm_benchmark_search_indexed.xls"),
        SEARCH("orm_benchmark_.xls");

        private static final String logDirPath = "";

        private String fileName;

        LogFileOperationType(String fileName) {
            this.fileName = logDirPath + fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }


}
