package com.k8smanager.pod.controllers;

import com.k8smanager.pod.data.PodData;
import com.k8smanager.pod.pagination.Pagination;
import com.k8smanager.pod.service.K8sManagerDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pod")
@RequiredArgsConstructor
@Slf4j
public class K8sDbController {

    private final K8sManagerDbService k8sScheduledDataService;
    private final Environment env;

    @GetMapping("/status/check")
    public String status(){
        return "Working on port "+ env.getProperty("local.server.port");
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{name}")
    public ResponseEntity<Map<String, Object>> getPodDataList(@PathVariable String name, @RequestParam(required = false,defaultValue = "1") Integer page){
//        log.info("name={}",name);
        Pagination pagination = new Pagination(page,3,k8sScheduledDataService.getSizeOfScheduledPodList(name));

        List<PodData> podList = k8sScheduledDataService.getScheduledPodDataList(name, pagination);

        Map<String, Object> returnValue = new HashMap<>();
        returnValue.put("pagination",pagination);
        returnValue.put("podList",podList);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

}
