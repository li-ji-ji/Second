package com.second;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.second.lhj.authority.mapper.MenuMapper;
import cn.second.lhj.authority.mapper.TestMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(SecondApplicationTests.class);

	@Autowired
	private TestMapper userInfoMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Test
	public void contextLoads() {
		logger.info(""+menuMapper.selectByPrimaryKey(1));
	}

}
