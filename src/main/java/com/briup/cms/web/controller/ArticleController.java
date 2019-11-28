package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@Api(description = "信息管理")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

  @PostMapping("/add")
  @ApiOperation(value = "添加信息",notes = "category.code category.name clickTimes publishDate不写")
    public Message addArticle(Article article){
        articleService.saveOrUpdate(article);
        return MessageUtil.success();
    }

    @GetMapping("/delete")
    @ApiOperation("删除信息")
    public  Message deleteArticle(int id){
      articleService.deleteArticleById(id);
      return  MessageUtil.success();
    }

    @GetMapping("/query")
    @ApiOperation("通过id查询")
    public Message queryArticle(int id){
        Article article1 = articleService.queryById(id);
        return MessageUtil.success(article1);
    } 
}
