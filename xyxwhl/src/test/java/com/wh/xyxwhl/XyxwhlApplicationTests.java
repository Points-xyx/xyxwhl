package com.wh.xyxwhl;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.wh.xyxwhl.web.XyxwhlApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XyxwhlApplication.class)
@Import(FdfsClientConfig.class)
public class XyxwhlApplicationTests {

    @Autowired
    private FastFileStorageClient storageClient;

    @Test
    public void contextLoads() {

        File file = new File("C:\\Users\\Administrator\\Desktop\\20181123T183808_23921_29709_31411.jpg");
        // 上传并且生成缩略图
        StorePath storePath = null;
        try {
            storePath = this.storageClient.uploadFile(
                    new FileInputStream(file), file.length(), "png", null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

}
