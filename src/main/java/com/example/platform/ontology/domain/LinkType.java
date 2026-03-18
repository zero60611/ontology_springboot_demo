/**
 * 定義業務物件之間可描述的關聯型別。
 */
package com.example.platform.ontology.domain;

public enum LinkType {
    BELONGS_TO,
    GENERATED_FROM,
    DERIVED_FROM,
    ASSIGNED_TO,
    REVIEWS,
    PUBLISHED_AS
}
