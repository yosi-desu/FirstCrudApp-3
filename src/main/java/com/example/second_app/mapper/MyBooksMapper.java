package com.example.second_app.mapper;

import com.example.second_app.domain.MyBooksModel;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface MyBooksMapper {
    @Select("SELECT * FROM mybooks")
    List<MyBooksModel> selectAll();

    @Select("select * from mybooks where id= #{id}")
    MyBooksModel selectOne(Integer id);

    @Insert("INSERT INTO mybooks (title, author ) values (#{title}, #{author})")
    @Options(useGeneratedKeys = true)
    void insert(MyBooksModel myBooksModel);

    @Update("update mybooks set title=#{title}, author=#{author} where id= #{id}")
    void update(MyBooksModel myBooksModel);

    @Delete("delete from mybooks where id = #{id}")
    void delete(Integer id);
}
