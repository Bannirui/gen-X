package ${_package};

import com.zto.titans.common.annotation.EnableFramework;
import com.zto.titans.config.annotation.EnableConfig;
import org.springframework.boot.SpringApplication;

@EnableFramework
@EnableConfig({"application"})
public class ${_upperArtifactId}Application {

    public static void main(String[] args) {
        SpringApplication.run(${_upperArtifactId}Application.class, args);
    }
}