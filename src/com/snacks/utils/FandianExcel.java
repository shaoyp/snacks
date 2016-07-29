package com.snacks.utils;
//黄焖鸡米饭
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class FandianExcel {
	// JDBC driver name and database URL
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/youxundata?characterEncoding=utf8";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   public static void main(String[] args) throws Exception {
		// 创建文件输出流，准备输出电子表格
		OutputStream out = null;
		int i = 0;
	        
        // 标题
		String headers[] = { "饭店id", "饭店名称", "饭店电话", "饭店总销量", "饭店地址","微信","联系日期","备注", "百度url","美团url", "饿了么url"};
		// 获取总列数
		int countColumnNum = headers.length;
		// 创建Excel文档
		HSSFWorkbook hwb = new HSSFWorkbook();
		// sheet 对应一个工作页
		HSSFSheet sheet = hwb.createSheet("sheet1");
		// 产生表格标题行
		HSSFRow firstrow = sheet.createRow(0);

		for (int k = 0; k < countColumnNum; k++) {

			HSSFCell cell = firstrow.createCell(k);

			HSSFRichTextString text = new HSSFRichTextString(headers[k]);

			cell.setCellValue(text);

		}
	    //插入数据
		int id = 0;
        String title = "";
        String address = "";
        String phone = "";
        String salestotal = "";
        

        //-------------------
        String murl = "";
    
        String burl = "";
    
        String eurl = "";
       
        // 东陵 浑南 铁西 沈河 皇姑 和平 于洪 沈北 大东
        String diqu = "大东";
        
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           String sql;

           sql = "     select f.id id,f.title title,f.address address,f.phone phone,f.salestotal salestotal,"
           		+ "           f.baidusales baidusales,f.baiduevaluate baiduevaluate,"
           		+ "           f.meituansales meituansales,f.meituanevaluate meituanevaluate,"
           		+ "           f.elemesales elemesales,f.elemeevaluate elemeevaluate,"
           		+ "           m.url murl,m.address maddress,m.phone mphone,m.cp mcp,"
           		+ "           b.url burl,b.address baddress,b.phone bphone,b.cp bcp,"
           		+ "           e.url eurl,e.address eaddress,e.phone ephone,e.cp ecp"
           		+ "      from fandian f "
           		+ " left join meituanwaimai m "
           		+ "        on m.id = f.meituan "
           		+ " left join baiduwaimai b "
           		+ "        on b.id = f.baidu "
           		+ " left join elemewaimai e "
           		+ "        on e.id = f.eleme"
           		+ "     where 1=1   "
           		+ "       and f.diqu like \"%"+diqu+"%\"  ";
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               //Retrieve by column name
               id  = rs.getInt("id");
               title = rs.getString("title");
               address = rs.getString("address");
               phone = rs.getString("phone");
               salestotal = rs.getString("salestotal");
             
               //-------------------
               murl = rs.getString("murl");
              
               burl = rs.getString("burl");
              
               eurl = rs.getString("eurl");
              
              
               System.out.println("ID: " + id +", title: " + title+", murl: " + murl+", burl: " + burl+", eurl: " + eurl);
               //导出excel
            // 创建一行
		    	HSSFRow row = sheet.createRow(i + 1);
		    	for (int j = 0; j < countColumnNum; j++) {
		    		// 在一行内循环
		    		
		    		// "饭店id", "饭店名称", "饭店电话", "饭店总销量", "饭店地址","微信","联系日期","备注", "百度url","美团url","饿了么url"
		    		//菜品id
					row.createCell(0).setCellValue(id);
					//饭店名称
					row.createCell(1).setCellValue(title);
					//饭店电话
					row.createCell(2).setCellValue(phone);
					//饭店总销量
					row.createCell(3).setCellValue(salestotal);
					//饭店地址
					row.createCell(4).setCellValue(address);
					//微信
					row.createCell(5).setCellValue("");
					//联系日期
					row.createCell(6).setCellValue("");
					//备注
					row.createCell(7).setCellValue("");
					//百度url
					row.createCell(8).setCellValue(burl);
					//美团url
					row.createCell(9).setCellValue(murl);
					//饿了么url
					row.createCell(10).setCellValue(eurl);
					
					
					
					
				}
		    	i++;
         
            }


		out = new FileOutputStream("D://饭店_"+diqu+"_"+i+".xls");

		hwb.write(out);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
			System.out.println("完成！"+i);
		}

	}
   
}
