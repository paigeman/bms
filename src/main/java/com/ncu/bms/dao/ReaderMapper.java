package com.ncu.bms.dao;

import com.ncu.bms.bean.Reader;
import com.ncu.bms.bean.ReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ReaderMapper {
    long countByExample(ReaderExample example);

    int deleteByExample(ReaderExample example);

    int deleteByPrimaryKey(String reader_id);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> selectByExampleWithRowbounds(ReaderExample example, RowBounds rowBounds);

    List<Reader> selectByExample(ReaderExample example);

    Reader selectByPrimaryKey(String reader_id);

    int updateByExampleSelective(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByExample(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}