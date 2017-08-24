import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/spring/root-context.xml"})

public class DataSourceTest {

    @Inject
    private DataSource ds;

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConection() throws Exception {
        try (Connection con = ds.getConnection()) {
            System.out.println(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFactory() {
        System.out.println(sqlSessionFactory);
    }
}