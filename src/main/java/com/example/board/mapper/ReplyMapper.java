package com.example.board.mapper;

import com.example.board.entity.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("select * from reply")
    List<Reply> selectAll();
    @Insert("insert into Reply (id, userid, content, regdate) values(id=#{reply.id}, userid=#{reply.userid}, content=#{reply.content}, regdate=#{reply.regdate})")
    int insert(@Param("reply")Reply reply);
    @Delete("delete from reply")
    int delete(@Param("reply")Reply reply);

}
