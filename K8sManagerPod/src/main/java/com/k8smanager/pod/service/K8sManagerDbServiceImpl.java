package com.k8smanager.pod.service;


import com.k8smanager.pod.data.PodData;
import com.k8smanager.pod.mapper.PodMapper;
import com.k8smanager.pod.pagination.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class K8sManagerDbServiceImpl implements K8sManagerDbService {

    private final PodMapper podMapper;

    @Override
    public List<PodData> getScheduledPodDataList(String name, Pagination pagination) {
        Map<String, Object> podAndPaginationInfo = new HashMap<>();
        podAndPaginationInfo.put("name",name);
        podAndPaginationInfo.put("pagination",pagination);
        return podMapper.getScheduledPodDataWithPagination(podAndPaginationInfo);
    }

    @Override
    public void insertPodInfo(List<PodData> podData) {
        podMapper.setPodDataList(podData);
    }

    @Override
    public Integer getSizeOfScheduledPodList(String name) {
        return podMapper.getSizeOfScheduledPodList(name);
    }




}
