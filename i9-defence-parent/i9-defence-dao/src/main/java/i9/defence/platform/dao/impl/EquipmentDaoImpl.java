package i9.defence.platform.dao.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import i9.defence.platform.dao.EquipmentDao;
import i9.defence.platform.dao.mapper.ChannelDataMapper;
import i9.defence.platform.dao.mapper.EquipmentMapper;
import i9.defence.platform.dao.vo.DealStatusDto;
import i9.defence.platform.dao.vo.EquipmentSearchDto;
import i9.defence.platform.dao.vo.EquipmentStatisticDto;
import i9.defence.platform.dao.vo.HiddenDangerChannelDto;
import i9.defence.platform.dao.vo.HiddenDangerDto;
import i9.defence.platform.dao.vo.HiddenDangerSearchDto;
import i9.defence.platform.dao.vo.MonthData;
import i9.defence.platform.dao.vo.MonthDataDto;
import i9.defence.platform.enums.DataTypeEnum;
import i9.defence.platform.model.ChannelData;
import i9.defence.platform.model.ChannelDataExample;
import i9.defence.platform.model.Equipment;
import i9.defence.platform.model.EquipmentExample;
import i9.defence.platform.model.EquipmentExample.Criteria;
import i9.defence.platform.model.Passageway;
import i9.defence.platform.utils.PageBounds;

/**
 * 设备DaoImpl
 * @author gbq
 * @create 2018年1月8日
 */
@Repository
public class EquipmentDaoImpl implements EquipmentDao{
	
	@Autowired
	private EquipmentMapper equipmentMapper;
	@Autowired
	private ChannelDataMapper channelDataMapper;
	
