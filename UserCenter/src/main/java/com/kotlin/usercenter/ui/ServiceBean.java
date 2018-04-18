package com.kotlin.usercenter.ui;

import java.util.List;

/**
 * @author Dsh toushihiroshi on 2018/4/18.
 */

public class ServiceBean {


    /**
     * status : true
     * code : 200
     * transfer_enable : 199.72
     * transfer_use : 21.82
     * configs : [{"server":"139.162.55.179","server_port":"10941","server_status":"online","password":"163.com","method":"aes-256-cfb","remarks":"???"},{"server":"172.105.221.80","server_port":"10941","server_status":"online","password":"163.com","method":"aes-256-cfb","remarks":"??"}]
     * msg : 成功
     */

    private boolean status;
    private int code;
    private double transfer_enable;
    private double transfer_use;
    private String msg;
    private List<ConfigsBean> configs;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getTransfer_enable() {
        return transfer_enable;
    }

    public void setTransfer_enable(double transfer_enable) {
        this.transfer_enable = transfer_enable;
    }

    public double getTransfer_use() {
        return transfer_use;
    }

    public void setTransfer_use(double transfer_use) {
        this.transfer_use = transfer_use;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ConfigsBean> getConfigs() {
        return configs;
    }

    public void setConfigs(List<ConfigsBean> configs) {
        this.configs = configs;
    }

    public static class ConfigsBean {
        /**
         * server : 139.162.55.179
         * server_port : 10941
         * server_status : online
         * password : 163.com
         * method : aes-256-cfb
         * remarks : ???
         */

        private String server;
        private String server_port;
        private String server_status;
        private String password;
        private String method;
        private String remarks;

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getServer_port() {
            return server_port;
        }

        public void setServer_port(String server_port) {
            this.server_port = server_port;
        }

        public String getServer_status() {
            return server_status;
        }

        public void setServer_status(String server_status) {
            this.server_status = server_status;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }
}
