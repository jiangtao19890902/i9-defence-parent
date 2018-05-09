package i9.defence.platform.service;

import java.util.List;

import i9.defence.platform.dao.vo.EqCategorySearchDto;
import i9.defence.platform.model.EquipmentCategory;
import i9.defence.platform.utils.BusinessException;
import i9.defence.platform.utils.PageBounds;

/**
 * 项目Service
 * @author gbq
 * @create 
 */
public interface EquipmentCategoryService {
	/**
     * 分页查询
     * @param eqCategorySearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<EquipmentCategory> selectByLimitPage(EqCategorySearchDto eqCategorySearchDto
            ) throws BusinessException;
    
    /**
     * 添加
     * @param eqCategory
     * @throws BusinessException
     */
    void addEqCategory(EquipmentCategory eqCategory) throws BusinessException;
    
    /**
     * 更新
     * @param eqCategory
     * @throws BusinessException
     */
    void updateEqCategory(EquipmentCategory eqCategory) throws BusinessException;
    
    /**
     * 根据ID获取
     * @param id
     * @return
     * @throws BusinessException
     */
    EquipmentCategory getEqCategoryById(int id) throws BusinessException;
    
    /**
     * 删除项目
     * @param id
     * @throws BusinessException
     */
    void deleteEqCategory(List<Integer> ids) throws BusinessException;
    
    /**
     * 查询全部
     * @param 
     * @throws BusinessException
     */
    List<EquipmentCategory> serchEqCategory()throws BusinessException;
    //
	int selectSumEqNum()throws BusinessException;
    
//    /**
//     * 查询数量
//     * @param 
//     * @throws Exception
//     */
//    List<EqCategorySearchDto> selectAllEqCategoryAndNum()throws BusinessException;
//    
}