	@Override
	public PageBounds<Equipment> selectByLimitPage(EquipmentSearchDto equipmentSearchDto, int currectPage, int pageSize)
			throws Exception {
		final int totalSize = equipmentMapper.countByExample(equipmentSearchDto);
        PageBounds<Equipment> pageBounds = new PageBounds<Equipment>(currectPage, totalSize, pageSize);
        List<Equipment> list = equipmentMapper.selectByLimitPage(equipmentSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
	}
	
	@Override
	public PageBounds<Equipment> selectByLimitPage2(EquipmentSearchDto equipmentSearchDto, int currectPage, int pageSize ,int distributorId)
			throws Exception {
		equipmentSearchDto.setDistributorId(distributorId);
		final int totalSize = equipmentMapper.countByExample2(equipmentSearchDto);
        PageBounds<Equipment> pageBounds = new PageBounds<Equipment>(currectPage, totalSize, pageSize);
        List<Equipment> list = equipmentMapper.selectByLimitPage2(equipmentSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
	}
	
	@Override
	public PageBounds<Equipment> selectByLimitPage3(EquipmentSearchDto equipmentSearchDto, int currentPage,
			int pageSize, Integer projectManagerId) {
		equipmentSearchDto.setProjectManagerId(projectManagerId);
		final int totalSize = equipmentMapper.countByExample3(equipmentSearchDto);
        PageBounds<Equipment> pageBounds = new PageBounds<Equipment>(currentPage, totalSize, pageSize);
        List<Equipment> list = equipmentMapper.selectByLimitPage3(equipmentSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
	}
	
	@Override
	public void addEquipment(Equipment equipment) throws Exception {
		equipmentMapper.insertSelective(equipment);
	}

	@Override
	public void updateEquipment(Equipment equipment) throws Exception {
		equipmentMapper.updateByPrimaryKeySelective(equipment);
	}

	@Override
	public Equipment getEquipmentById(int id) throws Exception {
		return equipmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteEquipment(List<Integer> ids) throws Exception {
		equipmentMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public List<Equipment> getEquipmentByIds(List<Integer> ids)
			throws Exception {
		EquipmentExample example = new EquipmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		return equipmentMapper.selectByExample(example);
	}

	@Override
	public List<Passageway> selectPassagewayByEid(String systemId) throws Exception {
		return equipmentMapper.selectPassagewayByEid(systemId);
	}

	@Override
	public void insertPassageWay(Passageway passageway) throws Exception {
		equipmentMapper.insertPassageWay(passageway);
	}

	@Override
	public void updateEquipments(List<Equipment> applies) throws Exception {
		equipmentMapper.updateEquipments(applies);
	}

	@Override
	public PageBounds<HiddenDangerDto> selectHiddenDangerByLimitPage(HiddenDangerSearchDto hiddenDangerSearchDto,
			int currectPage, int pageSize) throws Exception {
		final int totalSize = equipmentMapper.countHiddenDangerByExample(hiddenDangerSearchDto);
        PageBounds<HiddenDangerDto> pageBounds = new PageBounds<HiddenDangerDto>(currectPage, totalSize, pageSize);
        List<HiddenDangerDto> list = equipmentMapper.selectHiddenDangerByLimitPage(hiddenDangerSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
	}

	@Override
	public List<HiddenDangerChannelDto> selectHiddenDangerChannelDtoBySid(String systemId) {
		return equipmentMapper.selectHiddenDangerChannelDtoBySid(systemId);
	}
	
	@Override
	public List<HiddenDangerDto> getAllHiddenDanger(HiddenDangerSearchDto hiddenDangerSearchDto) throws Exception {
		List<HiddenDangerDto> list =equipmentMapper.selectAllHiddenDanger(hiddenDangerSearchDto);
		return list;
	}

	@Override
	public void updateDealStatus(List<DealStatusDto> list,Integer managerId,Date nowDate) throws Exception {
		channelDataMapper.updateDealStatusByIds(list,managerId,nowDate);
	}

	@Override
	public void addEquipments(List<Equipment> equipments) throws Exception {
		equipmentMapper.insertEquipments(equipments);
	}

	@Override
	public void updateEquipmentByIds(List<Equipment> equipments) throws Exception {
		equipmentMapper.updateEquipmentByIds(equipments);
	}

	@Override
	public List<HiddenDangerChannelDto> selectDangerChannelDtoBySid(String systemId) {
		return equipmentMapper.selectDangerChannelDtoBySid(systemId);
	}

	@Override
	public PageBounds<Equipment> selectErrorEquipment(EquipmentSearchDto equipmentSearchDto) {
		final int totalSize = equipmentMapper.countErrorByExample(equipmentSearchDto);
        PageBounds<Equipment> pageBounds = new PageBounds<Equipment>(equipmentSearchDto.getCurrentPage(), totalSize, equipmentSearchDto.getPageSize());
        List<Equipment> list = equipmentMapper.selectErrorEquipment(equipmentSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
		return pageBounds;
	}

	@Override
	public List<ChannelData> selectErrorRecord(EquipmentSearchDto equipmentSearchDto) {
		ChannelDataExample example = new ChannelDataExample();
		example.setOrderByClause("dateTime desc");
		example.createCriteria().andDeviceIdEqualTo(equipmentSearchDto.getDeviceId()).andTypeEqualTo(DataTypeEnum.ERROR.getId()).andDealStatusEqualTo(0);
		return channelDataMapper.selectByExample(example);
	}

	@Override
	public Equipment getEquipmentByIdentifier(String deviceId) {
		EquipmentExample example = new EquipmentExample();
		example.createCriteria().andDeviceIdEqualTo(deviceId);
		List<Equipment> list = equipmentMapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public HiddenDangerDto selectHiddenDangerDtoByDeviceId(String deviceId) {
		return equipmentMapper.selectHiddenDangerDtoByDeviceId(deviceId);
	}

	@Override
	public List<MonthData> selectMonthWarningData(MonthDataDto monthDataDto) {
		return equipmentMapper.selectWarningMonthData(Arrays.asList(monthDataDto.getProjectId()), monthDataDto.getStartTime(), monthDataDto.getEndTime());
	}

	@Override
	public List<MonthData> selectHiddenMonthData(MonthDataDto monthDataDto) {
		return equipmentMapper.selectHiddenMonthData(Arrays.asList(monthDataDto.getProjectId()), monthDataDto.getStartTime(), monthDataDto.getEndTime());
	}

	@Override
	public List<HiddenDangerDto> selectAllHiddenDangerEdit(HiddenDangerSearchDto hiddenDangerSearchDto) {
		return equipmentMapper.selectAllHiddenDangerEdit(hiddenDangerSearchDto);
	}

	@Override
	public List<EquipmentStatisticDto> selectEquipStatistic(Integer ProjectId) throws Exception {
		return equipmentMapper.selectEquipStatistic(ProjectId);
	}

}
