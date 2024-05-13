package Testbasics;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="Amazonproductlist")
	public Object[][] Amazondataprovider()
	{
		return new Object [][] {{"shoe"},{"watch"},{"phone"},{"toys"},{"tyre"}};
	}
	@DataProvider(name="Facebookdata")
	public Object[][] fbdata()
	{
		return new Object [][] {{"hari","pswd1"},{"robot","pswd2"}};
	}
	@DataProvider(name="Tablefiltername")
	public Object[][] name1d()
	{
		return new Object [][] {{"Airi Satou"},{"Cedric Kelly"},{"Jennifer Acosta"},{"Suki Burks"},{"Hari"}};
	}
	@DataProvider(name="Formfill6D")
	public Object[][] formadd6d()
	{
		return new Object [][] {{"hari","krishnan","hariv","Trivandrum","Kerala","695020"},{"Robo","suzuki","robo5","shimla","Himachal","958541"}};
	}
	@DataProvider(name="simpleformtext")
	public Object[][] simpleformtextlist()
	{
		return new Object[][] {{"Menu"},{"Single Input Field"},{"Two Input Fields"}};
	}
}
