package codingon.codingonspringbootjpa.repository;

import codingon.codingonspringbootjpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository extends JpaRepository<BoardEntity, Integer> {

}
