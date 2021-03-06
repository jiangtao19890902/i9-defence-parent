package i9.defence.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import i9.defence.platform.dao.vo.ApplyDto;
import i9.defence.platform.model.Apply;
import i9.defence.platform.model.ApplyExample;
import i9.defence.platform.utils.BusinessException;
import i9.defence.platform.utils.PageBounds;

/**
 * 删除项目、设备申请表Dao
 * @ClassName: ApplyDao 
 * @Description: TODO
 * @author: luobo
 * @date: 2018年1月25日 上午9:52:15
 */ 
public interface ApplyDao {
	
	/**
	 * 分页查询申请表
	* @Title: selectByLimitPage 
	* @Description: TODO
	* @param applyExample
	* @param currectPage
	* @param pageSize
	* @return
	* @throws Exception
	 */
	PageBounds<Apply>  selectByLimitPage(ApplyExample applyExample, int currectPage, int pageSize) throws Exception;
	
	
	/**
	 * 分页查询申请表（外带处理人的父Id）
	* @Title: selectByLimitPage 
	* @Description: TODO
	* @param applyExample
	* @param currectPage
	* @param pageSize
	* @return
	* @throws Exception
	 */
	PageBounds<Apply>  selectByLimitPage2(ApplyDto applyDto, int currectPage, int pageSize) throws Exception;
	
	/**
	 * 删除申请
	* @Title: delApply 
	* @Description: TODO
	* @param ids
	* @throws BusinessException
	 */
	void delApply(List<Integer> ids) throws Exception;
	
	/**
	 * 批量插入设备申请删除记录
	* @Title: insertApplys 
	* @Description: TODO
	* @param applies
	* @throws Exception
	 */ 
	void insertEquipmentApplys(List<Apply> applies) throws Exception;
	
	/**
	 * 批量插入项目申请删除记录
	* @Title: insertProjectApplys 
	* @Description: TODO
	* @param applies
	* @throws Exception
	 */
	void insertProjectApplys(List<Apply> applies) throws Exception;
	
	/**
	 * 根据id查询Apply
	* @Title: getApplyById 
	* @Description: TODO
	* @param id
	* @return
	* @throws Exception
	 */
	Apply getApplyById(int id)throws Exception;
	
	/**
	 * 批量更新
	* @Title: updateApplys 
	* @Description: TODO
	* @param applies
	* @throws Exception
	 */
	void updateApplys(List<Apply> applies) throws Exception;
	
	/**
	 * 查询部分状态申请列表
	* @Title: selectPartState 
	* @Description: TODO
	* @return
	* @throws BusinessException
	 */
	List<Apply> selectPartState(Integer state) throws Exception;
	
	/**
	 * 查询是否已经提交过申请
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int  selectProjectCount(@Param("ids") List<Integer> ids) throws Exception;
	/**
	 * 查询是否已经提交过申请
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int  selectEquipmentCount(@Param("ids") List<Integer> ids) throws Exception;
	
	/**
	 * 
	* @Title: selectApplyByids 
	* @Description: TODO
	* @param ids
	* @return
	* @throws Exception
	 */
	List<Apply>  selectApplyByids(List<Integer> ids) throws Exception;
}
