package org.protogalaxy.phss.manager.bangumi;

import org.json.simple.JSONObject;
import org.protogalaxy.phss.manager.config.ApiBinding;
import org.springframework.lang.Nullable;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class BangumiApi extends ApiBinding {
    private static final String BANGUMI_API_BASE_URL = "https://api.bgm.tv";

    public BangumiApi(String accessToken) {
        super(accessToken);
    }

    /**
     * 条目信息
     *
     * @param subjectId     条目 ID
     * @param responseGroup 返回数据大小 参考 Define
     */
    public JSONObject getSubject(Integer subjectId, @Nullable String responseGroup) {
        String postUrl = BANGUMI_API_BASE_URL + "/subject/" + subjectId;
        if (responseGroup != null) {
            postUrl += ("?responseGroup=" + responseGroup);
        }
        return restTemplate.getForObject(postUrl, JSONObject.class);
    }

    /**
     * 章节数据
     *
     * <p>返回条目章节与条目基础信息</p>
     *
     * @param id 条目 ID
     */
    public JSONObject getEp(Integer id) {
        return restTemplate.getForObject(BANGUMI_API_BASE_URL + "/subject/" + id + "/ep", JSONObject.class);
    }

    /**
     * 每日放送
     */
    public JSONObject getCalendar() {
        return restTemplate.getForObject(BANGUMI_API_BASE_URL + "/calendar", JSONObject.class);
    }

    /**
     * 条目搜索
     *
     * @param keywords      关键词 需要 URL Encode
     * @param type          类型 参考 Define
     * @param responseGroup 返回数据大小 参考 Define
     * @param start         开始条数
     * @param maxResults    每页条数 最多 25
     */
    public JSONObject searchSubject(String keywords, Integer type, @Nullable String responseGroup, @Nullable Integer start, @Nullable Integer maxResults) throws Exception{
        String getUrl = BANGUMI_API_BASE_URL + "/search/subject/" + URLEncoder.encode(keywords, StandardCharsets.UTF_8.toString());
        boolean paramFlag = false;
        if (type != null) {
            getUrl += ("?type=" + type);
            paramFlag = true;
        }
        if (responseGroup != null && !paramFlag) {
            getUrl += ("?responseGroup=" + responseGroup);
            paramFlag = true;
        } else if (responseGroup != null) {
            getUrl += ("&responseGroup=" + responseGroup);
        }
        if (start != null && !paramFlag) {
            getUrl += ("?start=" + start);
            paramFlag = true;
        } else if (start != null) {
            getUrl += ("&start=" + start);
        }
        if (maxResults != null && !paramFlag) {
            getUrl += ("?max_results=" + maxResults);
        } else if (maxResults != null) {
            getUrl += ("&max_results=" + maxResults);
        }
        return restTemplate.getForObject(getUrl, JSONObject.class);
    }

    /**
     * 更新收视进度
     *
     * @param epId   章节 ID
     * @param status 收视类型
     */
    public JSONObject progressStatusUpdate(Integer epId, String status) {
        return restTemplateAuthorized.getForObject(BANGUMI_API_BASE_URL + "/ep/" + epId + "/status/" + status, JSONObject.class);
    }

    /**
     * 批量更新收视进度
     *
     * @param subjectId   条目 ID
     * @param watchedEps  章节话数 如看到第 123 话则 POST 123
     * @param watchedVols 书籍卷数 如看到第 3 卷则 POST 3, 仅对书籍条目有效
     */
    public JSONObject progressStatusMultiUpdate(Integer subjectId, String watchedEps, @Nullable String watchedVols) {
        String postUrl = BANGUMI_API_BASE_URL + "/subject/" + subjectId + "/update/" + watchedEps;
        if (watchedVols != null) {
            postUrl += ("?watched_vols=" + watchedVols);
        }
        return restTemplateAuthorized.postForObject(postUrl, null, JSONObject.class);
    }

    /**
     * 用户收视进度
     *
     * @param username  用户名
     * @param subjectId 条目 ID
     */
    public JSONObject getUserProgress(String username, @Nullable Integer subjectId) {
        String getUrl = BANGUMI_API_BASE_URL + "/account/" + username + "/progress";
        if (subjectId != null) {
            getUrl += ("?subject_id=" + subjectId);
        }
        return restTemplateAuthorized.getForObject(getUrl, JSONObject.class);
    }

    /**
     * 获取指定条目收藏信息
     *
     * @param subjectId 条目 ID
     */
    public JSONObject getCollection(Integer subjectId) {
        return restTemplateAuthorized.getForObject(BANGUMI_API_BASE_URL + "/collection/" + subjectId, JSONObject.class);
    }

    /**
     * 用户信息
     *
     * <p>返回用户基础信息</p>
     *
     * @param username 用户名 也可使用 UID
     */
    public JSONObject getUser(String username) {
        return restTemplate.getForObject(BANGUMI_API_BASE_URL + "/account/" + username, JSONObject.class);
    }

    /**
     * 用户收藏
     *
     * <p>获取用户收藏列表，默认为在看</p>
     *
     * @param username      用户名  也可使用 UID
     * @param cat           收藏类型  watching = 在看的动画与三次元条目 / all_watching = 在看的动画三次元与书籍条目
     * @param ids           收藏条目ID    批量查询收藏状态，将条目 ID 以半角逗号分隔，如 1,2,4,6
     * @param responseGroup 默认为 medium。small 时不返回条目详细信息
     */
    public JSONObject getUserCollection(String username, @Nullable String cat, @Nullable String ids, @Nullable String responseGroup) {
        String getUrl = BANGUMI_API_BASE_URL + "/account/" + username + "/collection";
        boolean paramFlag = false;
        if (cat != null) {
            getUrl += ("?cat=" + cat);
            paramFlag = true;
        }
        if (ids != null && !paramFlag) {
            getUrl += ("?ids=" + ids);
            paramFlag = true;
        } else if (ids != null) {
            getUrl += ("&ids=" + ids);
        }
        if (responseGroup != null && !paramFlag) {
            getUrl += ("?responseGroup=" + responseGroup);
        } else if (responseGroup != null) {
            getUrl += ("&responseGroup=" + responseGroup);
        }
        return restTemplate.getForObject(getUrl, JSONObject.class);
    }

    /**
     * 用户收藏概览
     *
     * <p>获取用户指定类型的收藏概览，固定返回最近更新的收藏，不支持翻页</p>
     *
     * @param username    用户名
     * @param subjectType 条目类型
     * @param maxResults  显示条数
     */
    public JSONObject getUserTypeCollection(String username, String subjectType, @Nullable Integer maxResults) {
        String getUrl = BANGUMI_API_BASE_URL + "/account/" + username + "/collections/" + subjectType;
        if (maxResults != null) {
            getUrl += ("?max_results=" + maxResults);
        }
        return restTemplate.getForObject(getUrl, JSONObject.class);
    }

    /**
     * 用户收藏统计
     *
     * <p>获取用户所有收藏信息</p>
     *
     * @param username 用户名
     */
    public JSONObject getUserStatusCollection(String username) {
        return restTemplate.getForObject(BANGUMI_API_BASE_URL + "/account/" + username + "/collections/status", JSONObject.class);
    }

    /**
     * '
     * 管理收藏
     *
     * @param subjectId 条目 ID
     * @param status    收藏状态 {wish/collect/do/on_hold/dropped} 参考 Define
     * @param comment   简评
     * @param tags      标签 以半角空格分割
     * @param rating    评分 0~10
     * @param privacy   收藏隐私 0 = 公开 / 1 = 私密
     */
    public JSONObject manageCollection(Integer subjectId, String status, @Nullable String comment, @Nullable String tags, @Nullable Integer rating, @Nullable Integer privacy) {
        String postUrl = BANGUMI_API_BASE_URL + "/collection/" + subjectId + "/update?status=" + status;
        if (comment != null) {
            postUrl += ("&comment=" + comment);
        }
        if (tags != null) {
            postUrl += ("&tags=" + tags);
        }
        if (rating != null) {
            postUrl += ("&rating=" + rating);
        }
        if (privacy != null) {
            postUrl += ("&privacy=" + privacy);
        }
        return restTemplateAuthorized.postForObject(postUrl, null, JSONObject.class);
    }
}
