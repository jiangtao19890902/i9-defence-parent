package i9.defence.platform.datapush.controller;

import i9.defence.platform.datapush.config.DeviceGroupAttributeNameCache;
import i9.defence.platform.datapush.entity.DeviceAttribute;
import i9.defence.platform.datapush.entity.DeviceInfo;
import i9.defence.platform.datapush.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * 数据显示view控制器
 * 
 * @author R12
 * @date 2018年10月22日 14:11:51
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceGroupAttributeNameCache deviceGroupAttributeNameCache;

    /**
     * 显示设备列表
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = { "/index.shtml", "/" })
    public String index(Model model) {
        List<DeviceInfo> deviceInfos = this.deviceService.getDeviceInfoList();
        model.addAttribute("deviceInfos", deviceInfos);
        return "index";
    }

    @RequestMapping(value = { "/deviceList.shtml" })
    public String deviceList(Model model) {
        List<DeviceInfo> deviceInfos = this.deviceService.getDeviceInfoList();
        model.addAttribute("deviceInfos", deviceInfos);
        return "deviceList";
    }

    /**
     * 显示设备详情
     * 
     * @param deviceId
     * @param model
     * @return
     */
    @RequestMapping(value = { "/details-{deviceId}.shtml" })
    public String details(@PathVariable("deviceId") String deviceId, Model model) {
        DeviceInfo deviceInfo = this.deviceService.getDeviceInfoById(deviceId);
        model.addAttribute("deviceInfo", deviceInfo);

        HashMap<String, DeviceAttribute> deviceAttributeValueResult = this.deviceService
                .getDeviceAttributeValueResult(deviceInfo.getDeviceId());

        LinkedHashMap<String, DeviceAttribute> values = new LinkedHashMap<String, DeviceAttribute>();
        LinkedHashMap<String, String> attributeNames = deviceGroupAttributeNameCache.getDeviceGroupAttributeResult("1");
        for (Entry<String, String> entry : attributeNames.entrySet()) {
            DeviceAttribute deviceAttribute = deviceAttributeValueResult.get(entry.getKey());
            values.put(entry.getValue(), deviceAttribute);
        }
        model.addAttribute("values", values);
        return "details";
    }
}