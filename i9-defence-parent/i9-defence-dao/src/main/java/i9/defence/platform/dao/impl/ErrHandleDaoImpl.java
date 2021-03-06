package i9.defence.platform.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import i9.defence.platform.dao.ErrHandleDao;
import i9.defence.platform.dao.mapper.ErrHandleMapper;
import i9.defence.platform.dao.vo.ErrHandleSearchDto;
import i9.defence.platform.dao.vo.ErrHandleToExcel;
import i9.defence.platform.model.ErrHandle;
import i9.defence.platform.model.ErrHandleExample;
import i9.defence.platform.model.ErrHandleExample.Criteria;
import i9.defence.platform.utils.PageBounds;

@Repository
public class ErrHandleDaoImpl implements ErrHandleDao{
	
	@Autowired
	private ErrHandleMapper errHandleMapper;

	@Override
	public void addErrHandle(ErrHandle errHandle) throws Exception {
		errHandleMapper.insertSelective(errHandle);
	}

	@Override
	public void updateErrHandle(ErrHandle errHandle) throws Exception {
		errHandleMapper.updateByPrimaryKeySelective(errHandle);
	}

	@Override
	public void deleteErrHandle(List<Integer> ids) throws Exception {
		ErrHandleExample example = new ErrHandleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		errHandleMapper.deleteByExample(example);
	}

	@Override
	public ErrHandle getErrHandleById(int id) throws Exception {
		return errHandleMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageBounds<ErrHandle> selectByLimitPage(ErrHandleSearchDto errHandleSearchDto) throws Exception {
		final int totalSize = (int)errHandleMapper.countByExample(errHandleSearchDto);
        PageBounds<ErrHandle> pageBounds = new PageBounds<ErrHandle>(errHandleSearchDto.getCurrentPage(), totalSize, errHandleSearchDto.getPageSize());
        List<ErrHandle> list = errHandleMapper.selectByLimitPage(errHandleSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
	}

	@Override
	public void updateHandleFault(List<String> eqDeviceIds) throws Exception {
		errHandleMapper.updateHandleFault(eqDeviceIds);	
	}
	
	@Override
	public void updateHandleHidden(List<String> eqDeviceIds) throws Exception {
		errHandleMapper.updateHandleHidden(eqDeviceIds);	
	}
	

	@Override
	public void updateBatchHandleFault(List<String> list) {
		errHandleMapper.updateBatchHandleFault(list);
	}

	@Override
	public void updateBatchHandlePolice(List<String> list) {
		errHandleMapper.updateBatchHandlePolice(list);
	}

	@Override
	public void updateBatchHandleHidden(List<String> list) {
		errHandleMapper.updateBatchHandleHidden(list);
	}

	@Override
	public void addBatchHandle(List<String> list) {
		errHandleMapper.addBatchHandle(list);
	}

	@Override
	public void addErrHandle(List<ErrHandle> errHandles) throws Exception {
		errHandleMapper.addErrHandles(errHandles);
	}

	@Override
	public void updateErrHandles(List<ErrHandle> errHandles) throws Exception {
		errHandleMapper.updateErrHandles(errHandles);
	}

    @Override
    public List<ErrHandleToExcel> selectErrHandleToExcel() throws Exception {
        return errHandleMapper.selectErrHandleToExcel();
    } 
	

}
