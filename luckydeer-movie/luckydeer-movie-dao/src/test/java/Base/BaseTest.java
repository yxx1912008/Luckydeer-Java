package Base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:testSpringConfig/testparent.xml",
                       "classpath:springConfig/spring-*.xml" })
public class BaseTest {

    @Test
    public void name() {

        System.out.println("ok");
    }

}
