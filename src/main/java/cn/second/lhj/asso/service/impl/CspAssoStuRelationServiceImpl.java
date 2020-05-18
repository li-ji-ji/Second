package cn.second.lhj.asso.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.asso.mapper.extend.AssoStuRelationMapper;
import cn.second.lhj.asso.po.CspAssoManagement;
import cn.second.lhj.asso.po.CspAssoStuRelation;
import cn.second.lhj.asso.po.CspAssoStuRelationExample;
import cn.second.lhj.asso.service.CspAssoManagementService;
import cn.second.lhj.asso.service.CspAssoStuRelationService;

@Service
public class CspAssoStuRelationServiceImpl implements CspAssoStuRelationService {

	@Autowired
	private AssoStuRelationMapper cspAssoStuRelationMapper;
	@Autowired
	private CspAssoManagementService assoManagement;
	
	//查询所有学生与社团关系
	@Override
	public List<CspAssoStuRelation> getASRelationAll() throws Exception {
		return cspAssoStuRelationMapper.selectByExample(null);
	}

	//根据社团编号查询关系
	@Override
	public List<CspAssoStuRelation> getASRelationByAId(String assoId) throws Exception {
		CspAssoStuRelationExample example=new CspAssoStuRelationExample();
		CspAssoStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andAssoIdEqualTo(assoId);
		return cspAssoStuRelationMapper.selectByExample(example);
	}

	//根据学生编号查询关系
	@Override
	public List<CspAssoStuRelation> getASRelationBySId(String stuId) throws Exception {
		CspAssoStuRelationExample example=new CspAssoStuRelationExample();
		CspAssoStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return cspAssoStuRelationMapper.selectByExample(example);
	}

	//根据关系ID查询关系
	@Override
	public CspAssoStuRelation getASRelationById(Integer id) throws Exception {
		return cspAssoStuRelationMapper.selectByPrimaryKey(id);
	}

	//增加单个关系
	@Override
	public int insertRelationOne(CspAssoStuRelation relation) throws Exception {
		try {
			CspAssoManagement asso=assoManagement.getAssoByAssoId(relation.getAssoId());
			relation.setAssoName(asso.getAssoName());
			cspAssoStuRelationMapper.insertSelective(relation);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID删除单个关系
	@Override
	public int deleteRelationOneById(Integer id) throws Exception {
		try {
			cspAssoStuRelationMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID批量删除关系
	@Override
	public int deleteListRelationById(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList) {
				cspAssoStuRelationMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据社团编号批量删除关系
	@Override
	public int deleteRelationByAId(String assoId) throws Exception {
		return 0;
	}

	//根据学生编号批量删除关系
	@Override
	public int deleteRelationBySId(String stuId) throws Exception {
		try {
			CspAssoStuRelationExample example=new CspAssoStuRelationExample();
			CspAssoStuRelationExample.Criteria criteria=example.createCriteria();
			criteria.andStuIdEqualTo(stuId);
			cspAssoStuRelationMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据社团编号与学生编号删除关系
	@Override
	public int deleteRelationByASId(String assoId, String stuId) throws Exception {
		try {
			cspAssoStuRelationMapper.deleteByASId(assoId, stuId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据社团编号与学生编号查询关系
	@Override
	public CspAssoStuRelation getRelationByASId(String assoId, String stuId) throws Exception {
		return cspAssoStuRelationMapper.selectByASId(assoId, stuId);
	}

	//根据社团编号查询关系条数
	@Override
	public int countRelationByAId(String assoId) throws Exception {
		return cspAssoStuRelationMapper.countByAId(assoId);
	}

	//根据学生学号查询关系条数
	@Override
	public int countRelationBySId(String stuId) throws Exception {
		return cspAssoStuRelationMapper.countBySId(stuId);
	}

	@Override
	public Map<String, Object> getAssoStuJoin() throws Exception {
		List<CspAssoStuRelation> ASRList = getASRelationAll();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Integer> count = new HashMap<String, Integer>();
		List<String> labels = new ArrayList<String>();
		List<Integer> datas = new ArrayList<Integer>();
		for(CspAssoStuRelation asr:ASRList) {
			if(count.containsKey(asr.getAssoName())){
				count.put(asr.getAssoName(), count.get(asr.getAssoName())+1);
//				System.out.println(count.get(act.getActivityKindName()));
			}else {
				count.put(asr.getAssoName(), 1);
			}
		}
		System.out.println(count);
		for(Map.Entry<String, Integer> entry : count.entrySet()){
			labels.add(entry.getKey());
			datas.add(entry.getValue());
		}
		result.put("labels", labels);
		result.put("datas", datas);
		return result;
	}

}
