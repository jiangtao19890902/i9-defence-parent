package i9.defence.platform.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import i9.defence.platform.dao.EquipmentCategoryDao;
import i9.defence.platform.dao.PassageWayDao;
import i9.defence.platform.dao.vo.PassagewayDto;
import i9.defence.platform.model.EquipmentCategory;
import i9.defence.platform.model.Passageway;
import i9.defence.platform.service.PassagewayService;
import i9.defence.platform.utils.BusinessException;

@Service
@Transactional
public class PassagewayServiceImpl implements PassagewayService {

	@Autowired
	private PassageWayDao passageWayDao;
	@Autowired
	private EquipmentCategoryDao equipmentCategoryDao;
	@Override
	public List<Passageway> selectPassagewaysBySystemId(String systemId) throws BusinessException {
		try {
			return passageWayDao.selectPassagewaysBySystemId(systemId);
		} catch (Exception e) {
			throw new BusinessException("根据设备id查询通道失败", e.getMessage());
		}
	}

	@Override
	public void addPassageway(PassagewayDto passagewayDto) throws BusinessException {
		try {
			EquipmentCategory equipmentCategory = equipmentCategoryDao.getEqCategoryById(passagewayDto.getCategoryId());
			passageWayDao.delPassagewayBySystemId(equipmentCategory.getEqCategoryId());
			List<Passageway> passageways = Arrays.asList(passagewayDto.getPassageways());
			for (Passageway passageway : passageways) {
				passageway.setSystemId(equipmentCategory.getEqCategoryId());
			}
			passageWayDao.addPassageway(passageways);
		} catch (BusinessException e) {
			throw new BusinessException(e.getErrorMessage(), e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("新增通道失败", e.getMessage());
		}
	}

	@Override
	public void delPassageway(Passageway passageway) throws BusinessException {
		try {
			passageWayDao.delPassageway(passageway);
		} catch (Exception e) {
			throw new BusinessException("删除通道失败", e.getMessage());
		}
	}

	@Override
	public List<Integer> selectChannelByDeviceId(String deviceId) throws BusinessException {
		try {
			return passageWayDao.selectChannelByDeviceId(deviceId);
		} catch (Exception e) {
			throw new BusinessException("根据设备deviceId查询Channel失败", e.getMessage());
		}
	}

	/*
	 * @Override public void addPassageway(PassagewayDto passagewayDto) throws
	 * BusinessException { try { Equipment equipment =
	 * equipmentDao.getEquipmentById(passagewayDto.getEquipmentId());
	 * //删除旧的通道对应关系
	 * passageWayDao.delPassagewayBySystemId(equipment.getDeviceId());
	 * List<Passageway> passageways =
	 * Arrays.asList(passagewayDto.getPassageways()); for (Passageway passageway
	 * : passageways) { passageway.setDeviceId(equipment.getDeviceId()); }
	 * passageWayDao.addPassageway(passageways);
	 * 
	 * } catch (Exception e) { throw new
	 * BusinessException("根据设备id查询通道失败",e.getMessage()); } }
	 */

}
