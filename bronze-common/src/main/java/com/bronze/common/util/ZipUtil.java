package com.bronze.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Don
 * @version V1.0
 * @Package: cc.s2m.web.followUpVisit.util
 * @Description: TODO
 * @Creation Date:2018-10-09
 */
public class ZipUtil {
    /**
     * 将多个Excel压缩导出
     *
     * @param response
     * @param workBookMap key为Excel文件名，value为对应workbook
     * @param zipFileName 压缩文件名< 不带后缀>
     * @return false： 出现异常或没有可导出的内容
     */
    public static boolean exportExcelToZip(HttpServletResponse response, Map<String, Workbook> workBookMap, String
            zipFileName) {
        if (workBookMap == null) {
            return false;
        }
        OutputStream out = null;
        ZipOutputStream zos = null;
        try {
            List<String> pathList = null;
            if (workBookMap != null) {
                Set keys = workBookMap.keySet();
                if (keys != null) {
                    // 清空输出流
                    response.resetBuffer();
                    // 设置reponse返回数据类型，文件名，以及处理文件名乱码
                    response.setHeader("Content-disposition",
                            "attachment; filename=" + new String((zipFileName + ".zip").getBytes("GB2312"),
                                    "ISO8859-1"));
                    // 设置返回内容形式：下载
                    response.setContentType("application/x-download; charset=utf-8");
                    // 取得输出流
                    out = response.getOutputStream();
                    // 压缩输出流
                    zos = new ZipOutputStream(out);
                    // 获取所有Excel名字
                    Iterator<String> it = keys.iterator();
                    while (it.hasNext()) {
                        String name = it.next();
                        Workbook book = workBookMap.get(name);
                        if (book != null) {
                            // 创建一个压缩对象，并赋上文件名
                            ZipEntry entry = new ZipEntry(name + ".xls");
                            // 将一个要压缩的对象放进压缩流中
                            zos.putNextEntry(entry);
                            book.write(zos);
                            zos.closeEntry();
                        }
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // 关闭顺序必须是zos在前面，否则在用wrar解压时报错：“不可预料的压缩文件末端是什么原因”
                if (zos != null) {
                    zos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 给sheet组装数据<基础方法>
     *
     * @param workbook
     * @param sheetName
     * @param headers
     * @param dataList
     */
    public static void addSheetData(HSSFWorkbook workbook, String sheetName, String[] headers,
                                    List<Object[]> dataList) {
        CellStyle titleStyle = getTitleCellStyle(workbook);
        CellStyle style = getCellStyle(workbook);
        if (workbook == null) {
            return;
        }

        // 生成一个sheet页
        Sheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(20);
        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            if (titleStyle != null) {
                cell.setCellStyle(titleStyle);
            }
            RichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        // 遍历集合数据，产生数据行
        int index = 0;
        // 数字正则
        Pattern p = Pattern.compile("\\d*\\.?\\d*");
        for (Object[] objects : dataList) {
            if (objects == null || objects.length == 0) {
                continue;
            }
            index++;
            row = sheet.createRow(index);
            for (int i = 0; i < objects.length; i++) {
                String val = (String) objects[i];
                Cell cell = row.createCell(i);
                if (style != null) {
                    cell.setCellStyle(style);
                }
                if(StringUtils.isBlank(val)){
                    cell.setCellValue("");
                    continue;
                }
                // 处理数字
                Matcher matcher = p.matcher(val);
                if (matcher.matches()) {
                    /**数字如果不加数字样式，导出的数据无法进行求和等操作*/
                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                }
                cell.setCellValue(val);
            }
        }
    }

    /**
     * 返回标题栏单元格样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getTitleCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font font = getTitleCellFont(workbook);
        if (font != null) {
            style.setFont(font);
        }
        return style;
    }

    /**
     * 返回标题单元格样式
     *
     * @param workbook
     * @return
     */
    public static Font getTitleCellFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setColor(HSSFColor.VIOLET.index);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        return font;
    }

    /**
     * 返回单元格样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font font = getCellFont(workbook);
        if (font != null) {
            style.setFont(font);
        }
        return style;
    }

    /**
     * 返回普通单元格样式
     *
     * @param workbook
     * @return
     */
    public static Font getCellFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        return font;
    }
}
