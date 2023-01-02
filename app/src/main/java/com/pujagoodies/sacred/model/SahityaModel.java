package com.pujagoodies.sacred.model;

import java.util.ArrayList;

public class SahityaModel {
    String sahityaTopicTv;
    ArrayList<SahityaImageModel> list;

    public SahityaModel(String sahityaTopicTv, ArrayList<SahityaImageModel> list) {
        this.sahityaTopicTv = sahityaTopicTv;
        this.list = list;
    }

    public String getSahityaTopicTv() {
        return sahityaTopicTv;
    }

    public void setSahityaTopicTv(String sahityaTopicTv) {
        this.sahityaTopicTv = sahityaTopicTv;
    }

    public ArrayList<SahityaImageModel> getList() {
        return list;
    }

    public void setList(ArrayList<SahityaImageModel> list) {
        this.list = list;
    }
}
