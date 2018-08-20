package com.example.hiberate.openSessionInView.entity;

import com.example.hiberate.openSessionInView.converter.BooleanToIntegerConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "chouti_user_profiles")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer, handler"})
public class User{
    @Id
    private String jid;
    private String nick;
    @Convert(converter=BooleanToIntegerConverter.class)
    private Boolean isadmin;
    private String img_url;

    private Integer is_bind_phone;
    private Integer sex;
    private Long submitted_count;
    private Long comments_count;
    private Long liked_count;

    @Column(name = "prove_name")
    private String proveName;//省会名
    @Column(name = "city_name")
    private String cityName;//城市名
    private Long create_time;

    private String strtmp1;
    private String phone;
    private String sign;
    private Integer ct;
    @Column(name = "dissent_flag")
    private Integer dissentFlag;//杠精标志:0 否 1 是

    @Column(name = "dissent_id")
    private Integer dissentId;//杠精标签Id

    private String master_jid;

    private transient String source;
    private transient String version;
}
