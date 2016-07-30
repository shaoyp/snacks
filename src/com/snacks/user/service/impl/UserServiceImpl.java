package com.snacks.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snacks.user.dao.UserMapper;
import com.snacks.user.model.User;
import com.snacks.user.service.UserService;
import com.snacks.utils.Pager;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public User login(User user){
		User u = userMapper.selectByUsername(user.getUsername());
		if(null != u){
			if(user.getPassword().equals(u.getPassword())){
				return u;
			}
		}
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see com.king.menu.service.impl.MenuService#getAllList(java.util.Map)
	 */
	public Map<String, Object> getAllList(Map<String, Object> queryConditions) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Pager pager = (Pager) queryConditions.get("pager");
		
		if(null != pager){
			queryConditions.put("start", pager.getStart());
			queryConditions.put("numPerPage", pager.getNumPerPage());
		}
		
		List<User> menuList = userMapper.selectByPagerList(queryConditions);
		
		int count = userMapper.selectByPagerCount(queryConditions);
		
		if(null != pager){
			pager.setDataList(menuList);
			pager.setTotalCount(count);
			resultMap.put("pager", pager);
		}
		resultMap.put("dataList", menuList);
		
		return resultMap;
	}
	
	/* (non-Javadoc)
	 * @see com.king.menu.service.impl.MenuService#add(com.king.menu.model.Menu)
	 */
	public int add(User user) throws Exception{

		return userMapper.insertSelective(user);
	}

	/* (non-Javadoc)
	 * @see com.king.menu.service.impl.MenuService#delete(java.lang.String)
	 */
	public int delete(String ids) throws Exception{
		String[] idAry = ids.split(",");
		int result = 0;
		for(String id : idAry){
			result = userMapper.deleteByPrimaryKey(id.trim());
			if(result == 0){
				return 0;
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.king.menu.service.impl.MenuService#getRuleById(java.lang.String)
	 */
	public User getDetailById(String id) throws Exception{
		
		return userMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.king.menu.service.impl.MenuService#update(com.king.menu.model.Menu)
	 */
	public int update(User user) throws Exception{
		
		return userMapper.updateByPrimaryKeySelective(user);
	}
}
