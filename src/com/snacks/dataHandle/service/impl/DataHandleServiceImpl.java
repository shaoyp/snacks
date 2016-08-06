package com.snacks.dataHandle.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snacks.baiduwaimai.dao.BaiduwaimaiMapper;
import com.snacks.baiduwaimai.model.Baiduwaimai;
import com.snacks.caipin.dao.CaipinMapper;
import com.snacks.dataHandle.service.DataHandleService;
import com.snacks.elemewaimai.dao.ElemewaimaiMapper;
import com.snacks.elemewaimai.model.Elemewaimai;
import com.snacks.fandian.dao.FandianMapper;
import com.snacks.fandian.model.Fandian;
import com.snacks.fandiandata.dao.FandiandataMapper;
import com.snacks.fandiandata.model.Fandiandata;
import com.snacks.meituanwaimai.dao.MeituanwaimaiMapper;
import com.snacks.meituanwaimai.model.Meituanwaimai;
import com.snacks.utils.UtilTools;
@Service
public class DataHandleServiceImpl implements DataHandleService {
	
	
	@Resource
	private MeituanwaimaiMapper meituanwaimaiMapper;
	
	@Resource
	private ElemewaimaiMapper elemewaimaiMapper;
	
	@Resource
	private BaiduwaimaiMapper baiduwaimaiMapper;
	
	@Resource
	private FandiandataMapper fandiandataMapper;
	
	@Resource
	private FandianMapper fandianMapper;
	
	@Resource
	private CaipinMapper caipinMapper;
	
	
	
