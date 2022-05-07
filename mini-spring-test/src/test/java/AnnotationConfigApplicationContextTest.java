import cn.hutool.core.lang.Assert;
import org.example.mine.spring.context.AnnotationConfigApplicationContext;
import org.example.mini.spring.service.IUserService;
import org.junit.Test;

public class AnnotationConfigApplicationContextTest {

    @Test
    public void testScan() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.example.mini.spring");

        Object userController = context.getBean("userController");
        Object userController2 = context.getBean(("userController"));

        Assert.notNull(userController);
        Assert.isTrue(userController == userController2);

        Object userServiceImpl = context.getBean("userServiceImpl");
        Assert.notNull(userServiceImpl);

        IUserService userService = context.getBean("userServiceImpl", IUserService.class);
        Assert.isTrue(userService == userServiceImpl);

    }
}