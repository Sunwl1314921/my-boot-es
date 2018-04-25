package com.boot.es.mybootes.ESSearch;

import java.io.Serializable;
import lombok.Data;
/**
 * 城市实体类
 * <p>
 * Created by bysocket on 03/05/2017.
 */
//@Document(indexName = "cityindex", type = "city")
@Data
public class City implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    private int id;

    /**
     * 省份编号
     */
    private int provinceid;

    /**
     * 城市名称
     */
    private String cityname;

    /**
     * 描述
     */
    private String description;

    /**
     * 商品名称，当前内容包含高亮标签
     */
    private String highName;

    public City(){}

    public City(int id, int provinceid, String cityname, String description) {
        this.id = id;
        this.provinceid = provinceid;
        this.cityname = cityname;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
