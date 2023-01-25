package com.k8smanager.pod.service;


import com.k8smanager.pod.data.PodData;
import com.k8smanager.pod.pagination.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface K8sManagerDbService {
    //각각 이름으로 불러오는 거랑 인서트 각 2개씩.
    List<PodData> getScheduledPodDataList(String name, Pagination pagination);


    void insertPodInfo(List<PodData> podData);

    Integer getSizeOfScheduledPodList(String name);
}
