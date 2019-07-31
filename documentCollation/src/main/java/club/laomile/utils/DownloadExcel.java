package club.laomile.utils;

import club.laomile.bean.QuestionBean;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
    Excel下载
 */
public class DownloadExcel {
    public static void downExel(List<QuestionBean> list, HttpServletResponse response){
        // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("sheet1");
        sheet.setColumnWidth(1,30000);
        sheet.setColumnWidth(0,30000);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        HSSFCell cell = row.createCell(0);
        //设置标头

        cell.setCellValue("问题");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("答案");
        cell.setCellStyle(style);
        cell = row.createCell(2);


        //查找数据
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            QuestionBean qb = list.get(i);
            // 第四步，创建单元格，并设置值  
            row.createCell(0).setCellValue((qb.getQuestion() == null ? "" : qb.getQuestion()));
            if (qb.getAnswer() != null) {
                row.createCell(1).setCellValue(qb.getAnswer());
            } else {
                row.createCell(1).setCellValue("");
            }
        }

//下载

        ServletOutputStream out;
        try {
            out = response.getOutputStream();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            String fileName = sdf.format(date) + ".xls";
            response.reset();
            response.setContentType("application/msexcel");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            wb.write(out);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
