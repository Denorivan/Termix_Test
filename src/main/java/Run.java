import tests.TestForDrills;
import tests.TestForGrinder;
import tests.TestForPerfors;
import tests.TestForScrewdrivers;

import java.io.IOException;

public class Run {

    public static void runTests() throws IOException{
        TestForPerfors.runFirstTest();
        TestForDrills.runSecondTest();
        TestForScrewdrivers.runThirdTest();
        TestForGrinder.runFourthTest();
    }
}
