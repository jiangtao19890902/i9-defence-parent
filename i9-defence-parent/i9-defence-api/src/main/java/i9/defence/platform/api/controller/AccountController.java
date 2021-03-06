package i9.defence.platform.api.controller;

import i9.defence.platform.dao.vo.ManagerSearchDto;
import i9.defence.platform.model.Manager;
import i9.defence.platform.model.Role;
import i9.defence.platform.service.ManagerService;
import i9.defence.platform.service.RoleService;
import i9.defence.platform.utils.Constants;
import i9.defence.platform.utils.PageBounds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 创建时间：2018年1月11日 下午3:29:17
 * @author  lby
 * @version  
 * 
 */
@RestController
@RequestMapping("account")
public class AccountController {
    
    @Autowired
    private ManagerService managerService;
    
    @Autowired
    private RoleService roleService;
    /**
     * 分页查询账户
     * @param managerSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    @RequiresPermissions("account_list")
    @RequestMapping("/pageAccount")
    public HashMap<String, Object> pageAcount(@RequestBody ManagerSearchDto managerSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (managerSearchDto.getTypes() == null) {
            managerSearchDto.setTypes(Arrays.asList(Constants.S_ACCOUNT));
        }
        Manager manager = managerService.getLoginManager();
        //经销商只能看到他自己的项目管理人员和他的下面的经销商
        if (Arrays.asList(Constants.S_AGENCY).contains(manager.getRole().getName())){
            managerSearchDto.setDistributorId(manager.getId());
        }
        PageBounds<Manager> pageBounds = managerService.selectByLimitPage(managerSearchDto);
        result.put("data",pageBounds);
        return result;
    }
    
    /**
     * 添加账户
     * @param manager
     * @return
     */
    @RequiresPermissions("account_add")
    @RequestMapping("/addAccount")
    public HashMap<String, Object> addAccount(
            @Valid @RequestBody Manager manager, BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.addProjectManager(manager);
        return result;
    }
    
    /**
     * 删除账户
     * @param ids
     * @return
     */
    @RequiresPermissions("account_del")
    @RequestMapping("/delAccount")
    public HashMap<String, Object> delAccount(
            @Valid @NotEmpty(message = "账户IDS不能为空") @RequestBody Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.deleteManager(Arrays.asList(ids));
        return result;
    }
    
    /**
     * 修改账户开启状态Status
     */
    @RequiresPermissions("account_list")
    @RequestMapping("/updateStatus")
    public HashMap<String, Object> updateStatus(@RequestBody Manager manager) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.updateStatus(manager);
        return result;
    }
    
    /**
     * 查询部分用户角色
     */
    @RequestMapping("/selectPartRole")
    public HashMap<String, Object> selectPartRole() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Role> roles = roleService.selectPartRole();
        result.put("data", roles);
        return result;
    }
}
