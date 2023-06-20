package Dao;

import pojos.Player;

public interface PlayerDao {
	String addplayerToTeam(Player newPlayer,long teamId);
}
