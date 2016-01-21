package org.lohas.bf.dao.mongomodels;

/**
 * Created by fule https:github.com/lohasle on 2016/1/14 0014.
 * 区域模型
 */
public class RegionModel {
    /**
     * 区域Id
     */
    private Integer regionId;

    /**
     * 区域名称
     */
    private String regionName;


    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public RegionModel(Integer regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public RegionModel(){}
}
