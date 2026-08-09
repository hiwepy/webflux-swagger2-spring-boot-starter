package io.springfox.spring.boot.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GlobalResponseMessage Tests")
class GlobalResponseMessageTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        GlobalResponseMessage msg = new GlobalResponseMessage();
        assertThat(msg).isNotNull();
    }

    @Test
    @DisplayName("Fields can be set and read")
    void testFields() {
        GlobalResponseMessage msg = new GlobalResponseMessage();
        List<GlobalResponseMessageBody> bodies = new ArrayList<>();
        GlobalResponseMessageBody body = new GlobalResponseMessageBody();
        body.setCode("200");
        body.setMessage("OK");
        bodies.add(body);
        
        msg.setPost(bodies);
        msg.setGet(bodies);
        msg.setPut(bodies);
        msg.setPatch(bodies);
        msg.setDelete(bodies);
        msg.setHead(bodies);
        msg.setOptions(bodies);
        msg.setTrace(bodies);
        
        assertThat(msg.getPost()).hasSize(1);
        assertThat(msg.getGet()).hasSize(1);
        assertThat(msg.getPut()).hasSize(1);
        assertThat(msg.getPatch()).hasSize(1);
        assertThat(msg.getDelete()).hasSize(1);
        assertThat(msg.getHead()).hasSize(1);
        assertThat(msg.getOptions()).hasSize(1);
        assertThat(msg.getTrace()).hasSize(1);
    }
}
