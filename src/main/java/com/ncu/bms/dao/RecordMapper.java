package com.ncu.bms.dao;

import com.ncu.bms.bean.Record;
import com.ncu.bms.bean.RecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RecordMapper {
    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer record_id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExampleWithRowbounds(RecordExample example, RowBounds rowBounds);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer record_id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<Record> selectByRecordSelective(Record record);

}