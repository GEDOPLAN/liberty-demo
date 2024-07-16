package de.gedoplan.showcase.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.gedoplan.showcase.entity.Person;
import de.gedoplan.showcase.persistence.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Startup;
import jakarta.inject.Inject;


@ApplicationScoped
public class InitPersonDemoDataService {
  @Inject
  PersonRepository personRepository;

  private static final Log LOG = LogFactory.getLog(InitPersonDemoDataService.class);

  /**
   * Create test/demo data.
   * Attn: Interceptors may not be called, if method is private!
   *
   * @param event Application scope initialization event
   */
  // @Transactional
  void createDemoData(@Observes Startup event) {
    try {
      if (this.personRepository.count() == 0) {
        this.personRepository.insert(new Person("Duck", "Dagobert"));
        this.personRepository.insert(new Person("Duck", "Donald"));
        LOG.debug("Created demo data");
      }
    } catch (Exception e) {
      LOG.warn("Cannot create demo data", e);
    }

  }

}
