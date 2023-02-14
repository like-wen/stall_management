package com.lkw.stall_management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lkw.stall_management.entity.License;
import com.lkw.stall_management.service.LicenseService;
import com.lkw.stall_management.utils.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@Api(tags = "证件")
@RequestMapping("/license")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;
    @GetMapping("list/{stallId}")
    public R getLiceseList(@PathVariable String stallId){
        QueryWrapper<License> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stall_id",stallId);
        List<License> list=licenseService.list(queryWrapper);
        return R.ok().data("list",list);
    }

    @PostMapping("add")
    public R addLicense(@RequestBody License license){
        if (licenseService.save(license))
            return R.ok().message("添加证件成功");
        else
            return R.error().message("添加证件失败");
    }

    @DeleteMapping("{licenseId}")
    public R deleteLicense(@PathVariable String licenseId){
        if (licenseService.removeById(licenseId)) {
            return R.ok().message("删除证件成功");
        }else{
            return R.error().message("删除证件失败");
        }
    }
}
