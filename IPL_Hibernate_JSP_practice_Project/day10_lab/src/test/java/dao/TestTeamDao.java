package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Dao.TeamDao;
import Dao.TeamDaoImpl;
import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao {
	private static TeamDao dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		HibernateUtils.getFactory();
		dao=new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}

	@Test
	void test() {
//		Team team = new Team("Chennai Super King ", "CSK", "owner1", 32, 60, 5);
		Team team = new Team("Mumbai Indians", "MI", "Ambani", 35, 55, 15);
		String msg = dao.addTeam(team);
		System.out.println(msg);
//		assertEquals(1,team.getId());
		assertEquals(2,team.getId());
	}

	@Test
	void testGetAllTeam() {
		List<Team> team = dao.getAllTeam();
		team.forEach(t->System.out.println(t.getId()+" "+t.getAbbreviation()));
		assertEquals(2, team.size());
	}
}
