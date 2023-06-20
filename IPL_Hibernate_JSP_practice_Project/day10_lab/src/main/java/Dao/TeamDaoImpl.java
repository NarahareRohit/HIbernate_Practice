package Dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeam(Team team) {
		String msg = "Failed to add!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			msg ="Team Added with ID: "+team.getId();
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<Team> getAllTeam() {
		List<Team> teamList = null;
		String jpql = "select new pojos.Team(id,abbreviation) from Team";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teamList = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return teamList;
	}

	@Override
	public Team getTeamById(long id) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Team team=null;
		try {
			team = session.get(Team.class, id);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return team;
	}

}
