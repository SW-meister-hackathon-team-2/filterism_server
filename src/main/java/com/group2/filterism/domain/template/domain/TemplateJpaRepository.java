package com.group2.filterism.domain.template.domain;

import com.group2.filterism.domain.hashtag.domain.HashtagEntity;
import com.group2.filterism.domain.template.vo.AccessScope;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TemplateJpaRepository extends JpaRepository<TemplateEntity, Long>, JpaSpecificationExecutor<TemplateEntity> {
    List<TemplateEntity> findAllByAccessScope(AccessScope accessScope);
    Optional<TemplateEntity> findByIdAndAccessScope(Long id, AccessScope accessScope);

    default Optional<TemplateEntity> findPendingTemplateById(Long id) {
        return findByIdAndAccessScope(id, AccessScope.PENDING);
    }

    default Optional<TemplateEntity> findPublicTemplateById(Long id) {
        return findByIdAndAccessScope(id, AccessScope.PUBLIC);
    }

    default List<TemplateEntity> findAllPublicTemplate() {
        return findAllByAccessScope(AccessScope.PUBLIC);
    }

    private Specification<TemplateEntity> withDynamicQuery(
            String searchText,
            Set<Long> hashtags
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchText != null && !searchText.trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + searchText + "%"));
            }

            if (hashtags != null && !hashtags.isEmpty()) {
                Join<TemplateEntity, HashtagEntity> hashTagJoin = root.join("hashtags", JoinType.INNER);
                predicates.add(hashTagJoin.get("id").in(hashtags));

                query.groupBy(root.get("id"));
                query.having(criteriaBuilder.ge(criteriaBuilder.count(root.get("id")), hashtags.size()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    default List<TemplateEntity> search(String searchText, Set<Long> hashTags) {
        return findAll(withDynamicQuery(searchText, hashTags));
    }
}
