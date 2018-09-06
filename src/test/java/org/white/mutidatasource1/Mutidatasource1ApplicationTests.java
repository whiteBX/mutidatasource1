package org.white.mutidatasource1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.white.mutidatasource1.dao.back.AdminMapper;
import org.white.mutidatasource1.dao.front.UserMapper;
import org.white.mutidatasource1.dto.AdminDTO;
import org.white.mutidatasource1.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Mutidatasource1ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void test() {
		AdminDTO admin = new AdminDTO();
		admin.setAdminId("3");
		admin.setAdminName("admin3");
		UserDTO user = new UserDTO();
		user.setUserId("3");
		user.setUserName("user3");

		int userCount = userMapper.insert(user);
		int adminCount = adminMapper.insert(admin);
		Assert.assertTrue("用户插入失败", userCount == 1);
		Assert.assertTrue("管理员插入失败", adminCount == 1);
    }

}
