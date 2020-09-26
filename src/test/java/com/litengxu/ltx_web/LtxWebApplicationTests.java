package com.litengxu.ltx_web;

import com.litengxu.ltx_web.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LtxWebApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private SysUserService sysUserService;

}
