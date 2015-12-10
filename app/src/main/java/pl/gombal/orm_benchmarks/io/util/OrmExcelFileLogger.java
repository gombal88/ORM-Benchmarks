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
import java.util.Iterator;
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

    public void logCreate(int rowCount, long time) {
        CellProperties properties = new CellProperties();
        properties.columnTitle = "Create DB";
        properties.rowTitle = String.valueOf(rowCount);
        properties.value = time;

        putToLogMap(LogFileOperationType.CREATE_DB, properties);

        LogUtils.LOGD(TAG, "createDB: " + time);
    }

    public void logDropDb(int rowCount, long time) {
        CellProperties properties = new CellProperties();
        properties.columnTitle = "Drop DB";
        properties.rowTitle = String.valueOf(rowCount);
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

    public void logSearchIndexed(ORMBenchmarkTasks.EntityType entityType, int rowCount, long time) {
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

        for (LogFileOperationType oprType : Arrays.asList(LogFileOperationType.values())) {
            try {
                String fileName = oprType.getFileName();

                Workbook workbook = getWorkbook(fileName);

                if (workbook != null) {
                    Sheet sheet = workbook.getSheet(ormName);
                    if (sheet == null)
                        sheet = workbook.createSheet(ormName);

                    ExcelUtils.getCellAt(ExcelUtils.getRowAt(sheet, 0), 0).setCellValue("Row count");

                    List<CellProperties> cellList = logMap.get(oprType);
                    if (cellList != null) {
                        for (CellProperties cellProperties : cellList) {

                            int collID = setColumnTitle(sheet, cellProperties);
                            int rowID = setRowTitle(sheet, cellProperties);

                            Row row = sheet.getRow(rowID);
                            Cell cell = ExcelUtils.getCellAt(row, collID);
                            cell.setCellValue(cellProperties.value);
                        }
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

    private Workbook getWorkbook(String fileName) throws IOException {
        if (clearLogFiles && ExcelUtils.isFileExist(fileName)) {
            ExcelUtils.deleteFile(fileName);
            ExcelUtils.createEmptyExcelFile(fileName);
        } else if (!ExcelUtils.isFileExist(fileName)) {
            ExcelUtils.createEmptyExcelFile(fileName);
        }
        return ExcelUtils.openWorkBook(fileName);
    }

    private int setColumnTitle(Sheet sheet, CellProperties cellProperties) {
        Integer columnID = getColumnID(sheet, cellProperties);
        Row row = ExcelUtils.getRowAt(sheet, 0);
        Cell cell = ExcelUtils.getCellAt(row, columnID);
        cell.setCellValue(cellProperties.columnTitle);
        return columnID;
    }

    private int setRowTitle(Sheet sheet, CellProperties cellProperties) {
        Integer rowID = getRowID(sheet, cellProperties);
        Row row = ExcelUtils.getRowAt(sheet, rowID);
        Cell cell = ExcelUtils.getCellAt(row, 0);
        cell.setCellValue(cellProperties.rowTitle);
        return rowID;
    }

    @NonNull
    private Integer getColumnID(Sheet sheet, CellProperties cellProperties) {

        Row firstRow = ExcelUtils.getRowAt(sheet, 0);
        Iterator<Cell> cellIterator = firstRow.cellIterator();

        int rowID = getRowID(sheet, cellProperties);
        Row requiredRow = ExcelUtils.getRowAt(sheet, rowID);
        int cellID = 0;
        while (cellIterator.hasNext()) {
            Cell titleCell = cellIterator.next();
            if (getCellValueAsString(titleCell).equals(cellProperties.columnTitle)) {
                Cell requiredCell = requiredRow.getCell(cellID);
                if (requiredCell == null || getCellValueAsString(titleCell).isEmpty()) {
                    break;
                }
            }
            cellID++;
        }
        return cellID;
    }

    private int getRowID(Sheet sheet, CellProperties cellProperties) {
        Iterator<Row> rowIterator = sheet.iterator();
        int rowID = 0;
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Cell cell = currentRow.getCell(0);
            if (rowID != 0) {
                if (cell == null || getCellValueAsString(cell).equals(cellProperties.rowTitle)) {
                    break;
                }
            }
            rowID++;
        }
        return rowID;
    }

    private String getCellValueAsString(Cell cell) {
        String value;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            default:
                value = "";
        }
        return value;
    }


    class CellProperties {
        String columnTitle;
        String rowTitle;
        long value;
    }


    enum LogFileOperationType {
        CREATE_DB("orm_benchmark_create_db.xls"),
        DROP_DB("orm_benchmark_drop_db.xls"),
        INSERT("orm_benchmark_insert.xls"),
        UPDATE("orm_benchmark_update.xls"),
        SELECT("orm_benchmark_select.xls"),
        SEARCH_INDEXED("orm_benchmark_search_indexed.xls"),
        SEARCH("orm_benchmark_search.xls");

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
