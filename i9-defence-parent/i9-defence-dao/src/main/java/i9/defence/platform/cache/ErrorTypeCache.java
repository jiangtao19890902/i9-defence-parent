package i9.defence.platform.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import i9.defence.platform.dao.EquipmentFaultDao;
import i9.defence.platform.model.EquipmentFault;

/** 
* 创建时间：2018年4月14日 上午2:40:30
* @author  lby
* @version  
* 
*/
@Component
public class ErrorTypeCache {
	@Autowired
	private EquipmentFaultDao equipmentFaultDao;
	
	/**
     *  id和name
     *  
     */
    public static Map<String,String> dictMap = new HashMap<String,String>();
    //public static List<string> codetypeList = new ArrayList<string>();
    
    public void init() {
    	 List<EquipmentFault> list = equipmentFaultDao.getAllTypes();
         //清空缓存数据
         ErrorTypeCache.dictMap.clear();
  
         for (EquipmentFault equipmentFault : list) {
         	dictMap.put(equipmentFault.getCode(), equipmentFault.getName());
         }
         System.out.println("字典数据大小：  "+dictMap.size());
    }
    
    public static String getCacheDict(String code){
    	for (Map.Entry<String,String> entry : dictMap.entrySet()) {
			if(code.equals(entry.getKey())){
				return entry.getValue();
			}
		}
    	return "未知故障";
    }
}