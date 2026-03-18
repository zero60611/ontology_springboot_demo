/**
 * 提供 ontology metadata 查詢 API。
 */
package com.example.platform.ontology.api;

import com.example.platform.ontology.application.OntologyRegistryService;
import com.example.platform.ontology.domain.ObjectMetadata;
import com.example.platform.ontology.domain.ObjectType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/ontology/metadata")
public class OntologyController {

    private final OntologyRegistryService ontologyRegistryService;

    public OntologyController(OntologyRegistryService ontologyRegistryService) {
        this.ontologyRegistryService = ontologyRegistryService;
    }

    /**
     * 取得全部物件定義。
     *
     * @return 全部 metadata
     */
    @GetMapping
    public Collection<ObjectMetadata> getAll() {
        return ontologyRegistryService.getAll();
    }

    /**
     * 依型別取得單一物件定義。
     *
     * @param objectType 物件型別
     * @return 物件 metadata
     */
    @GetMapping("/{objectType}")
    public ObjectMetadata getByType(@PathVariable ObjectType objectType) {
        return ontologyRegistryService.get(objectType);
    }
}
