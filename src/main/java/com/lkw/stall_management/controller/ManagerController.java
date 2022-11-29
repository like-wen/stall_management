package com.lkw.stall_management.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkw.stall_management.entity.Manager;
import com.lkw.stall_management.entity.Vo.ManagerQuery;
import com.lkw.stall_management.entity.Vo.ManagerShowVo;
import com.lkw.stall_management.service.ManagerService;
import com.lkw.stall_management.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("{managerId}")
    public R GetManagerById(@PathVariable String managerId){
        Manager manager = managerService.getById(managerId);
        ManagerShowVo managerShowVo = new ManagerShowVo();
        BeanUtils.copyProperties(manager,managerShowVo);
        return R.ok().data("manager",managerShowVo);
    }

    @PostMapping("pageManager/{current}/{limit}")
    public R pageManagerCondition(@PathVariable Long current,
                                  @PathVariable Long limit,
                                  @RequestBody(required = false)ManagerQuery managerQuery){
        Page<Manager> managerPage=new Page<>(current,limit);
        //构造条件
        QueryWrapper<Manager> managerQueryWrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(managerQuery.getName())){
            managerQueryWrapper.like("name",managerQuery.getName());
        }
        if(!StringUtils.isEmpty(managerQuery.getDistrict())){
            managerQueryWrapper.eq("district",managerQuery.getDistrict());
        }
        managerQueryWrapper.orderByDesc("name");//按名字排序
        managerService.page(managerPage,managerQueryWrapper);
        long total = managerPage.getTotal();//获取总记录数
        List<Manager> records = managerPage.getRecords();
        //转变成ManagerShowVo,滤去密码,时间,逻辑删除等
        List<ManagerShowVo> collect = records.stream().map(manager -> {
            ManagerShowVo managerShowVo = new ManagerShowVo();
            BeanUtils.copyProperties(manager, managerShowVo);
            return managerShowVo;
        }).collect(Collectors.toList());
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",collect);
        return R.ok().data("map",map);

    }


}
