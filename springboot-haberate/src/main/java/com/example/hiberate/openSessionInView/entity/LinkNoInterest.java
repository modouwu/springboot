package com.example.hiberate.openSessionInView.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "chouti_link_no_interest")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer, handler"})
public class LinkNoInterest {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "link_id")
    private Link link;

    /*@Column(name = "link_id")
    private String link;*/

    //在前面加上前缀 hi,this is platform:
    //@Convert(converter = PlatformConverter.class)
    private String platform;

    @Column(name = "device_id")
    private String deviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jid")
    private User user;

    /*@Column(name = "jid")
    private String user;*/
    private Long createTime;
    private Long actionTime;
}