	/**
	 * 合并美团、饿了么、百度数据到饭店表
	 */
	@Override
	public int mergeData() {
		
		int count = 0;
		Fandiandata fandiandata = null;
		try {
			//日期
			Date currentTime = new Date();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			String dateString = formatter.format(currentTime);
		    
			//饿了么外卖
			List<Elemewaimai> elemewaimaiList = new ArrayList<Elemewaimai>();
			elemewaimaiList = elemewaimaiMapper.selectByMerge();
			
			
			
			int j = 0,k = 0;
			//插入饿了么数据
			Elemewaimai elemewaimai = null;
			Elemewaimai e = null;
			for (int i = 0; i < elemewaimaiList.size(); i++) {
				elemewaimai = elemewaimaiList.get(i);
				fandiandata = new Fandiandata();
				fandiandata.setResourceId(UtilTools.getSequence(null));
				fandiandata.setTitle(elemewaimai.getTitle());
				fandiandata.setUrl(elemewaimai.getUrl()+",");
				fandiandata.setAddress(elemewaimai.getAddress());
				fandiandata.setPhone(elemewaimai.getPhone());

				fandiandata.setEleme(elemewaimai.getResourceId());
				fandiandata.setElemesales(Integer.parseInt(elemewaimai.getSales()));
				fandiandata.setElemeevaluate(elemewaimai.getEvaluate());
				fandiandata.setGetTime(formatter.parse(dateString));
				fandiandata.setTotalsales(Integer.parseInt(elemewaimai.getSales()));
				System.out.println(elemewaimai.getGetTime());
				//插入
				fandiandataMapper.insertSelective(fandiandata);
				//做 插入标记
				e = new Elemewaimai();
				e.setResourceId(elemewaimai.getResourceId());
				e.setFlg("1");
				elemewaimaiMapper.updateByPrimaryKeySelective(e);
				j++;
			}
			System.out.println("饿了么数据：新增" + j);
			count += j;
			
			//百度外卖
			List<Baiduwaimai> baiduwaimaiList = new ArrayList<Baiduwaimai>();
			baiduwaimaiList = baiduwaimaiMapper.selectByMerge();
			j = 0;k=0;
			//插入百度数据
			Baiduwaimai baiduwaimai = null;
			Baiduwaimai b = null;
			Fandiandata f = null;
			for (int i = 0; i < baiduwaimaiList.size(); i++) {
				baiduwaimai = baiduwaimaiList.get(i);
				// 看是否有饭店
				f = fandiandataMapper.selectFandiandataByPhone(baiduwaimai.getPhone());
				if(null != f){//有，修改
					fandiandata = new Fandiandata();
					fandiandata.setResourceId(f.getResourceId());
					fandiandata.setBaidu(baiduwaimai.getResourceId());
					fandiandata.setBaidusales(Integer.parseInt(baiduwaimai.getSales()));
					fandiandata.setBaiduevaluate(baiduwaimai.getEvaluate());
					fandiandata.setTotalsales(f.getTotalsales()+Integer.parseInt(baiduwaimai.getSales()));
					fandiandata.setGetTime(formatter.parse(dateString));
					//插入
					fandiandataMapper.updateByPrimaryKeySelective(fandiandata);
					j++;
				}else{//没有，增加
					fandiandata = new Fandiandata();
					fandiandata.setResourceId(UtilTools.getSequence(null));
					fandiandata.setTitle(baiduwaimai.getTitle());
					fandiandata.setAddress(baiduwaimai.getAddress());
					fandiandata.setPhone(baiduwaimai.getPhone());
					fandiandata.setBaidu(baiduwaimai.getResourceId());
					fandiandata.setBaiduevaluate(baiduwaimai.getEvaluate());
					fandiandata.setBaidusales(Integer.parseInt(baiduwaimai.getSales()));
					fandiandata.setTotalsales(Integer.parseInt(baiduwaimai.getSales()));
					fandiandata.setGetTime(formatter.parse(dateString));
					//插入
					fandiandataMapper.insertSelective(fandiandata);
					k++;
				}
				//做 插入标记
				b = new Baiduwaimai();
				b.setResourceId(baiduwaimai.getResourceId());
				b.setFlg("1");
				baiduwaimaiMapper.updateByPrimaryKeySelective(b);
			}
			
			System.out.println("百度数据：修改"+j+",新增："+k);
			count += k;
			
			//美团外卖
			List<Meituanwaimai> meituanwaimaiList = new ArrayList<Meituanwaimai>();
			meituanwaimaiList = meituanwaimaiMapper.selectByMerge();
			j = 0;k=0;
			//插入美团数据
			Meituanwaimai meituanwaimai = null;
			Meituanwaimai m = null;
			for (int i = 0; i < meituanwaimaiList.size(); i++) {
				meituanwaimai = meituanwaimaiList.get(i);
				// 看是否有饭店
				f = fandiandataMapper.selectFandiandataByPhone(meituanwaimai.getPhone());
				if(null != f){//有，修改
					fandiandata = new Fandiandata();
					fandiandata.setResourceId(f.getResourceId());
					fandiandata.setMeituan(meituanwaimai.getResourceId());
					fandiandata.setMeituansales(Integer.parseInt(meituanwaimai.getSales()));
					fandiandata.setMeituanevaluate(meituanwaimai.getEvaluate());
					fandiandata.setTotalsales(f.getTotalsales()+Integer.parseInt(meituanwaimai.getSales()));
					fandiandata.setGetTime(formatter.parse(dateString));
					//插入
					fandiandataMapper.updateByPrimaryKeySelective(fandiandata);
					j++;
				}else{//没有，增加
					fandiandata = new Fandiandata();
					fandiandata.setResourceId(UtilTools.getSequence(null));
					fandiandata.setTitle(meituanwaimai.getTitle());
					fandiandata.setAddress(meituanwaimai.getAddress());
					fandiandata.setPhone(meituanwaimai.getPhone());
					fandiandata.setMeituan(meituanwaimai.getResourceId());
					fandiandata.setMeituansales(Integer.parseInt(meituanwaimai.getSales()));
					fandiandata.setMeituanevaluate(meituanwaimai.getEvaluate());
					fandiandata.setTotalsales(Integer.parseInt(meituanwaimai.getSales()));
					fandiandata.setGetTime(formatter.parse(dateString));
					//插入
					fandiandataMapper.insertSelective(fandiandata);
					k++;
				}
				//做 插入标记
				m = new Meituanwaimai();
				m.setResourceId(meituanwaimai.getResourceId());
				m.setFlg("1");
				meituanwaimaiMapper.updateByPrimaryKeySelective(m);
			}
			System.out.println("美团数据：修改"+j+",新增："+k);
			count += k;
			System.out.println("OK");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}



	/**
	 * 合并饭店数据到饭店表
	 */
	@Override
	public void mergeFandian() {
		//日期
		Date currentTime = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		
		String dateString = formatter.format(currentTime);
		
		String eachmonthsales = "";
		try {
			
		
			//遍历fandiandata，flg为0的项
			List<Fandiandata> fandiandataList = fandiandataMapper.selectByMerge();
			Fandian fandian = null;
			Fandiandata fandiandata = null;
	 		for (Fandiandata f : fandiandataList) {
				//插入fandian表中
				fandian = fandianMapper.selectFandianByPhone(f.getPhone());
				//如果没有，插入
				if(null == fandian || "".equals(fandian)){
					fandian = new Fandian();
					fandian.setResourceId(UtilTools.getSequence(null));
					fandian.setTitle(f.getTitle());
					fandian.setAddress(f.getAddress());
					fandian.setPhone(f.getPhone());
					fandian.setMeituanevaluate(f.getMeituanevaluate());
					fandian.setElemeevaluate(f.getElemeevaluate());
					fandian.setBaiduevaluate(f.getBaiduevaluate());
					fandian.setLastmonthsales(String.valueOf(f.getTotalsales()));
					fandian.setTotalsales(String.valueOf(f.getTotalsales()));
					fandian.setBaidu(f.getBaidu());
					fandian.setMeituan(f.getMeituan());
					fandian.setEleme(f.getEleme());
					//是否是新增
					fandian.setNewre("1");
					//销量
					eachmonthsales = "\""+dateString + "\":\""+ String.valueOf(f.getTotalsales())+"\",";
					fandian.setEachmonthsales(eachmonthsales);
					//插入
					fandianMapper.insertSelective(fandian);
				}else{
					//如果有,修改
					fandian.setMeituanevaluate(f.getMeituanevaluate());
					fandian.setElemeevaluate(f.getElemeevaluate());
					fandian.setBaiduevaluate(f.getBaiduevaluate());
					fandian.setLastmonthsales(String.valueOf(f.getTotalsales()));
					fandian.setTotalsales(String.valueOf(
							Integer.parseInt(fandian.getTotalsales())+f.getTotalsales()));
					fandian.setBaidu(f.getBaidu());
					fandian.setMeituan(f.getMeituan());
					fandian.setEleme(f.getEleme());
					//是否是新增
					fandian.setNewre("0");
					//销量
					eachmonthsales = fandian.getEachmonthsales()+"\""+dateString + "\":\""+ String.valueOf(f.getTotalsales())+"\",";
					fandian.setEachmonthsales(eachmonthsales);
					//修改
					fandianMapper.updateByPrimaryKeySelective(fandian);
					
				}
				//修改fandiandata标记
				fandiandata = new Fandiandata();
				fandiandata.setFlg("1");
				fandiandata.setResourceId(f.getResourceId());
				fandiandataMapper.updateByPrimaryKeySelective(fandiandata);
	 		}
	 		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		





	@Override
	public void mergeZuobiao() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mergeCaipin() {
		// 删除菜品数据
		try {
			
			int delResult = caipinMapper.deleteAllCaipin();
			// 导入菜品数据
			List<Fandian> fandianList = fandianMapper.selectAllFandianByCaipin();
			
			String cp = "";
			Baiduwaimai b = null;
			Meituanwaimai m = null;
			Elemewaimai e = null;
			for (Fandian fandian : fandianList) {
				//百度外卖菜品
				if(null != fandian.getBaidu() && !"".equals(fandian.getBaidu())){
					b = baiduwaimaiMapper.selectByPrimaryKey(fandian.getBaidu());
					if(null != b && !"".equals(b)){
						cp = b.getCaipin();
						System.out.println("b:"+cp);
					}
				}
				//美团外卖菜品
				if(null != fandian.getMeituan() && !"".equals(fandian.getMeituan())){
					m = meituanwaimaiMapper.selectByPrimaryKey(fandian.getMeituan());
					if(null != m && !"".equals(m)){
						cp = m.getCaipin();
						System.out.println("m:"+cp);
					}
				}
				//饿了么外卖菜品
				if(null != fandian.getEleme() && !"".equals(fandian.getEleme())){
					e = elemewaimaiMapper.selectByPrimaryKey(fandian.getEleme());
					if(null != e && !"".equals(e)){
						cp = e.getCaipin();
						System.out.println("e:"+cp);
					}
				}
				System.out.println("--------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	/* 
//	 * 根据坐标，半径选址
//	 */
//	public Map<String, Object> getAllList(Map<String, Object> queryConditions) throws Exception {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//
//		StringBuffer buff = new StringBuffer();
//		buff.append("[");
//		//根据位置获取参数信息
//		String weizhizuobiao = (String) queryConditions.get("weizhizuobiao");
//		String banjing = (String) queryConditions.get("banjing");
//		
//		
//		if(null != weizhizuobiao && !"".equals(weizhizuobiao) && null != banjing && !"".equals(banjing)){
//			//获取经纬度
//			String[] zuobiao = weizhizuobiao.split(",");
//			//判断位置和半径
//			double[] arr = DituUtil.getAround(Double.parseDouble(zuobiao[0]),Double.parseDouble(zuobiao[1]),Integer.parseInt(banjing));  
//			queryConditions.put("minLng", arr[0]);
//			queryConditions.put("minLat", arr[1]);
//			queryConditions.put("maxLng", arr[2]);
//			queryConditions.put("maxLat", arr[3]);
//			
//			System.out.println("minLng:"+arr[0]+",minLat:"+arr[1]+",maxLng:"+arr[2]+",maxLat:"+arr[3]);
//			//查询
//			
//			//----------------------------------------
//			Pager pager = (Pager) queryConditions.get("pager");
//			
//			if(null != pager){
//				queryConditions.put("start", pager.getStart());
//				queryConditions.put("numPerPage", pager.getNumPerPage());
//			}
//			List<Fandian> fandianList = fandianMapper.getMapByinput(queryConditions);
//			int count = fandianMapper.getMapByinputCount(queryConditions);
//			
//			if(null != pager){
//				pager.setDataList(fandianList);
//				pager.setTotalCount(count);
//				resultMap.put("pager", pager);
//			}
//			resultMap.put("dataList", fandianList);
//			//----------------------------------------
//			
//			
//			System.out.println(fandianList.size());
//			//构造json [{"title":"阿尔卑斯比萨自助（铁西万达店）","point":"41.780986,123.359275",},{"title":"帕冰素（中街兴隆店）","point":"41.800571,123.45434",}]
//			
//			Fandian fandian = null;
//			for (int i = 0; i < fandianList.size(); i++) {
//			//for (int i = 0; i < 10; i++) {
//				fandian = fandianList.get(i);
//				buff.append("{");
//				buff.append("\"title\":\"").append(fandian.getTitle()).append("\",");
//				buff.append("\"point\":\"").append(fandian.getJing()+","+fandian.getWei()).append("\",");
//				buff.append("\"id\":\"").append(fandian.getId()).append("\",");			
//				buff.append("},");
//			}
//			
//			
//		}else{
//			
//			//----------------------------------------
//			Pager pager = (Pager) queryConditions.get("pager");
//			
//			if(null != pager){
//				queryConditions.put("start", pager.getStart());
//				queryConditions.put("numPerPage", pager.getNumPerPage());
//			}
//			List<Fandian> fandianList = fandianMapper.getMapByinput(queryConditions);
//			int count = fandianMapper.getMapByinputCount(queryConditions);
//			
//			if(null != pager){
//				pager.setDataList(fandianList);
//				pager.setTotalCount(count);
//				resultMap.put("pager", pager);
//			}
//			resultMap.put("dataList", fandianList);
//			//----------------------------------------
//		}
//		buff.append("]");
//		System.out.println(buff.toString());
//		resultMap.put("jsonStr", buff.toString());
//		return resultMap;
//	}





//	/**
//	 * 获取所有信息，分页
//	 */
//	@Override
//	public Map<String, Object> selectAllList(Map<String, Object> queryConditions) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		
//		Pager pager = (Pager) queryConditions.get("pager");
//		
//		if(null != pager){
//			queryConditions.put("start", pager.getStart());
//			queryConditions.put("numPerPage", pager.getNumPerPage());
//		}
//		
//		List<Fandian> fandianList = fandianMapper.selectByPagerList(queryConditions);
//		
//		int count = fandianMapper.selectByPagerCount(queryConditions);
//		
//		if(null != pager){
//			pager.setDataList(fandianList);
//			pager.setTotalCount(count);
//			resultMap.put("pager", pager);
//		}
//		resultMap.put("dataList", fandianList);
//		
//		//查询所有地址
//		StringBuffer buff = new StringBuffer();
//		buff.append("[");
//		List<Fandian> fandianAllList = fandianMapper.selectByNoZuobiao();
//		for (int i = 0; i < fandianAllList.size(); i++) {
//		//for (int i = 0; i < 20; i++) {
//			buff.append("{");
//			buff.append("\"id\":\"").append(fandianAllList.get(i).getId()).append("\",");
//			buff.append("\"address\":\"").append(fandianAllList.get(i).getAddress()).append("\",");
//			buff.append("\"jing\":\"").append(fandianAllList.get(i).getJing()).append("\",");
//			buff.append("\"wei\":\"").append(fandianAllList.get(i).getWei()).append("\"");
//			buff.append("},");
//		}
//		buff.append("]");
//		System.out.println(buff.toString());
//		resultMap.put("addressJson", buff.toString());
//		return resultMap;
//	}
//
//
//	/**
//	 * 插入坐标
//	 */
//	@Override
//	public int insertZB(String map_str) {
//		//id:1|address:沈阳市经济技术开发区六号街17甲1号-5北侧7门|zuobiao:41.756917, 123.262519;id:2|address:沈阳经济技术开发区中央南大街45甲1-17号3门|zuobiao:41.740384, 123.255413;id:3|address:沈阳市沈北新区人和街118号|zuobiao:41.92055, 123.59256;id:4|address:沈阳市皇姑区鸭绿江西街6号|zuobiao:41.836382, 123.452824;id:5|address:沈阳市大东区东顺城街17号一层|zuobiao:41.80379, 123.46482;id:6|address:沈阳市和平区中华路朗勤商道负一层1005|zuobiao:41.792987, 123.3983;id:7|address:沈阳市沈河区北站路112号|zuobiao:41.81864, 123.44083;id:8|address:沈阳市大东区机校街15号|zuobiao:41.82481, 123.46562;id:9|address:沈阳市皇姑区第一大道负一层食尚品味区A007号|zuobiao:41.819981, 123.415906;id:10|address:沈阳市小北一中路1号1层2门|zuobiao:41.81026, 123.381767;id:11|address:沈阳市和平区新华路37号|zuobiao:41.77734, 123.398075;id:12|address:沈阳经济技术开发区沈辽西路116号|zuobiao:41.743011, 123.248756;id:13|address:沈阳经济技术开发区沈辽西路116号1291|zuobiao:41.743011, 123.248756;id:14|address:沈阳市经济技术开发区六号街17甲1号-5北侧7门|zuobiao:41.756917, 123.262519;id:15|address:沈阳市铁西区熊家岗路28号4门|zuobiao:41.81462, 123.32056;id:16|address:沈阳经济技术开发区中央南大街45甲1-17号3门|zuobiao:41.740384, 123.255413;id:17|address:沈阳共达小商品大世界负一层XS051号|zuobiao:41.80316, 123.46479;id:18|address:沈阳市沈北新区人和街118号|zuobiao:41.92055, 123.59256;id:19|address:沈阳经济技术开发区沈辽西路116号1223|zuobiao:41.743011, 123.248756;id:20|address:沈阳经济技术开发区洪湖二街23-17号（2-18/19-1）|zuobiao:41.7745, 123.30474;
//		
//			
//			
//			String[] arr = map_str.split(";");
//			String str = "";
//			String[] arrInfo = {};
//			Fandian f = null;
//			int count = 0;
//		try {
//			for (int i = 0; i < arr.length; i++) {
//				f = new Fandian();
//				//id:1|address:沈阳市经济技术开发区六号街17甲1号-5北侧7门|zuobiao:41.756917, 123.262519
//				str = arr[i];
//				arrInfo = str.split("&");
//				f.setId(Integer.parseInt(arrInfo[0].split(":")[1]));
//				System.out.println(arrInfo[1]);
//				//System.out.println(arrInfo[2].split(":")[1]);
//				f.setJing(arrInfo[2].split(":")[1].split(",")[0]);
//				f.setWei(arrInfo[2].split(":")[1].split(",")[1]);
//				f.setDiqu(arrInfo[3].split(":")[1]);
//				count = fandianMapper.updateByPrimaryKeySelective(f);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return count;
//	}
//	
//	/**
//	 * 获取详细信息
//	 */
//	public Fandian getDetailById(String id) throws Exception{
//		
//		return fandianMapper.selectByPrimaryKey(Integer.parseInt(id));
//	}
//
//
//	/**
//	 * 插入菜品
//	 */
//	public int caipin() throws Exception {
//		List<Fandian> fandianList = new ArrayList<Fandian>();
//		fandianList = fandianMapper.selectByCaipin();
//		String cp = "";
//		JSONArray jsonArray = null;
//		int iSize = 0;
//		int i = 0;
//		int z = 0;
//		float shangxian = 0;
//		float xiaxian = 0;
//		Fandian f = null;
//		float price = 0;
//		int sales = 0;
//		String title = "";
//		Caipin caipin = null;
//		int fdtype = 0; //外卖类型
//		
//		System.out.println("-----------size:"+ fandianList.size());
//		for (Fandian fandian : fandianList) {
//			fdtype = 0;
//			shangxian = 0;
//			xiaxian = 0;
//			//美团
//			if(null != fandian.getMeituancp() && !"".equals(fandian.getMeituancp())){
//				cp = fandian.getMeituancp();
//				fdtype = 1;
//			}
//			//饿了么
//			else if(null != fandian.getElemecp() && !"".equals(fandian.getElemecp())){
//				cp = fandian.getElemecp();
//				fdtype = 2;
//			}
//			//百度
//			else if(null != fandian.getBaiducp() && !"".equals(fandian.getBaiducp())){
//				cp = fandian.getBaiducp();
//				fdtype = 3;
//			}else{
//				continue;
//			}
//			
//			//排除\
//			cp = cp.replace("\\", "\\\\");
//			System.out.println("cp:"+cp);
//			cp = FandianServiceImpl.jsonString(cp);
//			jsonArray = new JSONArray(cp);
//			iSize = jsonArray.length();
//			
//			for (i = 0; i < iSize; i++) {
//				JSONObject jsonObj = jsonArray.getJSONObject(i);
//				System.out.println(String.valueOf(jsonObj.get("cpname")));
//				System.out.println("[" + i + "]cpname=" + FandianServiceImpl.parseTitle(String.valueOf(jsonObj.get("cpname"))));
//				System.out.println("[" + i + "]cpsale=" + FandianServiceImpl.parseSale(String.valueOf(jsonObj.get("cpsale"))));
//				System.out.println("[" + i + "]cpprice=" + jsonObj.get("cpprice"));
//				System.out.println("[" + i + "]cpprice=" + FandianServiceImpl.parsePrice(String.valueOf(jsonObj.get("cpprice"))));
//				//添加菜品
//				caipin = new Caipin();
//				title = FandianServiceImpl.parseTitle(String.valueOf(jsonObj.get("cpname")));
//				caipin.setTitle(title);
//				sales = FandianServiceImpl.parseSale(String.valueOf(jsonObj.get("cpsale")));
//				caipin.setSales(sales);
//				price = FandianServiceImpl.parsePrice(String.valueOf(jsonObj.get("cpprice")));
//				System.out.println("price:"+price);
//				caipin.setPrice(price);
//				if(shangxian < price){
//					shangxian = price;
//				}
//				if(xiaxian > price ){
//					xiaxian = price;
//				}
//				
//				
//				if(fdtype == 1){//美团
//					caipin.setMeituan(fandian.getMeituan());
//					caipin.setFandianevaluate(fandian.getMeituanevaluate());
//					caipin.setFandiansales(fandian.getMeituansales());
//				}else if(fdtype == 2){//饿了么
//					caipin.setEleme(fandian.getEleme());
//					caipin.setFandianevaluate(fandian.getElemeevaluate());
//					caipin.setFandiansales(fandian.getElemesales());
//				}else if(fdtype == 3){//百度外卖
//					caipin.setBaidu(fandian.getBaidu());
//					caipin.setFandianevaluate(fandian.getBaiduevaluate());
//					caipin.setFandiansales(fandian.getBaidusales());
//				}
//				caipin.setFandiantitle(fandian.getTitle());
//				caipin.setFandianid(fandian.getId());
//				System.out.println("title:"+title);
//				caipinMapper.insertSelective(caipin);
//				
//				
//			}
//			//修改价格
//			f = new Fandian();
//			f.setJiageshangxian(shangxian);
//			f.setJiagexiaxian(xiaxian);
//			f.setId(fandian.getId());
//			fandianMapper.updateByPrimaryKeySelective(f);
//			
//			cp = "";
//			jsonArray = null;
//			iSize = 0;
//			i = 0;
//			z++;
//			System.out.println(z);
//		}
//		
//		return 0;
//	}
//	
//	//解析菜品，遇到json里面'"'和'：'的替换
//	private static String jsonString(String s){
//        char[] temp = s.toCharArray();       
//        int n = temp.length;
//        for(int i =0;i<n;i++){
//            if(temp[i]==':'&& temp[i+1]=='"'){
//                    for(int j =i+2;j<n;j++){
//                        if(temp[j]=='"'){
//                            if(temp[j+1]!=',' &&  temp[j+1]!='}'){
//                                temp[j]='\'';
//                            }else if(temp[j+1]==',' ||  temp[j+1]=='}'){
//                                break ;
//                            }
//                        }
//                        if(temp[j]==':'){
//                            if(temp[j+1]!=',' &&  temp[j+1]!='}'){
//                                temp[j] = ';';
//                            }else if(temp[j+1]==',' ||  temp[j+1]=='}'){
//                                break ;
//                            }
//                        }
//                    }   
//            }
//        }       
//        return new String(temp);
//    }
//	//解析价格, 去除; 多个;,去除/, 带单位, 带汉字, 字符为空
//	private static float parsePrice(String s){
//		
//		if(s.contains(";") && s.contains("/")){
//			s = s.substring(s.indexOf(";") + 1, s.indexOf("/"));
//		}
//		if(s.contains("/")){
//			s = s.replaceAll("/", "");
//		}
//		if(s.contains(";")){
//			
//			if(s.split(";").length>2){
//				s = s.split(";")[1].replaceAll(";", "").replaceAll(",", "");
//			}else{
//				s = "0";
//			}
//		}
//		//去,
//		if(s.contains(",")){
//			s = s.replaceAll(",", "");
//		}
//		//去,
//		if(s.contains(".") && s.length() < 2){
//			s = s.replaceAll(".", "");
//		}
//		//去""
//		if(s.contains("\"")){
//			s = s.replaceAll("\"", "");
//		}
//		//去汉字
//		String reg = "[\u4e00-\u9fa5]";
//
//	    Pattern pat = Pattern.compile(reg);  
//
//	    Matcher mat=pat.matcher(s); 
//
//	    s = mat.replaceAll("");
//	    //去空
//	    if(null == s || "".equals(s)){
//	    
//	    	s = "0";
//		}
//	    
//	    return Float.parseFloat(s);
//	}
//	//解析销售量, 去除; 多个;,去除/, 带单位, 带汉字, 字符为空
//	private static int parseSale(String s){
//		
//		if(s.contains(";") && s.contains("/")){
//			s = s.substring(s.indexOf(";") + 1, s.indexOf("/"));
//		}
//		if(s.contains("/")){
//			s = s.replaceAll("/", "");
//		}
//		if(s.contains(";")){
//			
//			if(s.split(";").length>2){
//				s = s.split(";")[1].replaceAll(";", "").replaceAll(",", "");
//			}else{
//				s = "0";
//			}
//		}
//		//去,
//		if(s.contains(",")){
//			s = s.replaceAll(",", "");
//		}
//
//		//去""
//		if(s.contains("\"")){
//			s = s.replaceAll("\"", "");
//		}
//		//去汉字
//		String reg = "[\u4e00-\u9fa5]";
//
//	    Pattern pat = Pattern.compile(reg);  
//
//	    Matcher mat=pat.matcher(s); 
//
//	    String repickStr = mat.replaceAll("");
//	    //去空
//	    if(null == repickStr || "".equals(repickStr)){
//	    
//	    	repickStr = "0";
//		}
//	    
//	    return Integer.parseInt(repickStr);
//	}
//	//解析销售量, 去除; 多个;,去除/, 带单位, 带汉字, 字符为空
//	private static String parseTitle(String s) throws UnsupportedEncodingException{
////		if (s.equals(new String(s.getBytes("GBK"), "GBK"))) {      
////                  
////           return new String(s.getBytes(), "UTF-8");      
////        }else{
////        	
////        	return s;
////        }  
//		return s;   
//	}
//	
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = "15.0";
//		//str = ";15;15";
//		//str = ";10/袋" ;
//		//str = "30起送";
//		//str = ";";
//		System.out.println(FandianServiceImpl.parsePrice(str));
//		String a = "暗黄们";
//		System.out.println(FandianServiceImpl.parseTitle(a));
//	}

	
	
}
