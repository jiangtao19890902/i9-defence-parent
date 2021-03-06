package i9.defence.platform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import i9.defence.platform.dao.vo.DealStatusDto;
import i9.defence.platform.dao.vo.EquipmentNewestDto;
import i9.defence.platform.dao.vo.EquipmentProjectDto;
import i9.defence.platform.dao.vo.EquipmentSearchDto;
import i9.defence.platform.dao.vo.HiddenDangerChannelDto;
import i9.defence.platform.dao.vo.HiddenDangerDto;
import i9.defence.platform.dao.vo.HiddenDangerSearchDto;
import i9.defence.platform.dao.vo.MonthData;
import i9.defence.platform.dao.vo.MonthDataDto;
import i9.defence.platform.dao.vo.TotalEquipmentDto;
import i9.defence.platform.model.ChannelData;
import i9.defence.platform.model.Equipment;
import i9.defence.platform.model.Passageway;
import i9.defence.platform.utils.BusinessException;
import i9.defence.platform.utils.PageBounds;

/**
 * 设备Service
 * @author gbq
 * @create 2018年1月9日
 */
public interface EquipmentService {
	  /**
     * 分页查询设备
     * @param equipmentSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Equipment> selectByLimitPage(EquipmentSearchDto equipmentSearchDto) throws BusinessException;
    
    /**
     * 添加设备
     * @param equipment
     * @throws Exception
     */
    Equipment addEquipment(Equipment equipment) throws BusinessException;
    
    /**
     * 向老平台插入设备
     * @param equipment
     * @throws Exception
     */
    void addEquipmentToOldPlat(Equipment equipment) throws BusinessException;
    
    /**
     * 更新设备
     * @param equipment
     * @throws Exception
     */
    void updateEquipment(Equipment equipment) throws BusinessException;
    
    /**
     * 根据ID获取设备
     * @param id
     * @return
     * @throws Exception
     */
    Equipment getEquipmentById(int id) throws BusinessException;
    
    /**
     * 删除设备
     * @param id
     * @throws Exception
     */
    void deleteEquipment(List<Integer> ids) throws BusinessException;
    
    /**
     * 申请删除设备集合
    * @Title: applyEquipment 
    * @Description: TODO
    * @param ids
    * @throws BusinessException
     */
    public String  applyDelEquipment(List<Integer> ids) throws BusinessException;
    
    /**
     * 根据设备Id查找通道
     * @return
     * @throws BusinessException
     */
    List<Passageway> selectPassagewayByEid(String systemId)throws BusinessException;
    /**
     * 分页查询隐患报警
     * @param equipmentSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<HiddenDangerDto> selectHiddenDangerByLimitPage(HiddenDangerSearchDto hiddenDangerSearchDto) throws BusinessException;
    
    /**
     * 分页查询隐患报警
     * @param equipmentSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<HiddenDangerDto> selectHiddenDangerByLimitPage2(HiddenDangerSearchDto hiddenDangerSearchDto) throws BusinessException;
    
    /**
     * 分页查询隐患报警
     * @param equipmentSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<HiddenDangerDto> selectHiddenDangerByLimitPage3(HiddenDangerSearchDto hiddenDangerSearchDto) throws BusinessException;
    
    /**
     * 新增通道
     * @param passageway
     * @throws BusinessException
     */
    void insertPassageWay(Passageway passageway) throws BusinessException;
    /**
     * 查询具体隐患报警--隐患
     * @param selectHiddenDangerChannelDtoBySid
     * @return
     */
    List<HiddenDangerChannelDto> selectHiddenDangerChannelDtoBySid(String deviceId,int count)throws BusinessException;
    /**
     * 查询全部隐患报警
     */
    /*List<HiddenDangerDto> getAllHiddenDanger(HiddenDangerSearchDto hiddenDangerSearchDto)throws BusinessException;*/
    /**
     * 
     * 修改隐患报警
     * @param DealStatusDto
     * @return
     */
    void updateDealStatus(List<DealStatusDto> list,Integer managerId,Date nowDate) throws BusinessException;
    /**
     * 查询具体隐患报警--隐患
     * @param selectHiddenDangerChannelDtoBySid
     * @return
     */
    List<HiddenDangerChannelDto> selectDangerChannelDtoBySid(String deviceId,int count)throws BusinessException;
    
