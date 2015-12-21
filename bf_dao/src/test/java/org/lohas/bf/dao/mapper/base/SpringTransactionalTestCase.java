package org.lohas.bf.dao.mapper.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.FileNotFoundException;
/**
 * Created with IntelliJ IDEA.
 * UserInfo: fule
 * Date: 13-6-7
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 */

/**
 * 用于dao层单元测试基类
 * Spring的支持数据库访问, 事务控制和依赖注入的JUnit4 集成测试基类.
 * 相比Spring原基类名字更短并保存了dataSource变量.
 * 定义applicationContext文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-dao.xml"})
@ActiveProfiles("dev")
public  class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	@Override
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}

	@Test
	public void test(){

	}

}
