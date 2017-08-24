package com.team.geaStargram.service;

import com.team.geaStargram.dao.AccountDao;
import com.team.geaStargram.exception.EmptyDataException;
import com.team.geaStargram.status.AccountStatus;
import com.team.geaStargram.vo.Account;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Random;

@Service
public class AccountService {

    @Inject
    private AccountDao accountDao;

    public AccountStatus login(String email, String pw) {

        //새로운 객체를 생성해 받아온 정보를 입력
        Account account = new Account();
        account.setEmail(email);

        try {
            //해당 객체를 통해 불러온 정보를 다시 객체에 주입
            account = accountDao.select(account);
            // 해당 객체 검사
            isExistDataInObject(account);
            //들고온 비밀번호가 입력한 비밀번호가 다를경우
            if (!account.getPassword().equals(pw)) {
                // 카운트 증가
                account.setCnt(account.getCnt() + 1);
                accountDao.update(account);
                return AccountStatus.WORNG_PASSWORD;
            }
            //카운트가 5이상일 경우
            if (account.getCnt() > 4) return AccountStatus.OVER_COUNT;

            //맞는경우 카운트 초기화
            account.setCnt(0);
            accountDao.update(account);
            return AccountStatus.DONE;

        } catch (EmptyDataException e) {
            //실행중 exception 발생시 data를 불러오지 못했음으로 이메일 없음을 리턴
            e.printStackTrace();
            return AccountStatus.NO_EMAIL;
        }
    }

    public AccountStatus registIn(Account account) {
        try {
            // 전달받은 객체 검사
            isExistDataInObject(account);
            accountDao.Insert(account);
            // 메일발송
            sendMail("인증메일 입니다.", authCodeMake().toString(), account.getEmail());
            return AccountStatus.DONE;
        } catch (EmptyDataException e) {
            // 객체값중 빈값이 있을경우
            e.printStackTrace();
            return AccountStatus.FAIL_REGIST;
        }
    }

    public AccountStatus findPassword(String email) {

        // 입력받은 이메일을 객체에 주입
        Account account = new Account();
        account.setEmail(email);

        try {
            // 주입받은 객체를 통해 data 가져오기
            account = accountDao.select(account);
            //가져온 객체 검사
            isExistDataInObject(account);

            // 해당 데이터의 비밀번호를 랜덤으로 변경
            String tempPassword = tempPassword().toString();
            account.setPassword(tempPassword);
            accountDao.update(account);

            // 임시비밀번호 메일 발송
            sendMail("임시 비밀번호 입니다.", tempPassword, account.getEmail());
            account.setCnt(0);
            return AccountStatus.DONE;

        } catch (EmptyDataException e) {
            // 객체 검사에서 걸린경우
            e.printStackTrace();
            return AccountStatus.NO_EMAIL;
        }
    }

    public AccountStatus unlockAccount(Account account) {
        Account selected = accountDao.select(account);

        try {
            isExistDataInObject(selected);

            if (!account.getBirth().equals(selected.getBirth())) return AccountStatus.UNMATCHED_INFO;
            if (!account.getNickName().equals(selected.getNickName())) return AccountStatus.UNMATCHED_INFO;

            selected.setCnt(0);
            accountDao.update(selected);
            return AccountStatus.DONE;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return AccountStatus.NO_EMAIL;
        }
    }


    //    private Method ========================================================== *
    private void isExistDataInObject(Account account) {
        if (account.getEmail() == null) throw new EmptyDataException(" No Email DATA ");
        if (account.getPassword() == null) throw new EmptyDataException(" No Password DATA ");
        if (account.getNickName() == null) throw new EmptyDataException(" No NickName DATA ");
        if (account.getBirth() == null) throw new EmptyDataException(" No Birth DATA ");
    }

    private StringBuffer tempPassword() {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (rnd.nextBoolean()) {
                buf.append((char) ((int) (rnd.nextInt(26)) + 97));
            } else {
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf;
    }

    private StringBuffer authCodeMake() {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            if (rnd.nextBoolean()) {
                buf.append((char) ((int) (rnd.nextInt(26)) + 97));
            } else {
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf;
    }


    private void sendMail(String msg, String code, String email) {

    }
}
