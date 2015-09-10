package pl.gombal.orm_benchmarks.util;


import android.os.Environment;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static final String TAG = "ExcelUtils";

    public static boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        return file.delete();
    }

    public static boolean createEmptyExcelFile(String fileName) {
        if (!isExternalStorageAvailable() || !isExternalStorageReadOnly() || !fileName.contains(".xls")) {
            Log.w(TAG, "Storage not available, read only or illegal file name!");

            return false;
        }

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        FileOutputStream os = null;

        try {
            os = new FileOutputStream(file);
            wb.write(os);
            Log.w(TAG, "Writing file " + file);
            success = true;
        } catch (IOException e) {
            Log.w(TAG, "Error writing " + file, e);
        } catch (Exception e) {
            Log.w(TAG, "Failed to save file", e);
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (Exception ignored) {
            }
        }
        return success;
    }

    public static Workbook openWorkBook(String fileName) throws IOException {
        if (!isExternalStorageAvailable() || !fileName.contains(".xls")) {
            Log.w(TAG, "Storage not available or illegal file name!");
            return null;
        }

        NPOIFSFileSystem fs = new NPOIFSFileSystem(new File(Environment.getExternalStorageDirectory(), fileName));
        Workbook wb = new HSSFWorkbook(fs.getRoot(), true);
        fs.close();
        return wb;
    }

    public static boolean saveWorkBook(String fileName, Workbook workbook) {
        if (!isExternalStorageAvailable() || !isExternalStorageReadOnly() || !fileName.contains(".xls")) {
            Log.w(TAG, "Storage not available, read only or illegal file name!");

            return false;
        }

        boolean success = false;

        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        FileOutputStream os = null;

        try {
            os = new FileOutputStream(file);
            workbook.write(os);
            Log.w(TAG, "Writing file " + file);
            success = true;
        } catch (IOException e) {
            Log.w(TAG, "Error writing " + file, e);
        } catch (Exception e) {
            Log.w(TAG, "Failed to save file", e);
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (Exception ignored) {
            }
        }
        return success;
    }

    public static int getLastEmptyRowID(Sheet sheet) {
        if (sheet == null)
            throw new IllegalArgumentException("Sheet can not be null!");
        return sheet.getLastRowNum() == 0 ? sheet.getLastRowNum() : sheet.getLastRowNum() + 1;
    }

    public static int getLastEmptyCellID(Row row) {
        if (row == null)
            throw new IllegalArgumentException("Row can not be null!");
        return row.getLastCellNum() == 0 ? row.getLastCellNum() : row.getLastCellNum() + 1;
    }

    public static Row getRowAt(Sheet sheet, int position) {
        return sheet.getRow(position) != null ? sheet.getRow(position) : sheet.createRow(position);
    }

    public static Cell getCellAt(Row row, int position) {
        return row.getCell(position) != null ? row.getCell(position) : row.createCell(position);
    }

    public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);
    }

    public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return !Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }
}
