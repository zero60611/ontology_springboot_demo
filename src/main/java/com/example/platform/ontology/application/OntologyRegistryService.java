/**
 * 維護平台所有物件中繼資料的註冊表。
 */
package com.example.platform.ontology.application;

import com.example.platform.ontology.domain.ActionType;
import com.example.platform.ontology.domain.LinkType;
import com.example.platform.ontology.domain.ObjectMetadata;
import com.example.platform.ontology.domain.ObjectType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@Service
public class OntologyRegistryService {

    /**
     * 以記憶體方式保存目前載入的物件定義。
     */
    private final Map<ObjectType, ObjectMetadata> registry = new EnumMap<>(ObjectType.class);

    /**
     * 啟動時載入預設的 ontology metadata。
     */
    @PostConstruct
    void init() {
        register(new ObjectMetadata(
                ObjectType.DATASET,
                "Dataset",
                Set.of(ActionType.CREATE, ActionType.INGEST),
                Set.of(LinkType.DERIVED_FROM),
                Set.of("datasetKey", "name", "sourceSystem"),
                "ROLE_BASED"
        ));
        register(new ObjectMetadata(
                ObjectType.PIPELINE_RUN,
                "Pipeline Run",
                Set.of(ActionType.CREATE, ActionType.EXECUTE),
                Set.of(LinkType.GENERATED_FROM, LinkType.DERIVED_FROM),
                Set.of("pipelineKey", "status", "datasetKey"),
                "ROLE_BASED"
        ));
        register(new ObjectMetadata(
                ObjectType.WORKFLOW_RUN,
                "Workflow Run",
                Set.of(ActionType.CREATE, ActionType.EXECUTE, ActionType.APPROVE),
                Set.of(LinkType.ASSIGNED_TO, LinkType.GENERATED_FROM),
                Set.of("workflowKey", "status", "targetObjectId"),
                "DEPARTMENT_SCOPE"
        ));
        register(new ObjectMetadata(
                ObjectType.POLICY,
                "Policy",
                Set.of(ActionType.CREATE, ActionType.APPROVE),
                Set.of(LinkType.BELONGS_TO),
                Set.of("policyKey", "scope", "effect"),
                "ADMIN_ONLY"
        ));
        register(new ObjectMetadata(
                ObjectType.EXAM,
                "Exam",
                Set.of(ActionType.CREATE),
                Set.of(LinkType.BELONGS_TO),
                Set.of("examId", "title"),
                "ROLE_BASED"
        ));
        register(new ObjectMetadata(
                ObjectType.EXAM_RESPONSE,
                "Exam Response",
                Set.of(ActionType.SUBMIT, ActionType.SCORE),
                Set.of(LinkType.BELONGS_TO, LinkType.GENERATED_FROM),
                Set.of("responseId", "candidateId", "status"),
                "ROW_LEVEL"
        ));
        register(new ObjectMetadata(
                ObjectType.REVIEW_TASK,
                "Review Task",
                Set.of(ActionType.ASSIGN, ActionType.APPROVE),
                Set.of(LinkType.ASSIGNED_TO, LinkType.REVIEWS),
                Set.of("taskId", "assigneeId"),
                "DEPARTMENT_SCOPE"
        ));
        register(new ObjectMetadata(
                ObjectType.SCORING_RESULT,
                "Scoring Result",
                Set.of(ActionType.SCORE),
                Set.of(LinkType.GENERATED_FROM),
                Set.of("score", "grader"),
                "ROLE_BASED"
        ));
        register(new ObjectMetadata(
                ObjectType.REPORT,
                "Report",
                Set.of(ActionType.PUBLISH),
                Set.of(LinkType.PUBLISHED_AS),
                Set.of("reportId", "status"),
                "FIELD_MASKING"
        ));
    }

    /**
     * 取得全部物件定義。
     *
     * @return 物件中繼資料集合
     */
    public Collection<ObjectMetadata> getAll() {
        return registry.values();
    }

    /**
     * 依物件型別查詢定義。
     *
     * @param objectType 物件型別
     * @return 物件中繼資料
     */
    public ObjectMetadata get(ObjectType objectType) {
        return registry.get(objectType);
    }

    /**
     * 註冊單一物件定義。
     *
     * @param metadata 物件中繼資料
     */
    private void register(ObjectMetadata metadata) {
        registry.put(metadata.objectType(), metadata);
    }
}
