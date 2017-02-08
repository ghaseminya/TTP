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
 * Home object for domain model class RoomWeekBusy.
 * @see .RoomWeekBusy
 * @author Hibernate Tools
 */
public class RoomWeekBusyHome {

	private static final Log log = LogFactory.getLog(RoomWeekBusyHome.class);

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

	public void persist(RoomWeekBusy transientInstance) {
		log.debug("persisting RoomWeekBusy instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RoomWeekBusy instance) {
		log.debug("attaching dirty RoomWeekBusy instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoomWeekBusy instance) {
		log.debug("attaching clean RoomWeekBusy instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RoomWeekBusy persistentInstance) {
		log.debug("deleting RoomWeekBusy instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoomWeekBusy merge(RoomWeekBusy detachedInstance) {
		log.debug("merging RoomWeekBusy instance");
		try {
			RoomWeekBusy result = (RoomWeekBusy) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoomWeekBusy findById(java.lang.Integer id) {
		log.debug("getting RoomWeekBusy instance with id: " + id);
		try {
			RoomWeekBusy instance = (RoomWeekBusy) sessionFactory
					.getCurrentSession().get("RoomWeekBusy", id);
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

	public List<RoomWeekBusy> findByExample(RoomWeekBusy instance) {
		log.debug("finding RoomWeekBusy instance by example");
		try {
			List<RoomWeekBusy> results = (List<RoomWeekBusy>) sessionFactory
					.getCurrentSession().createCriteria("RoomWeekBusy").add(
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
