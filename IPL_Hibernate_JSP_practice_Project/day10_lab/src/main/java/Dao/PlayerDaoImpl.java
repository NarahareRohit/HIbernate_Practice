package Dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addplayerToTeam(Player newPlayer, long teamId) {
		String msg = "Failed To add";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
//			System.out.println(newPlayer);
			if (team != null) {
				team.addPlayer(newPlayer);
				session.persist(newPlayer);
			}
			tx.commit();
			msg = "Added";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
