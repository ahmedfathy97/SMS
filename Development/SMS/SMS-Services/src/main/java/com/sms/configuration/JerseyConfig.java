package com.sms.configuration;

//import com.sms.controller.AttachmentRes;
//import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CORSFilter.class);
     //   register(AttachmentRes.class);
//        register(MultiPartFeature.class);
        packages("com.sms.controller");

    }

}
