package com.team.geaStargram.service;

import com.team.geaStargram.dao.AccountDao;
import com.team.geaStargram.exception.EmptyDataException;
import com.team.geaStargram.exception.NotMacthedValueException;
import com.team.geaStargram.exception.OverCountException;
import com.team.geaStargram.status.AccountStatus;
import com.team.geaStargram.vo.Account;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
public class AccountService {

    @Inject
    private AccountDao accountDao;

    private static final int TRY_LOGIN_MAX_COUNT = 5;

    public AccountStatus login(String email, String pw) {

        //새로운 객체를 생성해 받아온 정보를 입력
        Account account = new Account();
        account.setEmail(email);
        //해당 객체를 통해 불러온 정보를 다시 객체에 주입
        account = accountDao.select(account);

        try {
            // 해당 객체 검사
            isExistDataInObject(account);

            //들고온 비밀번호가 입력한 비밀번호가 다를경우
            loginCntIncrease(account, pw);

            //카운트가 5이상일 경우 method
            lockAccount(account);

            //맞는경우 카운트 초기화 method
            return resetLoginCnt(account);

        } catch (EmptyDataException e) {
            //실행중 exception 발생시 data를 불러오지 못했음으로 이메일 없음을 리턴
            return AccountStatus.NO_EMAIL;
        } catch (NotMacthedValueException e) {
            //비밀번호가 다를경우
            return AccountStatus.WORNG_PASSWORD;
        } catch (OverCountException e) {
            // 카운트 5 초과
            return AccountStatus.OVER_COUNT;
        }
    }

    public AccountStatus registIn(Account account, File profileImg) {
        try {
            // 전달받은 객체 검사
            isExistDataInObject(account);
            accountDao.Insert(account);
            // 사진 저장
            account.setSumnailImgPath(getFilePath(profileImg, account.getEmail()));

            // 메일발송
            sendMail("인증메일 입니다.", authCodeMake().toString(), account.getEmail());

            return AccountStatus.DONE;

        } catch (EmptyDataException e) {
            // 객체값중 빈값이 있을경우
            e.printStackTrace();
            return AccountStatus.FAIL_REGIST;
        } catch (IOException e) {
            //사진 등록 불가
            return AccountStatus.UPLOAD_FAIL;
        }
    }

    public AccountStatus updateAccount(Account account, File profileImg) {

        Account selected = accountDao.select(account);

        try {
            //db에서 들고온 객체 검사.
            isExistDataInObject(selected);

            //이미지 경로 저장
            selected.setSumnailImgPath(getFilePath(profileImg, account.getEmail()));

            // 수정된 정보 DB에 등록
            accountDao.update(account);
            return AccountStatus.DONE;

        } catch (EmptyDataException e) {
            return AccountStatus.NO_EMAIL;
        } catch (IOException e) {
            return AccountStatus.UPLOAD_FAIL;
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


    //    ================  private Method  ================================ *


    private void isExistDataInObject(Account account) {
        if (account.getEmail() == null || account.getEmail().equals(""))
            throw new EmptyDataException(" No Email DATA ");
        if (account.getPassword() == null || account.getPassword().equals(""))
            throw new EmptyDataException(" No Password DATA ");
        if (account.getNickName() == null || account.getEmail().equals(""))
            throw new EmptyDataException(" No NickName DATA ");
        if (account.getBirth() == null || account.getBirth().equals(""))
            throw new EmptyDataException(" No Birth DATA ");
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

    private void loginCntIncrease(Account account, String password) throws NotMacthedValueException {
        if (!account.getPassword().equals(password)) {
            account.setCnt(account.getCnt() + 1);
            accountDao.update(account);
            throw new NotMacthedValueException("! WORNG PASSWORD !");
        }
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


    private void lockAccount(Account account) throws OverCountException {
        if (account.getCnt() >= TRY_LOGIN_MAX_COUNT) throw new OverCountException();
    }

    private AccountStatus resetLoginCnt(Account account) {
        account.setCnt(0);
        accountDao.update(account);
        return AccountStatus.DONE;
    }

    private void sendMail(String msg, String code, String email) {

    }

    private String getFilePath(File file, String email) throws IOException {
        String rootPath = new File("").getCanonicalPath();
        String savedPath = rootPath + "/profileImg/" + email + ".jpg";
        File moveTo = new File(savedPath);
        FileUtils.moveDirectoryToDirectory(file, moveTo, true);
        return savedPath;
    }
}
