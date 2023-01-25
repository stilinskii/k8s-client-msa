package com.k8smanager.kubercli.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class PodData {
    private int idx;
    private String name; //pod.metadata.name
    private int ready;// 컨테이너 레디 수 / 컨테이너 전체 수 형태 필요 ( ex) 1/2 )
    private String status; //pod.status.phase
    private int restarts; //pod.status.containerStatuses[0].restartCount
    private String ip;//pod.status.podIP
    private String createdTime;//pod.status.containerStatuses[0].state.running.startedAt
    private String nodeName; //pod.spec.nodeName
    private String labels; // pod.metadata.labels

    public PodData(String name, int ready, String status, int restarts, String ip, String createdTime, String nodeName, String label) {
        this.name = name;
        this.ready = ready;
        this.status = status;
        this.restarts = restarts;
        this.ip = ip;
        this.createdTime = createdTime;
        this.nodeName = nodeName;
        this.labels = label;
    }

    public void setLabels(Map<String, String> labels) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.labels = objectMapper.writeValueAsString(labels);
        } catch (JsonProcessingException e) {
            this.labels = null;
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PodData podData = (PodData) o;
        return idx == podData.idx && ready == podData.ready && restarts == podData.restarts && Objects.equals(name, podData.name) && Objects.equals(status, podData.status) && Objects.equals(ip, podData.ip) && Objects.equals(createdTime, podData.createdTime) && Objects.equals(nodeName, podData.nodeName) && Objects.equals(labels, podData.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx, name, ready, status, restarts, ip, createdTime, nodeName, labels);
    }

    @Override
    public String toString() {
        return "PodData{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", ready=" + ready +
                ", status='" + status + '\'' +
                ", restarts=" + restarts +
                ", ip='" + ip + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", labels='" + labels + '\'' +
                '}';
    }
}
