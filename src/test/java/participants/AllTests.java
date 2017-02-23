package participants;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import participants.view.CitizenInformationControllerTest;
import participants.view.HTMLControllerTest;


@RunWith(Suite.class)
@SuiteClasses({ 
	DbTest.class,
	CitizenInformationControllerTest.class,
	HTMLControllerTest.class
})
public class AllTests {

}
