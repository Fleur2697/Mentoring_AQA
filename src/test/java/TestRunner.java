import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import testPack.Task123jUnitTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        Task123jUnitTest.class
})
public class TestRunner {

}
