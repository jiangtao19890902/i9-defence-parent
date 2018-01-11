package i9.defence.platform.service;

import i9.defence.platform.model.Role;
import i9.defence.platform.model.RoleExample;
import i9.defence.platform.utils.BusinessException;
import i9.defence.platform.utils.PageBounds;

import java.util.List;

/** 
 * 创建时间：2018年1月4日 上午9:47:35
 * @author  lby
 * @version  
 * 
 */
public interface RoleService {
    /**
     * 添加角色
     * @param Role
     * @throws BusinessException
     */
    void addRole(Role role) throws BusinessException;
    
    /**
     * 更新角色
     * @param Role
     * @throws BusinessException
     */
    void updateRole(Role role) throws BusinessException;
    
    /**
     * 删除角色
     * @param kid
     * @throws BusinessException
     */
    void deleteRole(List<Integer> ids) throws BusinessException;
    
    /**
     * 根据ID获取角色
     * @param kid
     * @return
     * @throws BusinessException
     */
    Role getRoleById(int id) throws BusinessException;
    
    /**
     * 获取全部的角色
     * @return
     * @throws BusinessException
     */
    List<Role> findAllRole() throws BusinessException;
    
    /**
     * 分页查询角色
     * @param RoleSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     * @throws BusinessException
     */
    PageBounds<Role> selectByLimitPage(RoleExample roleExample,
            int currectPage, int pageSize) throws BusinessException;
}
