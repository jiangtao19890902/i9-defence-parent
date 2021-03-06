package i9.defence.platform.service;

import java.util.List;

import i9.defence.platform.model.HiddenDanger;
import i9.defence.platform.model.HiddenDangerExample;
import i9.defence.platform.utils.BusinessException;
import i9.defence.platform.utils.PageBounds;

/**
 * 隐患提醒类型Service
 * 
 * @ClassName: HiddenDangerService
 * @Description: TODO
 * @author: luobo
 * @date: 2018年4月2日 下午3:37:36
 */
public interface HiddenDangerService {

	/**
	 * 分页查询
	 * 
	 * @Title: selectByLimitPage
	 * @Description: TODO
	 * @param hiddenDangerExample
	 * @param currectPage
	 * @param pageSize
	 * @return
	 * @throws BusinessException
	 */
	 PageBounds<HiddenDanger> selectByLimitPage(HiddenDangerExample hiddenDangerExample,int currectPage,int pageSize,Integer equipCategoryId) throws BusinessException;

	/**
	 * 新增隐患提醒类型
	 * 
	 * @Title: insertHiddenDanger
	 * @Description: TODO
	 * @param hiddenDanger
	 * @throws Exception
	 */
	void insertHiddenDanger(HiddenDanger hiddenDanger) throws BusinessException;

	/**
	 * 更改隐患提醒
	 * 
	 * @Title: updateHiddenDanger
	 * @Description: TODO
	 * @param hiddenDanger
	 * @throws Exception
	 */
	void updateHiddenDanger(HiddenDanger hiddenDanger) throws BusinessException;

	/**
	 * 根据id获取隐患
	 * 
	 * @Title: getHiddenById
	 * @Description: TODO
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	HiddenDanger getHiddenById(Integer Id) throws BusinessException;

	/**
	 * 批量删除隐患
	 * 
	 * @Title: delHiddenDangers
	 * @Description: TODO
	 * @param ids
	 * @throws Exception
	 */
	void delHiddenDangers(List<Integer> ids) throws BusinessException;
	
	/**
	 * 查询全部隐患类型
	 * @return
	 * @throws BusinessException
	 */
	List<HiddenDanger> selectAllHiddendanger() throws BusinessException;
	
	/**
	 * 查询未处理的故障设备ids
	 * @return
	 * @throws BusinessException
	 */
	List<String> selectErrorEquipmentIds() throws BusinessException;

}
