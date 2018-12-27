package com.sl.core.mvc.bean;

import java.io.Serializable;

/**
 * TODO
 * @param <T>
 */
public class Result<T> implements Serializable {

    private String code;

    private String desc;

    private T data;

    public Result(Builder<T> builder) {
        this.code = builder.code;
        this.desc = builder.desc;
        this.data = builder.data;
    }

    public static class Builder<T> {

        private String code;

        private String desc;

        private T data;

        public Result build() {
            return new Result(this);
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }
    }

}
