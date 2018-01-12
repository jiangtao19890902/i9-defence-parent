package i9.defence.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import i9.defence.platform.dao.vo.ClientSearchDto;
import i9.defence.platform.model.Client;
import i9.defence.platform.model.ClientExample;

public interface ClientMapper {
    long countByExample(@Param("example") ClientSearchDto clientSearchDto);

    int deleteByExample(ClientExample example);

    int deleteByPrimaryKey(List<Integer> ids);

    int insert(Client record);

    int insertSelective(Client record);

    List<Client> selectByExample(ClientExample example);

    Client selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Client record, @Param("example") ClientExample example);

    int updateByExample(@Param("record") Client record, @Param("example") ClientExample example);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
    //查询全部负责人 
    List<Client> selectAllClient();
    //分页查询
    List<Client> selectByLimitPage(@Param("example") ClientSearchDto clientSearchDto, @Param("offset") int offset, @Param("limit") int pageSize);
}