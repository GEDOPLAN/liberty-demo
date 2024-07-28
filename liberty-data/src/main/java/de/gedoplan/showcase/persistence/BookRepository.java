package de.gedoplan.showcase.persistence;

import de.gedoplan.showcase.entity.Book;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
// TODO Without @Transactional transactions seem to be started automatically
@Transactional(TxType.MANDATORY)
public interface BookRepository extends CrudRepository<Book, Integer> {
}
