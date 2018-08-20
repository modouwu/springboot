package com.example.hiberate.openSessionInView.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "chouti_links")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer, handler"})
public class Link {
    @Id
    @GeneratedValue
    private Long id;
    // 标题或者段子内容
    private String title;

    // 连接地址或者发表图片后的地址
    private String url;

    // 配图
    @Column(name = "img_url")
    private String imgUrl;

    // 反对数
    private Integer downs;

    // 支持数
    private Integer ups;

    // 评论数
    @Column(name = "comments_count")
    private Integer commentsCount;

    // 点击数
    @Column(name = "clicks_count")
    private Integer clicksCount;

    // 热度分值计算值
    @Column(name = "ups_with_weight")
    private Double upsWithWeight;

    // 该链接是否清理过
    @Column(name = "clean_zero")
    private Integer cleanZero;

    // 热度计算的分数
    private Double score;

    // 链接的摘要内容
    private String content;

    // 发表链接的jid
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jid")
    private User submitter;

    // 资讯的摘要内容
    @Column(name = "domain")
    private String domain;

    // 入热榜时间
    @Column(name = "time_into_pool")
    private Long timeIntoPool;

    private Integer pool;

    // 删除信息
    @Column(name = "delete_info")
    private String deleteInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "action_time")
    private Long actionTime;

    // 管理员操作时间
    @Column(name = "operate_time")
    private Long operateTime;

    // 管理者
    private String operator;

    @Column(name = "tec_score")
    private Double tecScore;

    // 榜单发布时间点对应jid的id地址
    @Column(name = "ip_info")
    private String ip;

    @Column(name = "video_info_id")
    private Integer videoInfo;

    @Column(name = "inttmp1")
    private Integer noComments;

    @Column(name = "show_type")
    private Long showType;
}
