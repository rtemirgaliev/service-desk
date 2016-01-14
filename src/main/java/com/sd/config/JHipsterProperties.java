//     Properties are configured in the application.yml file.


package com.sd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;


@ConfigurationProperties(prefix = "jhipster", ignoreUnknownFields = false)
public class JHipsterProperties {

    private final Async async = new Async();

    private final Security security = new Security();

    public Async getAsync() {
        return async;
    }

    public Security getSecurity() {
        return security;
    }

    public static class Async {
        private int corePoolSize = 2;
        private int maxPoolSize = 50;
        private int queueCapacity = 1000;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }
//    private final Datasource datasource = new Datasource();
//
//
//    public Datasource getDatasource() {
//        return datasource;
//    }
//
//
//    public static class Datasource {
//
//        private boolean cachePrepStmts = true;
//
//        private int prepStmtCacheSize = 250;
//
//        private int prepStmtCacheSqlLimit = 2048;
//
//        private boolean useServerPrepStmts = true;
//
//        public boolean isCachePrepStmts() {
//            return cachePrepStmts;
//        }
//
//        public void setCachePrepStmts(boolean cachePrepStmts) {
//            this.cachePrepStmts = cachePrepStmts;
//        }
//
//        public int getPrepStmtCacheSize() {
//            return prepStmtCacheSize;
//        }
//
//        public void setPrepStmtCacheSize(int prepStmtCacheSize) {
//            this.prepStmtCacheSize = prepStmtCacheSize;
//        }
//
//        public int getPrepStmtCacheSqlLimit() {
//            return prepStmtCacheSqlLimit;
//        }
//
//        public void setPrepStmtCacheSqlLimit(int prepStmtCacheSqlLimit) {
//            this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
//        }
//
//        public boolean isUseServerPrepStmts() {
//            return useServerPrepStmts;
//        }
//
//        public void setUseServerPrepStmts(boolean useServerPrepStmts) {
//            this.useServerPrepStmts = useServerPrepStmts;
//        }
//    }

    public static class Security {

        private final Rememberme rememberme = new Rememberme();

        public Rememberme getRememberme() {
            return rememberme;
        }

        public static class Rememberme {

            @NotNull
            private String key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }


}
