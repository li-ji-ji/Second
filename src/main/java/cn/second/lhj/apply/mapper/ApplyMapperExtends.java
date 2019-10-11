package cn.second.lhj.apply.mapper;

import org.apache.ibatis.annotations.Update;

public interface ApplyMapperExtends extends ApplyMapper {
	
	//根据申请种类批量修改审核情况
	@Update("update `apply` set check_status=#{checkStatus} WHERE kind_id=#{kindId}")
	public int checkApplyListByKind(Integer checkStatus,Integer kindId)throws Exception;
	//根据学生学号批量审核情况
	@Update("update `apply` set check_status=#{checkStatus} WHERE stu_id=#{stuId}")
	public int checkApplyListByStuId(Integer checkStatus,String stuId)throws Exception;
	//根据积分批量审核情况
	@Update("update `apply` set check_status=#{checkStatus} WHERE integral=#{integral}")
	public int checkApplyListByIntegral(Integer checkStatus,Double integral) throws Exception;
	//根据学生学号批量修改申请状态
	@Update("update `apply` set status=#{status} WHERE stu_id=#{stuId}")
	public int updateStatusByStuId(Integer status,String stuId)throws Exception;
	
}
