package com.k8smanager.kubercli.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeploymentData {
    private int idx;
    private String name;//items.metadata.name
    private String image;//items.spec.template.spec.containers.image
    private String labels;// items.spec.template.metadata.labels
    private String createdTime;//items.metadata.creationTimestamp
    private int readyReplicas;//items.status.readyReplicas
    private int replicas;//items.status.replicas
    private String writeTime;
}

