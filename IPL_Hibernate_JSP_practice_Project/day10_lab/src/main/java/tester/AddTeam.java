package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.Session;

import Dao.TeamDao;
import Dao.TeamDaoImpl;
import pojos.Team;


public class AddTeam {
	public static void main(String[] args) {
		TeamDao teamDao = new TeamDaoImpl();
		try(Session session = getFactory().getCurrentSession();
				Scanner sc = new Scanner(System.in)){
			System.out.println("Enter Details");
			Team t = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			
		}
	}
}
