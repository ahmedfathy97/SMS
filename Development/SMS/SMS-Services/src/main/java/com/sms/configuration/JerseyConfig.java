package com.sms.configuration;

import com.sms.controller.*;
import com.sms.controller.filter.AuthenticationFilter;
import com.sms.controller.filter.AuthorizationFilter;
import com.sms.controller.filter.CORSFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CORSFilter.class);
        register(AuthorizationFilter.class);
        register(AuthenticationFilter.class);
        register(AttachmentRes.class);
        register(MultiPartFeature.class);
        register(AttachmentRes.class);
        register(AttendanceRes.class);
        register(CourseRes.class);
        register(GradeRes.class);
        register(LectureRes.class);
        register(LookupRes.class);
        register(QuizRes.class);
        register(SecurityRes.class);
        register(UserRes.class);
//        packages("com.sms.controller");

    }
//    @Autowired
//    ApplicationContext appCtx;
//
//    @PostConstruct
//    public void setup() {
//        log.info("Rest classes found:");
//        Map<String,Object> beans = appCtx.getBeansWithAnnotation(Path.class);
//        for (Object o : beans.values()) {
//            log.info(" -> " + o.getClass().getName());
//            register(o);
//        }
//    }
}
