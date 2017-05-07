import com.system.ccew.Application;
import com.system.ccew.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Daotest {

    @Autowired
    UserDao userDao;

    @Test
    public void test(){
        System.out.println(userDao.findAll().get(0));
    }

}
