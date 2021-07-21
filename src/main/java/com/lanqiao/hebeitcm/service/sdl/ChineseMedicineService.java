package com.lanqiao.hebeitcm.service.sdl;

import com.lanqiao.hebeitcm.model.sdl.TbCulproChineseMedicine;

import java.util.List;

/**
 * ClassName ChineseMedicineService
 * Description
 *
 * @author 石都林
 * @date 2021/7/21 18:58
 * Version 1.0
 */
public interface IChineseMedicineService {
    /**
     * 按用户输入条件查询名老中医信息
     * @param medName
     * @return java.util.List<com.lanqiao.hebeitcm.model.sdl.TbCulproChineseMedicine>
     */
    public List<TbCulproChineseMedicine> selectChineseMedicine(String medName);
}
