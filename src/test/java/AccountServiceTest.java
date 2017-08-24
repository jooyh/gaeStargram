//import com.team.geaStargram.dao.AccountDao;
//import com.team.geaStargram.service.AccountService;
//import com.team.geaStargram.status.AccountStatus;
//import com.team.geaStargram.vo.Account;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.inject.Inject;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:web/WEB-INF/spring/root-context.xml"})
//public class AccountServiceTest {
//
//    @Inject
//    private AccountService accountService;
//
//    @Inject
//    private AccountDao dao;
//
//    Account user1;
//    Account user2;
//    Account user3;
//
//    @Before
//    public void setup() {
//        user1 = new Account();
//        user1.setNickName("apple");
//        user1.setEmail("appple.com");
//        user1.setPassword("11111");
//        user1.setBirth("1991");
//        user1.setCnt(0);
//
//        user2 = new Account();
//        user2.setNickName("banana");
//        user2.setEmail("banana.com");
//        user2.setPassword("22222");
//        user2.setBirth("1993");
//        user2.setCnt(0);
//
//        user3 = new Account();
//        user3.setNickName("citron");
//        user3.setEmail("citron.com");
//        user3.setPassword("33333");
//        user3.setBirth("1995");
//        user3.setCnt(0);
//
//        dao.deleteAll();
//    }
//
//    @Test
//    public void regist() {
//        assertThat(accountService.registIn(user1), is(AccountStatus.DONE));
//    }
//
//    @Test
//    public void login() {
//        user2.setCnt(5);
//        assertThat(accountService.registIn(user2), is(AccountStatus.DONE));
//        assertThat(accountService.login(user2.getEmail(), user2.getPassword()), is(AccountStatus.OVER_COUNT));
//        assertThat(accountService.login(user2.getEmail() + "a", user2.getPassword()), is(AccountStatus.NO_EMAIL));
//        assertThat(accountService.login(user2.getEmail(), user2.getPassword() + "1"), is(AccountStatus.WORNG_PASSWORD));
//    }
//
//    @Test
//    public void loginFailCountNUnlock() {
//        assertThat(accountService.registIn(user1), is(AccountStatus.DONE));
//        assertThat(accountService.login(user1.getEmail(), user2.getPassword() + "1"), is(AccountStatus.WORNG_PASSWORD));
//        assertThat(dao.select(user1).getCnt(), is(1));
//        assertThat(accountService.login(user1.getEmail(), user2.getPassword() + "1"), is(AccountStatus.WORNG_PASSWORD));
//        assertThat(dao.select(user1).getCnt(), is(2));
//        assertThat(accountService.login(user1.getEmail(), user2.getPassword() + "1"), is(AccountStatus.WORNG_PASSWORD));
//        assertThat(dao.select(user1).getCnt(), is(3));
//        assertThat(accountService.login(user1.getEmail(), user2.getPassword() + "1"), is(AccountStatus.WORNG_PASSWORD));
//        assertThat(dao.select(user1).getCnt(), is(4));
//        assertThat(accountService.login(user1.getEmail(), user2.getPassword() + "1"), is(AccountStatus.WORNG_PASSWORD));
//        assertThat(dao.select(user1).getCnt(), is(5));
//        assertThat(accountService.login(user1.getEmail(), user1.getPassword()), is(AccountStatus.OVER_COUNT));
//
//        assertThat(accountService.unlockAccount(user1),is(AccountStatus.DONE));
//        assertThat(dao.select(user1).getCnt(), is(0));
//    }
//
//    @Test
//    public void findPassword() {
//        assertThat(accountService.registIn(user1), is(AccountStatus.DONE));
//        accountService.findPassword(user1.getEmail());
//        Account account = dao.select(user1);
//        System.out.println(account.getPassword());
//    }
//}
