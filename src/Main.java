import gui.login.Login;
import services.loadsave.analysistypes.LoadAnalysisTypes;
import services.loadsave.coefficientbonus.LoadCoefficientBonus;
import services.loadsave.homevisitprices.LoadHomeVisitPrices;
import services.loadsave.reports.LoadReports;
import services.loadsave.users.LoadUsers;

public class Main {

	public static void main(String[] args) {
		//load data
		LoadUsers.loadUsers();
		LoadAnalysisTypes.loadAnalysisTypes();
		LoadCoefficientBonus.loadCoefficientBonuses();
		LoadHomeVisitPrices.loadHomeVisitPrices();
		LoadReports.loadReports();
		
		//start gui
		Login.main(args);
	}
}
