package engine.repository;

import engine.entity.CompletedEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedRepository extends PagingAndSortingRepository<CompletedEntity, Long> {

    Page<CompletedEntity> findAllByUserEmail(String userEmail, Pageable pageable); }