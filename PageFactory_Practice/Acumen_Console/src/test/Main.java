package test;

import java.text.ParseException;

import components.Add_Component;
import components.Add_Utilization;
import components.Edit_Component;
import components.Edit_Utilization;

public class Main
{
	public static void main(String[] args) throws InterruptedException, ParseException
	{
		Login l = new Login();
		l.setup();
		l.login();
		
		Add_Component ac = new Add_Component(l.getDriver());
//		ac.addcomponent();
//		ac.viewtoConfirm();
		
		Edit_Component ec = new Edit_Component(l.getDriver());
//		ec.editcomponent();
//		ec.viewtoconfirm();
		
		Add_Utilization au = new Add_Utilization(l.getDriver());
//		au.addutilization();
//		au.viewtoConfirm();
		
		Edit_Utilization eu = new Edit_Utilization(l.getDriver());
//		eu.editutilization();
//		eu.viewtoConfirm();
	}
}