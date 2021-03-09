package com.eduservice.controller;

import com.commonutils.R;
import com.eduservice.entity.EduTeacher;
import com.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    // 把service注入
    @Autowired
    private EduTeacherService teacherService;
    // 1.查询讲师表所有数据
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
//    public List<EduTeacher> findAllTeacher(){
//        //调用service方法实现查询操作
//       List<EduTeacher> list = teacherService.list(null);
//        return list;
//    }
    //统一返回格式后
    public R findAll(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items",list);

    }

    //2 逻辑删除讲师的方法
    @DeleteMapping({"id"})
    public R removeTeacher(@ApiParam(name="id",value = "讲师Id",required = true) @PathVariable String id){
        boolean flag =  teacherService.removeById(id);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}
