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



public class CaipinExcel {
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
		String headers[] = { "菜品id","菜品名称", "饭店名称", "菜品价格", "菜品销量", "饭店评分", "饭店销量", "饭店url", "饭店地址", "饭店电话", "饭店菜品总览","地区"};
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
        String fandiantitle = "";
        float price = 0;
        int sales = 0;
        float fandianevaluate = 0;
        int fandiansales = 0;
        int meituan = 0;
        int baidu = 0;
        int eleme = 0;
        //-------------------
        String murl = "";
        String maddress = "";
        String mphone = "";
        String mcp = "";
        String burl = "";
        String baddress = "";
        String bphone = "";
        String bcp = "";
        String eurl = "";
        String eaddress = "";
        String ephone = "";
        String ecp = "";
        //浑南 铁西 沈河 皇姑 和平 于洪 沈北 大东 东陵
        String diqu = "东陵";
        String caipin = "卤肉";
        
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
//           sql = "     select f.id id,f.title title,f.fandiantitle fandiantitle, f.price price,f.sales sales,f.fandianevaluate fandianevaluate,f.fandiansales fandiansales,f.meituan meituan,f.baidu baidu,f.eleme eleme,"
//           		+ "           m.url murl,m.address maddress,m.phone mphone,m.cp mcp,"
//           		+ "           b.url burl,b.address baddress,b.phone bphone,b.cp bcp,"
//           		+ "           e.url eurl,e.address eaddress,e.phone ephone,e.cp ecp"
//           		+ "      from caipin f "
//           		+ " left join meituanwaimai m "
//           		+ "        on m.id = f.meituan"
//           		+ " left join baiduwaimai b "
//           		+ "        on b.id = f.baidu "
//           		+ " left join elemewaimai e "
//           		+ "        on e.id = f.eleme"
//           		+ " left join fandian fan"
//           		+ "     where 1=1  "
//           		+ "    and   f.title like \"%卤肉%\" "
//           		+ "      and  (m.address like \"%"+diqu+"%\" or b.address like \"%"+diqu+"%\" or e.address like \"%"+diqu+"%\" )"
//           		+ "  group by fandiantitle ";
           sql = "     select f.id id,f.title title,f.fandiantitle fandiantitle, f.price price,f.sales sales,f.fandianevaluate fandianevaluate,f.fandiansales fandiansales,f.meituan meituan,f.baidu baidu,f.eleme eleme,"
              		+ "           m.url murl,m.address maddress,m.phone mphone,m.cp mcp,"
              		+ "           b.url burl,b.address baddress,b.phone bphone,b.cp bcp,"
              		+ "           e.url eurl,e.address eaddress,e.phone ephone,e.cp ecp"
              		+ "      from caipin f "
              		+ " left join meituanwaimai m "
              		+ "        on m.id = f.meituan"
              		+ " left join baiduwaimai b "
              		+ "        on b.id = f.baidu "
              		+ " left join elemewaimai e "
              		+ "        on e.id = f.eleme"
              		+ "     where 1=1  "
              		+ "       and   f.title like \"%卤肉%\" "
              		+ "       and  (m.address like \"%"+diqu+"%\" or b.address like \"%"+diqu+"%\" or e.address like \"%"+diqu+"%\" )"
              		+ "  group by fandiantitle ";
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               //Retrieve by column name
               id  = rs.getInt("id");
               title = rs.getString("title");
               fandiantitle = rs.getString("fandiantitle");
               price = rs.getFloat("price");
               sales = rs.getInt("sales");
               fandianevaluate = rs.getFloat("fandianevaluate");
               fandiansales = rs.getInt("fandiansales");
               meituan = rs.getInt("meituan");
               baidu = rs.getInt("baidu");
               eleme = rs.getInt("eleme");
               //-------------------
               murl = rs.getString("murl");
               maddress = rs.getString("maddress");
               mphone = rs.getString("mphone");
               mcp = rs.getString("mcp");
               burl = rs.getString("burl");
               baddress = rs.getString("baddress");
               bphone = rs.getString("bphone");
               bcp = rs.getString("bcp");
               eurl = rs.getString("eurl");
               eaddress = rs.getString("eaddress");
               ephone = rs.getString("ephone");
               ecp = rs.getString("ecp");
              
               System.out.println("ID: " + id +", title: " + title+",fandiantitle:" + fandiantitle +",price:"+price+",sales:"+sales+",meituan:"+meituan+",baidu:"+baidu+",eleme:"+eleme);
               //导出excel
            // 创建一行
		    	HSSFRow row = sheet.createRow(i + 1);
		    	for (int j = 0; j < countColumnNum; j++) {
		    		// 在一行内循环
		    		
		    		//"菜品id","菜品名称", "饭店名称", "菜品价格", "菜品销量", "饭店评分", "饭店销量", "饭店url", "饭店地址", "饭店电话", "饭店菜品总览"
		    		//菜品id
					row.createCell(0).setCellValue(id);
					//菜品名称
					row.createCell(1).setCellValue(title);
					//饭店名称
					row.createCell(2).setCellValue(fandiantitle);
					//菜品价格
					row.createCell(3).setCellValue(price);
					//菜品销量
					row.createCell(4).setCellValue(sales);
					//饭店评分
					row.createCell(5).setCellValue(fandianevaluate);
					//饭店销量
					row.createCell(6).setCellValue(fandiansales);
					if(0 != meituan && !"".equals(meituan)){
						//饭店url
						row.createCell(7).setCellValue(murl);
						//饭店地址
						row.createCell(8).setCellValue(maddress);
						//饭店电话
						row.createCell(9).setCellValue(mphone);
						//饭店菜品总览
						row.createCell(10).setCellValue("");
						//地区
						row.createCell(11).setCellValue(diqu);
					}
					if(0 != baidu && !"".equals(baidu)){
						//饭店url
						row.createCell(7).setCellValue(burl);
						//饭店地址
						row.createCell(8).setCellValue(baddress);
						//饭店电话
						row.createCell(9).setCellValue(bphone);
						//饭店菜品总览
						row.createCell(10).setCellValue("");
						//地区
						row.createCell(11).setCellValue(diqu);
					}
					if(0 != eleme && !"".equals(eleme)){
						//饭店url
						row.createCell(7).setCellValue(eurl);
						//饭店地址
						row.createCell(8).setCellValue(eaddress);
						//饭店电话
						row.createCell(9).setCellValue(ephone);
						//饭店菜品总览
						row.createCell(10).setCellValue("");
						//地区
						row.createCell(11).setCellValue(diqu);
					}
					
					
					
				}
		    	i++;
         
            }


		out = new FileOutputStream("D://"+caipin+"_huangmenji_"+diqu+"_"+i+".xls");

		hwb.write(out);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
			System.out.println("完成！"+i);
		}

	}
   
}
