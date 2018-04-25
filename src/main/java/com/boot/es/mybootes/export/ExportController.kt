package com.boot.es.mybootes.export

import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.text.SimpleDateFormat
import java.util.*
import javax.servlet.http.HttpServletResponse

@Controller
class ExportController {


    @Autowired
    private lateinit var beanServices: BeanServices

    @RequestMapping("/export", method = [RequestMethod.GET])
    fun export(response: HttpServletResponse, model: ModelMap) {
        //第一个工作表的数据
        val sheetOneVOs = ArrayList<SheetOneVO>()
        var pageNumber = 1
        var ytxResponse: YTXResponse
        while (true) {
            //获取数据
            ytxResponse = beanServices.getBeans()
            val page = ytxResponse.data["page"] as Page<OrderVO>
            if (page.total <= 0 || page.pageNum < pageNumber) {
                //如果没有了就跳出循环
                break
            }
            pageNumber++
            //开始组装数据
            for (orderVo in page.list) {
                assembleSheetOneVO(sheetOneVOs, orderVo)
            }
        }
        //调用导出的方法
        val orderExportVO = OrderExportVO()
        orderExportVO.sheetOneVOs = sheetOneVOs
        outXls(response, orderExportVO)
    }

    private fun outXls(response: HttpServletResponse, orderExportVO: OrderExportVO) {
        val sdf = SimpleDateFormat("yyyyMMddHHmmss")
        response.contentType = "application/octet-stream"
        response.addHeader("Content-disposition", "attachment;filename=" + sdf.format(Date()) + ".xls")
        response.flushBuffer()
        ExportXlsUtlis().exportExcel(orderExportVO, response)
    }

    private fun assembleSheetOneVO(sheetOneVOs: ArrayList<SheetOneVO>, orderVo: OrderVO) {
        val sheetOneVO = SheetOneVO()
        BeanUtils.copyProperties(orderVo, sheetOneVO)
        sheetOneVOs.add(sheetOneVO)
    }
}