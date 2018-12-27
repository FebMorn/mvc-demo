package com.sl.core.mvc.dao.impl;

import com.sl.core.mvc.dao.MongoDAO;
import org.springframework.stereotype.Component;


/**
 * @Desc:mongodb访问基类
 * @author Nick	
 * @date 2017年7月21日
 */
@Component
public class MongoDAOImpl implements MongoDAO {

    //private MongoOperations mongoOperations;
    //
    //@Override
    //public <T extends BaseDO> void insert(T entity) throws DAOException {
    //    try {
    //        Date date = new Date();
    //        entity.setGmtCreate(date);
    //        mongoOperations.insert(entity);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T extends BaseDO> void insert(T entity, String collectionName) throws DAOException {
    //    try {
    //        Date date = new Date();
    //        entity.setGmtCreate(date);
    //        entity.setGmtModified(date);
    //        mongoOperations.insert(entity, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T extends BaseDO> void save(T entity) throws DAOException {
    //    try {
    //        Date date = new Date();
    //        entity.setGmtModified(date);
    //        mongoOperations.save(entity);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T extends BaseDO> void save(T entity, String collectionName) throws DAOException {
    //    try {
    //        Date date = new Date();
    //        entity.setGmtModified(date);
    //        mongoOperations.save(entity, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> void save(T entity, String collectionName) throws DAOException {
    //    try {
    //        mongoOperations.save(entity,collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> long count(Query query, Class<T> clazz) throws DAOException {
    //    try {
    //        return mongoOperations.count(query, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public long count(Query query, String collectionName) throws DAOException {
    //    try {
    //        return mongoOperations.count(query, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> void remove(Query query, Class<T> clazz) throws DAOException {
    //    try {
    //        mongoOperations.remove(query, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public void remove(Query query, String collectionName) throws DAOException {
    //    try {
    //        mongoOperations.remove(query, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> void updateMulti(Query query, Update update, Class<T> clazz) throws DAOException {
    //    try {
    //        mongoOperations.updateMulti(query, update, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public void updateMulti(Query query, Update update, String collectionName) throws DAOException {
    //    try {
    //        mongoOperations.updateMulti(query, update, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> T get(Object bean, Class<T> clazz) throws DAOException {
    //    try {
    //        Query query = SpringMongoUtils.beanToQuery(bean);
    //        return get(query, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> T get(Query query, Class<T> clazz) throws DAOException {
    //    try {
    //        return mongoOperations.findOne(query, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <T> T get(Query query, Class<T> clazz, String collectionName) throws DAOException {
    //    try {
    //        return mongoOperations.findOne(query, clazz, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <E> List<E> listForPagination(Pagination pagination, Object bean, Class<E> clazz) throws DAOException {
    //    try {
    //        Query query = SpringMongoUtils.beanToQuery(bean);
    //        return listForPagination(pagination, query, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <E> List<E> listForPagination(Pagination pagination, Query query, Class<E> clazz) throws DAOException {
    //    try {
    //        Integer count = Long.valueOf(mongoOperations.count(query, clazz)).intValue();
    //        if (pagination == null) {
    //            pagination = new Pagination();
    //        }
    //        pagination.setTotal(count);
    //        query.skip(pagination.getStart()).limit(pagination.getRows());
    //        return mongoOperations.find(query, clazz);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <E> List<E> listForPagination(Pagination pagination, Object bean, Class<E> clazz, String collectionName) throws DAOException {
    //    try {
    //        Query query = SpringMongoUtils.beanToQuery(bean);
    //        return listForPagination(pagination, query, clazz, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <E> List<E> listForPagination(Pagination pagination, Query query, Class<E> clazz, String collectionName) throws DAOException {
    //    try {
    //        Integer count = Long.valueOf(mongoOperations.count(query, clazz, collectionName)).intValue();
    //        if (pagination == null) {
    //            pagination = new Pagination();
    //        }
    //        pagination.setTotal(count);
    //        query.skip(pagination.getStart()).limit(pagination.getRows());
    //        return mongoOperations.find(query, clazz, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //@Override
    //public <E> List<E> list(Query query, Class<E> clazz, String collectionName) throws DAOException {
    //    try {
    //        return mongoOperations.find(query, clazz, collectionName);
    //    } catch (Exception ex) {
    //        throw new DAOException(ex);
    //    }
    //}
    //
    //public MongoOperations getMongoOperations() {
    //    return mongoOperations;
    //}
    //
    //public void setMongoOperations(MongoOperations mongoOperations) {
    //    this.mongoOperations = mongoOperations;
    //}
}
