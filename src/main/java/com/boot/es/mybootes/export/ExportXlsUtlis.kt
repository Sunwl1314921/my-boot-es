package com.boot.es.mybootes.export

import com.mysql.jdbc.StringUtils
import org.apache.poi.hssf.usermodel.HSSFRichTextString
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.util.*
import javax.servlet.http.HttpServletResponse


/**
 * 导出xls的类
 */
class ExportXlsUtlis {

    @SuppressWarnings("unchecked")
    fun exportExcel(vo: OrderExportVO, response: HttpServletResponse) {
        // 声明一个工作薄
        val workbook = HSSFWorkbook()
        var index = 0
        for (sheetStr in OrderExportVO.sheets) {
            // 生成一个表格
            val sheet = workbook.createSheet(sheetStr)
            // 产生表格标题行
            val row = sheet.createRow(0)
            if (index == 0) {
                header(row, SheetOneVO.headers)
                var r = 1
                for (sheetOneVO in vo.sheetOneVOs) {
                    reflectDataXls(sheetOneVO, sheet.createRow(r))
                    r++
                }
            }
            index++
        }
        workbook.write(response.outputStream)
    }

    /**
     * 生成标题行
     */
    private fun header(row: HSSFRow, headers: Array<String>) {
        for (i in 0 until headers.size) {
            val cell = row.createCell(i)
            val text = HSSFRichTextString(headers[i])
            cell.setCellValue(text)
        }
    }

    /**
     * 反射填充数据
     */
    private fun reflectDataXls(obj: Any, row: HSSFRow) {
        val tclass = obj.javaClass

        var i = 0
        for (field in tclass.declaredFields) {
            val cell = row.createCell(i)
            val fieldName = field.name
            if (fieldName == "headers") {
                continue
            }
            val getMethodName = ("get"
                    + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1))
            val method = tclass.getMethod(getMethodName)
//            val value = method.invoke(obj, *method.parameters)
            val value = method.invoke(obj, *method.parameterAnnotations)
            println("fieldName=$fieldName | value=$value")
            if (value != null) {
                cell.setCellValue(HSSFRichTextString(value.toString()))
            }
            i++
        }


        val atx = "1,2,3,4"
        val itemCategoryIdList = Arrays.asList(atx.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        val longs = ArrayList<Long>()
        for (anItemCategoryIdList in itemCategoryIdList) {
            if (!StringUtils.isNullOrEmpty(anItemCategoryIdList.toString())) {
                longs.add(java.lang.Long.parseLong(anItemCategoryIdList.toString()))
            }
        }
    }
}