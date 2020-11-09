import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import testPack.Task123jUnitTest;
import testPack.Task4EdgeBrowserTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        Task4EdgeBrowserTest.class,
        Task123jUnitTest.class
})
public class TestRunnerr {

}
