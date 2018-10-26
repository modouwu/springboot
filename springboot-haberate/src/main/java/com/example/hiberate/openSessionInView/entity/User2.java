package com.example.hiberate.openSessionInView.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "chouti_user_profiles")
public class User2 {
    @Id
    private String jid;
    private String nick;
    private String img_url;
    private Action action;

    private Integer is_bind_phone;
    private Integer sex;
    private Long submitted_count;
    private Long comments_count;
    private Long liked_count;

    private String proveName;//省会名
    private String cityName;//城市名
    private Long create_time;

    private String strtmp1;
    private String phone;
    private String sign;
    private Integer ct;
    @Column(name = "dissent_flag")
    private DissentFlag dissentFlag;//杠精标志:0 否 1 是

    @Column(name = "dissent_id")
    private Integer dissentId;//杠精标签Id

    private String master_jid;

    @Column(name = "isAdmin")
    private Type type;

    private transient String source;
    private transient String version;

    public String getId() {
        return jid;
    }

    /**
     * 功能：
     * 作者：刘柏勋
     * 联系：wmsjhappy@gmail.com
     * 时间：17-3-29 下午7:12
     * 更新：
     * 备注：
     */
    public enum Action {
        NORMAL(0, "正常"),
        UNBANED(1, "解封"),
        BANED(2, "封禁"),
        COMPLETE_PROHIBITION(3, "彻底封禁");

        public int code;
        private String desc;

        Action(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 功能：用户类型
     * 作者：刘柏勋
     * 联系：wmsjhappy@gmail.com
     * 时间：17-4-7 下午3:33
     * 更新：
     * 备注：
     */
    public enum Type {
        NORMAL_USER(0, "普通用户"),
        ADMIN(1, "管理员"),
        RSS(2, "RSS用户"),
        AUDIT_FREE_USER(3, "免审核用户"),
        BIND_USER(4, "绑定用户"),
        PERSPECTIVE_VORTEX(5, "透视漩涡"),
        REPORTED_USER(6, "被举报用户");

        private int code;
        private String desc;

        Type(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return code+"";
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum DissentFlag{
        FLAG_FALSE(0, "否"),
        FLAG_TRUE(1, "是");
        private int code;
        private String desc;

        DissentFlag(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}