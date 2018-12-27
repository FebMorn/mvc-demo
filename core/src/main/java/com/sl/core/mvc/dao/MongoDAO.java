package com.sl.core.mvc.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @Desc:mongodb访问基类接口
 * @author Nick	
 * @date 2017年7月21日
 */
public interface MongoDAO {

    //<T extends BaseDO> void insert(T entity) throws DAOException;
    //
    //<T extends BaseDO> void insert(T entity, String collectionName) throws DAOException;
    //
    //<T extends BaseDO> void save(T entity) throws DAOException;
    //
    //<T extends BaseDO> void save(T entity, String collectionName) throws DAOException;
    //
    //<T> void save(T entity, String collectionName) throws DAOException;
    //
    //<T> long count(Query query, Class<T> clazz) throws DAOException;
    //
    //long count(Query query, String collectionName) throws DAOException;
    //
    //<T> void remove(Query query, Class<T> clazz) throws DAOException;
    //
    //void remove(Query query, String collectionName) throws DAOException;
    //
    //<T> void updateMulti(Query query, Update update, Class<T> clazz) throws DAOException;
    //
    //void updateMulti(Query query, Update update, String collectionName) throws DAOException;
    //
    //<T> T get(Object bean, Class<T> clazz) throws DAOException;
    //
    //<T> T get(Query query, Class<T> clazz) throws DAOException;
    //
    //<T> T get(Query query, Class<T> clazz, String collectionName) throws DAOException;
    //
    //<E> List<E> listForPagination(Pagination pagination, Object bean, Class<E> clazz) throws DAOException;
    //
    //<E> List<E> listForPagination(Pagination pagination, Query query, Class<E> clazz) throws DAOException;
    //
    //<E> List<E> listForPagination(Pagination pagination, Object bean, Class<E> clazz, String collectionName) throws DAOException;
    //
    //<E> List<E> listForPagination(Pagination pagination, Query query, Class<E> clazz, String collectionName) throws DAOException;
    //
    //<E> List<E> list(Query query, Class<E> clazz, String collectionName) throws DAOException;
}
