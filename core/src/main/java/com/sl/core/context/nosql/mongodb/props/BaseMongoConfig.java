package com.sl.core.context.nosql.mongodb.props;


import com.mongodb.*;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


public abstract class BaseMongoConfig {

    public MongoDbFactory mongoDbFactory() throws Exception{
        ServerAddress serverAddress = new ServerAddress(host,port);
        MongoCredential mongoCredential = MongoCredential.createCredential(userName,database,password.toCharArray());
        //mongodb 配置
        MongoClientOptions.Builder options = new MongoClientOptions.Builder();
        options.cursorFinalizerEnabled(true);
        //与目标数据库建立的最大连接数
        options.connectionsPerHost(300);
        //数据库连接超时时间
        options.connectTimeout(1000*30*1);
        //当前线程获取数据库连接等待时间
        options.maxWaitTime(1000*5*1);
        //socket超时时间 0是默认为无限
        options.socketTimeout(0);
        //线程队列数
        options.threadsAllowedToBlockForConnectionMultiplier(10);
        //mongodb 应答机制 TODO
        options.writeConcern(WriteConcern.MAJORITY);

        return new SimpleMongoDbFactory(new MongoClient(serverAddress,mongoCredential,options.build()),database);
    }

    public abstract MongoTemplate getMongoTemplate() throws Exception;

    private String host;

    private Integer port;

    private String database;

    private String userName;

    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
