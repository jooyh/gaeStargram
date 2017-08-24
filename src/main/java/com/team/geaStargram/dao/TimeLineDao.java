package com.team.geaStargram.dao;

import com.team.geaStargram.vo.Account;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TimeLineDao {
    @Inject
    private SqlSession session;


    private static final String namespace = "accountMapper";

    public void Insert(Account account) {
        session.insert(namespace + ".insert", account);
    }

    public void update(Account account) {
        session.update(namespace + ".update", account);
    }

    public void delete(Account account) {
        session.delete(namespace + ".delete", account);
    }

    public List<Account> selectAll() {
        return session.selectList(namespace + ".selectAll");
    }

    public Account select(Account account) {
        return session.selectOne(namespace + ".select", account);
    }

    public void deleteAll() {
        session.delete(namespace + ".deleteAll");
    }

    public int getCount() {
        return session.selectOne(namespace + ".getCount");
    }


}
