package ru.optima.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.optima.persist.model.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {
    Work findById(long id);
}
