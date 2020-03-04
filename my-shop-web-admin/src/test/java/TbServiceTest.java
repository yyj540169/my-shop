import com.thoth.my.shop.domain.TbUser;
import com.thoth.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: my-shop
 * @description: test
 * @author: yyj
 * @create: 2019-12-06 16:36
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbServiceTest {

    @Autowired
    private TbUserService tbUserService;


    @Test
    public void test() {

        List<TbUser> tbUsers = tbUserService.selectAll();

        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }


    }


    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setEmail("admin@admin.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("amdin".getBytes()));
        tbUser.setPhone("15888888888");
        tbUser.setUsername("thoth");
        tbUser.setCreated(new Date());
        tbUser.setUpdate(new Date());

        tbUserService.insert(tbUser);
    }
    @Test
    public void ts() {


    }


}
