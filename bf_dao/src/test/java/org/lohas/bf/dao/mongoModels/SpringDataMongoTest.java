package org.lohas.bf.dao.mongomodels;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.lohas.bf.dao.entities.BaseRegion;
import org.lohas.bf.dao.entities.SnsUser;
import org.lohas.bf.dao.entities.SnsUserExample;
import org.lohas.bf.dao.mapper.BaseRegionMapper;
import org.lohas.bf.dao.mapper.SnsUserMapper;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by lohas on 2015/10/30.
 * https://github.com/lohasle
 */
public class SpringDataMongoTest extends SpringTransactionalTestCase {

    private static Logger logger = LoggerFactory.getLogger(SpringDataMongoTest.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SnsUserMapper snsUserMapper;

    @Autowired
    private BaseRegionMapper baseRegionMapper;


    /**
     * 将mysql  用户数据转移到mongodb 中
     */
    @Test
    public void testTransportToMongo() {


        // 清理数据
        mongoTemplate.remove(new Query(),UserModel.class);



        // 开始传输
        String domain = "http://app.weizy.cn/";

        SnsUserExample example = new SnsUserExample();
        example.createCriteria().andUserGroupEqualTo(1);// 普通用户
        List<SnsUser> snsUsers = snsUserMapper.selectByExample(example);
        int index = 0;
        long t1 = System.currentTimeMillis();
        for (SnsUser snsUser : snsUsers) {

            UserModel userModel = new UserModel();

            userModel.setSeq(snsUser.getId());
            userModel.setName(snsUser.getName());
            userModel.setUserName(snsUser.getUserName());
            userModel.setCreateTime(snsUser.getCreateTime());
            userModel.setAddress(snsUser.getAddress());
            userModel.setBirthDate(snsUser.getBirthDate());
            userModel.setGtCid(snsUser.getGtCid());
            userModel.setEmail(snsUser.getEmail());
            userModel.setIdcard(snsUser.getIdcard());
            if(StringUtils.isNotBlank(snsUser.getAvatar())){
                userModel.setAvatar(domain + snsUser.getAvatar());
            }
            userModel.setLat(snsUser.getLat());
            userModel.setLng(snsUser.getLng());
            userModel.setPhone(snsUser.getPhone());
            userModel.setSalt(snsUser.getSalt());
            userModel.setWechatOpenId(snsUser.getWechat());//微信openid
            userModel.setWeiboOpenId(snsUser.getWeibo());//微博openid
            userModel.setQqOpenId(snsUser.getQq());//qq openid
            userModel.setModifyTime(snsUser.getModifyTime());
            userModel.setVersion(snsUser.getVersion());
            userModel.setSalt(snsUser.getSalt());
            userModel.setState(snsUser.getState());
            userModel.setSex(snsUser.getSex());
            userModel.setPwdHash(snsUser.getPwdHash());

            Integer regionId = snsUser.getRegionId();
            if(regionId!=null){
                BaseRegion baseRegion = baseRegionMapper.selectByPrimaryKey(regionId);
                RegionModel regionModel = new RegionModel();
                regionModel.setRegionId(regionId);
                if(baseRegion!=null){
                    regionModel.setRegionName(baseRegion.getAreaName());
                }
                userModel.setRegion(regionModel);
            }

            mongoTemplate.save(userModel);

            System.out.println("第"+(++index)+"传输成功");

        }
        long t2 = System.currentTimeMillis();

        System.out.println("共传输"+(index)+"条数据耗时"+(t2-t1));
    }



    @Test
    public void testQuery(){
        Query query=new BasicQuery("{phone:'15279113047'}","{userName:1,phone:1,avatar:1,ucToken:1,gtCid:1,region:1,pwdHash:1}");
        List<UserModel> userModels = mongoTemplate.find(query, UserModel.class);
        System.out.println(JSON.toJSONString(userModels));
    }
}
