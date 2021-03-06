package i9.defence.platform.dao;

import java.util.List;

import i9.defence.platform.model.Passageway;
import i9.defence.platform.utils.BusinessException;

/**
 * 通道dao
 * @ClassName: PassageWayDao 
 * @Description: TODO
 * @author: luobo
 * @date: 2018年4月2日 下午5:01:32
 */
public interface PassageWayDao {
	
	/**
	 * 根据设备类型id查询通道
	* @Title: selectPassagewaysByEquipId 
	* @Description: TODO
	* @param Id
	* @return
	* @throws Exception
	 */
	List<Passageway> selectPassagewaysBySystemId(String systemId)throws Exception;
	
	
	/**
	 * 新增通道
	* @Title: addPassageway 
	* @Description: TODO
	* @param passageway
	* @throws Exception
	 */
	void addPassageway(List<Passageway> passageways) throws Exception;

	/**
	 * 删除旧的通道对应关系
	 * @param systemId
	 * @throws Exception
	 */
	void delPassagewayBySystemId(String systemId) throws Exception;
	
	/**
	 * 根据类型和通道查询
	 * @param passageway
	 * @return
	 * @throws Exception
	 */
	int selectCountByCatIdAndChannelId(Passageway passageway) throws Exception;

	/**
	 * 删除通道
	 * @param passageway
	 */
	void delPassageway(Passageway passageway) throws Exception;

	/**
	 * 通过设备编号查询设备关注的通道号
	 * @param systemId
	 * @return
	 */
	List<Integer> selectChannelsBySystemId(String systemId);
	
	/**
	 * 根据deviceId查询Channel
	* @Title: selectChannelByDeviceId 
	* @Description: TODO
	* @param deviceId
	* @return
	* @throws BusinessException
	 */
	List<Integer> selectChannelByDeviceId(String deviceId) throws Exception;
}
