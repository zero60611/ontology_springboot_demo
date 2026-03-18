package com.example.platform.dataset.application;

import com.example.platform.dataset.domain.Dataset;
import com.example.platform.dataset.domain.DatasetStatus;
import com.example.platform.shared.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 維護資料集註冊表與版本資訊。
 */
@Service
public class DatasetRegistryService {

    private final List<Dataset> datasets = new CopyOnWriteArrayList<>();

    /**
     * 建立新的資料集定義。
     *
     * @param command 建立命令
     * @return 新建資料集
     */
    public Dataset create(CreateDatasetCommand command) {
        Dataset dataset = new Dataset(
                IdGenerator.newUuid(),
                command.datasetKey(),
                command.name(),
                command.sourceSystem(),
                1,
                DatasetStatus.ACTIVE,
                LocalDateTime.now()
        );
        datasets.add(dataset);
        return dataset;
    }

    /**
     * 取得全部資料集。
     *
     * @return 資料集清單
     */
    public List<Dataset> getAll() {
        return List.copyOf(datasets);
    }
}
