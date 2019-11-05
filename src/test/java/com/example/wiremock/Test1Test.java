package com.example.wiremock;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1Test {

    @ClassRule
    public static WireMockRule testApi = new WireMockRule(options().port(8888));

    @Autowired
    private CommandLineRunner commandLineRunner;

    @Test
    public void test1() throws Exception {
        // given:
        testApi.stubFor(
                post("/test")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("{\"status\": true}"))
        );

        // when:
        commandLineRunner.run("Start");

        // then:
        testApi.verify(1, postRequestedFor(urlEqualTo("/test")));
    }
}
