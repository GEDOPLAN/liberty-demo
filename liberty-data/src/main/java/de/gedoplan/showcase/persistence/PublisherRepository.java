package de.gedoplan.showcase.persistence;

import de.gedoplan.showcase.entity.Publisher;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
// TODO Without @Transactional transactions seem to be started automatically
@Transactional(TxType.MANDATORY)
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
  long count();
}
