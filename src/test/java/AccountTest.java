import com.team.geaStargram.dao.AccountDao;
import com.team.geaStargram.service.AccountService;
import com.team.geaStargram.status.AccountStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.team.geaStargram.vo.Account;

import javax.inject.Inject;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/spring/root-context.xml"})
public class AccountTest {

    @Inject
    private AccountDao accountDao;

    Account user1;
    Account user2;
    Account user3;


    @Before
    public void setup() {
        user1 = new Account();
        user1.setNickName("apple");
        user1.setEmail("appple.com");
        user1.setPassword("11111");
        user1.setBirth("1991");
        user1.setCnt(0);

        user2 = new Account();
        user2.setNickName("banana");
        user2.setEmail("banana.com");
        user2.setPassword("22222");
        user2.setBirth("1993");
        user2.setCnt(0);

        user3 = new Account();
        user3.setNickName("citron");
        user3.setEmail("citron.com");
        user3.setPassword("33333");
        user3.setBirth("1995");
        user3.setCnt(0);

        accountDao.deleteAll();
    }

    @Test
    public void insertNCount() {
        assertThat(accountDao.getCount(), is(0));
        accountDao.Insert(user1);
        assertThat(accountDao.getCount(), is(1));
        accountDao.Insert(user2);
        assertThat(accountDao.getCount(), is(2));
        accountDao.Insert(user3);
        assertThat(accountDao.getCount(), is(3));
        accountDao.deleteAll();
        assertThat(accountDao.getCount(), is(0));
    }

    @Test
    public void updateNGet() {
        accountDao.Insert(user1);

        user2.setEmail(user1.getEmail());
        accountDao.update(user2);

        Account updated = accountDao.select(user2);
        assertThat(updated.getEmail(), is(user2.getEmail()));
        assertThat(updated.getNickName(), is(user2.getNickName()));
    }

    @Test
    public void delete() {
        assertThat(accountDao.getCount(), is(0));
        accountDao.Insert(user1);
        assertThat(accountDao.getCount(), is(1));
        accountDao.Insert(user2);
        assertThat(accountDao.getCount(), is(2));
        accountDao.Insert(user3);
        assertThat(accountDao.getCount(), is(3));

        accountDao.delete(user3);
        assertThat(accountDao.getCount(), is(2));
    }

    @Test
    public void getAll() {
        assertThat(accountDao.getCount(), is(0));
        accountDao.Insert(user1);
        assertThat(accountDao.getCount(), is(1));
        accountDao.Insert(user2);
        assertThat(accountDao.getCount(), is(2));
        accountDao.Insert(user3);
        assertThat(accountDao.getCount(), is(3));

        List<Account> users = accountDao.selectAll();

        for (Account account : users) {
            System.out.println(account.getEmail());
            System.out.println(account.getNickName());
        }
    }

}
