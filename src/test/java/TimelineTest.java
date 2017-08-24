import com.team.geaStargram.dao.TimeLineDao;
import com.team.geaStargram.vo.TimeLine;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/spring/root-context.xml"})
public class TimelineTest {

    @Inject
    TimeLineDao dao;

    public void getList(){

    }

}
