package com.lanqiao.hebeitcm.mapper.fww;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.fww.culturals;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CultureMapper {
    public List<culturals> selectAllFilms();
}
