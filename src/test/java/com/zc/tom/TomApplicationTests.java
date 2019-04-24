package com.zc.tom;

import com.zc.tom.mapper.LevelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TomApplicationTests {

    @Autowired
    private LevelMapper levelMapper;

    @Test
    public void contextLoads() {
        levelMapper.updateStudentLevel();
    }

}
