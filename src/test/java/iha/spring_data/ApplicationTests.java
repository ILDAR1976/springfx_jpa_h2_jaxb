package iha.spring_data;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import javafx.embed.swing.JFXPanel;

import org.springframework.boot.SpringBootConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration()
public class ApplicationTests {

    @BeforeClass
    public static void bootstrapJavaFx(){
         new JFXPanel();
    }

    @Test
	public void contextLoads() {
	}

}
