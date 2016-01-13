package org.lohas.bf.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lohas.bf.dao.entities.SnsUser;
import org.lohas.bf.dao.entities.SnsUserExample;

public interface SnsUserMapper {
    int countByExample(SnsUserExample example);

    int deleteByExample(SnsUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SnsUser record);

    int insertSelective(SnsUser record);

    List<SnsUser> selectByExample(SnsUserExample example);

    SnsUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SnsUser record, @Param("example") SnsUserExample example);

    int updateByExample(@Param("record") SnsUser record, @Param("example") SnsUserExample example);

    int updateByPrimaryKeySelective(SnsUser record);

    int updateByPrimaryKey(SnsUser record);
}