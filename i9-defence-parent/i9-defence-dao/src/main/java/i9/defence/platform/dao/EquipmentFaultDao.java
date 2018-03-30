package i9.defence.platform.dao;

import java.util.List;

import i9.defence.platform.dao.vo.EquipmentFaultSearchDto;
import i9.defence.platform.model.EquipmentFault;
import i9.defence.platform.utils.PageBounds;

/**
 * @author user: jiace
 * @version creatTime：2018年3月29日 上午11:20:28 设备故障dao
 */
public interface EquipmentFaultDao {
	/*
	 * 分页查询
	 */
	PageBounds<EquipmentFault> selectByLimitPage(EquipmentFaultSearchDto equipmentFaultSearchDto, int currectPage,
			int pageSize) throws Exception;

	/*
	 * 添加
	 */
	void add(EquipmentFault equipmentFault) throws Exception;

	/*
	 * 更新
	 */
	void update(EquipmentFault equipmentFault) throws Exception;

	/*
	 * 批量删除
	 */
	void deleteBatch(List<Integer> ids) throws Exception;

	/*
	 * 根据id查询
	 */
	EquipmentFault getById(Integer id) throws Exception;
	
	/**
	 * 查询所有故障
	 * @return
	 * @throws Exception
	 */
	List<EquipmentFault> selectAllFaults() throws Exception;
}
