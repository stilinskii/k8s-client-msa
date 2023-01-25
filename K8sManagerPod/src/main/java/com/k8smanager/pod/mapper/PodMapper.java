package com.k8smanager.pod.mapper;


import com.k8smanager.pod.data.PodData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PodMapper {
    void setPodDataList(List<PodData> podDataList);
    List<PodData> getSchedulingPodData(int id);
    List<PodData> getPodDataList(int id);

    List<PodData> getScheduledPodList(String name);

    Integer getSizeOfScheduledPodList(String name);

    List<PodData> getScheduledPodDataWithPagination(Map<String,Object> podAndPaginationInfo);
}
