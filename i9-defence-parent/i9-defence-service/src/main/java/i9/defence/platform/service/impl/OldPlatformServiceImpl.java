package i9.defence.platform.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import i9.defence.platform.dao.TestDao;
import i9.defence.platform.dao.vo.Demo;
import i9.defence.platform.model.ChannelData;
import i9.defence.platform.service.OldPlatformService;
import i9.defence.platform.utils.BusinessException;
import i9.defence.platform.utils.EncryptUtils;
import i9.defence.platform.utils.TargetDataSource;

/**
 * 创建时间：2018年5月7日 下午1:55:48
 * 
 * @author lby
 * @version
 * 
 */
@Service
@Transactional
public class OldPlatformServiceImpl implements OldPlatformService {

	@Autowired
	private TestDao testDao;

	@TargetDataSource("hjxfweb")
	@Override
	public List<Demo> getListByDs1() {
		return testDao.getList();
	}

	@TargetDataSource("hjxfweb")
	@Override
	public void saveAlertOrigin(String text) throws Exception {
		// 将数据添加到通道数据表中

		JSONObject jsonObject = JSONObject.parseObject(text);
		// 获取通道数据
		List<ChannelData> list = new ArrayList<ChannelData>();
		JSONArray object = (JSONArray) jsonObject.get("dataList");
		for (Object object2 : object) {
			ChannelData channelData = new ChannelData();
			channelData.setSystemId((String) jsonObject.get("systemId"));
			JSONObject jsonObject2 = (JSONObject) object2;
			channelData.setType((int) jsonObject2.get("type"));
			channelData.setChannel((int) jsonObject2.get("channel"));
			channelData.setValue(String.valueOf(jsonObject2.get("value")));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			channelData.setDateTime(
					simpleDateFormat.parse((String) (jsonObject2.get("datetime").toString().replace("#", " "))));
			channelData.setSystemType((String) jsonObject.get("systemType"));
			channelData.setDeviceAddress(jsonObject.getString("deviceAddress"));
			int loop = (int) jsonObject.get("loop");
			channelData.calDeviceId(EncryptUtils.bytesToHexString(EncryptUtils.intToBytes(loop)));
			list.add(channelData);
		}
		try {
			//this.addUpStreamDecode(upStreamDecode);
			//channelDataDao.insertBatch(list);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

}
