package com.k8smanager.kubercli.data;

import lombok.Data;

//Data를 쓰지 않고 Getter, Setter를 사용한 후 다른 필요한 어노테이션을 붙이는게 훨씬 보안상 좋지만 개발에선 귀찮으니 Data로 처리

@Data
public class ServiceData {
    private int idx;

    private String name;
    private String createdTime;
    private String label;
    private String type;
    private String clusterIP;
    private String externalIP;
    private String port;
    private String writeTime;
}
