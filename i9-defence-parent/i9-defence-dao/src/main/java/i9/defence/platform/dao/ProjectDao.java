package i9.defence.platform.dao;

import java.util.List;

import i9.defence.platform.dao.vo.ProjectSearchDto;
import i9.defence.platform.dao.vo.ProjectSelectDto;
import i9.defence.platform.model.Project;
import i9.defence.platform.utils.PageBounds;

/**
 * 项目Dao
 * @author 姜哲
 * @create 2018年1月8日
 */
public interface ProjectDao {

	/**
     * 添加项目
     * @param project
     * @throws Exception
     */
    void addProject(Project project) throws Exception;
    
    /**
     * 更新项目
     * @param project
     * @throws Exception
     */
    void updateProject(Project project) throws Exception;
    
    /**
     * 删除项目
     * @param kid
     * @throws Exception
     */
    void deleteProject(List<Integer> ids) throws Exception;
    
    /**
     * 根据ID获取项目
     * @param id
     * @return
     * @throws Exception
     */
    Project getProjectById(int id) throws Exception;
    
    /**
     * 获取全部的项目
     * @return
     * @throws Exception
     */
    List<Project> findAllProject() throws Exception;
    
    /**
     * 分页查询项目
     * @param projectSearchDto
     * @param currectPage
     * @param pageSize
     * @return
     */
    PageBounds<Project> selectByLimitPage(ProjectSearchDto projectSearchDto,
            int currectPage, int pageSize) throws Exception;
    
    /**
     * 获取全部的项目的主键ID和项目名称
     * @return
     * @throws Exception
     */
    List<ProjectSelectDto> selectAllProjectName(ProjectSearchDto projectSearchDto) throws Exception;
    
    /**
     * 向项目-设备表 增加  设备ID
     * @param kid
     * @throws Exception
     */
    void saveProjectEquipment(Integer projectId,List<Integer> equipmentIds) throws Exception;
    
    /**
     * 获取当前项目下的全部设备ID
     * @return
     * @throws Exception
     */
    List<Integer> selectAllEquipmentIds(Integer projectId) throws Exception;

}
