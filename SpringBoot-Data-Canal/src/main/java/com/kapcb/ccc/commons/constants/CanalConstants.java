package com.kapcb.ccc.commons.constants;

/**
 * <a>Title: CanalConstants </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 14:50
 */
public class CanalConstants {

    private CanalConstants() {
    }

    public static final String DEFAULT_HOST = "127.0.0.1";

    public static final Integer DEFAULT_PORT = 1111;

    public static final String DEFAULT_DESTINATION = "example";

    public static final String DEFAULT_USERNAME = "canal";

    public static final String DEFAULT_PASSWORD = "canal";

    public static final Integer DEFAULT_BATCH_SIZE = 1000;

    public static final String DEFAULT_FILTER = ".*\\..*";

    public static final Boolean DEFAULT_CUSTOM = true;

    public static final Boolean DEFAULT_CLUSTER_ENABLED = false;

    /**
     * 多过滤使用逗号分隔
     */
    public static final String DEFAULT_FILTER_SPLIT = ",";

    /**
     * 数据库与表名只是使用点风格
     */
    public static final String DEFAULT_TABLE_SPLIT = "\\.";

}
