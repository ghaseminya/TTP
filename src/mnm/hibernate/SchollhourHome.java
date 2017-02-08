package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:23:45 AM by Hibernate Tools 3.2.2.GA

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Schollhour.
 * @see .Schollhour
 * @author Hibernate Tools
 */
public class SchollhourHome {

	private static final Log log = LogFactory.getLog(SchollhourHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Schollhour transientInstance) {
		log.debug("persisting Schollhour instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Schollhour instance) {
		log.debug("attaching dirty Schollhour instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Schollhour instance) {
		log.debug("attaching clean Schollhour instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Schollhour persistentInstance) {
		log.debug("deleting Schollhour instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Schollhour merge(Schollhour detachedInstance) {
		log.debug("merging Schollhour instance");
		try {
			Schollhour result = (Schollhour) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Schollhour findById(java.lang.Integer id) {
		log.debug("getting Schollhour instance with id: " + id);
		try {
			Schollhour instance = (Schollhour) sessionFactory
					.getCurrentSession().get("Schollhour", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Schollhour> findByExample(Schollhour instance) {
		log.debug("finding Schollhour instance by example");
		try {
			List<Schollhour> results = (List<Schollhour>) sessionFactory
					.getCurrentSession().createCriteria("Schollhour").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
