package com.ncu.bms.dao;

import com.ncu.bms.bean.Book;
import com.ncu.bms.bean.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(String book_No);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExampleWithRowbounds(BookExample example, RowBounds rowBounds);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(String book_No);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}