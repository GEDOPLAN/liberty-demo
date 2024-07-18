package de.gedoplan.showcase.persistence;

import java.util.stream.Stream;

import de.gedoplan.showcase.entity.Person;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
// TODO Without @Transactional transactions seem to be started automatically
@Transactional(TxType.MANDATORY)
public interface PersonRepository extends CrudRepository<Person, Integer> {
  long count();

  Stream<Person> findByName(String name);
}
