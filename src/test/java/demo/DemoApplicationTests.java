package demo;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;
    private URL base;

    @Autowired
    TestRestTemplate restTemplate;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/hello");
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

        assertThat(response.getBody(), equalTo("Greeting from Spring Boot"));
    }

    private void assertThat(String body, Matcher<String> greeting_from_spring_boot) {
    }

}
