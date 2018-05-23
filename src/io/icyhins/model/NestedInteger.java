package io.icyhins.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Silver.Kan
 * @date 2018/5/23
 */
public class NestedInteger {

    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public NestedInteger(Integer integer) {
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    public void add(NestedInteger nestedInteger) {
        if (list != null) {
            list.add(nestedInteger);
        } else {
            this.list = new ArrayList<>();
            list.add(nestedInteger);
        }
    }

    public boolean isInteger() {

        return integer != null;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
