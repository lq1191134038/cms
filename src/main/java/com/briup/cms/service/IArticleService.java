package com.briup.cms.service;

import com.briup.cms.bean.Article;
import com.briup.cms.exception.CustomerException;

public interface IArticleService {

    void saveOrUpdate(Article article) throws CustomerException;

    void deleteArticleById(int id) throws CustomerException;

    Article queryById(int id) throws  CustomerException;
}
