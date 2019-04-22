package org.protogalaxy.phss.thirdparty.bangumi;

public final class BangumiConsts {
    /**
     * Subject Type
     */
    public static final Integer
            SUBJECT_TYPE_BOOK = 1,
            SUBJECT_TYPE_ANIME = 2,
            SUBJECT_TYPE_MUSIC = 3,
            SUBJECT_TYPE_GAME = 4,
            SUBJECT_TYPE_REAL = 5;

    /**
     * Collection Status
     * <p>
     * wish = 想做
     * collect = 做过
     * do = 在做
     * on_hold = 搁置
     * dropped = 抛弃
     */
    public static final String
            COLLECTION_STATUS_WISH = "wish",
            COLLECTION_STATUS_COLLECT = "collect",
            COLLECTION_STATUS_DO = "do",
            COLLECTION_STATUS_ONHOLD = "on_hold",
            COLLECTION_STATUS_DROPPED = "dropped";

    /**
     * Ep Status
     * <p>
     * watched = 看过
     * queue = 想看
     * drop = 抛弃
     * remove = 撤销
     */
    public static final String
            EP_STATUS_WATCHED = "watched",
            EP_STATUS_QUEUE = "queue",
            EP_STATUS_DROP = "drop",
            EP_STATUS_REMOVE = "remove";

    /**
     * Response Group
     */
    public static final String
            RESPONSE_GROUP_SMALL = "small",
            RESPONSE_GROUP_MEDIUM = "medium",
            RESPONSE_GROUP_LARGE = "large";
}
