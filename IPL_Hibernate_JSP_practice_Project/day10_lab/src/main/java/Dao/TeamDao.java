package Dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
	List<Team> getAllTeam();
	String addTeam(Team team);
	Team getTeamById(long id);
}
