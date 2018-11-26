package com.wh.xyxwhl.web;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@MapperScan("com.wh.xyxwhl.web.dao")
@Import(FdfsClientConfig.class) /*FdfsClientConfig加载*/
public class XyxwhlApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyxwhlApplication.class, args);
    }
}
