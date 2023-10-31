package com.sisp.controller;

import com.sisp.beans.HttpResponseEntity;
import com.sisp.dao.entity.ProjectEntity;
import com.sisp.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    private ProjectService projectService;
    /**
     * 项目列表查询
     */
    @RequestMapping(value = "/queryProjectList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<ProjectEntity> hasProject = projectService.queryProjectList(projectEntity);
            if(CollectionUtils.isEmpty(hasProject)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(hasProject.get(0));
                httpResponseEntity.setMessage("无项目信息");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasProject);
                httpResponseEntity.setMessage("查询成功");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /**
     * 项目添加
     */
    @RequestMapping(value = "/addProjectInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addProject(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.addProjectInfo(projectEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /**
     * 项目修改
     */
    @RequestMapping(value = "/modifyProjectInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity modifyProject(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.modifyProjectInfo(projectEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        }catch (Exception e){
        }
        return httpResponseEntity;
    }
    /**
     * 项目删除
     */
    @RequestMapping(value = "/deleteProjectInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deleteProject(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.deleteProjectById(projectEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
