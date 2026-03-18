package com.example.platform.dataset.api;

import com.example.platform.dataset.application.CreateDatasetCommand;
import com.example.platform.dataset.application.DatasetRegistryService;
import com.example.platform.dataset.domain.Dataset;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供資料集管理 API。
 */
@RestController
@RequestMapping("/api/datasets")
public class DatasetController {

    private final DatasetRegistryService datasetRegistryService;

    public DatasetController(DatasetRegistryService datasetRegistryService) {
        this.datasetRegistryService = datasetRegistryService;
    }

    /**
     * 建立資料集定義。
     *
     * @param request 建立請求
     * @return 新建資料集
     */
    @PostMapping
    public Dataset create(@RequestBody CreateDatasetRequest request) {
        return datasetRegistryService.create(new CreateDatasetCommand(
                request.datasetKey(),
                request.name(),
                request.sourceSystem()
        ));
    }

    /**
     * 取得資料集清單。
     *
     * @return 資料集清單
     */
    @GetMapping
    public List<Dataset> getAll() {
        return datasetRegistryService.getAll();
    }

    /**
     * 建立資料集請求模型。
     *
     * @param datasetKey 資料集鍵值
     * @param name 顯示名稱
     * @param sourceSystem 來源系統
     */
    public record CreateDatasetRequest(
            @NotBlank String datasetKey,
            @NotBlank String name,
            @NotBlank String sourceSystem
    ) {
    }
}
