package com.zc.tom.service;

public interface LevelService {

    //等级调整
    void updateStudentLevel();

    //调整等级的基本薪资
    void updateLevelByLevelID(int levelID);
}
