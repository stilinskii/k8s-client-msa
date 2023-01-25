package com.k8smanager.kubercli.controllers;

import com.k8smanager.kubercli.data.PodData;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kubercli")
public class KuberCliController {

    private final KubernetesClient client = new KubernetesClientBuilder().build();

//    @GetMapping
//    public HashMap<String, Object> getPodDataList() {
//        Pagination pagination = new Pagination(page,10,podService.loadPodDataList().size());
//        HashMap<String, Object> podListWithPagination = new HashMap<>();
//        List<PodData> podDataList = podService.getPodDataListWithLimit(pagination);
//        podListWithPagination.put("podList",podDataList);
//        podListWithPagination.put("pagination", pagination);
//        return podListWithPagination;
//    }


    @GetMapping("/test")
    public List<Pod> test(){
        return client.pods().list().getItems();
    }

    public List<PodData> loadPodDataList() {
        List<Pod> podList = client.pods().list().getItems();
        List<PodData> podDataList = new ArrayList<>();

        for (Pod pod : podList) {
            PodData podData = new PodData();

            podData.setName(pod.getMetadata().getName());
            podData.setReady(1);
            podData.setStatus(pod.getStatus().getPhase());
            podData.setRestarts(Integer.valueOf((Optional.ofNullable(pod.getStatus().getContainerStatuses().get(0).getRestartCount()).orElse(0)).intValue()));
            podData.setIp(pod.getStatus().getPodIP());
            podData.setCreatedTime(pod.getMetadata().getCreationTimestamp());
            podData.setNodeName(pod.getSpec().getNodeName());
            podData.setLabels(pod.getMetadata().getLabels());

            podDataList.add(podData);
        }

        return podDataList;
    }

}
