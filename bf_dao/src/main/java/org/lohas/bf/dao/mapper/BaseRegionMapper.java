package org.lohas.bf.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lohas.bf.dao.entities.BaseRegion;
import org.lohas.bf.dao.entities.BaseRegionExample;

public interface BaseRegionMapper {
    int countByExample(BaseRegionExample example);

    int deleteByExample(BaseRegionExample example);

    int deleteByPrimaryKey(Integer areaId);

    int insert(BaseRegion record);

    int insertSelective(BaseRegion record);

    List<BaseRegion> selectByExample(BaseRegionExample example);

    BaseRegion selectByPrimaryKey(Integer areaId);

    int updateByExampleSelective(@Param("record") BaseRegion record, @Param("example") BaseRegionExample example);

    int updateByExample(@Param("record") BaseRegion record, @Param("example") BaseRegionExample example);

    int updateByPrimaryKeySelective(BaseRegion record);

    int updateByPrimaryKey(BaseRegion record);
}