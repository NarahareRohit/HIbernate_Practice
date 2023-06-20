package beans;

import java.time.LocalDate;

import Dao.PlayerDaoImpl;
import Dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean {
	private String myTeam;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String batavg;
	private String wicketTaken;
	private TeamDaoImpl tDao;
	private PlayerDaoImpl pDao;
	private Player player;
	
	public String validate() {
		Team team = tDao.getTeamById(Integer.parseInt(myTeam));
		String msg = "Not Added";
		if(team!=null) {
			if(Double.parseDouble(batavg)>team.getBattingAvg() && Integer.parseInt(wicketTaken)>team.getWicketsTaken()) {
				if(LocalDate.now().getYear()-LocalDate.parse(dob).getYear() > 19) {
					player = new Player(email,firstName,lastName,LocalDate.parse(dob),Double.parseDouble(batavg),Integer.parseInt(wicketTaken));
					msg = pDao.addplayerToTeam(player, team.getId());
					return msg;
				}
			}
		}
		return msg;
	}
	public PlayerBean(){
		tDao=new TeamDaoImpl();
		pDao = new PlayerDaoImpl();
	}
	
	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMyTeam() {
		return myTeam;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBatavg() {
		return batavg;
	}
	public void setBatavg(String batavg) {
		this.batavg = batavg;
	}
	public String getWicketTaken() {
		return wicketTaken;
	}
	public void setWicketTaken(String wicketTaken) {
		this.wicketTaken = wicketTaken;
	}
	
	
}
