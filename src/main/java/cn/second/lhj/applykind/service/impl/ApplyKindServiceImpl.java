package cn.second.lhj.applykind.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.second.lhj.applykind.mapper.ApplyKindMapperExtends;
import cn.second.lhj.applykind.po.ApplyKind;
import cn.second.lhj.applykind.po.ApplyKindExample;
import cn.second.lhj.applykind.service.ApplyKindService;

@Service
public class ApplyKindServiceImpl implements ApplyKindService {

	@Autowired
	private ApplyKindMapperExtends kindMapper;

	/*-----------------------------------------查询---------------------------------------------*/
	@Override
	public List<ApplyKind> getApplyKindAll() throws Exception {
		// TODO 查询所有分类
		return kindMapper.selectByExample(null);
	}

	@Override
	public List<ApplyKind> getApplyKindAllLimit(Integer page, Integer count) throws Exception {
		// TODO 查询所有分类（分页）
		PageHelper.startPage(page,count);
		return kindMapper.selectByExample(null);
	}

	@Override
	public ApplyKind getApplyKindById(Integer id) throws Exception {
		// TODO 根据ID查询分类
		return kindMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ApplyKind> getApplyKindByName(String name) throws Exception {
		// TODO 根据分类名称查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andKindNameEqualTo(name);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByNameLike(String keyWord) throws Exception {
		// TODO 根据分类名称查询分类（模糊）
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andKindNameLike("%"+keyWord+"%");
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByPid(Integer pId) throws Exception {
		// TODO 根据上级分类ID查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(pId);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByPidLimit(Integer pId,Integer page, Integer count) throws Exception {
		// 根据上级分类ID查询分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(pId);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByStatus(Integer status) throws Exception{
		// TODO 根据启用状态查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(status);
		return kindMapper.selectByExample(example);
	}
	
	@Override
	public List<ApplyKind> getApplyKindByStatusLimit(Integer status,Integer page,Integer count) throws Exception{
		// TODO 根据启用状态查询分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(status);
		return kindMapper.selectByExample(example);
	}
	
	@Override
	public List<ApplyKind> getApplyKindStatusOn() throws Exception{
		// TODO 查询已启用分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(1);
		return kindMapper.selectByExample(example);
	}
	
	@Override
	public List<ApplyKind> getApplyKindStatusOnLimit(Integer page,Integer count) throws Exception{
		// TODO 查询已启用分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(1);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindStatusOff() throws Exception{
		// TODO 查询未启用分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(0);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindStatusOffLimit(Integer page,Integer count) throws Exception{
		// TODO 查询未启用分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(0);
		return kindMapper.selectByExample(example);
	}
	
	@Override
	public List<ApplyKind> getApplyKindByIntegral(Double integral) throws Exception {
		// TODO 根据分类积分查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andKindIntegralEqualTo(integral);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByIntegralLimit(Double integral, Integer page, Integer count) throws Exception {
		// TODO 根据分类积分查询分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andKindIntegralEqualTo(integral);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByDocStatus(Integer docStatus) throws Exception {
		// TODO 根据是否需要佐证材料查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andNeedSuppDocEqualTo(docStatus);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByDocStatusLimit(Integer docStatus, Integer page, Integer count) throws Exception {
		// TODO 根据是否需要佐证材料查询分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andNeedSuppDocEqualTo(docStatus);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByFileStatus(Integer fileStatus) throws Exception {
		// TODO 根据是否需要文件查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andNeedSuppFileEqualTo(fileStatus);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByFileStatusLimit(Integer fileStatus, Integer page, Integer count) throws Exception {
		// TODO 根据是否需要文件查询分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andNeedSuppFileEqualTo(fileStatus);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByCheckStatus(Integer checkStatus) throws Exception {
		// TODO 根据是否需要审核查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andNeedCheckEqualTo(checkStatus);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByCheckStatusLimit(Integer checkStatus, Integer page, Integer count)throws Exception {
		// TODO 根据是否需要审核查询分类（分页）
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andNeedCheckEqualTo(checkStatus);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByCheckKind(Integer checkKind) throws Exception {
		// TODO 根据审核方式查询分类
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andCheckKindEqualTo(checkKind);
		return kindMapper.selectByExample(example);
	}

	@Override
	public List<ApplyKind> getApplyKindByCheckKindLimit(Integer checkKind, Integer page, Integer count)
			throws Exception {
		// TODO 根据审核方式查询分类（分页
		PageHelper.startPage(page,count);
		ApplyKindExample example=new ApplyKindExample();
		ApplyKindExample.Criteria criteria=example.createCriteria();
		criteria.andCheckKindEqualTo(checkKind);
		return kindMapper.selectByExample(example);
	}
	/*-----------------------------------------查询---------------------------------------------*/

	
	/*-----------------------------------------添加---------------------------------------------*/
	@Override
	public int insertApplyKindOne(ApplyKind applyKind) throws Exception {
		// TODO 添加单个分类
		try {
			kindMapper.insertSelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/*-----------------------------------------添加---------------------------------------------*/	

	
	
	/*-----------------------------------------修改---------------------------------------------*/
	@Override
	public int updateApplyKindOne(ApplyKind applyKind) throws Exception {
		// TODO 修改单个分类
		try {
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindStatusOn(Integer id) throws Exception{
		// TODO 启用分类
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setStatus(1);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int setApplyKindStatusOff(Integer id) throws Exception{
		// TODO 禁用分类
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setStatus(0);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int setApplyKindDocOn(Integer id) throws Exception {
		// TODO 启用佐证材料
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setNeedSuppDoc(1);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindDocOff(Integer id) throws Exception {
		// TODO 禁用佐证材料
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setNeedSuppDoc(0);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindFileOn(Integer id) throws Exception {
		// TODO 启用证明文件
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setNeedSuppFile(1);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindFileOff(Integer id) throws Exception {
		// TODO 禁用证明文件
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setNeedSuppFile(0);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindCheckOn(Integer id) throws Exception {
		// TODO 启用审核
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setNeedCheck(1);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindCheckOff(Integer id) throws Exception {
		// TODO 禁用审核
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setNeedCheck(0);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindCheckManual(Integer id) throws Exception {
		// TODO 启用手动审核
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setCheckKind(1);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setApplyKindCheckAuto(Integer id) throws Exception {
		// TODO 启用自动审核
		try {
			ApplyKind applyKind=new ApplyKind();
			applyKind.setId(id);
			applyKind.setCheckKind(0);
			kindMapper.updateByPrimaryKeySelective(applyKind);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/*-----------------------------------------修改---------------------------------------------*/	

	
	
	/*-----------------------------------------删除---------------------------------------------*/
	@Override
	public int delApplyKindOneById(Integer id) throws Exception {
		// TODO 根据ID删除单个分类
		try {
			kindMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delApplyKindListById(List<Integer> idList) throws Exception {
		// TODO 根据ID批量删除分类
		try {
			for(Integer id:idList) {
				kindMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delAppliKindListByPid(Integer pId) throws Exception {
		// 根据上级分类ID批量删除分类
		try {
			ApplyKindExample example=new ApplyKindExample();
			ApplyKindExample.Criteria criteria=example.createCriteria();
			criteria.andPIdEqualTo(pId);
			kindMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delApplyKindListByIntegral(Double Integral) throws Exception {
		// TODO 根据分类积分批量删除分类
		try {
			ApplyKindExample example=new ApplyKindExample();
			ApplyKindExample.Criteria criteria=example.createCriteria();
			criteria.andKindIntegralEqualTo(Integral);
			kindMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delApplyKindListByDocStatus(Integer docStatus) throws Exception {
		// TODO 根据是否需要佐证材料批量删除分类
		try {
			ApplyKindExample example=new ApplyKindExample();
			ApplyKindExample.Criteria criteria=example.createCriteria();
			criteria.andNeedSuppDocEqualTo(docStatus);
			kindMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delApplyKindListByFileStatus(Integer fileStatus) throws Exception {
		// TODO 根据是否需要证明文件批量删除分类
		try {
			ApplyKindExample example=new ApplyKindExample();
			ApplyKindExample.Criteria criteria=example.createCriteria();
			criteria.andNeedSuppFileEqualTo(fileStatus);
			kindMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delApplyKindListByCheckStatus(Integer checkStatus) throws Exception {
		// TODO 根据是否需要审核批量删除分类
		try {
			ApplyKindExample example=new ApplyKindExample();
			ApplyKindExample.Criteria criteria=example.createCriteria();
			criteria.andNeedCheckEqualTo(checkStatus);
			kindMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delApplyKindListByCheckKind(Integer checkKind) throws Exception {
		// TODO 根据审核方式批量删除分类
		try {
			ApplyKindExample example=new ApplyKindExample();
			ApplyKindExample.Criteria criteria=example.createCriteria();
			criteria.andCheckKindEqualTo(checkKind);
			kindMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/*-----------------------------------------删除---------------------------------------------*/

}
