package card.ygo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("card.ygo.mapper")
public class YgoApplication {
    public static void main(String args[])
    {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(YgoApplication.class);
        builder.headless(false).run(args);
    }
}
