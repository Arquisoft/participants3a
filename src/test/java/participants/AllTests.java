package participants;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import participants.view.CitizenInformationControllerTest;


@RunWith(Suite.class)
@SuiteClasses({ 
	DbTest.class,
	CitizenInformationControllerTest.class
})
public class AllTests {

}
