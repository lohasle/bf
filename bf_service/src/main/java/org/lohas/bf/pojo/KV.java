package org.lohas.bf.pojo;

/**
 * Created by lohas on 2015/6/24.
 * https://github.com/lohasle
 * K V 对象
 */
public class KV {

    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public KV(String name,Object value){
        this.name = name;
        this.value = value;
    }

    public static KV build(String name,Object value){
        return new KV(name,value);
    }
}
