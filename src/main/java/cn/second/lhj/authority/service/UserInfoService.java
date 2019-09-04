package cn.second.lhj.authority.service;

import cn.second.lhj.authority.models.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
