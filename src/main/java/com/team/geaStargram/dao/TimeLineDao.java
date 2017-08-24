package com.team.geaStargram.dao;

import com.team.geaStargram.vo.TimeLine;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TimeLineDao {
    @Inject
    private SqlSession session;

    private static final String namespace = "timelineMapper";

    public void Insert(TimeLine timeLine) {
        session.insert(namespace + ".insert", timeLine);
    }

    public void update(TimeLine timeLine) {
        session.update(namespace + ".update", timeLine);
    }

    public void delete(TimeLine timeLine) {
        session.delete(namespace + ".delete", timeLine);
    }

    public List<TimeLine> selectAll() {
        return session.selectList(namespace + ".selectAll");
    }

    public TimeLine select(TimeLine timeLine) {
        return session.selectOne(namespace + ".select", timeLine);
    }

    public void deleteAll() {
        session.delete(namespace + ".deleteAll");
    }

    public int getCount() {
        return session.selectOne(namespace + ".getCount");
    }

}