    /**
     * 分页查询故障设备
     * @param equipmentSearchDto
     * @return
     */
	PageBounds<Equipment> selectErrorEquipment(EquipmentSearchDto equipmentSearchDto) throws BusinessException;
	
	/**
	 * 查询故障记录
	 * @param equipmentSearchDto
	 * @return
	 * @throws BusinessException
	 */
	List<ChannelData> selectErrorRecord(EquipmentSearchDto equipmentSearchDto) throws BusinessException;
	
	/**
	 * 通过唯一编号找设备
	 * @param deviceId
	 * @return
	 */
	Equipment getEquipmentByIdentifier(String deviceId) throws BusinessException;
	
	/**
	 * 查询报警隐患数量
	 * @param deviceId
	 * @return
	 * @throws BusinessException
	 */
	HiddenDangerDto selectHiddenDangerDtoByDeviceId(String deviceId) throws BusinessException;
	
	/**
	 * 月统计报警
	 * @param monthDataDto
	 * @return
	 * @throws BusinessException
	 */
	List<MonthData> selectMonthWarningData(MonthDataDto monthDataDto) throws BusinessException;
	
	/**
	 * 月统计
	 * @param monthDataDto
	 * @return
	 * @throws BusinessException
	 */
	List<MonthData> selectHiddenMonthData(MonthDataDto monthDataDto) throws BusinessException;
	
	/**
	 * 查询全部
	 * @param hiddenDangerSearchDto
	 * @return
	 */
	List<HiddenDangerDto> selectAllHiddenDangerEdit(HiddenDangerSearchDto hiddenDangerSearchDto)throws BusinessException;
	//查询设备创建时间和负责人，安全负责人手机号
	EquipmentProjectDto selectDataAndManager(int id)throws BusinessException;
	
	/**
	 * 查询设备总数
	 * @param monthDataDto
	 * @return
	 * @throws BusinessException
	 */
	TotalEquipmentDto selectTotalEquipmentDto(MonthDataDto monthDataDto) throws BusinessException;

	/**
	 * 根据ids查询视图数据
	* @Title: selectHiddenDangerByIds 
	* @Description: TODO
	* @param ids
	* @return
	 */
	List<HiddenDangerDto> selectHiddenDangerByIds(List<Integer> ids)throws BusinessException;
	
	/**
	 * 更新所有设备的status
	* @Title: updateAllEquipmentStatus 
	* @Description: TODO
	* @throws BusinessException
	 */
    void updateAllEquipmentStatus()throws BusinessException;
    
    /**
     * 更新设备最新事件事件
    * @Title: updateEquipmentNewestTime 
    * @Description: TODO
    * @param eqDeviceId
    * @param dateTime
     */
    void updateEquipmentNewestTime(String eqDeviceId, String dateTime);
    
    /**
     * 查询所有的最新事件时间
    * @Title: selectAllEquipmentNewest 
    * @Description: TODO
    * @return
     */
    List<EquipmentNewestDto> selectAllEquipmentNewest();
    
    /**
     * 更新设备状态
    * @Title: updateSomeStatusByDevicedIds 
    * @Description: TODO
    * @param eqDeviceIdList
    * @throws BusinessException
     */
    void updateSomeStatusByDevicedIds(ArrayList<String> eqDeviceIdList) throws BusinessException;
    /**
     * Excel导出
     * @return
     */
    XSSFWorkbook downLoadExportToExcel(HiddenDangerSearchDto hiddenDangerSearchDto);
    /**
     * 故障数据
     * @param monthDataDto
     * @return
     */
    List<MonthData> selectCodeMonthData(MonthDataDto monthDataDto);

    List<String> selectCodename();

    List<MonthData> selectConnectLogMonthData(MonthDataDto monthDataDto)throws BusinessException;
}
