/**
 * 用於表示查無資源的例外。
 */
package com.example.platform.shared.exception;

public class ResourceNotFoundException extends RuntimeException {

    /**
     * 建立查無資源例外。
     *
     * @param message 錯誤訊息
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
