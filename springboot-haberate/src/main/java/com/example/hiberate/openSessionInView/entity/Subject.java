package com.example.hiberate.openSessionInView.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Jag 2018/1/4 16:55
 */
@Getter
@Setter
@Entity
@Table(name = "chouti_subjects")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer, handler"})
public class Subject{
    // 主键
    @Id
    @GeneratedValue
    private Long id;

    // 名称
    private String name;

    // 英文名称
    @Column(name = "en_name")
    private String enName;

    // 排序 规则 asc
    private Integer sort;

    // 是否发布
    @Column(name = "is_public")
    private Boolean release;

    // 描述
    private String description;

    // 话题的状态
    @Column(name = "action")
    private Integer action;

    // 创建者
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jid")
    private User user;

    // 话题头像
    @Column(name = "img_url")
    private String imgUrl;

    // todo 话题头像原始图片 原始图片部分没有上传到七牛CDN. 使用注意
    @Column(name = "ori_imgurl")
    private String oriImgUrl;

    // 话题显示类型，注意此表也用在榜单分类',
    @Column(name = "show_type")
    private Integer showType;

    // subject类型
    @Column(name = "type")
    private Integer type;

    private Long createTime;

    private Long actionTime;

    // 0显示在前面 1显示在后面 话题时间轴
    @Column(name = "story")
    private Integer story;

    // 话题故事轴原图地址
    @Column(name = "story_imgurl")
    private String storyImgUrl;

    // 删除信息
    @Column(name = "delete_info")
    private String deleteInfo;
}
