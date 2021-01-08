package com.example.second_app.service;

import com.example.second_app.domain.MyBooksModel;
import com.example.second_app.mapper.MyBooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyBooksService {
    @Autowired
    public MyBooksMapper myBooksMapper;

    @Transactional
    public List<MyBooksModel> selectAll() {return myBooksMapper.selectAll();}

    @Transactional
    public MyBooksModel selectOne(Integer id){return myBooksMapper.selectOne(id);}

    @Transactional
    public void insert(MyBooksModel myBooksModel) {myBooksMapper.insert(myBooksModel);}

    @Transactional
    public void update(MyBooksModel myBooksModel){myBooksMapper.update(myBooksModel);}
    @Transactional
    public void delete(Integer id) {myBooksMapper.delete(id);}
}
