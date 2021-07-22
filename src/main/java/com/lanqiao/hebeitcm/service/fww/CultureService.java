package com.lanqiao.hebeitcm.service.fww;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.fww.culturals;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CultureService {
    public List<culturals> selectAllFilms();
}
